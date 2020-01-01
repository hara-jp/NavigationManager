#!/bin/sh
get_classpath()
{
  FILE1=`ls ${RTM_JAVA_ROOT}/jar/OpenRTM*`
  FILE2=`ls ${RTM_JAVA_ROOT}/jar/commons-cli*`
  FILE3=`ls ${RTM_JAVA_ROOT}/jar/jna-?.?.?.jar`
  FILE4=`ls ${RTM_JAVA_ROOT}/jar/jna-platform-*.jar`
  FILE5=`ls jar/*.jar`
  CLASSPATH=.:$FILE1:$FILE2:$FILE3:$FILE4:$FILE5:${RTM_JAVA_ROOT}/bin:`dirname $0`/bin:`dirname $0`
  echo ${CLASSPATH}
}
if test "x$RTM_JAVA_ROOT" = "x" ; then
    echo "Environment variable RTM_JAVA_ROOT is not set."
    echo "Please specify the OpenRTM-aist installation directory."
    echo "Abort."
    exit 1
fi
export CLASSPATH=`get_classpath`
java NavigationManagerComp -f rtc.conf $*
