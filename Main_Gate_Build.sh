# ######################################################################
FileMarker "script:Main_Gate_Build.sh START"
# ######################################################################

for v_docker in ${DOCKER_LIST}
do
	HEADER2 "DOCKER BUILD ${v_docker}"
	docker build -t rao-${v_docker} docker/${v_docker} | pipe ${PIPE_DIR}/docker_build_${v_docker}.log
	if [ $? -eq 0 ]; then
		ADDENV "DOCKER_BUILD_${v_docker}=PASS"
	else
		ADDENV "DOCKER_BUILD_${v_docker}=FAIL"
	 	ERROR "docker build failed for \"${v_docker}\""
	fi
done

# ######################################################################
FileMarker "script:Main_Gate_Build.sh END"
# ######################################################################
