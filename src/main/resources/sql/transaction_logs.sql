create table transaction_logs(
	id bigint PRIMARY KEY not null,
	trans_id varchar(30),
	channel varchar(30),
	status varchar(30),
	transaction_date TIMESTAMP,
	barcode_string varchar(100),
	payload varchar(200),
	process_barcode_result_code varchar(10),
	process_barcode_result_desc varchar(150),
	notify_barcode_result_code varchar(10),
	notify_barcode_result_desc varchar(150));
CREATE INDEX transaction_logs_index
ON transaction_logs (trans_id, transaction_date);