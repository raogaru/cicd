ECHOpurple "script:build_db.sh START"
BUILD_DB_SQL=${PIPE_DIR}/build_db_${v_team}.sql

ECHO "Drop and recreate database for team ${v_team} using  ${BUILD_DB_SQL}"
cat ${WORKSPACE}/build_db.template |sed -e "s/V_TEAM/${v_team}/g" -e "s/V_APPNAME/${MYAPP_NAME}/g" > ${BUILD_DB_SQL}
cat ${BUILD_DB_SQL}

HEADER2 "Execute ${BUILD_DB_SQL}"
export PGPASSWORD=rao
psql -h localhost -p 5432 -d rao -U rao -f ${BUILD_DB_SQL}
r=$?

if [ $r -eq 0 ]; then
	ECHO "Build DB successful for team ${v_team}"
else
	ERROR "Build DB failed for team ${v_team}"
fi

ECHOpurple "script:build_db.sh END"
