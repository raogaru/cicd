# ######################################################################
# cicd.py	CI Pipeline Apache Airflow DAG
# ######################################################################
from airflow import DAG
from airflow.operators.empty import EmptyOperator
from airflow.operators.bash import BashOperator
from airflow.utils.task_group import TaskGroup

from datetime import datetime

with DAG(
    dag_id='rao_cicd',
    start_date=datetime(2022, 5, 28),
    schedule_interval=None,
    tags=["rao","cicd"]
) as dag:

    ci_pipe_start = EmptyOperator( task_id='CI-Start')

    with TaskGroup(group_id="Git", tooltip="Pull Git Repos") as pull_git:
        git_cicd=EmptyOperator(task_id="git_cicd")
       	git_ora=EmptyOperator(task_id="git_oracle")
       	git_pgs=EmptyOperator(task_id="git_postgres")
        git_dbx=EmptyOperator(task_id="git_databricks")
        git_dms=EmptyOperator(task_id="git_dms")
        git_verify=EmptyOperator(task_id="git_verify")
        [ git_cicd, git_ora, git_pgs, git_dbx, git_dms ] >> git_verify

    with TaskGroup(group_id="Main-Gate") as main_gate:
        mg_entrance = EmptyOperator(task_id="Main-Gate-Entrance")
        mg_checkin = EmptyOperator(task_id="Main-Gate-Checkin")
        with TaskGroup(group_id="Main-Gate-Build") as mg_build:
            mgb_ora = EmptyOperator(task_id="Main-Gate-Build-Oracle-Docker")
            mgb_pgs = EmptyOperator(task_id="Main-Gate-Build-Postgres-Docker")
            mgb_app = EmptyOperator(task_id="Main-Gate-Build-App-Docker")
        mg_verify = EmptyOperator(task_id="Main-Gate-Verify")
        mg_entrance >> mg_checkin >> mg_build >> mg_verify

    with TaskGroup(group_id="Team-Gate") as team_gate:
        tg_entry = EmptyOperator(task_id="Team-Gate-Entrance")

        tg_mars_entry = EmptyOperator(task_id="Team-Gate-Mars-Entrace")
        with TaskGroup(group_id="Team-Gate-Build-on-Mars") as tgb_mars:
            tgb_mars_entry = EmptyOperator(task_id="Test-Gate-Build-Mars-Entrance")
            tgb_mars_ora = EmptyOperator(task_id="Test-Gate-Build-Mars-Oracle-Docker")
            tgb_mars_pgs = EmptyOperator(task_id="Test-Gate-Build-Mars-Postgres-Docker")
            tgb_mars_app = EmptyOperator(task_id="Test-Gate-Build-Mars-App-Docker")
            tgb_mars_exit = EmptyOperator(task_id="Test-Gate-Build-Mars-Exit")
            tgb_mars_entry >> [ tgb_mars_ora, tgb_mars_pgs, tgb_mars_app] >> tgb_mars_exit
        with TaskGroup(group_id="Team-Gate-Deploy-on-Mars") as tgd_mars:
            tgd_mars_entry = EmptyOperator(task_id="Test-Gate-Deploy-Mars-Entrance")
            tgd_mars_ora = EmptyOperator(task_id="Test-Gate-Deploy-Mars-Oracle-Docker")
            tgd_mars_pgs = EmptyOperator(task_id="Test-Gate-Deploy-Mars-Postgres-Docker")
            tgd_mars_app = EmptyOperator(task_id="Test-Gate-Deploy-Mars-App-Docker")
            tgd_mars_exit = EmptyOperator(task_id="Test-Gate-Deploy-Mars-Exit")
            tgd_mars_entry >> [ tgd_mars_ora, tgd_mars_pgs, tgd_mars_app] >> tgd_mars_exit
        with TaskGroup(group_id="Team-Gate-Test-on-Mars") as tgt_mars:
            tgt_mars_entry = EmptyOperator(task_id="Test-Gate-Test-Mars-Entrance")
            tgt_mars_ora = EmptyOperator(task_id="Test-Gate-Test-Mars-Functional")
            tgt_mars_pgs = EmptyOperator(task_id="Test-Gate-Test-Mars-Performance")
            tgt_mars_app = EmptyOperator(task_id="Test-Gate-Test-Mars-Security")
            tgt_mars_exit = EmptyOperator(task_id="Test-Gate-Test-Mars-Exit")
            tgt_mars_entry >> [ tgt_mars_ora, tgt_mars_pgs, tgt_mars_app] >> tgt_mars_exit
        tg_mars_exit = EmptyOperator(task_id="Team-Gate-Mars-Exit")
        tg_mars_entry >> tgb_mars >> tgd_mars >> tgt_mars >> tg_mars_exit


        tg_venus_entry = EmptyOperator(task_id="Team-Gate-Venus-Entrace")
        with TaskGroup(group_id="Team-Gate-Build-on-Venus") as tgb_venus:
            tgb_venus_entry = EmptyOperator(task_id="Test-Gate-Build-Venus-Entrance")
            tgb_venus_ora = EmptyOperator(task_id="Test-Gate-Build-Venus-Oracle-Docker")
            tgb_venus_pgs = EmptyOperator(task_id="Test-Gate-Build-Venus-Postgres-Docker")
            tgb_venus_app = EmptyOperator(task_id="Test-Gate-Build-Venus-App-Docker")
            tgb_venus_exit = EmptyOperator(task_id="Test-Gate-Build-Venus-Exit")
            tgb_venus_entry >> [ tgb_venus_ora, tgb_venus_pgs, tgb_venus_app] >> tgb_venus_exit
        with TaskGroup(group_id="Team-Gate-Deploy-on-Venus") as tgd_venus:
            tgd_venus_entry = EmptyOperator(task_id="Test-Gate-Deploy-Venus-Entrance")
            tgd_venus_ora = EmptyOperator(task_id="Test-Gate-Deploy-Venus-Oracle-Docker")
            tgd_venus_pgs = EmptyOperator(task_id="Test-Gate-Deploy-Venus-Postgres-Docker")
            tgd_venus_app = EmptyOperator(task_id="Test-Gate-Deploy-Venus-App-Docker")
            tgd_venus_exit = EmptyOperator(task_id="Test-Gate-Deploy-Venus-Exit")
            tgd_venus_entry >> [ tgd_venus_ora, tgd_venus_pgs, tgd_venus_app] >> tgd_venus_exit
        with TaskGroup(group_id="Team-Gate-Test-on-Venus") as tgt_venus:
            tgt_venus_entry = EmptyOperator(task_id="Test-Gate-Test-Venus-Entrance")
            tgt_venus_ora = EmptyOperator(task_id="Test-Gate-Test-Venus-Functional")
            tgt_venus_pgs = EmptyOperator(task_id="Test-Gate-Test-Venus-Performance")
            tgt_venus_app = EmptyOperator(task_id="Test-Gate-Test-Venus-Security")
            tgt_venus_exit = EmptyOperator(task_id="Test-Gate-Test-Venus-Exit")
            tgt_venus_entry >> [ tgt_venus_ora, tgt_venus_pgs, tgt_venus_app] >> tgt_venus_exit
        tg_venus_exit = EmptyOperator(task_id="Team-Gate-Venus-Exit")
        tg_venus_entry >> tgb_venus >> tgd_venus >> tgt_venus >> tg_venus_exit


        tg_pluto_entry = EmptyOperator(task_id="Team-Gate-Pluto-Entrace")
        with TaskGroup(group_id="Team-Gate-Build-on-Pluto") as tgb_pluto:
            tgb_pluto_entry = EmptyOperator(task_id="Test-Gate-Build-Pluto-Entrance")
            tgb_pluto_ora = EmptyOperator(task_id="Test-Gate-Build-Pluto-Oracle-Docker")
            tgb_pluto_pgs = EmptyOperator(task_id="Test-Gate-Build-Pluto-Postgres-Docker")
            tgb_pluto_app = EmptyOperator(task_id="Test-Gate-Build-Pluto-App-Docker")
            tgb_pluto_exit = EmptyOperator(task_id="Test-Gate-Build-Pluto-Exit")
            tgb_pluto_entry >> [ tgb_pluto_ora, tgb_pluto_pgs, tgb_pluto_app] >> tgb_pluto_exit
        with TaskGroup(group_id="Team-Gate-Deploy-on-Pluto") as tgd_pluto:
            tgd_pluto_entry = EmptyOperator(task_id="Test-Gate-Deploy-Pluto-Entrance")
            tgd_pluto_ora = EmptyOperator(task_id="Test-Gate-Deploy-Pluto-Oracle-Docker")
            tgd_pluto_pgs = EmptyOperator(task_id="Test-Gate-Deploy-Pluto-Postgres-Docker")
            tgd_pluto_app = EmptyOperator(task_id="Test-Gate-Deploy-Pluto-App-Docker")
            tgd_pluto_exit = EmptyOperator(task_id="Test-Gate-Deploy-Pluto-Exit")
            tgd_pluto_entry >> [ tgd_pluto_ora, tgd_pluto_pgs, tgd_pluto_app] >> tgd_pluto_exit
        with TaskGroup(group_id="Team-Gate-Test-on-Pluto") as tgt_pluto:
            tgt_pluto_entry = EmptyOperator(task_id="Test-Gate-Test-Pluto-Entrance")
            tgt_pluto_ora = EmptyOperator(task_id="Test-Gate-Test-Pluto-Functional")
            tgt_pluto_pgs = EmptyOperator(task_id="Test-Gate-Test-Pluto-Performance")
            tgt_pluto_app = EmptyOperator(task_id="Test-Gate-Test-Pluto-Security")
            tgt_pluto_exit = EmptyOperator(task_id="Test-Gate-Test-Pluto-Exit")
            tgt_pluto_entry >> [ tgt_pluto_ora, tgt_pluto_pgs, tgt_pluto_app] >> tgt_pluto_exit
        tg_pluto_exit = EmptyOperator(task_id="Team-Gate-Pluto-Exit")
        tg_pluto_entry >> tgb_pluto >> tgd_pluto >> tgt_pluto >> tg_pluto_exit

        tg_exit = EmptyOperator(task_id="Team-Gate-Exit")

        tg_entry >> [ tg_mars_entry, tg_venus_entry, tg_pluto_entry ]
        [ tg_mars_exit, tg_venus_exit, tg_pluto_exit ] >> tg_exit

    with TaskGroup(group_id="System-Gate") as system_gate:
        sg_entry = EmptyOperator(task_id="System-Gate-Entrance")
        with TaskGroup(group_id="System-Gate-Build") as sg_build:
            sgb_entry = EmptyOperator(task_id="System-Gate-Build-Entrance")
            sgb_ora = EmptyOperator(task_id="System-Gate-Build-Oracle-Docker")
            sgb_pgs = EmptyOperator(task_id="System-Gate-Build-Possgres-Docker")
            sgb_app = EmptyOperator(task_id="System-Gate-Build-App-Docker")
            sgb_exit = EmptyOperator(task_id="System-Gate-Build-Exit")
            sgb_entry >> [ sgb_ora, sgb_pgs, sgb_app] >> sgb_exit
        with TaskGroup(group_id="System-Gate-Deploy") as sg_deploy:
            sgd_entry = EmptyOperator(task_id="System-Gate-Deploy-Entrance")
            sgd_ora = EmptyOperator(task_id="System-Gate-Deploy-Oracle-Docker")
            sgd_pgs = EmptyOperator(task_id="System-Gate-Deploy-Postgres-Docker")
            sgd_app = EmptyOperator(task_id="System-Gate-Deploy-App-Docker")
            sgd_exit = EmptyOperator(task_id="System-Gate-Deploy-Exit")
            sgd_entry >> [ sgd_ora, sgd_pgs, sgd_app] >> sgd_exit
        with TaskGroup(group_id="System-Gate-Test") as sg_test:
            sgt_entry = EmptyOperator(task_id="System-Gate-Test-Entrance")
            sgt_ora = EmptyOperator(task_id="System-Gate-Test-Functional")
            sgt_pgs = EmptyOperator(task_id="System-Gate-Test-Performance")
            sgt_app = EmptyOperator(task_id="System-Gate-Test-Security")
            sgt_exit = EmptyOperator(task_id="System-Gate-Test-Exit")
            sgt_entry >> [ sgt_ora, sgt_pgs, sgt_app] >> sgt_exit
        sg_exit = EmptyOperator(task_id="System-Gate-Exit")
        sg_entry >> sg_build >> sg_deploy >> sg_test >> sg_exit

    with TaskGroup(group_id="Release-Gate") as release_gate:
        rg_entry = EmptyOperator(task_id="Release-Gate-Entrance")
        rg_prepare = EmptyOperator(task_id="Release-Gate-Prepare")
        rg_build = EmptyOperator(task_id="Release-Gate-Build")
        rg_artifact = EmptyOperator(task_id="Release-Gate-Artifact")
        rg_verify = EmptyOperator(task_id="Release-Gate-Verify")
        rg_publish = EmptyOperator(task_id="Release-Gate-Publish")
        rg_notify = EmptyOperator(task_id="Release-Gate-Notify")
        rg_exit = EmptyOperator(task_id="Release-Gate-Exit")
        rg_entry >> rg_prepare >> rg_build >> rg_artifact >> rg_verify >> rg_publish >> rg_notify >> rg_exit

    ci_pipe_end = EmptyOperator( task_id='CI-End')

    ci_pipe_start >> pull_git >> main_gate >> team_gate >> system_gate >> release_gate >> ci_pipe_end

# End of file
