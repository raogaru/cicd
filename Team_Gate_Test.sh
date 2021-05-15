# ######################################################################
ECHOpurple "script:Team_Gate_Test.sh argument:$1 $2 START"
# ######################################################################
v_team=${1}	# team name
v_type=${2}	# test type

HEADER2 "Build \"${v_type}\" in team-${v_team} branch requested"

HEADER2 "Check if commits in team-${v_team} branch"

v_deployed=$(READENV TEAM_DEPLOY_${v_team})

if [ "${v_deployed}" != "YES" ]; then
	ECHO "Deploy not scucess. Nothing to do."
else
	ECHO "Proceed with \"${v_type}\" test for team ${v_team} ..."
fi
# ----------------------------------------------------------------------
f_teamgate_test () {

HEADER2 "team gate test "
}
# ----------------------------------------------------------------------
f_teamgate_test

case "${v_type}" in
"phase1") 
	HEADER2 "test phase1" 
	DUMMY_ACTION
	ADDENV "TEAM_TEST_${v_team}=SUCCESS"
	;;
"phase2") 
	HEADER2 "test phase2" 
	DUMMY_ACTION
	ADDENV "TEAM_TEST_${v_team}=SUCCESS"
	;;
"phase3") 
	HEADER2 "test phase3" 
	DUMMY_ACTION
	ADDENV "TEAM_TEST_${v_team}=SUCCESS"
	;;
esac

# ######################################################################
ECHOpurple "script:Team_Gate_Test.sh END"
# ######################################################################
