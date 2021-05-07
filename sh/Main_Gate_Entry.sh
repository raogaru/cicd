# ######################################################################
# Main-Gate-Entry.sh 
# ######################################################################
echo "Script $0 START"
rm -f ${PIPE_ENV}
[[ -f ${PIPE_ENV} ]] && ERROR "Failed to delete ${PIPE_ENV} file"

touch ${PIPE_ENV}
chmod 755 ${PIPE_ENV}
[[ -f ${PIPE_ENV} ]] && ERROR "Failed to create ${PIPE_ENV} file"

export PIPE_NUM=$(date '+%Y%m%d%H%M')
ADDENV "PIPE_NUM=${PIPE_NUM}"

PIPE_DIR=/tmp/build${MYAPP_NAME}/${PIPE_NUM}
ADDENV "PIPE_DIR=${PIPE_DIR}"

mkdir -p ${PIPE_DIR}
[[ ! -d ${PIPE_DIR} ]] && ERROR "Failed to create ${PIPE_DIR} directory"

ADDENV "AGILE_TEAMS=\"${AGILE_TEAMS}\""

ECHOpurple "Build Initialized - PIPE_NUM is \"${PIPE_NUM}\""

echo "Script $0 END"
# ######################################################################
# EOF
# ######################################################################
