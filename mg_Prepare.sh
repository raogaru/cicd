# ######################################################################
MARKER "script:mg_Prepare.sh START"
# ######################################################################

HEADER2 "Build DB Environment" 
HEADER3	"Build Oracle DB Docker"
DUMMY_ACTION
HEADER3	"Build PostgreSQL DB Docker"
DUMMY_ACTION
HEADER3	"Build MySQL DB Docker"
DUMMY_ACTION
HEADER3	"Build Maria DB Docker"
DUMMY_ACTION
HEADER3	"Build Redis DB Docker"
DUMMY_ACTION

HEADER2 "Build WWW Environment" 
HEADER3 "Build Nginix Docker"
DUMMY_ACTION

HEADER2 "Build APP Environment" 
HEADER3 "build Tomcat1 Docker for App1"
DUMMY_ACTION
HEADER3 "build Tomcat2 Docker for App2"
DUMMY_ACTION
HEADER3 "build Tomcat2 Docker for App3"
DUMMY_ACTION

HEADER2 "Build Kafka docker"
DUMMY_ACTION
HEADER2 "Build Vault docker"
DUMMY_ACTION
HEADER2 "Build Hygiea Docker"
DUMMY_ACTION

# ======================================================================

v_docker_build_final_status=${cPASS}
v_docker_build_final_point=""
for v_docker in ${DOCKER_LIST}
do
	HEADER2 "DOCKER BUILD ${v_docker}"
	WARN "Commented docker build command"
	#${DOCKER_HOME}/bin/docker build -t rao-${v_docker} -q docker/${v_docker} | tee ${PIPE_DIR}/docker_build_${v_docker}.log
	if [ $? -eq 0 ]; then
		ADDENV "DOCKER_BUILD_${v_docker}=${cPASS}"
	else
		ADDENV "DOCKER_BUILD_${v_docker}=${cFAIL}"
		v_docker_build_final_status=${cFAIL}
		v_docker_build_final_point=${v_docker}
	fi
done

[[ "${v_docker_build_final_status}" == "${cFAIL}" ]] && ERROR "docker build failed. check ${PIPE_DIR}/docker_build_\*.log"

# ######################################################################
MARKER "script:mg_Prepare.sh START"
# ######################################################################
