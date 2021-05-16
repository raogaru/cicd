# ######################################################################
ECHOpurple "script:System_Build_Exit.sh START"
# ######################################################################
HEADER2 "Evaluate build status for all build types ${BUILD_TYPES}"
v_build_final="SUCCESS"
for v_type in ${BUILD_TYPES}
do
	v_build=$(READENV SYSGATE_BUILD_${v_type})
	ECHO "SYSGATE_BUILD_${v_type}=${v_build}"
	[[ "${v_build}" == "FAILED" ]] && v_build_final="FAILED"
	[[ "${v_build}" == "N/A" ]] && v_build_final="N/A"
done
ADDENV "SYSGATE_BUILD=${v_build_final}"
# ######################################################################
ECHOpurple "script:System_Build_Exit.sh END"
# ######################################################################
