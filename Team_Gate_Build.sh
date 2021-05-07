# ######################################################################
echo Team-Gate-Build.sh START
# ######################################################################
v_team=${1}	# team name
v_type=${2}	# build type
HEADER2 "Build \"${v_type}\" in team-${v_team} branch requested"

HEADER2 "Check if commits in team-${v_team} branch"

cat ${PIPE_ENV}

ERROR "for no reason"

# ######################################################################
echo Team-Gate-Build.sh END
# ######################################################################
