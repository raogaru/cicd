# ######################################################################
FileMarker "script:Team_Build_Exit.sh START"
# ######################################################################
for v_team in ${AGILE_TEAMS}
do
	HEADER2 "Evaluate team build status for ${v_team}"
	v_build_final="SUCCESS"
	for v_type in ${BUILD_TYPES}
	do
		v_build=$(READENV TEAM_BUILD_${v_team}_${v_type})
		ECHO "TEAM_BUILD_${v_team}_${v_type}=${v_build}"
		[[ "${v_build}" == "FAILED" ]] && v_build_final="FAILED"
		[[ "${v_build}" == "N/A" ]] && v_build_final="N/A"
	done
	ADDENV "TEAM_BUILD_${v_team}=${v_build_final}"
done
# ######################################################################
FileMarker "script:Team_Build_Exit.sh END"
# ######################################################################
