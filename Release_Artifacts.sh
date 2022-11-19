# ######################################################################
MARKER "script:Release_Artifacts.sh argument:$1 $2 START"
# ######################################################################

REL_NOTES=${PIPE_DIR}/release_notes_${PIPE_NUM}.txt

# ----------------------------------------------------------------------
HEADER2 "Title"
echo "${vLINE1}
RELEASE NOTES 

Application Name: ${MYAPP_NAME}

Release Number  : ${REL_MAJOR_NUM}.${REL_MINOR_NUM}.${PIPE_NUM}

Release Time    : $(date '+%Y-%m-%d %H:%M:%S')

Git Repository  : ${MYAPP_GIT}

Agile Teams     : ${AGILE_TEAMS}

${vLINE1}

" >> ${REL_NOTES}

# ----------------------------------------------------------------------
HEADER2 "Git Commits by Team"


for v_team in ${AGILE_TEAMS}
do
echo "
${vLINE2} 
Git commits information by team \"${v_team}\"

" >> ${REL_NOTES}

cat ${PIPE_DIR}/git_commits_by_${v_team}.lst | awk ' BEGIN {FS=":"} ; { print "Commit Time:",$1,"\nCommit Hash:",$2," - ",$3,"\nUser ID    :",$4,"\nEmail ID   :",$5,"\nComments   :",$6,"\n" }' >> ${REL_NOTES}

done

# ----------------------------------------------------------------------
HEADER2 "Git Files Modified by Team"

for v_team in ${AGILE_TEAMS}
do
echo "
${vLINE2}
Git files modified by team \"${v_team}\"

" >> ${REL_NOTES}
cat ${PIPE_DIR}/git_files_modified_by_${v_team}.lst >> ${REL_NOTES}
done


# ######################################################################
MARKER "script:Release_Artifacts.sh END"
# ######################################################################
