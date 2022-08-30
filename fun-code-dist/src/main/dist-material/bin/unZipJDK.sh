#!/bin/bash
PRG="$0"
PRGDIR=$(dirname "$PRG")
[ -z "$CODE_HOME" ] && CODE_HOME=$(cd "$PRGDIR/.." > /dev/null || exit 1; pwd)

if [ ! -d "$CODE_HOME"/jdk1.8.0_311 ];then
    echo "正在解压jdk..."
    tar -zxf source/jdk-8u311-linux-x64.tar.gz -C "$CODE_HOME"
    echo "export CODE_JAVA_HOME=${CODE_HOME}/jdk1.8.0_311" >> /root/.bashrc
    export CODE_JAVA_HOME=${CODE_HOME}/jdk1.8.0_311
    source /root/.bashrc
    echo "jdk解压完成,设置环境变量CODE_JAVA_HOME=${CODE_JAVA_HOME}"
else
    echo "已存在目录jdk1.8.0_311, 请勿重复解压JDK, 退出本脚本..."
fi

