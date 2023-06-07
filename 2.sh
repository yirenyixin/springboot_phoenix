#/bin/bash

tomcat=$(netstat -nlp | grep :8080 | awk '{print $7}' | awk -F"/" '{ print $1 }')
 if [ -z "${tomcat}" ]; then
   echo 1 > test.log
  else
   kill -9 $tomcat
 fi

cd springboot_phoenix

mvn clean compile   -Dmaven.test.skip=true > /root/info.log

cat /root/info.log | grep "ERROR" > /root/error.log

if test -s /root/error.log; then
    cat /root/error.log
else
	cd target/classes
    rm ../lib/slf4j-log4j12-1.7.26.jar
	nohup java -Dfile.encoding=utf-8  -Djava.ext.dirs=../lib:$JAVA_HOME/jre/lib/ext  net.educoder.Application >/root/springboot.log 2>&1 &
	   while true
            do
                springboot=$(netstat -nlp | grep :8080 | awk '{print $7}' | awk -F"/" '{ print $1 }')
                if [ -z "${springboot}" ]; then
                  echo 1 > /root/test.log
                else
                    curl -s  localhost:8080/jsMindInfo  -d 'id=431202201704110'
                  break
                fi
            done
fi

