#!/bin/sh

if [ "$ES_DATABASE" = "" ]; then
  echo $0: ES_DATABASE not defined
  exit 1
fi

if [ "$ES_USERNAME" = "" ]; then
  echo $0: ES_USERNAME not defined
  exit 1
fi

echo ------------------- WARNING!!! ------------------
echo THIS WILL DELETE ALL ECON DATA!!!
echo Are you sure you want to continue?
echo ""
read tt
if [ "$tt" != "y" ]; then
  echo $0: aborting
  exit 1
fi

psql --username=$ES_USERNAME $ES_DATABASE << EOF

DROP TABLE IF EXISTS TIME_SERIES_DATA;
DROP TABLE IF EXISTS TIME_SERIES;

CREATE TABLE TIME_SERIES(
  ID INTEGER PRIMARY KEY, -- e.g. 100
  NAME VARCHAR(100) UNIQUE NOT NULL, -- e.g. 'CORPCCC'
  TITLE VARCHAR(500) NOT NULL, -- e.g. 'ICE BofA CCC & Lower US High Yield Index Effective Yield'
  SOURCE VARCHAR(100), -- e.g. 'FRED'
  SOURCE_ID VARCHAR(100), -- e.g. 'BAMLH0A3HYCEY'
  UNITS VARCHAR(100),
  UNITS_SHORT VARCHAR(50),
  FREQUENCY VARCHAR(100),
  FREQUENCY_SHORT VARCHAR(50),
  NOTES TEXT); -- free-form notes 

CREATE TABLE TIME_SERIES_DATA(
  ID INTEGER REFERENCES TIME_SERIES(ID) NOT NULL,
  DATESTAMP DATE NOT NULL,
  VALUE REAL NOT NULL,
  UNIQUE(ID, DATESTAMP));
EOF

