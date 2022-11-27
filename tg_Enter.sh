# ######################################################################
MARKER "script:tg_Enter.sh START"
# ######################################################################
HEADER2 "List development teams"
        rm -f ${PIPE_DIR}/teams.tmp
        for TEAM in ${AGILE_TEAMS}; do echo "${TEAM}" >> ${PIPE_DIR}/teams.tmp; done
        cat ${PIPE_DIR}/teams.tmp |sort > ${PIPE_DIR}/teams.lst
        cat ${PIPE_DIR}/teams.lst
        rm -f ${PIPE_DIR}/teams.tmp

HEADER2 "Identify list of team-branches"
	cd ${GIT_MASTER_DIR}
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
# ----------------------------------------------------------------------
for TEAM in ${AGILE_TEAMS}
do
        HEADER2 "List of commits by team \"${TEAM}\":"
        SHOWCMD "git log origin/${GIT_MASTER_BRANCH}..team-${TEAM}"
        git log origin/${GIT_MASTER_BRANCH}..origin/team-${TEAM} --pretty=format:"%ad:%h:%H:%an:%ae:%s" --date format:'%Y-%m-%d-%H-%M-%S'  | tee  ${PIPE_DIR}/git_commits_by_${TEAM}.lst
	echo ""
        if [ -s ${PIPE_DIR}/git_commits_by_${TEAM}.lst ]; then
		ADDENV "TEAM_COMMITS_${TEAM}=YES"
	else
		ADDENV "TEAM_COMMITS_${TEAM}=NO"
	fi
done
# ----------------------------------------------------------------------
for TEAM in ${AGILE_TEAMS}
do
        HEADER2 "List of files modified by team \"${TEAM}\":"
        SHOWCMD "git log origin/${GIT_MASTER_BRANCH}..team-${TEAM}"
        git log origin/${GIT_MASTER_BRANCH}..origin/team-${TEAM} --pretty="" --name-only | tee ${PIPE_DIR}/git_files_modified_by_${TEAM}.lst
	echo ""
done
# ----------------------------------------------------------------------
HEADER2 "Checkout team branches"
for TEAM in ${AGILE_TEAMS}
do
	v_commits=$(READENV TEAM_COMMITS_${TEAM})
	if [ "${v_commits}" == "YES" ] ; then
		HEADER2 "Checkout team branch team-${TEAM} of ${MYAPP_NAME} Git repo ${MYAPP_GIT}"
        	GIT_TEAM_DIR=${PIPE_DIR}/git/${TEAM}
	        mkdir -p ${GIT_TEAM_DIR}
		cd ${GIT_TEAM_DIR}
	        ECHO "GIT_TEAM_DIR is ${GIT_TEAM_DIR}"
		ADDENV "GIT_TEAM_DIR_${TEAM}=${GIT_TEAM_DIR}"
		SHOWCMD "git clone -b team-${TEAM} ${MYAPP_GIT} ${GIT_TEAM_DIR}"
		git clone -b team-${TEAM} ${MYAPP_GIT} ${GIT_TEAM_DIR}
		if [ $? -eq 0 ]; then
			ADDENV "TEAM_CHECKOUT_${TEAM}=${cPASS}"
		else
			ADDENV "TEAM_CHECKOUT_${TEAM}=${cFAIL}"
			ERROR "Failed to clone ${MYAPP_GIT} git repo team-${TEAM} branch"
		fi
		[[ ! -d ${GIT_TEAM_DIR} ]] && ERROR "Failed to clone ${MYAPP_GIT} git repo into ${GIT_TEAM_DIR} directory"
	else
		ECHO "No commits for team ${TEAM}. No need to checkout team-${TEAM} branch"
        	ADDENV "TEAM_CHECKOUT_${TEAM}=${cNOTA}"
	fi
done
# ----------------------------------------------------------------------
HEADER2 "Drop and recreate build branches"
for TEAM in ${AGILE_TEAMS}
do
	v_commits=$(READENV TEAM_COMMITS_${TEAM})
	if [ "${v_commits}" == "YES" ] ; then
		HEADER3 "Drop and recreated build branch build-${TEAM}"
        	GIT_TEAM_DIR=${PIPE_DIR}/git/${TEAM}
		cd ${GIT_TEAM_DIR}
		ECHO "Current branch should be team-${TEAM}"
		git branch

		ECHO "Drop build branch build-${TEAM}"
		SHOWCMD "git branch -D build-${TEAM}"
		git branch -D build-${TEAM}

		ECHO "Create build branch build-${TEAM}"
		SHOWCMD "git branch build-${TEAM}"
		git branch build-${TEAM}

		ECHO "Checkout build branch build-${TEAM}"
		SHOWCMD "git checkout build-${TEAM}"w
		git checkout build-${TEAM}

		ECHO "Current branch should be build-${TEAM}"
		git branch
	fi
done
# ----------------------------------------------------------------------
HEADER2 "Verify DB connectivity"
for TEAM in ${AGILE_TEAMS}
do
	v_commits=$(READENV TEAM_COMMITS_${TEAM})
	if [ "${v_commits}" == "YES" ] ; then

	TMP_DB_SQL=${PIPE_DIR}/tmp_db_${v_team}.sql
	echo "select datname from pg_database where datname='${TEAM}';" > ${TMP_DB_SQL}

	export PGPASSWORD=rao
	${PGSQL_HOME}/bin/psql -h localhost -p 5432 -d ${TEAM} -U rao -f ${TMP_DB_SQL}
	r=$?
	if [ $r -eq 0 ]; then
		ECHO "DB connection successful for ${v_team}"
	else
		ERROR "DB connection failed for ${v_team}"
	fi
	fi
done
# ######################################################################
MARKER "script:tg_Enter.sh END"
# ######################################################################
