import groovy.sql.Sql

def call(String event) {
 echo "auditEvent2(): >"
 //sh "psql -h postgres_host -U postgres SELECT * FROM audit_events;" 
 def timestamp = new Date().format("yyyyMMdd.HHmm", TimeZone.getTimeZone('EST'))
 try {
   println("timestamp=" + timestamp);
   def sql = Sql.newInstance("jdbc:postgresql://postgres_host/audit", "ciuser","ciuser", "org.postgresql.Driver")
   sql.execute "INSERT INTO audit_events (event_datetime, event_uid, event_name) VALUES ('" + timestamp + "', 'unknown_user', '" + event + "');"
 } catch(Exception e) {
   println("auditEvent2(): Exception " + e);
 }
 echo "auditEvent2(): <"
}
