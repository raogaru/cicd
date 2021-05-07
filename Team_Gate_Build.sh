# ######################################################################
echo Team-Gate-Build.sh START
# ######################################################################
v_team=${1}	# team name
v_type=${2}	# build type
HEADER2 "Build \"${v_type}\" in team-${v_team} branch requested"

HEADER2 "Check if commits in team-${v_team} branch"

cat ${PIPE_ENV}

v_commits=$(READENV TEAM_COMMITS_${v_team})

if [ "${v_commits}" != "YES" ]; then
	ECHO "No commits. Nothing to do"
fi

case "${v_type}" in
"jar") HEADER2 "Building jar using maven" ;;
"docker") HEADER2 "Building docker using kubectl" ;;
"ec2") HEADER2 "Building ec2 using awscli" ;;
esac

exit 0
# ######################################################################
echo Team-Gate-Build.sh END
# ######################################################################
