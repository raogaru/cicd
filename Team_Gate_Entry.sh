# ######################################################################
# Team-Gate-Entry.sh 
# ######################################################################
echo "Script $0 START"
# ----------------------------------------------------------------------
f_teamgate_checkout_master () {
HEADER2 "Checkout master branch of ${MYAPP_NAME} Git repo ${GITREPO_URL}"
	git checkout master

HEADER2 "List all branches"
	git branch -a

HEADER2 "Make sure working on master branch"
        x1=$(git branch | grep "^\*" | sed -e 's/^\* //')
        [[ "${x1}" != "master" ]] && ERROR "Current branch is not \"master\"."
	ECHO Current branch is "master"
}

# ----------------------------------------------------------------------
f_teamgate_validate_team_branches () {
HEADER2 "List development teams"
        rm -f ${PIPE_DIR}/teams.tmp
        for TEAM in ${AGILE_TEAMS}; do echo "${TEAM}" >> ${PIPE_DIR}/teams.tmp; done
        cat ${PIPE_DIR}/teams.tmp |sort > ${PIPE_DIR}/teams.lst
        cat ${PIPE_DIR}/teams.lst
        rm -f ${PIPE_DIR}/teams.tmp

HEADER2 "Identify list of team-branches"
        git branch -a | grep remote | grep "\/team\-" | sed -e 's/^.*\/team-//'|sort > ${PIPE_DIR}/git_team_branches.lst
        cat ${PIPE_DIR}/git_team_branches.lst | sed -e 's/^/team\-/'

HEADER2 "Compare teams with team-branches"
        diff ${PIPE_DIR}/teams.lst ${PIPE_DIR}/git_team_branches.lst
        r=$?

if [ $r -eq 0 ]; then
        ECHO "agile-teams and team-branches match"
else
        WARN "agile-teams and team-branches does not match"

        WARN "Team branches missing. Branches to be created: "
        diff ${PIPE_DIR}/teams.lst ${PIPE_DIR}/git_team_branches.lst |grep "<" |sed -e 's/^\< //'| sed -e 's/^/team\-/'

        WARN "Team branches found for unknown team. Branches to be deleted:"
        diff ${PIPE_DIR}/teams.lst ${PIPE_DIR}/git_team_branches.lst |grep ">" |sed -e 's/^\> //' | sed -e 's/^/team\-/'
fi
}
# ----------------------------------------------------------------------
f_teamgate_list_commits_by_each_team () {
HEADER2 "Compare team branch \"team-${TEAM}\" with build branch \"build-${TEAM}\""
for TEAM in ${AGILE_TEAMS}
do
        echo ''
        HEADER2 "List of commits by team \"${TEAM}\":"
        ECHO "git log origin/master..build-${TEAM}"
        git log origin/master..origin/team-${TEAM} --pretty=format:"%ad:%h:%H:%an:%ae:%s" --date format:'%Y-%m-%d-%H-%M-%S'
        git log origin/master..origin/team-${TEAM} --pretty=format:"%ad:%h:%H:%an:%ae:%s" --date format:'%Y-%m-%d-%H-%M-%S'  > ${PIPE_DIR}/git_commits_by_${TEAM}.lst
        [[ -s ${PIPE_DIR}/git_commits_by_${TEAM}.lst ]] && ADDENV "TEAM_COMMITS_${TEAM}=YES"
done
}
# ######################################################################
# START HERE
# ######################################################################
f_teamgate_checkout_master
f_teamgate_validate_team_branches
f_teamgate_list_commits_by_each_team

echo "Script $0 END"
# ######################################################################
# EOF
# ######################################################################
