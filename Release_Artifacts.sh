# ######################################################################
FileMarker "script:Release_Artifacts.sh argument:$1 $2 START"
# ######################################################################


REL_NOTES=${PIPE_DIR}/release_notes_${PIPE_NUM}.txt

# ----------------------------------------------------------------------
HEADER2 "Git Commits by Team"

echo ${vLINE1} > ${REL_NOTES}
echo "RELEASE NOTES for Release ${REL_MAJOR_NUM}.${REL_MINOR_NUM}.${PIPE_NUM}" >> ${REL_NOTES}
echo ${vLINE1} >> ${REL_NOTES}
echo "" >> ${REL_NOTES}

for v_team in ${AGILE_TEAMS}
do
	echo ${vLINE2} >> ${REL_NOTES}
	echo "Git Commits Info by Team \"${v_team}\""  >> ${REL_NOTES}
	echo "" >> ${REL_NOTES}
	cat ${PIPE_DIR}/git_commits_by_${v_team}.lst | awk ' BEGIN {FS=":"} ; { print "Commit Time:",$1,"\nCommit Hash:",$2," - ",$3,"\nUser ID    :",$4,"\nEmail ID   :",$5,"\nComments   :",$6,"\n" }' >> ${REL_NOTES}

done

# ----------------------------------------------------------------------
HEADER2 "Git Files Modified by Team"

for v_team in ${AGILE_TEAMS}
do
	echo ${vLINE2} >> ${REL_NOTES}
	echo "Git Files Modified by Team \"${v_team}\""  >> ${REL_NOTES}
	echo "" >> ${REL_NOTES}
	cat ${PIPE_DIR}/git_files_modified_by_${TEAM}.lst >> >> ${REL_NOTES}
done


# ######################################################################
FileMarker "script:Release_Artifacts.sh END"
# ######################################################################
