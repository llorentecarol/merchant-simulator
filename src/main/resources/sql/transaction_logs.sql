create table transaction_logs(
	msisdn varchar(12) not null,
	can varchar(16) not null,
	transaction_date TIMESTAMP,
	gcash_trans_id varchar(30),
	gcash_status varchar(30),
	beep_code varchar(30),
	beep_status varchar(30),
	create_load_result_code varchar(10),
	create_load_result_desc varchar(150),
	reverse_result_code varchar(10),
	reverse_result_desc varchar(150),
	PRIMARY KEY (gcash_trans_id),
	INDEX (msisdn, can, transaction_date));