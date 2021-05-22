# ######################################################################
FileMarker "script:Team_Test_Exit.sh START"
# ######################################################################
for v_team in ${AGILE_TEAMS}
do
	HEADER2 "Evaluate team test status for ${v_team}"
	v_test_final=${cPASS}
	for v_type in ${TEST_TYPES}
	do
		v_test=$(READENV TEAM_TEST_${v_team}_${v_type})
		ECHO "TEAM_TEST_${v_team}_${v_type}=${v_test}"
		[[ "${v_test}" == "${cFAIL}" ]] && v_test_final="${cFAIL}"
		[[ "${v_test}" == "${cNOTA}" ]] && v_test_final="${cNOTA}"
	done
	ADDENV "TEAM_TEST_${v_team}=${v_test_final}"
done
# ######################################################################
FileMarker "script:Team_Test_Exit.sh END"
# ######################################################################
