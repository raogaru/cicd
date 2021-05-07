# ######################################################################
# demo.sh - Main program to be called by Jenkins jobs
# ######################################################################
ARG1=$1
source demo.env
set +x
HEADER1 "BEGIN $ARG1"

[[ -f ${PIPE_ENV} ]] && source ${PIPE_ENV}

case "${ARG1}" in
"Main-Gate-Entry") 
	ECHOpurple "Option:${ARG1}"
	. ./Main_Gate_Entry.sh
	;;
"Team-Gate-Entry") 
	ECHOpurple "Option:${ARG1}"
	. ./Team_Gate_Entry.sh
	;;
"Team-Build-MARS-1") 
	ECHOpurple "Option:${ARG1}"
	. ./Team_Gate_Build.sh mars jar
	;;
"Team-Build-VENUS-1") 
	ECHOpurple "Option:${ARG1}"
	. ./Team_Gate_Build.sh venus jar
	;;
"Team-Build-PLUTO-1") 
	ECHOpurple "Option:${ARG1}"
	. ./Team_Gate_Build.sh pluto jar
	;;
"Team-Build-MARS-2") 
	ECHOpurple "Option:${ARG1}"
	. ./Team_Gate_Build.sh mars docker
	;;
"Team-Build-VENUS-2") 
	ECHOpurple "Option:${ARG1}"
	. ./Team_Gate_Build.sh venus docker
	;;
"Team-Build-PLUTO-2") 
	ECHOpurple "Option:${ARG1}"
	. ./Team_Gate_Build.sh pluto docker
	;;
"Team-Build-MARS-3") 
	ECHOpurple "Option:${ARG1}"
	. ./Team_Gate_Build.sh mars ec2
	;;
"Team-Build-VENUS-3") 
	ECHOpurple "Option:${ARG1}"
	. ./Team_Gate_Build.sh venus ec2
	;;
"Team-Build-PLUTO-3") 
	ECHOpurple "Option:${ARG1}"
	. ./Team_Gate_Build.sh pluto ec2
	;;
"Team-Deploy-MARS-1") 
	ECHOpurple "Option:${ARG1}"
	;;
"Team-Deploy-VENUS-1") 
	ECHOpurple "Option:${ARG1}"
	;;
"Team-Deploy-PLUTO-1") 
	ECHOpurple "Option:${ARG1}"
	;;
"Team-Deploy-MARS-2") 
	ECHOpurple "Option:${ARG1}"
	;;
"Team-Deploy-VENUS-2") 
	ECHOpurple "Option:${ARG1}"
	;;
"Team-Deploy-PLUTO-2") 
	ECHOpurple "Option:${ARG1}"
	;;
"Team-Deploy-MARS-3") 
	ECHOpurple "Option:${ARG1}"
	;;
"Team-Deploy-VENUS-3") 
	ECHOpurple "Option:${ARG1}"
	;;
"Team-Deploy-PLUTO-3") 
	ECHOpurple "Option:${ARG1}"
	;;
"Team-Test-MARS-1") 
	ECHOpurple "Option:${ARG1}"
	;;
"Team-Test-VENUS-1") 
	ECHOpurple "Option:${ARG1}"
	;;
"Team-Test-PLUTO-1") 
	ECHOpurple "Option:${ARG1}"
	;;
"Team-Test-MARS-2") 
	ECHOpurple "Option:${ARG1}"
	;;
"Team-Test-VENUS-2") 
	ECHOpurple "Option:${ARG1}"
	;;
"Team-Test-PLUTO-2") 
	ECHOpurple "Option:${ARG1}"
	;;
"Team-Test-MARS-3") 
	ECHOpurple "Option:${ARG1}"
	;;
"Team-Test-VENUS-3") 
	ECHOpurple "Option:${ARG1}"
	;;
"Team-Test-PLUTO-3") 
	ECHOpurple "Option:${ARG1}"
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
esac

FOOTER1 "END $ARG1"
# ######################################################################
