# ######################################################################
# demo.sh - Main program to be called by Jenkins jobs
# ######################################################################
ARG1=$1
source demo.env
set +x
HEADER1 "BEGIN $ARG1"
echo "Hello World"
case "${ARG1}" in
"Main-Gate-Entry") 
	#INFO "${ARG1}"
	sh/Main_Gate_Entry.sh
	;;
"Team-Gate-Entry") 
	WARN "${ARG1}"
	;;
"Team-Build-MARS-1") 
	INFO "${ARG1}"
	;;
"Team-Build-VENUS-1") 
	INFO "${ARG1}"
	;;
"Team-Build-PLUTO-1") 
	INFO "${ARG1}"
	;;
"Team-Build-MARS-2") 
	INFO "${ARG1}"
	;;
"Team-Build-VENUS-2") 
	INFO "${ARG1}"
	;;
"Team-Build-PLUTO-2") 
	INFO "${ARG1}"
	;;
"Team-Build-MARS-3") 
	INFO "${ARG1}"
	;;
"Team-Build-VENUS-3") 
	INFO "${ARG1}"
	;;
"Team-Build-PLUTO-3") 
	INFO "${ARG1}"
	;;
"Team-Deploy-MARS-1") 
	INFO "${ARG1}"
	;;
"Team-Deploy-VENUS-1") 
	INFO "${ARG1}"
	;;
"Team-Deploy-PLUTO-1") 
	INFO "${ARG1}"
	;;
"Team-Deploy-MARS-2") 
	INFO "${ARG1}"
	;;
"Team-Deploy-VENUS-2") 
	INFO "${ARG1}"
	;;
"Team-Deploy-PLUTO-2") 
	INFO "${ARG1}"
	;;
"Team-Deploy-MARS-3") 
	INFO "${ARG1}"
	;;
"Team-Deploy-VENUS-3") 
	INFO "${ARG1}"
	;;
"Team-Deploy-PLUTO-3") 
	INFO "${ARG1}"
	;;
"Team-Test-MARS-1") 
	INFO "${ARG1}"
	;;
"Team-Test-VENUS-1") 
	INFO "${ARG1}"
	;;
"Team-Test-PLUTO-1") 
	INFO "${ARG1}"
	;;
"Team-Test-MARS-2") 
	INFO "${ARG1}"
	;;
"Team-Test-VENUS-2") 
	INFO "${ARG1}"
	;;
"Team-Test-PLUTO-2") 
	INFO "${ARG1}"
	;;
"Team-Test-MARS-3") 
	INFO "${ARG1}"
	;;
"Team-Test-VENUS-3") 
	INFO "${ARG1}"
	;;
"Team-Test-PLUTO-3") 
	INFO "${ARG1}"
	;;
"Team-Gate-Exit") 
	INFO "${ARG1}"
	;;
"System-Gate-Entry") 
	INFO "${ARG1}"
	;;
"System-Build-1") 
	INFO "${ARG1}"
	;;
"System-Build-2") 
	INFO "${ARG1}"
	;;
"System-Build-3") 
	INFO "${ARG1}"
	;;
"System-Deploy-1") 
	INFO "${ARG1}"
	;;
"System-Deploy-2") 
	INFO "${ARG1}"
	;;
"System-Deploy-3") 
	INFO "${ARG1}"
	;;
"System-Test-1") 
	INFO "${ARG1}"
	;;
"System-Test-2") 
	INFO "${ARG1}"
	;;
"System-Test-3") 
	INFO "${ARG1}"
	;;
"System-Gate-Exit") 
	INFO "${ARG1}"
	;;
"Release-Gate-Entry") 
	INFO "${ARG1}"
	;;
"Release-Prepare") 
	INFO "${ARG1}"
	;;
"Release-Build") 
	INFO "${ARG1}"
	;;
"Release-Verify") 
	ERROR "${ARG1}"
	;;
"Release-Publish") 
	INFO "${ARG1}"
	;;
"Release-Notify") 
	INFO "${ARG1}"
	;;
"Release-Gate-Exit") 
	INFO "${ARG1}"
	;;
"Main-Gate-Exit") 
	INFO "${ARG1}"
	;;
esac
echo "Hello World"
FOOTER1 "END $ARG1"
# ######################################################################
