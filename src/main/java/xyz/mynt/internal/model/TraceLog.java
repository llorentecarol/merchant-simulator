/**
 * 
 */
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
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "txn_trace_log")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class TraceLog implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "generator")
	@GenericGenerator(name = "generator", strategy = "increment")
	@Column(name = "id", columnDefinition = "int")
	private Long id;

	@Column(name = "trans_id")
	@NotNull(message = "Transaction Id is required.")
	private String transId;

	@Column(name = "channel")
	@NotNull(message = "Channel is required.")
	private String channel;
	
	@Column(name = "direction")
	@NotNull(message = "Direction is required.")
	private String direction;

	@Column(name = "logtime")
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING, timezone = "GMT+8")
	private Date logtime;

	@Column(name = "payload")
	private String payload;
}
