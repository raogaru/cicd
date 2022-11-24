##!/bin/bash
# ######################################################################
# ci.sh - Main program to be called by CI-Jenkins-pipeline
# ######################################################################
ARG1=$1
ARG2=$2
ARG3=$3
ARG4=$4
ARG5=$5
source cicd.env
set +x
HEADER1 "BEGIN STAGE $ARG1"

[[ -f ${PIPE_ENV} ]] && source ${PIPE_ENV}

MARKER "script:ci.sh argument:${ARG1} START"

case "${ARG1}" in

"Main-Gate-Enter") . ${WORKSPACE}/mg_Enter.sh ;;
"Main-Gate-Checkin") . ${WORKSPACE}/mg_Checkin.sh ;;
"Main-Gate-Prepare") . ${WORKSPACE}/mg_Prepare.sh ${ARG2};;
"Main-Gate-Verify") . ${WORKSPACE}/mg_Verify.sh ;;

"Team-Gate-Enter") . ${WORKSPACE}/tg_Enter.sh ;;

"Team-Gate-Build-MARS-1") . ${WORKSPACE}/tgBuild.sh mars db ;;
"Team-Gate-Build-MARS-2") . ${WORKSPACE}/tgBuild.sh mars docker ;;
"Team-Gate-Build-MARS-3") . ${WORKSPACE}/tgBuild.sh mars ec2 ;;

"Team-Gate-Deploy-MARS-1") . ${WORKSPACE}/tgDeploy.sh mars db ;;
"Team-Gate-Deploy-MARS-2") . ${WORKSPACE}/tgDeploy.sh mars kubernetes ;;
"Team-Gate-Deploy-MARS-3") . ${WORKSPACE}/tgDeploy.sh mars tomcat ;;

"Team-Gate-Test-MARS-1") . ${WORKSPACE}/tgTest.sh mars phase1 ;;
"Team-Gate-Test-MARS-2") . ${WORKSPACE}/tgTest.sh mars phase2 ;;
"Team-Gate-Test-MARS-3") . ${WORKSPACE}/tgTest.sh mars phase3 ;;

"Team-Gate-Build-VENUS-1") . ${WORKSPACE}/tgBuild.sh venus db ;;
"Team-Gate-Build-VENUS-2") . ${WORKSPACE}/tgBuild.sh venus docker ;;
"Team-Gate-Build-VENUS-3") . ${WORKSPACE}/tgBuild.sh venus ec2 ;;

"Team-Gate-Deploy-VENUS-1") . ${WORKSPACE}/tgDeploy.sh venus db ;;
"Team-Gate-Deploy-VENUS-2") . ${WORKSPACE}/tgDeploy.sh venus kubernetes ;;
"Team-Gate-Deploy-VENUS-3") . ${WORKSPACE}/tgDeploy.sh venus tomcat ;;

"Team-Gate-Test-VENUS-1") . ${WORKSPACE}/tgTest.sh venus phase1 ;;
"Team-Gate-Test-VENUS-3") . ${WORKSPACE}/tgTest.sh venus phase3 ;;
"Team-Gate-Test-VENUS-2") . ${WORKSPACE}/tgTest.sh venus phase2 ;;

"Team-Gate-Build-PLUTO-1") . ${WORKSPACE}/tgBuild.sh pluto db ;;
"Team-Gate-Build-PLUTO-2") . ${WORKSPACE}/tgBuild.sh pluto docker ;;
"Team-Gate-Build-PLUTO-3") . ${WORKSPACE}/tgBuild.sh pluto ec2 ;;

"Team-Gate-Deploy-PLUTO-1") . ${WORKSPACE}/tgDeploy.sh pluto db ;;
"Team-Gate-Deploy-PLUTO-2") . ${WORKSPACE}/tgDeploy.sh pluto kubernetes ;;
"Team-Gate-Deploy-PLUTO-3") . ${WORKSPACE}/tgDeploy.sh pluto tomcat ;;

"Team-Gate-Test-PLUTO-1") . ${WORKSPACE}/tgTest.sh pluto phase1 ;;
"Team-Gate-Test-PLUTO-2") . ${WORKSPACE}/tgTest.sh pluto phase2 ;;
"Team-Gate-Test-PLUTO-3") . ${WORKSPACE}/tgTest.sh pluto phase3 ;;

"Team-Gate-Build-Exit") . ${WORKSPACE}/tgBuild_Exit.sh ;;
"Team-Gate-Build-Exit") . ${WORKSPACE}/Team_Build_Exit.sh ;;
"Team-Gate-Build-Exit") . ${WORKSPACE}/Team_Build_Exit.sh ;;

"Team-Gate-Deploy-Exit") . ${WORKSPACE}/Team_Deploy_Exit.sh ;;

"Team-Gate-Test-Exit") . ${WORKSPACE}/Team_Test_Exit.sh ;;

"Team-Gate-Exit") . ${WORKSPACE}/Team_Gate_Exit.sh ;;

"System-Gate-Enter") . ${WORKSPACE}/System_Gate_Enter.sh ;;

"System-Build-1") . ${WORKSPACE}/System_Gate_Build.sh sysgate db ;;
"System-Build-2") . ${WORKSPACE}/System_Gate_Build.sh sysgate docker ;;
"System-Build-3") . ${WORKSPACE}/System_Gate_Build.sh sysgate ec2 ;;
"System-Build-Exit") . ${WORKSPACE}/System_Build_Exit.sh ;;

"System-Deploy-1") . ${WORKSPACE}/System_Gate_Deploy.sh sysgate db ;;
"System-Deploy-2") . ${WORKSPACE}/System_Gate_Deploy.sh sysgate docker ;;
"System-Deploy-3") . ${WORKSPACE}/System_Gate_Deploy.sh sysgate ec2 ;;
"System-Deploy-Exit") . ${WORKSPACE}/System_Deploy_Exit.sh ;;

"System-Test-1") . ${WORKSPACE}/System_Gate_Test.sh phase1 ;;
"System-Test-2") . ${WORKSPACE}/System_Gate_Test.sh phase2 ;;
"System-Test-3") . ${WORKSPACE}/System_Gate_Test.sh phase3 ;;
"System-Test-Exit") . ${WORKSPACE}/System_Test_Exit.sh ;;

"System-Gate-Exit") MARKER "Option:${ARG1}" ;;

"Release-Gate-Enter") MARKER "Option:${ARG1}" ;;
"Release-Gate-Prepare") MARKER "Option:${ARG1}" ;;
"Release-Gate-Build") . ${WORKSPACE}/Release_Gate_Build.sh ;;
"Release-Gate-Artifacts") . ${WORKSPACE}/Release_Artifacts.sh ;;
"Release-Gate-Verify") MARKER "Option:${ARG1}" ;;
"Release-Gate-Publish") MARKER "Option:${ARG1}" ;;
"Release-Gate-Notify") MARKER "Option:${ARG1}" ;;
"Release-Gate-Exit") MARKER "Option:${ARG1}" ;;

"Main-Gate-Exit") MARKER "Option:${ARG1}" ;;

"DUMMY") DUMMY_ACTION ;;

"*") ERROR "Invalid argument to ci.sh" ;;

esac

r=$?
if [ $r -eq 0 ]; then
	MARKER "script:ci.sh END"
else
	ECHOred "script:ci.sh END FAILED"
fi
# ######################################################################
FOOTER1 "END STAGE $ARG1"
# ######################################################################
