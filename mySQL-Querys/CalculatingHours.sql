SELECT
  id,
  punch_in,
  punch_out,
  TIMEDIFF(punch_out, punch_in) AS difference
FROM punchtime.shift;