# ######################################################################
ECHOpurple "script:Team_Gate_Build.sh argument:$1 $2 START"
# ######################################################################
v_team=${1}	# team name
v_type=${2}	# build type

HEADER2 "Build \"${v_type}\" in team-${v_team} branch requested"

HEADER2 "Check if commits in team-${v_team} branch"

# ----------------------------------------------------------------------
f_teamgate_checkout_status_check () {
v_checkout=$(READENV TEAM_CHECKOUT_${v_team})

if [ "${v_checkout}" != "SUCCESS" ]; then
	ECHO "Checkout not success. Noting to do"
else
	ECHO "Proceed with \"${v_type}\" build for team ${v_team} ..."
fi
}
# ----------------------------------------------------------------------
f_teamgate_build () {
ECHOpurple "function:f_teamgate_build"

GIT_TEAM_DIR=${PIPE_DIR}/git/${v_team}

HEADER2 "List my branch"
        cd ${GIT_TEAM_DIR}
        git branch

HEADER2 "Make sure working on team-${v_team} branch"
        x1=$(git branch | grep "^\*" | sed -e 's/^\* //')
        [[ "${x1}" != "team-${v_team}" ]] && ECHOred "Current branch is not \"team-${v_team}\"." && return 1
        ECHO Current branch is "${x1}"

case "${v_type}" in
"jar") 
	HEADER2 "Building jar using maven" 
	DUMMY_ACTION
	;;
"docker") 
	HEADER2 "Building docker using kubectl" 
	DUMMY_ACTION
	;;
"ec2") 
	HEADER2 "Building ec2 using awscli" 
	DUMMY_ACTION
	;;
"abc") 
	HEADER2 "Building abc " 
	DUMMY_ACTION
	;;
"pqr") 
	HEADER2 "Building pqr " 
	DUMMY_ACTION
	;;
"xyz") 
	HEADER2 "Building xyz " 
	DUMMY_ACTION
	;;
esac

./build_${v_type}.sh
r=$?
if [ $? -eq 0 ]; then
	ADDENV "TEAM_BUILD_${v_team}_${v_type}=SUCCESS"
else
	ADDENV "TEAM_BUILD_${v_team}_${v_type}=FAILED"
fi
}
# ######################################################################
# START HERE
# ######################################################################
f_teamgate_checkout_status_check
if [ $? -eq 0 ]; then 
	f_teamgate_build
fi
# ######################################################################
ECHOpurple "script:Team_Gate_Build.sh END"
# ######################################################################
