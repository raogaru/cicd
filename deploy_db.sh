ECHOpurple "script:deploy_db.sh START"

V_DB=${1}

HEADER2 "Deploy using liquibase to database \"${V_DB}\""
ECHO "current directory is $PWD"

liquibase \
  --driver=org.postgresql.Driver \
  --classpath=../../war/WEB-INF/lib/postgresql-42.2.20.jar \
  --url="jdbc:postgresql://localhost:5432/${V_DB}" \
  --changeLogFile=src/db/liquibase.xml \
  --liquibaseSchemaName=demo \
  --databaseChangeLogTableName=db_chg_log \
  --databaseChangeLogLockTableName=db_chg_lock \
  --username=rao \
  --password=rao \
  --logLevel info \
update

#  --defaultsFile src/db/liquibase.properties \

r=$?

if [ $r -eq 0 ]; then
	ECHO "Build DB successful for team ${v_team}"
else
	ERROR "Build DB failed for team ${v_team}"
fi

ECHOpurple "script:deploy_db.sh END"
