# A customization of the "openshift/jenkins:2" image available in the OpenShift 3.x catalog

FROM openshift/jenkins-2-centos7
LABEL version="2018_12a"
LABEL description="This is a customization of the Openshift Jenkins:2 image that applies jobs, plugins, and custom configuration on startup"
LABEL maintainer="https://www.github.com/cloudomatic"

USER 0
#ADD war/jenkins.war /var/tmp/jenkins.war
#RUN cd /var/tmp/ && unzip jenkins.war && zip -u /usr/lib/jenkins.war WEB-INF/lib/post.jar
ADD configuration/lib/postgresql-9.1-901-1.jdbc4.jar /usr/lib/jvm/java*x86_64/jre/lib/ext/postgresql-9.1-901-1.jdbc4.jar
RUN yum install -y postgresql && \
    chmod u+rwx,g+rwx,o+x /usr/lib/jvm/java*x86_64/jre/lib/ext/postgresql-9.1-901-1.jdbc4.jar 

USER 1001

ADD configuration/jobs /opt/openshift/configuration/jobs
ADD configuration/*.xml /opt/openshift/configuration/
ADD python_pg_client /opt/openshift/configuration/python_pg_client

