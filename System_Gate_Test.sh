# ######################################################################
MARKER "script:System_Gate_Test.sh argument:$1 START"
# ######################################################################
v_type=${1}	# test type

HEADER2 "Test \"${v_type}\" from sysgate branch requested"

HEADER2 "Check if deploy in sysgate branch successful"

v_deployed=$(READENV SYSGATE_DEPLOY)

# ----------------------------------------------------------------------
f_sysgate_test_val_build () {
if [ "${v_deployed}" != "${cPASS}" ]; then
	ECHO "Deploy not scucess. Nothing to do."
	return 1
else
	ECHO "Proceed with \"${v_type}\" test for sysgate ..."
fi
return 0
}
# ----------------------------------------------------------------------
f_sysgate_test () {
HEADER2 "sysgate test "
case "${v_type}" in
"phase1") 
	HEADER2 "test phase1" 
	DUMMY_ACTION
	;;
"phase2") 
	HEADER2 "test phase2" 
	DUMMY_ACTION
	;;
"phase3") 
	HEADER2 "test phase3" 
	DUMMY_ACTION
	;;
esac
r=$?
if [ $? -eq 0 ]; then
	ADDENV "SYSGATE_TEST_${v_type}=${cPASS}"
else
	ADDENV "SYSGATE_TEST_${v_type}=${cFAIL}"
fi
}
# ----------------------------------------------------------------------
f_sysgate_test_val_build
if [ $? -eq 0 ]; then 
	f_sysgate_test
fi
# ######################################################################
MARKER "script:System_Gate_Test.sh END"
# ######################################################################
