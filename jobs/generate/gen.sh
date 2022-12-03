#!/bin/bash
team_num_from=101
team_num_to=110

rm -f DEMO-CI-20-team-gate.output
rm -f DEMO_CI_team_gate_T*.groovy
rm -f DEMO-CI-20-team-gate.groovy

for team_num in $(seq -f "%03g" $team_num_from $team_num_to)
do
echo $team_num
cat DEMO_CI_team_gate_XXXX.template | sed -e "s/XXXX/T${team_num}/g" >  DEMO_CI_team_gate_T${team_num}.groovy
cat DEMO-CI-20-team-gate.line | sed -e "s/XXXX/T${team_num}/g" >> DEMO-CI-20-team-gate.output
done

cat DEMO-CI-20-team-gate.template |sed -e '/FILE_INSERT_BEGIN/r DEMO-CI-20-team-gate.output' > DEMO-CI-20-team-gate.groovy

echo mv .groovy files to jobs directory

rm -f DEMO-CI-20-team-gate.output
