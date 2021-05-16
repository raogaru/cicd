# ######################################################################
ECHOpurple "script:System_Test_Exit.sh START"
# ######################################################################
HEADER2 "Evaluate team test status for ${TEAM}"
v_test_final="SUCCESS"
for v_type in ${TEST_TYPES}
do
	v_test=$(READENV SYSGATE_TEST_${v_type})
	ECHO "SYSGATE_TEST_${v_type}=${v_test}"
	[[ "${v_test}" == "FAILED" ]] && v_test_final="FAILED"
	[[ "${v_test}" == "N/A" ]] && v_test_final="N/A"
done
ADDENV "SYSGATE_TEST=${v_test_final}"
# ######################################################################
ECHOpurple "script:System_Test_Exit.sh END"
# ######################################################################
