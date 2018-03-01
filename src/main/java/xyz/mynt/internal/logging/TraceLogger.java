package xyz.mynt.internal.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.Getter;
import lombok.Setter;
import xyz.mynt.internal.model.TraceLog;
import xyz.mynt.internal.repository.TraceLogRepository;

public class TraceLogger {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TraceLogger.class);
	
	@Autowired
	private TraceLogRepository traceLogRepository;
	
	@Getter @Setter private TraceLog traceLog;
	
	public TraceLogger() {
		//this.traceLog = traceLog;
	}
	
	public void logMessage() {
		LOGGER.info("TraceLogger logMessage");
	}
}
