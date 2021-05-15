# ######################################################################
ECHOpurple "script:Team_Gate_Build.sh argument:$1 $2 START"
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
# ----------------------------------------------------------------------
f_teamgate_checkout_team_branch () {
HEADER2 "Checkout team branch team-${v_team} of ${MYAPP_NAME} Git repo ${GITREPO_URL}"
        GIT_TEAM_DIR=${PIPE_DIR}/git/${v_team}
        ECHO "GIT_TEAM_DIR is ${GIT_TEAM_DIR}"
        mkdir -p ${GIT_TEAM_DIR}
        git clone -b team-${v_team} ${MYAPP_GIT} ${GIT_TEAM_DIR}
        [[ $? -ne 0 ]] && ERROR "Failed to clone ${MYAPP_GIT} git repo team-${v_team} branch"
        [[ ! -d ${GIT_TEAM_DIR} ]] && ERROR "Failed to clone ${MYAPP_GIT} git repo into ${GIT_TEAM_DIR} directory"
        ADDENV "GIT_TEAM_DIR_${v_team}=${GIT_TEAM_DIR}"

HEADER2 "List my branch"
        cd ${GIT_TEAM_DIR}
        git branch

HEADER2 "Make sure working on team-${v_team} branch"
        x1=$(git branch | grep "^\*" | sed -e 's/^\* //')
        [[ "${x1}" != "team-${v_team}" ]] && ERROR "Current branch is not \"team-${v_team}\"."
        ECHO Current branch is "${x1}"
}
# ----------------------------------------------------------------------
f_teamgate_checkout_team_branch

case "${v_type}" in
"jar") 
	HEADER2 "Building jar using maven" 
	DUMMY_ACTION
	ADDENV "TEAM_BUILD_${v_team}=SUCCESS"
	;;
"docker") 
	HEADER2 "Building docker using kubectl" 
	DUMMY_ACTION
	ADDENV "TEAM_BUILD_${v_team}=SUCCESS"
	;;
"ec2") 
	HEADER2 "Building ec2 using awscli" 
	DUMMY_ACTION
	ADDENV "TEAM_BUILD_${v_team}=SUCCESS"
	;;
"abc") 
	HEADER2 "Building abc " 
	DUMMY_ACTION
	ADDENV "TEAM_BUILD_${v_team}=SUCCESS"
	;;
"pqr") 
	HEADER2 "Building pqr " 
	DUMMY_ACTION
	ADDENV "TEAM_BUILD_${v_team}=SUCCESS"
	;;
"xyz") 
	HEADER2 "Building xyz " 
	DUMMY_ACTION
	ADDENV "TEAM_BUILD_${v_team}=SUCCESS"
	;;
esac


# ######################################################################
ECHOpurple "script:Team_Gate_Build.sh END"
# ######################################################################
