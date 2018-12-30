#!/usr/bin/python

#
#  The purpose of this program is to demonstrate calling a python program 
#  from a containerized Jenkins instance with the libraries completely encapsulated on the jenkins-data
#  volume, without requiring a pip install on the source Jenkins installation
#
#
#

import sys,datetime
# Install dependencies (e.g. Postgres) into the mounte volume via (e.g.)
#    pip install --user pg8000
#    mv ~/.local/* /home/ec2-user/CI/pg_stub_libraries
#
# Notes on the pg8000 library are here:
#    https://github.com/tlocke/pg8000#interactive-example
sys.path.append("/home/ec2-user/CI/pg_stub_libraries/lib/python2.7/site-packages/");
import pg8000


timestamp = '{:%Y-%m-%d %H:%M:%S}'.format(datetime.datetime.now())
print timestamp + ": starting program"
databaseConnection = pg8000.connect(host="pg01", port=5432, user="postgres", password="0000")

# Insert example
insertCursor=databaseConnection.cursor()
insertCursor.execute("INSERT INTO t01 values ('" + timestamp + "', 'test')")
insertCursor.execute("INSERT INTO t01 values ('" + timestamp + "', 'test2')")

# Select example
selectCursor = databaseConnection.cursor()
selectCursor.execute("SELECT * FROM t01");
results = selectCursor.fetchall()
for row in results:
  _user, _pass = row
  print("_user=%s _pass=%s" % (_user, _pass))

  



    
    
