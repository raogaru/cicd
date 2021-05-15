ECHOpurple "script:build_db.sh START"
ECHO "Drop and recreate database for team ${v_team}"

BUILD_DB_SQL=${PIPE_DIR}/build_db_${v_team}.sql
#ADDENV "BUILD_DB_SQL_${v_team}=${BUILD_DB_SQL}"

ECHO "Prepare ${BUILD_DB_SQL}" 
echo -n "
\l+ ${v_team}
drop database if exists ${v_team};
\l+ ${v_team}
create database ${v_team};
\l+ ${v_team}
\" > ${BUILD_DB_SQL}

echo "connect ${v_team};
\dn
create schema ${MYAPP_NAME};
\dn
set search_path to ${MYAPP_NAME};
" >> ${BUILD_DB_SQL}

HEADER2 "File: ${BUILD_DB_SQL}"
cat ${BUILD_DB_SQL}

HEADER2 "Execute ${PIPE_DIR}/build_db.sql"
export PGPASSWORD=rao
psql -h localhost -p 5432 -d rao -U rao -f ${BUILD_DB_SQL}

ECHOpurple "script:build_db.sh END"
