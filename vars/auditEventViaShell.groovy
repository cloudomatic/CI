def call(String event) {
  echo "Call pgsql here and log the event into the database"
  sh "psql -h postgres_host -U postgres SELECT * FROM audit_events;" 
}
