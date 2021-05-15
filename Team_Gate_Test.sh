# ######################################################################
ECHOpurple "script:Team_Gate_Test.sh argument:$1 $2 START"
# ######################################################################
v_team=${1}	# team name
v_type=${2}	# test type

HEADER2 "Test \"${v_type}\" in team-${v_team} branch requested"

HEADER2 "Check if deploy in team-${v_team} branch successful"

v_deployed=$(READENV TEAM_DEPLOY_${v_team})

# ----------------------------------------------------------------------
f_teamgate_test_val_build () {
if [ "${v_deployed}" != "SUCCESS" ]; then
	ECHO "Deploy not scucess. Nothing to do."
	return 1
else
	ECHO "Proceed with \"${v_type}\" test for team ${v_team} ..."
fi
}
# ----------------------------------------------------------------------
f_teamgate_test () {
HEADER2 "team gate test "
case "${v_type}" in
"phase1") 
	HEADER2 "test phase1" 
	DUMMY_ACTION
	if [ $? -eq 0 ]; then
		ADDENV "TEAM_TEST_${v_team}_${v_type}=SUCCESS"
	else
		ADDENV "TEAM_TEST_${v_team}_${v_type}=FAILED"
	fi
	;;
"phase2") 
	HEADER2 "test phase2" 
	DUMMY_ACTION
	if [ $? -eq 0 ]; then
		ADDENV "TEAM_TEST_${v_team}_${v_type}=SUCCESS"
	else
		ADDENV "TEAM_TEST_${v_team}_${v_type}=FAILED"
	fi
	ADDENV "TEAM_TEST_${v_team}=SUCCESS"
	;;
"phase3") 
	HEADER2 "test phase3" 
	DUMMY_ACTION
	if [ $? -eq 0 ]; then
		ADDENV "TEAM_TEST_${v_team}_${v_type}=SUCCESS"
	else
		ADDENV "TEAM_TEST_${v_team}_${v_type}=FAILED"
	fi
	ADDENV "TEAM_TEST_${v_team}=SUCCESS"
	;;
esac
}
# ----------------------------------------------------------------------
f_teamgate_test_val_build
if [ $? -eq 0 ]; then 
	f_teamgate_test
fi
# ######################################################################
ECHOpurple "script:Team_Gate_Test.sh END"
# ######################################################################
