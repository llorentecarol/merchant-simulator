package xyz.mynt.internal.probing.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import xyz.mynt.internal.model.ProbingData;

public class ProbingDataRowMapper implements RowMapper<ProbingData> {

	@Override
	public ProbingData mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProbingData probingData = new ProbingData();
		probingData.setProbeDate(rs.getTimestamp("PROBE_DATE"));
		probingData.setTransactionDate(rs.getTimestamp("TRANSACTION_DATE"));
		probingData.setTransId(rs.getString("TRANS_ID"));
		probingData.setStatus(rs.getString("STATUS"));
		probingData.setProbeCounter(rs.getInt("PROBE_COUNTER"));
		probingData.setResponseCode(rs.getString("RESPONSE_CODE"));
		return probingData;
	}
}
