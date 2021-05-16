# ######################################################################
ECHOpurple "script:Team_Gate_Deploy.sh argument:$1 $2 START"
# ######################################################################
v_team=${1}	# team name
v_type=${2}	# deploy type

HEADER2 "Deploy \"${v_type}\" in team-${v_team} branch requested"

# ----------------------------------------------------------------------
f_teamgate_deploy_check_build_status () {

HEADER2 "Check if build in team-${v_team} branch"

v_commits=$(READENV TEAM_COMMITS_${v_team})
v_checkout=$(READENV TEAM_CHECKOUT_${v_team})
v_build=$(READENV TEAM_BUILD_${v_team})

if [ "${v_commits}" != "YES" ] || [ "${v_checkout}" != "SUCCESS" ] || [ "${v_build}" != "SUCCESS" ]; then
	WARN "COMMITS=${v_commits}. CHECKOUT=${v_checkout}. BUILD=${v_build}. Hence, NOT doing deploy for team ${v_team}"
	ADDENV "TEAM_DEPLOY_${v_team}_${v_type}=N/A"
	return -1
else
	ECHO "Proceed with \"${v_type}\" deploy for team ${v_team} ..."
fi

GIT_TEAM_DIR=${PIPE_DIR}/git/${v_team}

HEADER2 "List my branch"
	cd ${GIT_TEAM_DIR}
        git branch 

HEADER2 "Make sure working on team-${v_team} branch"
        x1=$(git branch | grep "^\*" | sed -e 's/^\* //')
        [[ "${x1}" != "team-${v_team}" ]] && ECHOred "Current branch is not \"team-${v_team}\"." && return 1
        ECHO Current branch is "${x1}"

return 0
}
# ----------------------------------------------------------------------
f_teamgate_deploy () {
case "${v_type}" in
"db")
	HEADER2 "Deploying to DB using liquibase" 
	DUMMY_ACTION
	. ${WORKSPACE}/deploy_${v_type}.sh ${v_team}
	;;
"kubernetes")
	HEADER2 "Deploying docker using kubectl" 
	DUMMY_ACTION
	. ${WORKSPACE}/deploy_${v_type}.sh
	;;
"tomcat")
	HEADER2 "Deploying jar to tomcat"
	DUMMY_ACTION
	. ${WORKSPACE}/deploy_${v_type}.sh
	;;
"dep1")
	HEADER2 "Deploying dep1"
	DUMMY_ACTION
	. ${WORKSPACE}/deploy_${v_type}.sh
	;;
"dep2")
	HEADER2 "Deploying dep2"
	DUMMY_ACTION
	. ${WORKSPACE}/deploy_${v_type}.sh
	;;
"dep3")
	HEADER2 "Deploying dep3"
	DUMMY_ACTION
	. ${WORKSPACE}/deploy_${v_type}.sh
	;;
esac

r=$?

if [ $r -eq 0 ]; then
	ADDENV "TEAM_DEPLOY_${v_team}_${v_type}=SUCCESS"
	return 0
else
	ADDENV "TEAM_DEPLOY_${v_team}_${v_type}=FAILED"
	return 1
fi
}
# ######################################################################
# START HERE
# ######################################################################
f_teamgate_deploy_check_build_status
if [ $? -eq 0 ]; then
	f_teamgate_deploy
fi

# ######################################################################
ECHOpurple "script:Team_Gate_Deploy.sh END"
# ######################################################################
