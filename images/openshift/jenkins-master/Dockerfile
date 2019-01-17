FROM openshift/jenkins-2-centos7
LABEL version="2018_12a"
LABEL description="This is a customization of the Openshift Jenkins:2 image that applies jobs, plugins, and custom configuration on startup"
LABEL maintainer="https://www.github.com/cloudomatic"

USER 0
RUN yum install -y postgresql
ADD war/jenkins.war /var/tmp/jenkins.war
RUN cd /var/tmp/ && unzip jenkins.war && zip -u /usr/lib/jenkins.war WEB-INF/lib/post.jar

USER 1001
ADD configuration/jobs /opt/openshift/configuration/jobs
ADD configuration/*.xml /opt/openshift/configuration/
ADD python_pg_client /opt/openshift/configuration/python_pg_client
ADD configuration/lib/* 

