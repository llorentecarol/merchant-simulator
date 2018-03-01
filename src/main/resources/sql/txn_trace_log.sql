create table txn_trace_log(
	id bigint(16) not null,
	logtime TIMESTAMP,
	trans_id varchar(30),
	channel varchar(30),
	direction varchar(30),
	payload varchar(200),
	PRIMARY KEY (id),
	INDEX (trans_id, logtime));