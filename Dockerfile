FROM   registry.access.redhat.com/ubi8/ubi:8.2

MAINTAINER  Jorge Guerra Yerpes <jorgegueyer@gmail.com>

ENV	JAVA_OPTIONS -Xmx512m

# Install the Java runtime, create a user for running the app, and set permissions
RUN yum install -y --disableplugin=subscription-manager java-11-openjdk-headless && \
    yum clean all --disableplugin=subscription-manager -y && \
    useradd netty && \
    mkdir -p /opt/app-root/bin

WORKDIR /opt/app-root/bin

ARG JAR_FILE=target/reactive-booted.jar

COPY ${JAR_FILE} /opt/app-root/bin/app.jar

RUN  chown -R netty:netty /opt/app-root && \
     chmod -R 700 /opt/app-root

EXPOSE 8080

USER netty

ENTRYPOINT ["java","-jar","app.jar"]