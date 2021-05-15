#!/bin/bash
# ######################################################################
# cicd.sh - Main program to be called by Jenkins jobs
# ######################################################################
ARG1=$1
source cicd.env
set +x
HEADER1 "BEGIN $ARG1"

[[ -f ${PIPE_ENV} ]] && source ${PIPE_ENV}

ECHOpurple "script:cicd.sh argument:${ARG1} START"

case "${ARG1}" in
"Main-Gate-Entry") 
	. ${WORKSPACE}/Main_Gate_Entry.sh
	;;
"Team-Gate-Entry") 
	. ${WORKSPACE}/Team_Gate_Entry.sh
	;;
"Team-Build-MARS-1") 
	. ${WORKSPACE}/Team_Gate_Build.sh mars db
	;;
"Team-Build-VENUS-1") 
	. ${WORKSPACE}/Team_Gate_Build.sh venus db
	;;
"Team-Build-PLUTO-1") 
	. ${WORKSPACE}/Team_Gate_Build.sh pluto db
	;;
"Team-Build-MARS-2") 
	. ${WORKSPACE}/Team_Gate_Build.sh mars docker
	;;
"Team-Build-VENUS-2") 
	. ${WORKSPACE}/Team_Gate_Build.sh venus docker
	;;
"Team-Build-PLUTO-2") 
	. ${WORKSPACE}/Team_Gate_Build.sh pluto docker
	;;
"Team-Build-MARS-3") 
	. ${WORKSPACE}/Team_Gate_Build.sh mars ec2
	;;
"Team-Build-VENUS-3") 
	. ${WORKSPACE}/Team_Gate_Build.sh venus ec2
	;;
"Team-Build-PLUTO-3") 
	. ${WORKSPACE}/Team_Gate_Build.sh pluto ec2
	;;
"Team-Deploy-MARS-1") 
	. ${WORKSPACE}/Team_Gate_Deploy.sh mars liquibase
	;;
"Team-Deploy-VENUS-1") 
	. ${WORKSPACE}/Team_Gate_Deploy.sh venus liquibase
	;;
"Team-Deploy-PLUTO-1") 
	. ${WORKSPACE}/Team_Gate_Deploy.sh pluto liquibase
	;;
"Team-Deploy-MARS-2") 
	. ${WORKSPACE}/Team_Gate_Deploy.sh mars kubernetes
	;;
"Team-Deploy-VENUS-2") 
	. ${WORKSPACE}/Team_Gate_Deploy.sh venus kubernetes
	;;
"Team-Deploy-PLUTO-2") 
	. ${WORKSPACE}/Team_Gate_Deploy.sh pluto kubernetes
	;;
"Team-Deploy-MARS-3") 
	. ${WORKSPACE}/Team_Gate_Deploy.sh mars tomcat
	;;
"Team-Deploy-VENUS-3") 
	. ${WORKSPACE}/Team_Gate_Deploy.sh venus tomcat
	;;
"Team-Deploy-PLUTO-3") 
	. ${WORKSPACE}/Team_Gate_Deploy.sh pluto tomcat
	;;
"Team-Test-MARS-1") 
	. ${WORKSPACE}/Team_Gate_Test.sh mars phase1
	;;
"Team-Test-VENUS-1") 
	. ${WORKSPACE}/Team_Gate_Test.sh venus phase1
	;;
"Team-Test-PLUTO-1") 
	. ${WORKSPACE}/Team_Gate_Test.sh pluto phase1
	;;
"Team-Test-MARS-2") 
	. ${WORKSPACE}/Team_Gate_Test.sh mars phase2
	;;
"Team-Test-VENUS-2") 
	. ${WORKSPACE}/Team_Gate_Test.sh venus phase2
	;;
"Team-Test-PLUTO-2") 
	. ${WORKSPACE}/Team_Gate_Test.sh pluto phase2
	;;
"Team-Test-MARS-3") 
	. ${WORKSPACE}/Team_Gate_Test.sh mars phase3
	;;
"Team-Test-VENUS-3") 
	. ${WORKSPACE}/Team_Gate_Test.sh venus phase3
	;;
"Team-Test-PLUTO-3") 
	. ${WORKSPACE}/Team_Gate_Test.sh pluto phase3
	;;
"Team-Gate-Exit") 
	ECHOpurple "Option:${ARG1}"
	;;
"System-Gate-Entry") 
	ECHOpurple "Option:${ARG1}"
	;;
"System-Build-1") 
	ECHOpurple "Option:${ARG1}"
	;;
"System-Build-2") 
	ECHOpurple "Option:${ARG1}"
	;;
"System-Build-3") 
	ECHOpurple "Option:${ARG1}"
	;;
"System-Deploy-1") 
	ECHOpurple "Option:${ARG1}"
	;;
"System-Deploy-2") 
	ECHOpurple "Option:${ARG1}"
	;;
"System-Deploy-3") 
	ECHOpurple "Option:${ARG1}"
	;;
"System-Test-1") 
	ECHOpurple "Option:${ARG1}"
	;;
"System-Test-2") 
	ECHOpurple "Option:${ARG1}"
	;;
"System-Test-3") 
	ECHOpurple "Option:${ARG1}"
	;;
"System-Gate-Exit") 
	ECHOpurple "Option:${ARG1}"
	;;
"Release-Gate-Entry") 
	ECHOpurple "Option:${ARG1}"
	;;
"Release-Prepare") 
	ECHOpurple "Option:${ARG1}"
	;;
"Release-Build") 
	ECHOpurple "Option:${ARG1}"
	;;
"Release-Verify") 
	ECHOpurple "Option:${ARG1}"
	;;
"Release-Publish") 
	ECHOpurple "Option:${ARG1}"
	;;
"Release-Notify") 
	ECHOpurple "Option:${ARG1}"
	;;
"Release-Gate-Exit") 
	ECHOpurple "Option:${ARG1}"
	;;
"Main-Gate-Exit") 
	ECHOpurple "Option:${ARG1}"
	;;
"*")
	ERROR "Invalid argument to cicd.sh"
	;;
esac

r=$?
if [ $r -eq 0 ]; then
	ECHOpurple "script:cicd.sh END"
else
	ECHOred "script:cicd.sh END FAILED"
fi
# ######################################################################
FOOTER1 "END $ARG1"
# ######################################################################
