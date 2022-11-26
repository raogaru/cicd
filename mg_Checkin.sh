# ######################################################################
MARKER "script:mg_Checkin.sh START"
# ######################################################################
# ----------------------------------------------------------------------
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
# ----------------------------------------------------------------------
HEADER2 "List all branches"
	git branch -a
# ----------------------------------------------------------------------
HEADER2 "Make sure working on master branch"
        x1=$(git branch | grep "^\*" | sed -e 's/^\* //')
        [[ "${x1}" != "master" ]] && ERROR "Current branch is not \"master\"."
	ECHO Current branch is "master"
# ----------------------------------------------------------------------
#RAO HEADER2 "List development teams"
#RAO         rm -f ${PIPE_DIR}/teams.tmp
#RAO         for TEAM in ${AGILE_TEAMS}; do echo "${TEAM}" >> ${PIPE_DIR}/teams.tmp; done
#RAO         cat ${PIPE_DIR}/teams.tmp |sort > ${PIPE_DIR}/teams.lst
#RAO         cat ${PIPE_DIR}/teams.lst
#RAO         rm -f ${PIPE_DIR}/teams.tmp
# ----------------------------------------------------------------------
#RAO HEADER2 "Identify list of team-branches"
#RAO 	cd ${GIT_MASTER_DIR}
#RAO         git branch -a | grep remote | grep "\/team\-" | sed -e 's/^.*\/team-//'|sort > ${PIPE_DIR}/git_team_branches.lst
#RAO         cat ${PIPE_DIR}/git_team_branches.lst | sed -e 's/^/team\-/'
# ----------------------------------------------------------------------
#RAO HEADER2 "Compare teams with team-branches"
#RAO         diff ${PIPE_DIR}/teams.lst ${PIPE_DIR}/git_team_branches.lst
#RAO         r=$?
#RAO 
#RAO if [ $r -eq 0 ]; then
#RAO         ECHO "agile-teams and team-branches match"
#RAO else
#RAO         WARN "agile-teams and team-branches does not match"
#RAO 
#RAO         WARN "Team branches missing. Branches to be created: "
#RAO         diff ${PIPE_DIR}/teams.lst ${PIPE_DIR}/git_team_branches.lst |grep "<" |sed -e 's/^\< //'| sed -e 's/^/team\-/'

#RAO         WARN "Team branches found for unknown team. Branches to be deleted:"
#RAO         diff ${PIPE_DIR}/teams.lst ${PIPE_DIR}/git_team_branches.lst |grep ">" |sed -e 's/^\> //' | sed -e 's/^/team\-/'
#RAO fi
# ----------------------------------------------------------------------
#RAO HEADER2 "List of commits by each team"
#RAO for TEAM in ${AGILE_TEAMS}
#RAO do
#RAO         HEADER3 "List of commits by team \"${TEAM}\":"
#RAO         ECHO "git log origin/master..team-${TEAM}"
#RAO         git log origin/master..origin/team-${TEAM} --pretty=format:"%ad:%h:%H:%an:%ae:%s" --date format:'%Y-%m-%d-%H-%M-%S'  | tee  ${PIPE_DIR}/git_commits_by_${TEAM}.lst
#RAO         if [ -s ${PIPE_DIR}/git_commits_by_${TEAM}.lst ]; then
#RAO 		ADDENV "TEAM_COMMITS_${TEAM}=YES"
#RAO 	else
#RAO 		ADDENV "TEAM_COMMITS_${TEAM}=NO"
#RAO 	fi
#RAO 
#RAO         HEADER3 "List of files modified by team \"${TEAM}\":"
#RAO         ECHO "git log origin/master..team-${TEAM}"
#RAO         git log origin/master..origin/team-${TEAM} --pretty="" --name-only | tee ${PIPE_DIR}/git_files_modified_by_${TEAM}.lst
#RAO 
#RAO done
# ----------------------------------------------------------------------
#RAO HEADER2 "Checkout Team Branches"
#RAO for TEAM in ${AGILE_TEAMS}
#RAO do
#RAO 	v_commits=$(READENV TEAM_COMMITS_${TEAM})
#RAO 	if [ "${v_commits}" != "YES" ] ; then
#RAO 		ECHO "No commits for team ${TEAM}. No need to checkout team-${TEAM} branch"
#RAO         	ADDENV "TEAM_CHECKOUT_${TEAM}=N/A"
#RAO 	else
#RAO 		HEADER3 "Checkout team branch team-${TEAM} of ${MYAPP_NAME} Git repo ${GITREPO_URL}"
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
# ----------------------------------------------------------------------
# ######################################################################
MARKER "script:mg_Checkin.sh END"
# ######################################################################
