# ######################################################################
MARKER "script:Team_Deploy_Exit.sh START"
# ######################################################################
for v_team in ${AGILE_TEAMS}
do
	HEADER2 "Evaluate team deploy status for ${v_team}"
	v_deploy_final=${cPASS}
	for v_type in ${DEPLOY_TYPES}
	do
		v_deploy=$(READENV TEAM_DEPLOY_${v_team}_${v_type})
		ECHO "TEAM_DEPLOY_${v_team}_${v_type}=${v_deploy}"
		[[ "${v_deploy}" == "${cFAIL}" ]] && v_deploy_final="${cFAIL}"
		[[ "${v_deploy}" == "${cNOTA}" ]] && v_deploy_final="${cNOTA}"
	done
	ADDENV "TEAM_DEPLOY_${v_team}=${v_deploy_final}"
done
# ######################################################################
MARKER "script:Team_Deploy_Exit.sh END"
# ######################################################################
