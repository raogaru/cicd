# ######################################################################
# Main-Gate-Entry.sh 
# ######################################################################
ECHO "Script $0 START"

ECHO "Application Name is \"${MYAPP_NAME}\""
ECHO "Pipe Environment file is \"${PIPE_ENV}\""

rm -f ${PIPE_ENV}
[[ -f ${PIPE_ENV} ]] && ERROR "Failed to delete ${PIPE_ENV} file"

touch ${PIPE_ENV}
chmod 755 ${PIPE_ENV}
[[ ! -f ${PIPE_ENV} ]] && ERROR "Failed to create ${PIPE_ENV} file"

ADDENV "MYAPP_NAME=${MYAPP_NAME}"
ADDENV "AGILE_TEAMS=\"${AGILE_TEAMS}\""

export PIPE_NUM=$(date '+%Y%m%d%H%M')
ADDENV "PIPE_NUM=${PIPE_NUM}"

PIPE_DIR=/tmp/build${MYAPP_NAME}/${PIPE_NUM}
ADDENV "PIPE_DIR=${PIPE_DIR}"

mkdir -p ${PIPE_DIR}
[[ ! -d ${PIPE_DIR} ]] && ERROR "Failed to create ${PIPE_DIR} directory"

ECHO "Build Initialized - PIPE_NUM is \"${PIPE_NUM}\""

echo "Script $0 END"
# ######################################################################
# EOF
# ######################################################################
