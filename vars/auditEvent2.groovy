import groovy.sql.Sql

def call(String event) {
 echo "Call pgsql here and log the event into the database"
  //sh "psql -h postgres_host -U postgres SELECT * FROM audit_events;" 
 def timestamp = new Date().format("yyyyMMdd.HHmm", TimeZone.getTimeZone('EST'))
 def sql = Sql.newInstance("jdbc:postgresql://postgres_host/audit", "ciuser","ciuser", "org.postgresql.Driver")
 sql.execute "INSERT INTO audit_events (event_datetime, event_uid, event_name) VALUES ('001', '002', '003')"
}
