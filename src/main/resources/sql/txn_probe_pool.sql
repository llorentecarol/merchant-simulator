create table txn_probe_pool(
	id bigint(16) not null,
	probe_date TIMESTAMP,
	transaction_date TIMESTAMP,
	trans_id varchar(30),
	status varchar(30),
	probe_counter int,
	response_code varchar(10),
	PRIMARY KEY (id),
	INDEX (trans_id, transaction_date));