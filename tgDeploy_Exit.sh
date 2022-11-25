v_script=tgDeploy_Exit.sh
# ######################################################################
MARKER "script:${v_script} argument:$1 START"
# ######################################################################
v_team=$1
#for v_team in ${AGILE_TEAMS}
#do
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
#done
# ######################################################################
MARKER "script:${v_script} END"
# ######################################################################
