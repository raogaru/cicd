# ######################################################################
echo Team-Gate-Build.sh START
# ######################################################################
v_team=${1}	# team name
v_type=${2}	# build type

HEADER2 "Build \"${v_type}\" in team-${v_team} branch requested"

HEADER2 "Check if commits in team-${v_team} branch"

v_commits=$(READENV TEAM_COMMITS_${v_team})

if [ "${v_commits}" != "YES" ]; then
	ECHO "No commits. Nothing to do."
else
	ECHO "Proceed with \"${v_type}\" build for team ${v_team} ..."
fi

GIT_TEAM_DIR=${PIPE_DIR}/git/${v_team}

HEADER2 "List my branch"
	cd ${GIT_TEAM_DIR}
        git branch 

HEADER2 "Make sure working on team-${v_team} branch"
        x1=$(git branch | grep "^\*" | sed -e 's/^\* //')
        [[ "${x1}" != "team-${v_team}" ]] && ERROR "Current branch is not \"team-${v_team}\"."
        ECHO Current branch is "${x1}"


case "${v_type}" in
"liquibase")
	HEADER2 "Deploying to DB using liquibase" 
	;;
"kubernetes")
	HEADER2 "Deploying docker using kubectl" 
	;;
"tomcat")
	HEADER2 "Deploying jar to tomcat"
	;;
esac

ADDENV "TEAM_DEPLOY_${v_team}=SUCCESS"
exit 0
# ######################################################################
echo Team-Gate-Build.sh END
# ######################################################################
