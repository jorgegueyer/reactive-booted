FROM registry.access.redhat.com/ubi8/ubi:8.2

MAINTAINER Jorge Guerra Yerpes <jorgegueyer@gmail.com>

ENV	JAVA_OPTIONS -Xmx512m

# Install the Java runtime
RUN yum install -y --disableplugin=subscription-manager java-11-openjdk-headless && \
    yum clean all --disableplugin=subscription-manager -y && \
    mkdir -p /opt/app-root/bin

WORKDIR /opt/app-root/bin

ARG JAR_FILE=target/reactive-booted.jar

COPY ${JAR_FILE} /opt/app-root/bin/app.jar

# Set permissions
RUN  chgrp -R 0 /opt/app-root && \
     chmod -R g=u /opt/app-root

EXPOSE 8080

# User a non-root user
USER 1001

ENTRYPOINT ["java","-jar","app.jar"]