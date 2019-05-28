#!/bin/sh
APPLICATION="springboot-jpa-0.0.1-SNAPSHOT"
APPLICATION_JAR="${APPLICATION}.jar"
PID=$(ps -ef | grep "${APPLICATION_JAR}" | grep -v grep | awk '{ print $2 }')
if [[ -z "$PID" ]]
then
    echo ${APPLICATION} is already stopped
else
    echo kill  ${PID}
    kill ${PID}
    while [[ "$PID" ]] do
        echo -e "."
        sleep 1000
    done

    echo ${APPLICATION} stopped successfully
fi