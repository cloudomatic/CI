import groovy.sql.Sql

def call(String event) {
 echo "auditEvent2(): >"
  //sh "psql -h postgres_host -U postgres SELECT * FROM audit_events;" 
 def timestamp = new Date().format("yyyyMMdd.HHmm", TimeZone.getTimeZone('EST'))
 try {
   def sql = Sql.newInstance("jdbc:postgresql://postgres_host/audit", "ciuser","ciuser", "org.postgresql.Driver")
   sql.execute "INSERT INTO audit_events (event_datetime, event_uid, event_name) VALUES ('001', '002', '003')"
 } catch(Exception e) {
   println("auditEvent2(): Exception " + e);
 }
 echo "auditEvent2(): <"
}
