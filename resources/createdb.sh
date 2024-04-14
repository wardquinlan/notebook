#!/bin/sh

if [ `whoami` != 'postgres' ]; then
  echo $0: must run as \'postgres\'
  exit 1
fi

if [ "$NB_DATABASE" = "" ]; then
  echo $0: NB_DATABASE not defined
  exit 1
fi

if [ "$NB_USERNAME" = "" ]; then
  echo $0: NB_USERNAME not defined
  exit 1
fi

if [ "$NB_PASSWORD" = "" ]; then
  echo $0: NB_PASSWORD not defined
  exit 1
fi

echo $0: attempting to drop database \'$NB_DATABASE\'
dropdb $NB_DATABASE 2>/dev/null
if [ $? != 1 ]; then
  echo $0: database \'$NB_DATABASE\' not found';' skipping drop
fi

echo $0: attempting to create database \'$NB_DATABASE\'
createdb $NB_DATABASE
if [ $? != 0 ]; then
  echo $0: could not create database \'$NB_DATABASE\'
  exit 1
fi

echo $0: attempting to create user \'$NB_USERNAME\'
psql << EOF
  DROP USER IF EXISTS $NB_USERNAME;
  CREATE USER $NB_USERNAME WITH PASSWORD '$NB_PASSWORD';
EOF

echo $0: database $NB_DATABASE created

