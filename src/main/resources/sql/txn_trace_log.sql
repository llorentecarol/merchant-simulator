create table txn_trace_log(
	id bigint PRIMARY KEY not null,
	logtime TIMESTAMP,
	trans_id varchar(30),
	channel varchar(30),
	direction varchar(30),
	payload varchar(200));
CREATE INDEX txn_trace_log_index
ON txn_trace_log (trans_id, logtime);