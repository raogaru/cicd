from airflow import DAG
from airflow.operators.empty import EmptyOperator
from airflow.operators.bash import BashOperator
from airflow.utils.task_group import TaskGroup

from datetime import datetime

with DAG(
    dag_id='rao2',
    start_date=datetime(2022, 5, 28),
    schedule_interval=None, 
    tags=["rao"]
) as dag:

    task_1 = EmptyOperator( task_id='step_1')

    task_2a = BashOperator( task_id='step_2a', bash_command='scripts/test.sh')
    task_2b = BashOperator( task_id='step_2b', bash_command='scripts/test2.sh')
    task_2c = BashOperator( task_id='step_2c', bash_command='scripts/test.sh')

    task_3a = BashOperator( task_id='step_3a', bash_command='scripts/test.sh')
    task_3b = BashOperator( task_id='step_3b', bash_command='scripts/test.sh')
    task_3c = BashOperator( task_id='step_3c', bash_command='scripts/test.sh')

    task_4a = BashOperator( task_id='step_4a', bash_command='scripts/test.sh')
    task_4b = BashOperator( task_id='step_4b', bash_command='scripts/test.sh')
    task_4c = BashOperator( task_id='step_4c', bash_command='scripts/test.sh')

    with TaskGroup(group_id="task_5", tooltip="Tasks group 5") as task_5:
        group1_task_1 = EmptyOperator(task_id="group1_task_1")
       	group1_task_2 = EmptyOperator(task_id="group1_task_2")
        group1_task_3 = EmptyOperator(task_id="group1_task_3")
        group1_task_4 = EmptyOperator(task_id="group1_task_4")

        group1_task_1 >> [ group1_task_2, group1_task_3 ] 
        [ group1_task_2, group1_task_3 ] >> group1_task_4

    task_6a = BashOperator( task_id='step_6a', bash_command='scripts/test.sh')
    task_6b = BashOperator( task_id='step_6b', bash_command='scripts/test.sh')
    task_6c = BashOperator( task_id='step_6c', bash_command='scripts/test.sh')

    task_7a = BashOperator( task_id='step_7a', bash_command='scripts/test.sh')
    task_7b = BashOperator( task_id='step_7b', bash_command='scripts/test.sh')
    task_7c = BashOperator( task_id='step_7c', bash_command='scripts/test.sh')

    task_8 = EmptyOperator( task_id='step_8')

    task_9 = EmptyOperator( task_id='step_9')

    task_10 = EmptyOperator( task_id='step_10')

task_1 >> [ task_2a, task_2b, task_2c ] 

task_2a >> task_3a
task_2b >> task_3b
task_2c >> task_3c

task_3a >> task_4a
task_3b >> task_4b
task_3c >> task_4c

[ task_4a, task_4b, task_4c ]  >> task_5

task_5 >> [ task_6a, task_6b, task_6c ] 

task_6a >> task_7a
task_6b >> task_7b
task_6c >> task_7c

[ task_7a, task_7b, task_7c ]  >> task_8

task_8 >> task_9 >> task_10

