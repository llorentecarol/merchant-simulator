package xyz.mynt.internal.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "txn_probe_pool")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class ProbingData implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "generator")
	@GenericGenerator(name = "generator", strategy = "increment")
	@Column(name = "id", columnDefinition = "int")
	private Long id;
	
	@Column(name = "transaction_date")
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING, timezone = "GMT+8")
	private Date transactionDate;

	@Column(name = "probe_date")
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING, timezone = "GMT+8")
	private Date probeDate;
	
	@Column(name = "PROBE_COUNTER")
	private int probeCounter;
	
	@Column(name = "trans_id")
	private String transId;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "response_code")
	private String responseCode;
}
