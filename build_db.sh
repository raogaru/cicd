ECHOpurple "script:build_liquibase.sh START"
ECHO "Drop and recreate database for team ${v_team}"

ECHO "Prepare ${PIPE_DIR}/build_db.sql" 
echo "
\list
drop database ${v_team};
\list
create database ${v_team};
\list
\connect ${v_team}
\dn
create schema ${MYAPP_NAME};
\dn
set search_path to ${MYAPP_NAME};
" >> ${PIPE_DIR}/build_db.sql

HEADER2 "File: ${PIPE_DIR}/build_db.sql"
cat ${PIPE_DIR}/build_db.sql

HEADER2 "Execute ${PIPE_DIR}/build_db.sql"
psql -h localhost -p 5432 -d rao -U rao -P rao -f ${PIPE_DIR}/build_db.sql

ECHOpurple "script:build_liquibase.sh END"
