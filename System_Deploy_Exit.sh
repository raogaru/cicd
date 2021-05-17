# ######################################################################
FileMarker "script:System_Deploy_Exit.sh START"
# ######################################################################
HEADER2 "Evaluate deploy status for all deploy types ${DEPLOY_TYPES}"
v_deploy_final="SUCCESS"
for v_type in ${DEPLOY_TYPES}
do
	v_deploy=$(READENV SYSGATE_DEPLOY_${v_type})
	ECHO "SYSGATE_DEPLOY_${v_type}=${v_deploy}"
	[[ "${v_deploy}" == "FAILED" ]] && v_deploy_final="FAILED"
	[[ "${v_deploy}" == "N/A" ]] && v_deploy_final="N/A"
done
ADDENV "SYSGATE_DEPLOY=${v_deploy_final}"
# ######################################################################
FileMarker "script:System_Deploy_Exit.sh END"
# ######################################################################
