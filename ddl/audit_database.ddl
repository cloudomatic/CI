-- A database to audit events that happen in the Jenkins build pipeline, via the shared library "auditEvent.groovy"

CREATE TABLE audit_events(
  event_datetime text,
  event_name test
);
