# ######################################################################
MARKER "script:System_Build_Exit.sh START"
# ######################################################################
HEADER2 "Evaluate build status for all build types ${BUILD_TYPES}"
v_build_final=${cPASS}
for v_type in ${BUILD_TYPES}
do
	v_build=$(READENV SYSGATE_BUILD_${v_type})
	ECHO "SYSGATE_BUILD_${v_type}=${v_build}"
	[[ "${v_build}" == "${cFAIL}" ]] && v_build_final="${cFAIL}"
	[[ "${v_build}" == "${cNOTA}" ]] && v_build_final="${cNOTA}"
done
ADDENV "SYSGATE_BUILD=${v_build_final}"
# ######################################################################
MARKER "script:System_Build_Exit.sh END"
# ######################################################################
