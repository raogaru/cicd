# ######################################################################
MARKER "script:tgTeam_Exit.sh argument=$1 START"
# ######################################################################
v_team=$1	# team name
echo arguments $* 

HEADER2 "Notify build-cop, team-lead about build-END for team-${vTEAM}"



HEADER2 "Notify developers of their commits to team-${vTEAM}"



HEADER2 "Notify release manager of team-${vTEAM} build status"




# ######################################################################
MARKER "script:tgTeam_Exit.sh END"
# ######################################################################
