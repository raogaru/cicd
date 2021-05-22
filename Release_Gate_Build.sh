# ######################################################################
FileMarker "script:Release_Gate_Build.sh argument:$1 $2 START"
# ######################################################################

HEADER2 "Prepare Release Number"

ECHO "Release Number: ${REL_MAJOR_NUM}.${REL_MINOR_NUM}.${PIPE_NUM}"

# ######################################################################
FileMarker "script:Release_Gate_Build.sh END"
# ######################################################################
