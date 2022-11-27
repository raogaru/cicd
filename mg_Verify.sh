# ######################################################################
MARKER "script:mg_Verify.sh START"
# ######################################################################
echo arguments $* 

HEADER2 "Verify Dockers"
ADDENV "MAIN_VERIFY_DOCKER=PASS"

HEADER2 "Verify Databases"
ADDENV "MAIN_VERIFY_DB=PASS"

# ######################################################################
MARKER "script:mg_Verify.sh END"
# ######################################################################
