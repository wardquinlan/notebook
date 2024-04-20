#!/bin/sh

if [ "$NB_HOME" == "" ]; then
  echo NB_HOME not defined
  exit 1
fi

CLASSPATH=$NB_HOME/notebook.d
CLASSPATH=$CLASSPATH:$NB_HOME/notebook.d/notebook.jar
CLASSPATH=$CLASSPATH:$NB_HOME/notebook.d/log4j-1.2.14.jar
CLASSPATH=$CLASSPATH:$NB_HOME/notebook.d/commons-logging-1.1.jar
CLASSPATH=$CLASSPATH:$NB_HOME/notebook.d/postgresql-42.5.4.jar
CMD="$JAVA_HOME/bin/java -classpath $CLASSPATH -Xmx256m $JAVA_OPTS notebook.Main $@"
$CMD
