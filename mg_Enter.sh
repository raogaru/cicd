# ######################################################################
MARKER "script:mg_Enter.sh START"
# ######################################################################

ECHOred "RED ${vLINE1}"
ECHOgreen "GREEN ${vLINE1}"
ECHOyellow  "YELLOw ${vLINE1}"
ECHOblue  "BLUE ${vLINE1}"
ECHOmagenta  "MAGENTA ${vLINE1}"
ECHOcyan  "CYAN ${vLINE1}"
ECHOdarkred  "DARK RED ${vLINE1}"
ECHOdarkgreen  "DARK GREEN ${vLINE1}"
ECHOdarkyellow  "DARK YELLOW ${vLINE1}"
ECHOdarkblue  "DARK BLUE ${vLINE1}"
ECHOdarkmagenta  "DARK MAGENTA ${vLINE1}"
ECHOdarkcyan  "DARK CYAN ${vLINE1}"

ECHO "Application Name is \"${MYAPP_NAME}\""
ECHO "Pipe Environment file is \"${PIPE_ENV}\""

rm -f ${PIPE_ENV}
[[ -f ${PIPE_ENV} ]] && ERROR "Failed to delete ${PIPE_ENV} file"

touch ${PIPE_ENV}
chmod 755 ${PIPE_ENV}
[[ ! -f ${PIPE_ENV} ]] && ERROR "Failed to create ${PIPE_ENV} file"

ADDENV "MYAPP_NAME=${MYAPP_NAME}"
ADDENV "AGILE_TEAMS=\"${AGILE_TEAMS}\""
ADDENV "BUILD_TYPES=\"${BUILD_TYPES}\""
ADDENV "DEPLOY_TYPES=\"${DEPLOY_TYPES}\""
ADDENV "TEST_TYPES=\"${TEST_TYPES}\""
ADDENV "DOCKER_LIST=\"${DOCKER_LIST}\""

export PIPE_NUM=$(date '+%Y%m%d%H%M')
ADDENV "PIPE_NUM=${PIPE_NUM}"

PIPE_DIR=${MYAPP_TMP}/build${MYAPP_NAME}/${PIPE_NUM}
ADDENV "PIPE_DIR=${PIPE_DIR}"

ECHO "Cleaning up 7 days old build stash on host "
rm -rf ${MYAPP_TMP}/build${MYAPP_NAME}/$(TZ=GMT+167 date +%Y%m%d)????
[[ $? -ne 0 ]] && WARN "Failed to cleaning 7 days old build directories"

mkdir -p ${PIPE_DIR}
[[ ! -d ${PIPE_DIR} ]] && ERROR "Failed to create ${PIPE_DIR} directory"

ECHO "Build Initialized - PIPE_NUM is \"${PIPE_NUM}\""

ECHO "Workspace directory is ${WORKSPACE}"

# ######################################################################
MARKER "script:mg_Enter.sh END"
# ######################################################################
