# ######################################################################
ECHOpurple "script:Team_Build_Exit.sh START"
# ######################################################################
for TEAM in ${AGILE_TEAMS}
do
	HEADER2 "Evaluate team build status for ${TEAM}"
	v_build_final="SUCCESS"
	for PHASE in ${TEAM_BUILD_PHASES}
	do
		v_build=$(READENV TEAM_BUILD_${TEAM}_${PHASE})
		ECHO "TEAM_BUILD_${TEAM}_${PHASE}=${v_build}"
		[[ "${v_build}" == "FAILED" ]] && v_build_final="FAILED"
		[[ "${v_build}" == "N/A" ]] && v_build_final="N/A"
	done
	ADDENV "TEAM_BUILD_${TEAM}=${v_build_final}"
done
# ######################################################################
ECHOpurple "script:Team_Build_Exit.sh END"
# ######################################################################
