#!/bin/bash
PRG="$0"
PRGDIR=$(dirname "$PRG")
[ -z "$CODE_HOME" ] && CODE_HOME=$(
  cd "$PRGDIR/.." >/dev/null || exit 1
  pwd
)

if [ ! -d /home/java/jdk-11 ]; then
  if [ ! -d "$CODE_HOME"/source/openjdk-11+28_linux-x64_bin.tar.gz ]; then
    echo "正在下载openjdk-11..."
    curl -L https://download.java.net/openjdk/jdk11/ri/openjdk-11+28_linux-x64_bin.tar.gz --output "$CODE_HOME"/source/openjdk-11+28_linux-x64_bin.tar.gz
  fi
  echo "正在解压jdk..."
  tar -zxf "$CODE_HOME"/source/openjdk-11+28_linux-x64_bin.tar.gz -C /home/java
  echo "export CODE_JAVA_HOME=/home/java/jdk-11" >>/root/.bashrc
  export CODE_JAVA_HOME=/home/java/jdk-11
  source /root/.bashrc
  echo "jdk解压完成,设置环境变量CODE_JAVA_HOME=${CODE_JAVA_HOME}"
else
  echo "已存在目录jdk-11, 请勿重复解压JDK, 退出本脚本..."
fi
