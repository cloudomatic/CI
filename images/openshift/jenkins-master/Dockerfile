FROM openshift/jenkins-2-centos7
LABEL version="2018_12a"
LABEL description="This is a customization of the Openshift Jenkins:2 image that applies jobs, plugins, and custom configuration on startup"
LABEL maintainer="https://www.github.com/cloudomatic"

USER 0
RUN yum install -y postgresql

USER 1001
ADD configuration/jobs /opt/openshift/configuration/jobs
ADD configuration/*.xml /opt/openshift/configuration/
ADD python_pg_client /opt/openshift/configuration/python_pg_client
