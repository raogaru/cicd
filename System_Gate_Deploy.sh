# ######################################################################
FileMarker "script:System_Gate_Deploy.sh argument:$1 $2 START"
# ######################################################################
v_team=${1}	# team name
v_type=${2}	# deploy type

HEADER2 "Deploy \"${v_type}\" from ${v_team} branch requested"

# ----------------------------------------------------------------------
f_sysgate_deploy_check_build_status () {

HEADER2 "Check if build in team-${v_team} branch"

v_build=$(READENV SYSGATE_BUILD)

if [ "${v_build}" != "${cPASS}" ]; then
	WARN "SYSGATE_BUILD=${v_build}. Hence, NOT doing deploy for ${v_team}"
	ADDENV "SYSGATE_DEPLOY_${v_type}=${cNOTA}"
	return -1
else
	ECHO "Proceed with \"${v_type}\" deploy for ${v_team} ..."
fi

GIT_SYSGATE_DIR=${PIPE_DIR}/git/${v_team}

HEADER2 "List my branch"
	cd ${GIT_SYSGATE_DIR}
        git branch 

HEADER2 "Make sure working on ${v_team} branch"
        x1=$(git branch | grep "^\*" | sed -e 's/^\* //')
        [[ "${x1}" != "${v_team}" ]] && ECHOred "Current branch is not \"${v_team}\"." && return 1
        ECHO Current branch is "${x1}"

return 0
}
# ----------------------------------------------------------------------
f_sysgate_deploy () {
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
	ADDENV "SYSGATE_DEPLOY_${v_type}=${cPASS}"
	return 0
else
	ADDENV "SYSGATE_DEPLOY_${v_type}=${cFAIL}"
	return 1
fi
}
# ######################################################################
# START HERE
# ######################################################################
f_sysgate_deploy_check_build_status
if [ $? -eq 0 ]; then
	f_sysgate_deploy
fi

# ######################################################################
FileMarker "script:System_Gate_Deploy.sh END"
# ######################################################################
