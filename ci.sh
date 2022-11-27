##!/bin/bash
# ######################################################################
# ci.sh - Main program to be called by CI-Jenkins-pipeline
# ######################################################################
ARG1=$1
ARG2=$2
ARG3=$3
ARG4=$4
ARG5=$5
vSTAGE=$1
set +x
source ${WORKSPACE}/ci.env
HEADER1 "BEGIN STAGE ${vSTAGE}"

if [ "${vSTAGE}" == "Main-Gate-Enter" ]; then
	rm -f ${PIPE_ENV}
else
	[[ -f ${PIPE_ENV} ]] && source ${PIPE_ENV}
fi

MARKER "script:ci.sh argument:${vSTAGE} position:START"

case "${vSTAGE}" in

"Main-Gate-Enter") . ${WORKSPACE}/mg_Enter.sh ;;
"Main-Gate-Checkin") . ${WORKSPACE}/mg_Checkin.sh ;;
"Main-Gate-Prepare") . ${WORKSPACE}/mg_Prepare.sh ${ARG2};;
"Main-Gate-Verify") . ${WORKSPACE}/mg_Verify.sh ;;

"Team-Gate-Enter") . ${WORKSPACE}/tg_Enter.sh ;;

"Team-Gate-MARS-Enter") 	. ${WORKSPACE}/tgTeam_Enter.sh MARS ;;
"Team-Gate-Build-MARS-Enter")	. ${WORKSPACE}/tgBuild_Enter.sh MARS ;;
"Team-Gate-Build-MARS-DB1") 	. ${WORKSPACE}/tgBuild.sh MARS db1 ;;
"Team-Gate-Build-MARS-DB2") 	. ${WORKSPACE}/tgBuild.sh MARS db1 ;;
"Team-Gate-Build-MARS-WWW") 	. ${WORKSPACE}/tgBuild.sh MARS www ;;
"Team-Gate-Build-MARS-APP1") 	. ${WORKSPACE}/tgBuild.sh MARS app1 ;;
"Team-Gate-Build-MARS-APP2") 	. ${WORKSPACE}/tgBuild.sh MARS app2 ;;
"Team-Gate-Build-MARS-APP3") 	. ${WORKSPACE}/tgBuild.sh MARS app3 ;;
"Team-Gate-Build-MARS-Exit") 	. ${WORKSPACE}/tgBuild_Exit.sh MARS ;;
"Team-Gate-Deploy-MARS-Enter") 	. ${WORKSPACE}/tgDeploy_Enter.sh MARS ;;
"Team-Gate-Deploy-MARS-DB1") 	. ${WORKSPACE}/tgDeploy.sh MARS db1 ;;
"Team-Gate-Deploy-MARS-DB2") 	. ${WORKSPACE}/tgDeploy.sh MARS db2 ;;
"Team-Gate-Deploy-MARS-WWW") 	. ${WORKSPACE}/tgDeploy.sh MARS www ;;
"Team-Gate-Deploy-MARS-APP1") 	. ${WORKSPACE}/tgDeploy.sh MARS app1 ;;
"Team-Gate-Deploy-MARS-APP2") 	. ${WORKSPACE}/tgDeploy.sh MARS app2 ;;
"Team-Gate-Deploy-MARS-APP3") 	. ${WORKSPACE}/tgDeploy.sh MARS app3 ;;
"Team-Gate-Deploy-MARS-Exit") 	. ${WORKSPACE}/tgDeploy_Exit.sh MARS ;;
"Team-Gate-Test-MARS-Enter") 	. ${WORKSPACE}/tgTest_Enter.sh MARS enter ;;
"Team-Gate-Test-MARS-Functional") . ${WORKSPACE}/tgTest.sh MARS functional ;;
"Team-Gate-Test-MARS-Performance"). ${WORKSPACE}/tgTest.sh MARS performance ;;
"Team-Gate-Test-MARS-Security") . ${WORKSPACE}/tgTest.sh MARS security ;;
"Team-Gate-Test-MARS-Exit") 	. ${WORKSPACE}/tgTest_Exit.sh MARS ;;
"Team-Gate-MARS-Exit") 		. ${WORKSPACE}/tgTeam_Exit.sh MARS ;;

"Team-Gate-PLUTO-Enter") 	. ${WORKSPACE}/tgTeam_Enter.sh PLUTO ;;
"Team-Gate-Build-PLUTO-Enter")	. ${WORKSPACE}/tgBuild_Enter.sh PLUTO ;;
"Team-Gate-Build-PLUTO-DB1") 	. ${WORKSPACE}/tgBuild.sh PLUTO db1 ;;
"Team-Gate-Build-PLUTO-DB2") 	. ${WORKSPACE}/tgBuild.sh PLUTO db1 ;;
"Team-Gate-Build-PLUTO-WWW") 	. ${WORKSPACE}/tgBuild.sh PLUTO www ;;
"Team-Gate-Build-PLUTO-APP1") 	. ${WORKSPACE}/tgBuild.sh PLUTO app1 ;;
"Team-Gate-Build-PLUTO-APP2") 	. ${WORKSPACE}/tgBuild.sh PLUTO app2 ;;
"Team-Gate-Build-PLUTO-APP3") 	. ${WORKSPACE}/tgBuild.sh PLUTO app3 ;;
"Team-Gate-Build-PLUTO-Exit") 	. ${WORKSPACE}/tgBuild_Exit.sh PLUTO ;;
"Team-Gate-Deploy-PLUTO-Enter") 	. ${WORKSPACE}/tgDeploy_Enter.sh PLUTO ;;
"Team-Gate-Deploy-PLUTO-DB1") 	. ${WORKSPACE}/tgDeploy.sh PLUTO db1 ;;
"Team-Gate-Deploy-PLUTO-DB2") 	. ${WORKSPACE}/tgDeploy.sh PLUTO db2 ;;
"Team-Gate-Deploy-PLUTO-WWW") 	. ${WORKSPACE}/tgDeploy.sh PLUTO www ;;
"Team-Gate-Deploy-PLUTO-APP1") 	. ${WORKSPACE}/tgDeploy.sh PLUTO app1 ;;
"Team-Gate-Deploy-PLUTO-APP2") 	. ${WORKSPACE}/tgDeploy.sh PLUTO app2 ;;
"Team-Gate-Deploy-PLUTO-APP3") 	. ${WORKSPACE}/tgDeploy.sh PLUTO app3 ;;
"Team-Gate-Deploy-PLUTO-Exit") 	. ${WORKSPACE}/tgDeploy_Exit.sh PLUTO ;;
"Team-Gate-Test-PLUTO-Enter") 	. ${WORKSPACE}/tgTest_Enter.sh PLUTO enter ;;
"Team-Gate-Test-PLUTO-Functional") . ${WORKSPACE}/tgTest.sh PLUTO functional ;;
"Team-Gate-Test-PLUTO-Performance"). ${WORKSPACE}/tgTest.sh PLUTO performance ;;
"Team-Gate-Test-PLUTO-Security") . ${WORKSPACE}/tgTest.sh PLUTO security ;;
"Team-Gate-Test-PLUTO-Exit") 	. ${WORKSPACE}/tgTest_Exit.sh PLUTO ;;
"Team-Gate-PLUTO-Exit") 		. ${WORKSPACE}/tgTeam_Exit.sh PLUTO ;;

"Team-Gate-VENUS-Enter") 	. ${WORKSPACE}/tgTeam_Enter.sh VENUS ;;
"Team-Gate-Build-VENUS-Enter")	. ${WORKSPACE}/tgBuild_Enter.sh VENUS ;;
"Team-Gate-Build-VENUS-DB1") 	. ${WORKSPACE}/tgBuild.sh VENUS db1 ;;
"Team-Gate-Build-VENUS-DB2") 	. ${WORKSPACE}/tgBuild.sh VENUS db1 ;;
"Team-Gate-Build-VENUS-WWW") 	. ${WORKSPACE}/tgBuild.sh VENUS www ;;
"Team-Gate-Build-VENUS-APP1") 	. ${WORKSPACE}/tgBuild.sh VENUS app1 ;;
"Team-Gate-Build-VENUS-APP2") 	. ${WORKSPACE}/tgBuild.sh VENUS app2 ;;
"Team-Gate-Build-VENUS-APP3") 	. ${WORKSPACE}/tgBuild.sh VENUS app3 ;;
"Team-Gate-Build-VENUS-Exit") 	. ${WORKSPACE}/tgBuild_Exit.sh VENUS ;;
"Team-Gate-Deploy-VENUS-Enter") 	. ${WORKSPACE}/tgDeploy_Enter.sh VENUS ;;
"Team-Gate-Deploy-VENUS-DB1") 	. ${WORKSPACE}/tgDeploy.sh VENUS db1 ;;
"Team-Gate-Deploy-VENUS-DB2") 	. ${WORKSPACE}/tgDeploy.sh VENUS db2 ;;
"Team-Gate-Deploy-VENUS-WWW") 	. ${WORKSPACE}/tgDeploy.sh VENUS www ;;
"Team-Gate-Deploy-VENUS-APP1") 	. ${WORKSPACE}/tgDeploy.sh VENUS app1 ;;
"Team-Gate-Deploy-VENUS-APP2") 	. ${WORKSPACE}/tgDeploy.sh VENUS app2 ;;
"Team-Gate-Deploy-VENUS-APP3") 	. ${WORKSPACE}/tgDeploy.sh VENUS app3 ;;
"Team-Gate-Deploy-VENUS-Exit") 	. ${WORKSPACE}/tgDeploy_Exit.sh VENUS ;;
"Team-Gate-Test-VENUS-Enter") 	. ${WORKSPACE}/tgTest_Enter.sh VENUS enter ;;
"Team-Gate-Test-VENUS-Functional") . ${WORKSPACE}/tgTest.sh VENUS functional ;;
"Team-Gate-Test-VENUS-Performance"). ${WORKSPACE}/tgTest.sh VENUS performance ;;
"Team-Gate-Test-VENUS-Security") . ${WORKSPACE}/tgTest.sh VENUS security ;;
"Team-Gate-Test-VENUS-Exit") 	. ${WORKSPACE}/tgTest_Exit.sh VENUS ;;
"Team-Gate-VENUS-Exit") 		. ${WORKSPACE}/tgTeam_Exit.sh VENUS ;;

"Team-Gate-EARTH-Enter") 	. ${WORKSPACE}/tgTeam_Enter.sh EARTH ;;
"Team-Gate-Build-EARTH-Enter")	. ${WORKSPACE}/tgBuild_Enter.sh EARTH ;;
"Team-Gate-Build-EARTH-DB1") 	. ${WORKSPACE}/tgBuild.sh EARTH db1 ;;
"Team-Gate-Build-EARTH-DB2") 	. ${WORKSPACE}/tgBuild.sh EARTH db1 ;;
"Team-Gate-Build-EARTH-WWW") 	. ${WORKSPACE}/tgBuild.sh EARTH www ;;
"Team-Gate-Build-EARTH-APP1") 	. ${WORKSPACE}/tgBuild.sh EARTH app1 ;;
"Team-Gate-Build-EARTH-APP2") 	. ${WORKSPACE}/tgBuild.sh EARTH app2 ;;
"Team-Gate-Build-EARTH-APP3") 	. ${WORKSPACE}/tgBuild.sh EARTH app3 ;;
"Team-Gate-Build-EARTH-Exit") 	. ${WORKSPACE}/tgBuild_Exit.sh EARTH ;;
"Team-Gate-Deploy-EARTH-Enter") 	. ${WORKSPACE}/tgDeploy_Enter.sh EARTH ;;
"Team-Gate-Deploy-EARTH-DB1") 	. ${WORKSPACE}/tgDeploy.sh EARTH db1 ;;
"Team-Gate-Deploy-EARTH-DB2") 	. ${WORKSPACE}/tgDeploy.sh EARTH db2 ;;
"Team-Gate-Deploy-EARTH-WWW") 	. ${WORKSPACE}/tgDeploy.sh EARTH www ;;
"Team-Gate-Deploy-EARTH-APP1") 	. ${WORKSPACE}/tgDeploy.sh EARTH app1 ;;
"Team-Gate-Deploy-EARTH-APP2") 	. ${WORKSPACE}/tgDeploy.sh EARTH app2 ;;
"Team-Gate-Deploy-EARTH-APP3") 	. ${WORKSPACE}/tgDeploy.sh EARTH app3 ;;
"Team-Gate-Deploy-EARTH-Exit") 	. ${WORKSPACE}/tgDeploy_Exit.sh EARTH ;;
"Team-Gate-Test-EARTH-Enter") 	. ${WORKSPACE}/tgTest_Enter.sh EARTH enter ;;
"Team-Gate-Test-EARTH-Functional") . ${WORKSPACE}/tgTest.sh EARTH functional ;;
"Team-Gate-Test-EARTH-Performance"). ${WORKSPACE}/tgTest.sh EARTH performance ;;
"Team-Gate-Test-EARTH-Security") . ${WORKSPACE}/tgTest.sh EARTH security ;;
"Team-Gate-Test-EARTH-Exit") 	. ${WORKSPACE}/tgTest_Exit.sh EARTH ;;
"Team-Gate-EARTH-Exit") 	. ${WORKSPACE}/tgTeam_Exit.sh EARTH ;;
"Team-Gate-Exit") . ${WORKSPACE}/tg_Exit.sh ;;

"System-Gate-Enter") . ${WORKSPACE}/sg_Enter.sh ;;

"System-Gate-Build-Enter") 	. ${WORKSPACE}/sgBuild_Enter.sh ;;
"System-Gate-Build-DB1") 	. ${WORKSPACE}/sgBuild.sh ;;
"System-Gate-Build-DB2") 	. ${WORKSPACE}/sgBuild.sh ;;
"System-Gate-Build-WWW") 	. ${WORKSPACE}/sgBuild.sh ;;
"System-Gate-Build-APP1") 	. ${WORKSPACE}/sgBuild.sh ;;
"System-Gate-Build-APP2") 	. ${WORKSPACE}/sgBuild.sh ;;
"System-Gate-Build-APP3") 	. ${WORKSPACE}/sgBuild.sh ;;
"System-Gate-Build-Exit") 	. ${WORKSPACE}/sgBuild_Exit.sh ;;

"System-Gate-Deploy-Enter") 	. ${WORKSPACE}/sgDeploy_Enter.sh ;;
"System-Gate-Deploy-DB1") 	. ${WORKSPACE}/sgDeploy.sh ;;
"System-Gate-Deploy-DB2") 	. ${WORKSPACE}/sgDeploy.sh ;;
"System-Gate-Deploy-WWW") 	. ${WORKSPACE}/sgDeploy.sh ;;
"System-Gate-Deploy-APP1") 	. ${WORKSPACE}/sgDeploy.sh ;;
"System-Gate-Deploy-APP2") 	. ${WORKSPACE}/sgDeploy.sh ;;
"System-Gate-Deploy-APP3") 	. ${WORKSPACE}/sgDeploy.sh ;;
"System-Gate-Deploy-Exit") 	. ${WORKSPACE}/sgDeploy_Exit.sh ;;

"System-Gate-Test-Enter") 	. ${WORKSPACE}/sgTest_Enter.sh ;;
"System-Gate-Test-Functional") 	. ${WORKSPACE}/sgTest.sh ;;
"System-Gate-Test-Performance")	. ${WORKSPACE}/sgTest.sh ;;
"System-Gate-Test-Security") 	. ${WORKSPACE}/sgTest.sh ;;
"System-Gate-Test-Exit") 	. ${WORKSPACE}/sgTest_Exit.sh ;;

"System-Gate-Exit") . ${WORKSPACE}/sg_Exit.sh ;;

"Release-Gate-Enter") MARKER "Option:${vSTAGE}" ;;
"Release-Gate-Prepare") MARKER "Option:${vSTAGE}" ;;
"Release-Gate-Build") . ${WORKSPACE}/Release_Gate_Build.sh ;;
"Release-Gate-Artifacts") . ${WORKSPACE}/Release_Artifacts.sh ;;
"Release-Gate-Verify") MARKER "Option:${vSTAGE}" ;;
"Release-Gate-Publish") MARKER "Option:${vSTAGE}" ;;
"Release-Gate-Notify") MARKER "Option:${vSTAGE}" ;;
"Release-Gate-Exit") MARKER "Option:${vSTAGE}" ;;

"Main-Gate-Exit") MARKER "Option:${vSTAGE}" ;;

"DUMMY") DUMMY_ACTION ;;

"*") ERROR "Invalid argument to ci.sh" ;;

esac

r=$?
if [ $r -eq 0 ]; then
	MARKER "script:ci.sh argument:${vSTAGE} position:END"
else
	MARKER "script:ci.sh argument:${vSTAGE} position:END FAILED"
fi
# ######################################################################
FOOTER1 "END STAGE ${vSTAGE}"
# ######################################################################
exit $r
