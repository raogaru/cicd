# ######################################################################
MARKER "script:System_Deploy_Exit.sh START"
# ######################################################################
HEADER2 "Evaluate deploy status for all deploy types ${DEPLOY_TYPES}"
v_deploy_final=${cPASS}
for v_type in ${DEPLOY_TYPES}
do
	v_deploy=$(READENV SYSGATE_DEPLOY_${v_type})
	ECHO "SYSGATE_DEPLOY_${v_type}=${v_deploy}"
	[[ "${v_deploy}" == "${cFAIL}" ]] && v_deploy_final="${cFAIL}"
	[[ "${v_deploy}" == "${cNOTA}" ]] && v_deploy_final="${cNOTA}"
done
ADDENV "SYSGATE_DEPLOY=${v_deploy_final}"
# ######################################################################
MARKER "script:System_Deploy_Exit.sh END"
# ######################################################################
