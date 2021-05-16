# ######################################################################
ECHOpurple "script:Team_Deploy_Exit.sh START"
# ######################################################################
for v_team in ${AGILE_TEAMS}
do
	HEADER2 "Evaluate team deploy status for ${v_team}"
	v_deploy_final="SUCCESS"
	for v_type in ${DEPLOY_TYPES}
	do
		v_deploy=$(READENV TEAM_DEPLOY_${v_team}_${v_type})
		ECHO "TEAM_DEPLOY_${v_team}_${v_type}=${v_deploy}"
		[[ "${v_deploy}" == "FAILED" ]] && v_deploy_final="FAILED"
		[[ "${v_deploy}" == "N/A" ]] && v_deploy_final="N/A"
	done
	ADDENV "TEAM_DEPLOY_${v_team}=${v_deploy_final}"
done
# ######################################################################
ECHOpurple "script:Team_Deploy_Exit.sh END"
# ######################################################################
