# ######################################################################
MARKER "script:Team_Build_Exit.sh START"
# ######################################################################
for v_team in ${AGILE_TEAMS}
do
	HEADER2 "Evaluate team build status for ${v_team}"
	v_build_final=${cPASS}
	for v_type in ${BUILD_TYPES}
	do
		v_build=$(READENV TEAM_BUILD_${v_team}_${v_type})
		ECHO "TEAM_BUILD_${v_team}_${v_type}=${v_build}"
		[[ "${v_build}" == "${cFAIL}" ]] && v_build_final=${cFAIL}
		[[ "${v_build}" == "${cNOTA}" ]] && v_build_final="${cNOTA}"
	done
	ADDENV "TEAM_BUILD_${v_team}=${v_build_final}"
done
# ######################################################################
MARKER "script:Team_Build_Exit.sh END"
# ######################################################################
