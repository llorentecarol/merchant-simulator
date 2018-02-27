create table transaction_logs(
	trans_id varchar(30),
	channel varchar(30),
	status varchar(30),
	transaction_date TIMESTAMP,	
	process_barcode_result_code varchar(10),
	process_barcode_result_desc varchar(150),
	notify_barcode_result_code varchar(10),
	notify_barcode_result_desc varchar(150),
	PRIMARY KEY (trans_id),
	INDEX (transaction_date));