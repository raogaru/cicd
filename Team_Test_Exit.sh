# ######################################################################
ECHOpurple "script:Team_Test_Exit.sh START"
# ######################################################################
for TEAM in ${AGILE_TEAMS}
do
	HEADER2 "Evaluate team test status for ${TEAM}"
	v_test_final="SUCCESS"
	for PHASE in ${TEAM_TEST_PHASES}
	do
		v_test=$(READENV TEAM_TEST_${TEAM}_${PHASE})
		ECHO "TEAM_TEST_${TEAM}_${PHASE}=${v_test}"
		[[ "${v_test}" == "FAILED" ]] && v_test_final="FAILED"
		[[ "${v_test}" == "N/A" ]] && v_test_final="N/A"
	done
	ADDENV "TEAM_TEST_${TEAM}=${v_test_final}"
done
# ######################################################################
ECHOpurple "script:Team_Test_Exit.sh END"
# ######################################################################
