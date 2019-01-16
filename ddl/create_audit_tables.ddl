DROP TABLE audit_events;

CREATE TABLE audit_events(
  event_id SERIAL PRIMARY KEY,
  event_datetime text,
  event_name text
);

