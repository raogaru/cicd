# ######################################################################
MARKER "script:System_Test_Exit.sh START"
# ######################################################################
HEADER2 "Evaluate test status for all test types ${TEST_TYPES}"
v_test_final=${cPASS} 
for v_type in ${TEST_TYPES}
do
	v_test=$(READENV SYSGATE_TEST_${v_type})
	ECHO "SYSGATE_TEST_${v_type}=${v_test}"
	[[ "${v_test}" == "${cFAIL}" ]] && v_test_final=${cFAIL}
	[[ "${v_test}" == "${cNOTA}" ]] && v_test_final="${cNOTA}"
done
ADDENV "SYSGATE_TEST=${v_test_final}"
# ######################################################################
MARKER "script:System_Test_Exit.sh END"
# ######################################################################
