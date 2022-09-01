@echo off

if "%1"=="" (

	echo input version
	set /p version=
) else (

	set version=%1
)

if "%version%"=="" (

	echo version is empty
	exit 1
)

echo new version:%version%

cd ../

call ./mvnw -s ./scripts/settings.xml versions:set -DgenerateBackupPoms=false -DoldVersion=* -DnewVersion=%version% -DprocessAllModules=true -DallowSnapshots=true
echo 版本修改完成

pause