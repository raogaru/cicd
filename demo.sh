# ######################################################################
# demo.sh - Main program to be called by Jenkins jobs
# ######################################################################
ARG1=$1
source demo.env
set +x
ECHO "BEGIN $ARG1"
ECHO "Application Name is \"${MYAPP_NAME}\""
ECHO "Pipe Environment file is \"${PIPE_ENV}\""

case "${ARG1}" in
"Main-Gate-Entry") 
	ECHOpurple "${ARG1}"
	. sh/Main_Gate_Entry.sh
	;;
"Team-Gate-Entry") 
	ECHOpurple "${ARG1}"
	;;
"Team-Build-MARS-1") 
	ECHOpurple "${ARG1}"
	;;
"Team-Build-VENUS-1") 
	ECHOpurple "${ARG1}"
	;;
"Team-Build-PLUTO-1") 
	ECHOpurple "${ARG1}"
	;;
"Team-Build-MARS-2") 
	ECHOpurple "${ARG1}"
	;;
"Team-Build-VENUS-2") 
	ECHOpurple "${ARG1}"
	;;
"Team-Build-PLUTO-2") 
	ECHOpurple "${ARG1}"
	;;
"Team-Build-MARS-3") 
	ECHOpurple "${ARG1}"
	;;
"Team-Build-VENUS-3") 
	ECHOpurple "${ARG1}"
	;;
"Team-Build-PLUTO-3") 
	ECHOpurple "${ARG1}"
	;;
"Team-Deploy-MARS-1") 
	ECHOpurple "${ARG1}"
	;;
"Team-Deploy-VENUS-1") 
	ECHOpurple "${ARG1}"
	;;
"Team-Deploy-PLUTO-1") 
	ECHOpurple "${ARG1}"
	;;
"Team-Deploy-MARS-2") 
	ECHOpurple "${ARG1}"
	;;
"Team-Deploy-VENUS-2") 
	ECHOpurple "${ARG1}"
	;;
"Team-Deploy-PLUTO-2") 
	ECHOpurple "${ARG1}"
	;;
"Team-Deploy-MARS-3") 
	ECHOpurple "${ARG1}"
	;;
"Team-Deploy-VENUS-3") 
	ECHOpurple "${ARG1}"
	;;
"Team-Deploy-PLUTO-3") 
	ECHOpurple "${ARG1}"
	;;
"Team-Test-MARS-1") 
	ECHOpurple "${ARG1}"
	;;
"Team-Test-VENUS-1") 
	ECHOpurple "${ARG1}"
	;;
"Team-Test-PLUTO-1") 
	ECHOpurple "${ARG1}"
	;;
"Team-Test-MARS-2") 
	ECHOpurple "${ARG1}"
	;;
"Team-Test-VENUS-2") 
	ECHOpurple "${ARG1}"
	;;
"Team-Test-PLUTO-2") 
	ECHOpurple "${ARG1}"
	;;
"Team-Test-MARS-3") 
	ECHOpurple "${ARG1}"
	;;
"Team-Test-VENUS-3") 
	ECHOpurple "${ARG1}"
	;;
"Team-Test-PLUTO-3") 
	ECHOpurple "${ARG1}"
	;;
"Team-Gate-Exit") 
	ECHOpurple "${ARG1}"
	;;
"System-Gate-Entry") 
	ECHOpurple "${ARG1}"
	;;
"System-Build-1") 
	ECHOpurple "${ARG1}"
	;;
"System-Build-2") 
	ECHOpurple "${ARG1}"
	;;
"System-Build-3") 
	ECHOpurple "${ARG1}"
	;;
"System-Deploy-1") 
	ECHOpurple "${ARG1}"
	;;
"System-Deploy-2") 
	ECHOpurple "${ARG1}"
	;;
"System-Deploy-3") 
	ECHOpurple "${ARG1}"
	;;
"System-Test-1") 
	ECHOpurple "${ARG1}"
	;;
"System-Test-2") 
	ECHOpurple "${ARG1}"
	;;
"System-Test-3") 
	ECHOpurple "${ARG1}"
	;;
"System-Gate-Exit") 
	ECHOpurple "${ARG1}"
	;;
"Release-Gate-Entry") 
	ECHOpurple "${ARG1}"
	;;
"Release-Prepare") 
	ECHOpurple "${ARG1}"
	;;
"Release-Build") 
	ECHOpurple "${ARG1}"
	;;
"Release-Verify") 
	ERROR "${ARG1}"
	;;
"Release-Publish") 
	ECHOpurple "${ARG1}"
	;;
"Release-Notify") 
	ECHOpurple "${ARG1}"
	;;
"Release-Gate-Exit") 
	ECHOpurple "${ARG1}"
	;;
"Main-Gate-Exit") 
	ECHOpurple "${ARG1}"
	;;
esac
echo "Hello World"
ECHO "END $ARG1"
# ######################################################################
