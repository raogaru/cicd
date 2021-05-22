# ######################################################################
FileMarker "script:Main_Gate_Build.sh START"
# ######################################################################
HEADER2 "Build tomcat docker"
docker build -t rao-tomcat docker/tomcat
[[ $? -ne 0 ]] && ERROR "docker build failed for \"tomcat\""

HEADER2 "Build postgres docker"
docker build -t rao-postgres docker/postgres
[[ $? -ne 0 ]] && ERROR "docker build failed for \"postgres\""

# ----------------------------------------------------------------------
# ######################################################################
# START HERE
# ######################################################################

# ######################################################################
FileMarker "script:Main_Gate_Build.sh END"
# ######################################################################
