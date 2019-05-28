#!/bin/sh
APPLICATION="springboot-jpa-0.0.1-SNAPSHOT"
APPLICATION_JAR="${APPLICATION}.jar"
JAVA_OPT="-server -Xms2048m -Xmx2048m -Xmn512m -XX:MetaspaceSize=64m -XX:MaxMetaspaceSize=256m"
JAVA_OPT="${JAVA_OPT} -XX:-OmitStackTraceInFastThrow"
BASE_PATH=`pwd`
nohup java ${JAVA_OPT} -jar ${BASE_PATH}/boot/${APPLICATION_JAR}  > /opt/spring-boot-assembly/logs/spring-boot-assembly.log 2>&1 &