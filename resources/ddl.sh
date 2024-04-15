#!/bin/sh

if [ "$NB_DATABASE" = "" ]; then
  echo $0: NB_DATABASE not defined
  exit 1
fi

if [ "$NB_USERNAME" = "" ]; then
  echo $0: NB_USERNAME not defined
  exit 1
fi

echo ------------------- WARNING!!! ------------------
echo THIS WILL DELETE ALL NOTEBOOK DATA!!!
echo Are you sure you want to continue?
echo ""
read tt
if [ "$tt" != "y" ]; then
  echo $0: aborting
  exit 1
fi

psql --username=$NB_USERNAME $NB_DATABASE << EOF

DROP TABLE IF EXISTS NOTEBOOK;

CREATE TABLE NOTEBOOK(
  ID SERIAL,
  TS TIMESTAMP NOT NULL,
  TITLE VARCHAR(100) NOT NULL,
  NOTE TEXT);

EOF

