# ######################################################################
FileMarker "script:Main_Gate_Build.sh START"
# ######################################################################

v_docker_build_final_status=${cPASS}
v_docker_build_final_point=""
for v_docker in ${DOCKER_LIST}
do
	HEADER2 "DOCKER BUILD ${v_docker}"
	docker build -t rao-${v_docker} docker/${v_docker} | pipe ${PIPE_DIR}/docker_build_${v_docker}.log
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
FileMarker "script:Main_Gate_Build.sh END"
# ######################################################################
