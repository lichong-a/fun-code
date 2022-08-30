#!/bin/bash
# 输入参数为要关闭demo的访问端口号
if [ -z "$1" ]

then
    pid=`ps ax |grep -i 'demo.jar' |grep java | grep -v grep |  awk '{print $1}'`
else
    pid=`ps ax |grep -i 'demo.jar' |grep java | grep -i 'server.port='''${1}''''| grep -v grep |  awk '{print $1}'`
fi

if [ -z "$pid" ] ; then
        echo "demo is not running."
        exit 0;
fi

echo "demo(${pid}) is running."
echo "Send shutdown request to demo(${pid})....."
kill -9 ${pid}
echo "Shutdown demo(${pid}) success."
 