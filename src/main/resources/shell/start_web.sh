#!/bin/sh

cd /svc/dvdocs/event.redsaharastudio.net

config_file="conf/webserver_dev.json"
log_config="conf/log4j_dev.xml"

# Setting JVM classpath
CLASSPATH=""
CLASSPATH=$CLASSPATH:mylib/iw-event-api-0.5.jar
CLASSPATH=$CLASSPATH:mylib/javautils-0.6.1.jar
CLASSPATH=$CLASSPATH:lib/reflections-0.9.9-RC1.jar
CLASSPATH=$CLASSPATH:lib/guava-11.0.2.jar
CLASSPATH=$CLASSPATH:lib/javassist-3.16.1-GA.jar
CLASSPATH=$CLASSPATH:lib/commons-lang3-3.3.2.jar
CLASSPATH=$CLASSPATH:lib/commons-io-2.4.jar
CLASSPATH=$CLASSPATH:lib/yoke-2.0.3.jar
export CLASSPATH

# Setting VertX ENV options
VERTX_OPTS="-Dorg.vertx.logger-delegate-factory-class-name=org.vertx.java.core.logging.impl.Log4jLogDelegateFactory -Dlog4j.configuration=file:$log_config"
export VERTX_OPTS

nohup vertx run com.gmtsoft.iw.webserver.WebServer -instances 1 -conf $config_file > out.txt &
