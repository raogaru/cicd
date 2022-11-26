# ######################################################################
MARKER "script:mg_Checkin.sh START"
# ######################################################################
# ----------------------------------------------------------------------
f_maingate_checkin_checkout_master () {
MARKER "function:f_maingate_checkin_checkout_master"
HEADER2 "Checkout master branch of ${MYAPP_NAME} Git repo ${GITREPO_URL}"
	GIT_MASTER_DIR=${PIPE_DIR}/git/master
	mkdir -p ${GIT_MASTER_DIR}
	cd ${GIT_MASTER_DIR}
	ECHO "GIT_MASTER_DIR is ${GIT_MASTER_DIR}"
	git clone ${MYAPP_GIT} ${GIT_MASTER_DIR}
	git checkout master
	[[ $? -ne 0 ]] && ERROR "Failed to clone ${MYAPP_GIT} git repo"
	[[ ! -d ${GIT_MASTER_DIR} ]] && ERROR "Failed to clone ${MYAPP_GIT} git repo into ${GIT_MASTER_DIR} directory"
	ADDENV "GIT_MASTER_DIR=${GIT_MASTER_DIR}"

HEADER2 "List all branches"
	git branch -a

HEADER2 "Make sure working on master branch"
        x1=$(git branch | grep "^\*" | sed -e 's/^\* //')
        [[ "${x1}" != "master" ]] && ERROR "Current branch is not \"master\"."
	ECHO Current branch is "master"
}

# ----------------------------------------------------------------------
f_maingate_checkin_validate_team_branches () {
MARKER "function:f_maingate_checkin_validate_team_branches"
HEADER2 "List development teams"
        rm -f ${PIPE_DIR}/teams.tmp
        for TEAM in ${AGILE_TEAMS}; do echo "${TEAM}" >> ${PIPE_DIR}/teams.tmp; done
        cat ${PIPE_DIR}/teams.tmp |sort > ${PIPE_DIR}/teams.lst
        cat ${PIPE_DIR}/teams.lst
        rm -f ${PIPE_DIR}/teams.tmp

HEADER2 "Identify list of team-branches"
        git branch -a | grep remote | grep "\/team\-" | sed -e 's/^.*\/team-//'|sort > ${PIPE_DIR}/git_team_branches.lst
        cat ${PIPE_DIR}/git_team_branches.lst | sed -e 's/^/team\-/'

HEADER2 "Compare teams with team-branches"
        diff ${PIPE_DIR}/teams.lst ${PIPE_DIR}/git_team_branches.lst
        r=$?

if [ $r -eq 0 ]; then
        ECHO "agile-teams and team-branches match"
else
        WARN "agile-teams and team-branches does not match"

        WARN "Team branches missing. Branches to be created: "
        diff ${PIPE_DIR}/teams.lst ${PIPE_DIR}/git_team_branches.lst |grep "<" |sed -e 's/^\< //'| sed -e 's/^/team\-/'

        WARN "Team branches found for unknown team. Branches to be deleted:"
        diff ${PIPE_DIR}/teams.lst ${PIPE_DIR}/git_team_branches.lst |grep ">" |sed -e 's/^\> //' | sed -e 's/^/team\-/'
fi
}
# ----------------------------------------------------------------------
f_maingate_checkin_list_commits_by_each_team () {
MARKER "function:f_maingate_checkin_list_commits_by_each_team"
for TEAM in ${AGILE_TEAMS}
do
        HEADER2 "List of commits by team \"${TEAM}\":"
        ECHO "git log origin/master..team-${TEAM}"
        git log origin/master..origin/team-${TEAM} --pretty=format:"%ad:%h:%H:%an:%ae:%s" --date format:'%Y-%m-%d-%H-%M-%S'  | tee  ${PIPE_DIR}/git_commits_by_${TEAM}.lst
        if [ -s ${PIPE_DIR}/git_commits_by_${TEAM}.lst ]; then
		ADDENV "TEAM_COMMITS_${TEAM}=YES"
	else
		ADDENV "TEAM_COMMITS_${TEAM}=NO"
	fi

        HEADER2 "List of files modified by team \"${TEAM}\":"
        ECHO "git log origin/master..team-${TEAM}"
        git log origin/master..origin/team-${TEAM} --pretty="" --name-only | tee ${PIPE_DIR}/git_files_modified_by_${TEAM}.lst

done
}
# ----------------------------------------------------------------------
#RAO f_maingate_checkin_checkout_team_branch () {
#RAO MARKER "function:f_maingate_checkin_checkout_team_branch"
#RAO for TEAM in ${AGILE_TEAMS}
#RAO do
#RAO 	v_commits=$(READENV TEAM_COMMITS_${TEAM})
#RAO 	if [ "${v_commits}" != "YES" ] ; then
#RAO 		ECHO "No commits for team ${TEAM}. No need to checkout team-${TEAM} branch"
#RAO         	ADDENV "TEAM_CHECKOUT_${TEAM}=N/A"
#RAO 	else
#RAO 		HEADER2 "Checkout team branch team-${TEAM} of ${MYAPP_NAME} Git repo ${GITREPO_URL}"
#RAO         	GIT_TEAM_DIR=${PIPE_DIR}/git/${TEAM}
#RAO 	        mkdir -p ${GIT_TEAM_DIR}
#RAO 		cd ${GIT_TEAM_DIR}
#RAO 	        ECHO "GIT_TEAM_DIR is ${GIT_TEAM_DIR}"
#RAO 		ADDENV "GIT_TEAM_DIR_${TEAM}=${GIT_TEAM_DIR}"
#RAO 		git clone -b team-${TEAM} ${MYAPP_GIT} ${GIT_TEAM_DIR}
#RAO 		if [ $? -ne 0 ]; then
#RAO 			ADDENV "TEAM_CHECKOUT_${TEAM}=${cFAIL}"
#RAO 			ERROR "Failed to clone ${MYAPP_GIT} git repo team-${TEAM} branch"
#RAO 		else
#RAO 			ADDENV "TEAM_CHECKOUT_${TEAM}=${cPASS}"
#RAO 		fi
#RAO 	
#RAO 		[[ ! -d ${GIT_TEAM_DIR} ]] && ERROR "Failed to clone ${MYAPP_GIT} git repo into ${GIT_TEAM_DIR} directory"
#RAO 	fi
#RAO done
#RAO 
#RAO return 0
#RAO }
# ----------------------------------------------------------------------
# ######################################################################
# START HERE
# ######################################################################
f_maingate_checkin_checkout_master
f_maingate_checkin_validate_team_branches
f_maingate_checkin_list_commits_by_each_team
#RAO f_maingate_checkin_checkout_team_branch

# ######################################################################
MARKER "script:mg_Checkin.sh END"
# ######################################################################
