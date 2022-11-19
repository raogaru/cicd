# ######################################################################
MARKER "script:System_Gate_Build.sh argument:$1 $2 START"
# ######################################################################
v_team=${1}	# team name
v_type=${2}	# deploy type

HEADER2 "Build \"${v_type}\" in sysgate branch requested"

# ----------------------------------------------------------------------
f_sysgate_check_merge_status () {
v_merge=$(READENV SYSGATE_MERGE)

if [ "${v_merge}" != "${cPASS}" ] ; then
	WARN "MERGE=${v_merge}.  Hence, NOT doing build for sysgate"
	ADDENV "SYSGATE_BUILD_${v_type}=${cNOTA}"
	return -1
else
	ECHO "Proceed with \"${v_type}\" build for sysgate ..."
	return 0
fi
}
# ----------------------------------------------------------------------
f_sysgate_build () {
MARKER "function:f_sysgate_build"

#GIT_SYSGATE_DIR=${PIPE_DIR}/git/sysgate


HEADER2 "List my branch"
	cd ${GIT_SYSGATE_DIR}
	git checkout sysgate
        git branch

HEADER2 "Make sure working on sysgate branch"
        x1=$(git branch | grep "^\*" | sed -e 's/^\* //')
        [[ "${x1}" != "sysgate" ]] && ECHOred "Current branch is not \"sysgate\"." && return 1
        ECHO Current branch is "${x1}"

#HEADER2 "List files"
#	find . -path ./.git -prune -o -print

case "${v_type}" in
"jar") 
	HEADER2 "Building jar using maven" 
	DUMMY_ACTION
	;;
"docker") 
	HEADER2 "Building docker using kubectl" 
	DUMMY_ACTION
	;;
"ec2") 
	HEADER2 "Building ec2 using awscli" 
	DUMMY_ACTION
	;;
"db") 
	HEADER2 "Building database" 
	DUMMY_ACTION
	;;
"abc") 
	HEADER2 "Building abc " 
	DUMMY_ACTION
	;;
"xyz") 
	HEADER2 "Building xyz " 
	DUMMY_ACTION
	;;
esac

v_team=sysgate
. ${WORKSPACE}/build_${v_type}.sh
r=$?

if [ $? -eq 0 ]; then
	ADDENV "SYSGATE_BUILD_${v_type}=${cPASS}"
else
	ADDENV "SYSGATE_BUILD_${v_type}=${cFAIL}"
fi
}
# ######################################################################
# START HERE
# ######################################################################
f_sysgate_check_merge_status
if [ $? -eq 0 ]; then 
	f_sysgate_build
fi
# ######################################################################
FileMarker "script:System_Gate_Build.sh END"
# ######################################################################
