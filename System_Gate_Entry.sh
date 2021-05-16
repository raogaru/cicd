# ######################################################################
ECHOpurple "script:System_Gate_Entry.sh START"
# ######################################################################

f_sysgate_git_checkout_sysgate_branch () {
ECHOpurple "function:f_sysgate_git_checkout_sysgate_branch"

HEADER2 "Create directory for sysgate"
        GIT_SYSGATE_DIR=${PIPE_DIR}/git/sysgate
        mkdir -p ${GIT_SYSGATE_DIR}
        cd ${GIT_SYSGATE_DIR}
        ECHO "GIT_SYSGATE_DIR is ${GIT_SYSGATE_DIR}"

HEADER2 "Clone master branch"
        git clone ${MYAPP_GIT} ${GIT_SYSGATE_DIR}
	git checkout master
        [[ $? -ne 0 ]] && ERROR "Failed to checkout ${MYAPP_GIT} git repo master branch"
        [[ ! -d ${GIT_SYSGATE_DIR} ]] && ERROR "Failed to clone ${MYAPP_GIT} git repo into ${GIT_SYSGATE_DIR} directory"
        ADDENV "GIT_SYSGATE_DIR=${GIT_SYSGATE_DIR}"

HEADER2 "Checkout team branches"
	for TEAM in ${AGILE_TEAMS}
	do
		git checkout team-${TEAM}
        	[[ $? -ne 0 ]] && ERROR "Failed to checkout ${MYAPP_GIT} git repo team-${TEAM} branch"
	done

HEADER2 "Delete sysgate branch"
	git branch -D sysgate

HEADER2 "Create sysgate branch"
	git branch sysgate
	git checkout sysgate

HEADER2 "List all branches"
        git branch -a

HEADER2 "Make sure working on sysgate branch"
        x1=$(git branch | grep "^\*" | sed -e 's/^\* //')
        [[ "${x1}" != "sysgate" ]] && ERROR "Current branch is not \"sysgate\"."
        ECHO Current branch is "sysgate"
}
# ----------------------------------------------------------------------
f_sysgate_git_merge_team_branches () {
ECHOpurple "function:f_sysgate_git_merge_team_branches"

for TEAM in ${AGILE_TEAMS}
do
	v_test=$(READENV TEAM_TEST_${TEAM})
	#ECHO "TEAM_TEST_${TEAM}=${v_test}"
	if [ "${v_test}" == "SUCCESS" ] ;  then
		HEADER2 "Merge team-${TEAM} branch into sysgate branch"
		git merge team-${TEAM} -m "Merge branch team-${TEAM} pipe# ${PIPE_NUM}"
        	if [ $? -ne 0 ]; then
			WARN "Failed to merge team-${TEAM} branch of ${MYAPP_GIT} repo to sysgate branch"
			ADDENV "SYSGATE_MERGE_${TEAM}=FAILED"
			return 1
		else
			ECHO "git merge successful from team-${TEAM} branch to sysgate branch"
			ADDENV "SYSGATE_MERGE_${TEAM}=SUCCESS"
		fi
	else
		ECHO "Nothing to merge from team-${TEAM} branch"
		ADDENV "SYSGATE_MERGE_${TEAM}=N/A"
	fi
done
}
# ----------------------------------------------------------------------
f_sysgate_git_merge_status () {
ECHOpurple "function:f_sysgate_git_merge_status"

v_merge_final="SUCCESS"
for TEAM in ${AGILE_TEAMS}
do
	v_merge=$(READENV SYSGATE_MERGE_${TEAM})
	ECHO "SYSGATE_MERGE_${TEAM}=${v_merge}"
	[[ "${v_merge}" == "FAILED" ]] && v_merge_final="FAILED"
done
ADDENV "SYSGATE_MERGE=${v_merge_final}"
}
# ######################################################################
# START HERE
# ######################################################################

f_sysgate_git_checkout_sysgate_branch
if [ $? -eq 0 ]; then
	f_sysgate_git_merge_team_branches
	if [ $? -eq 0 ]; then
		f_sysgate_git_merge_status
	fi
fi
# ######################################################################
ECHOpurple "script:System_Gate_Entry.sh END"
# ######################################################################
