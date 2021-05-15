# ######################################################################
echo Team_Gate_Deploy.sh START
# ######################################################################
v_team=${1}	# team name
v_type=${2}	# deploy type

HEADER2 "Deploy \"${v_type}\" in team-${v_team} branch requested"

HEADER2 "Check if build in team-${v_team} branch"

v_build_status=$(READENV TEAM_BUILD_${v_team})

if [ "${v_build_status}" != "SUCCESS" ]; then
	ECHO "Team Build for \"${v_team}\" not SUCCESS. Nothing to deploy."
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

# ######################################################################
# START HERE 
# ######################################################################

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

# ######################################################################
echo Team_Gate_Deploy.sh END
# ######################################################################