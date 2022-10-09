############文件夹说明############

1. 各文件说明如下:
	1. unZipJDK.sh: 本服务使用jdk的解压脚本, 将会将source下的jdk压缩包解压到项目根目录路径下，如果不存在jdk压缩文件，会自动从互联网下载
	2. start.sh: jar包的启动脚本,执行时如果没有JAVA_HOME的环境变量会要求先执行unZipJDK.sh脚本
	3. stop.sh: 使用本脚本关闭服务
2. 执行本文件夹下脚本,执行命令为 sh xxx.sh
执行步骤如下:
    1. sh unZipJDK.sh
	2. sh start.sh
关闭脚本为 stop.sh,若需要关闭可执行脚本
	1. sh stop.sh
