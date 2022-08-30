#!/bin/bash
PRG="$0"
PRGDIR=$(dirname "$PRG")
[ -z "$CODE_HOME" ] && CODE_HOME=$(cd "$PRGDIR/.." > /dev/null || exit 1; pwd)

APP_NAME="demo"
echo "开始启动$JAVA_OPTS..."
DUMP_DIR=${CODE_HOME}/dump
CODE_LOG_DIR=${CODE_LOG_DIR:-"${CODE_HOME}/logs"}
JAVA_OPTS="${JAVA_OPTS:-  -Xms256M -Xmx512M -XX:+UseG1GC -server -Duser.timezone=Asia/shanghai -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=${DUMP_DIR}/java_error_in_${APP_NAME}_%p.hprof}"

echo "JAVA_OPTS：$JAVA_OPTS"

if [ ! -d "${CODE_HOME}/logs" ]; then
    mkdir -p "${CODE_LOG_DIR}"
fi

_RUNJAVA=${JAVA_HOME}/bin/java

if [ -z "$JAVA_HOME" ] && [ -z "$CODE_JAVA_HOME" ];then
    echo "请先配置JAVA运行环境，正在退出..."
    exit 1;
fi

[ -z "$JAVA_HOME" ] && _RUNJAVA=${CODE_JAVA_HOME}/bin/java

CLASSPATH="$CODE_HOME/config:$CLASSPATH"
for i in "$CODE_HOME"/libs/*.jar
do
    CLASSPATH="$i:$CLASSPATH"
done

CODE_OPTIONS=" -Dcode.logDir=${CODE_LOG_DIR}"

eval exec "\"$_RUNJAVA\" ${JAVA_OPTS} ${CODE_OPTIONS} -classpath $CLASSPATH -jar ${CODE_HOME}/source/${APP_NAME}.jar\
        2>${CODE_LOG_DIR}/out.log 1> /dev/null &"

if [ $? -eq 0 ]; then
    sleep 1
	echo "程序启动成功!"
else
	echo "程序启动失败!"
	exit 1
fi
