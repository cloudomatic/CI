FROM openshift/jenkins:2
LABEL version="2018_12a"
LABEL description="This is a customization of the Openshift Jenkins:2 image that applies jobs, plugins, and custom configuration on startup"

#ADD configuration/jobs .
ADD ../../pg_stub_libraries /opt/openshift/configuration
ADD ../../bin/pg_stub.py /opt/openshift/configuration
