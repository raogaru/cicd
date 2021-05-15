# ######################################################################
ECHOpurple "script:Team_Gate_Test.sh argument:$1 $2 START"
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
"test1") 
	HEADER2 "test phase1" 
	DUMMY_ACTION
ADDENV "TEAM_TEST_${v_team}=SUCCESS"
	;;
"test2") 
	HEADER2 "test phase2" 
	DUMMY_ACTION
ADDENV "TEAM_TEST_${v_team}=SUCCESS"
	;;
"test3") 
	HEADER2 "test phase3" 
	DUMMY_ACTION
ADDENV "TEAM_TEST_${v_team}=SUCCESS"
	;;
esac

# ######################################################################
ECHOpurple "script:Team_Gate_Test.sh END"
# ######################################################################
