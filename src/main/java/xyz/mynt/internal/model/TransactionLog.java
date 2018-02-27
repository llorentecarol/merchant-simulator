/**
 * 
 */
package xyz.mynt.internal.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "transaction_logs")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class TransactionLog implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "trans_id")
	@NotNull(message = "Transaction Id is required.")
	private String transId;
	
	@Column(name = "channel")
	@NotNull(message = "Channel is required.")
	private String channel;

	@Column(name = "status")
	@NotNull(message = "Status is required.")
	private String status;

	@Column(name = "transaction_date")
	@NotNull(message = "Transaction Date is required.")
	private Timestamp transactionDate;

	@Column(name = "process_barcode_result_code")
	private String processBarcodeResultCode;

	@Column(name = "process_barcode_result_desc")
	private String processBarcodeResultDesc;

	@Column(name = "notify_barcode_result_code")
	private String notifyBarcodeResultCode;

	@Column(name = "notify_barcode_result_desc")
	private String notifyBarcodeResultDesc;

}
