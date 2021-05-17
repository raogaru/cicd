# ######################################################################
FileMarker "script:Team_Test_Exit.sh START"
# ######################################################################
for v_team in ${AGILE_TEAMS}
do
	HEADER2 "Evaluate team test status for ${v_team}"
	v_test_final="SUCCESS"
	for v_type in ${TEST_TYPES}
	do
		v_test=$(READENV TEAM_TEST_${v_team}_${v_type})
		ECHO "TEAM_TEST_${v_team}_${v_type}=${v_test}"
		[[ "${v_test}" == "FAILED" ]] && v_test_final="FAILED"
		[[ "${v_test}" == "N/A" ]] && v_test_final="N/A"
	done
	ADDENV "TEAM_TEST_${v_team}=${v_test_final}"
done
# ######################################################################
FileMarker "script:Team_Test_Exit.sh END"
# ######################################################################
