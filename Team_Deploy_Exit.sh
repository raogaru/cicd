# ######################################################################
ECHOpurple "script:Team_Deploy_Exit.sh START"
# ######################################################################
for TEAM in ${AGILE_TEAMS}
do
	HEADER2 "Evaluate team deploy status for ${TEAM}"
	v_deploy_final="SUCCESS"
	for PHASE in ${TEAM_DEPLOY_PHASES}
	do
		v_deploy=$(READENV TEAM_DEPLOY_${TEAM}_${PHASE})
		ECHO "TEAM_DEPLOY_${TEAM}_${PHASE}=${v_deploy}"
		[[ "${v_deploy}" == "FAILED" ]] && v_deploy_final="FAILED"
		[[ "${v_deploy}" == "N/A" ]] && v_deploy_final="N/A"
	done
	ADDENV "TEAM_DEPLOY_${TEAM}=${v_deploy_final}"
done
# ######################################################################
ECHOpurple "script:Team_Deploy_Exit.sh END"
# ######################################################################
