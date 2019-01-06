-- A database to audit events that happen in the Jenkins build pipeline, via the shared library "auditEvent.groovy"

CREATE database audit;

CREATE USER ciuser WITH PASSWORD 'ciuser';

GRANT ALL PRIVILEGES ON DATABASE "audit" to ciuser;

CREATE TABLE ciuser.audit_events(
  event_datetime text PRIMARY KEY,
  event_name text
);

