# ######################################################################
MARKER "script:sg_Enter.sh START"
# ######################################################################

f_sysgate_git_checkout_sysgate_branch () {
MARKER "function:f_sysgate_git_checkout_sysgate_branch"

HEADER3 "Create directory for sysgate"
        GIT_SYSGATE_DIR=${PIPE_DIR}/git/sysgate
        mkdir -p ${GIT_SYSGATE_DIR}
        ECHO "GIT_SYSGATE_DIR is ${GIT_SYSGATE_DIR}"

HEADER3 "Clone System-Gate branch \"${GIT_SYSGATE_BRANCH}\""
        cd ${GIT_SYSGATE_DIR}
        SHOWCMD "git clone ${MYAPP_GIT} ${GIT_SYSGATE_DIR}"
        git clone ${MYAPP_GIT} ${GIT_SYSGATE_DIR}

HEADER3 "Drop System-Gate branch \"${GIT_SYSGATE_BRANCH}\""
	SHOWCMD "git branch -D ${GIT_SYSGATE_BRANCH}"
	git branch -D ${GIT_SYSGATE_BRANCH}
	SHOWCMD "git push origin -D ${GIT_SYSGATE_BRANCH}"
	git push origin -D ${GIT_SYSGATE_BRANCH}

HEADER3 "Clone ${GIT_MASTER_BRANCH} branch \"${GIT_SYSGATE_BRANCH}\""
	SHOWCMD "git checkout ${GIT_MASTER_BRANCH}"
	git checkout ${GIT_MASTER_BRANCH}
        [[ $? -ne 0 ]] && ERROR "Failed to checkout ${MYAPP_GIT} git repo ${GIT_MASTER_BRANCH} branch"
        [[ ! -d ${GIT_SYSGATE_DIR} ]] && ERROR "Failed to clone ${MYAPP_GIT} git repo into ${GIT_SYSGATE_DIR} directory"
        ADDENV "GIT_SYSGATE_DIR=${GIT_SYSGATE_DIR}"

HEADER3 "Checkout team branches"
	for TEAM in ${AGILE_TEAMS}
	do
		SHOWCMD "git checkout team-${TEAM}"
		git checkout team-${TEAM}
        	if [ $? -ne 0 ]; then
			WARN "Failed to checkout ${MYAPP_GIT} git repo team-${TEAM} branch"
			return 1
		else
			ECHO "git checkout team-${TEAM} successful"
		fi
		PrintLine2
	done

HEADER3 "Create sysgate branch"
	SHOWCMD "git branch ${GIT_SYSGATE_BRANCH}"
	git branch ${GIT_SYSGATE_BRANCH}
	SHOWCMD "git checkout ${GIT_SYSGATE_BRANCH}"
	git checkout ${GIT_SYSGATE_BRANCH}
       	if [ $? -ne 0 ]; then
		WARN "Failed to checkout ${MYAPP_GIT} git repo ${GIT_SYSGATE_BRANCH} branch"
		return 1
	else
		ECHO "git checkout ${GIT_SYSGATE_BRANCH} successful"
	fi

HEADER3 "List all branches"
        git branch -a

HEADER3 "Make sure working on ${GIT_SYSGATE_BRANCH} branch"
        x1=$(git branch | grep "^\*" | sed -e 's/^\* //')
        [[ "${x1}" != "${GIT_SYSGATE_BRANCH}" ]] && ERROR "Current branch is not \"${GIT_SYSGATE_BRANCH}\"."
        ECHO Current branch is "${GIT_SYSGATE_BRANCH}"
}
# ----------------------------------------------------------------------
f_sysgate_git_merge_team_branches () {
MARKER "function:f_sysgate_git_merge_team_branches"

for TEAM in ${AGILE_TEAMS}
do
	v_test=$(READENV TEAM_TEST_${TEAM})
	#ECHO "TEAM_TEST_${TEAM}=${v_test}"
	if [ "${v_test}" == "${cPASS}" ] ;  then
		HEADER2 "Merge team-${TEAM} branch into ${GIT_SYSGATE_BRANCH} branch"
		git merge team-${TEAM} -m "Merge branch team-${TEAM} pipe# ${PIPE_NUM}"
        	if [ $? -ne 0 ]; then
			WARN "Failed to merge team-${TEAM} branch of ${MYAPP_GIT} repo to ${GIT_SYSGATE_BRANCH} branch"
			ADDENV "SYSGATE_MERGE_${TEAM}=${cFAIL}"
			return 1
		else
			ECHO "git merge successful from team-${TEAM} branch to ${GIT_SYSGATE_BRANCH} branch"
			ADDENV "SYSGATE_MERGE_${TEAM}=${cPASS}"
		fi
	else
		ECHO "Nothing to merge from team-${TEAM} branch"
		ADDENV "SYSGATE_MERGE_${TEAM}=${cNOTA}"
	fi
done
}
# ----------------------------------------------------------------------
f_sysgate_git_merge_status () {
MARKER "function:f_sysgate_git_merge_status"

HEADER2 "Check merge status for each team"
v_merge_final="${cPASS}"
for TEAM in ${AGILE_TEAMS}
do
	v_merge=$(READENV SYSGATE_MERGE_${TEAM})
	ECHO "SYSGATE_MERGE_${TEAM}=${v_merge}"
	[[ "${v_merge}" == "${cFAIL}" ]] && v_merge_final="${cFAIL}"
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
MARKER "script:sg_Enter.sh END"
# ######################################################################
