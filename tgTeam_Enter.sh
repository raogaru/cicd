# ######################################################################
MARKER "script:tgTeam_Enter.sh argument=$1 START"
# ######################################################################
v_team=$1	# team name
echo arguments $* 

HEADER2 "Drop build-${vTEAM} branch"


HEADER2 "Recreate build-${vTEAM} branch"


HEADER2 "Inventory of commits in build-${vTEAM} from team-${vTEAM} branch"


HEADER2 "Inventory of files in build-${vTEAM} from team-${vTEAM} branch"


HEADER2 "Notify build-cop, team-lead about build-START for team-${vTEAM}"



# ######################################################################
MARKER "script:tgTeam_Enter.sh END"
# ######################################################################
