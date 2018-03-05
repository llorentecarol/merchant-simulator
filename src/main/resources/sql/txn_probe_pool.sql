CREATE TABLE txn_probe_pool(
	id bigint PRIMARY KEY NOT NULL,
	probe_date TIMESTAMP,
	transaction_date TIMESTAMP,
	trans_id varchar(30),
	status varchar(30),
	probe_counter int,
	response_code varchar(10));
CREATE INDEX txn_probe_pool_index
ON txn_probe_pool (trans_id, transaction_date);