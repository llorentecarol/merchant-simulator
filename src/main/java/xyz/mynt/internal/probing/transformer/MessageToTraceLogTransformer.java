package xyz.mynt.internal.probing.transformer;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.integration.transformer.AbstractTransformer;
import org.springframework.messaging.Message;

import xyz.mynt.internal.model.ProbingData;
import xyz.mynt.internal.model.TraceLog;

public class MessageToTraceLogTransformer extends AbstractTransformer {

	private static final Logger LOGGER = LoggerFactory.getLogger(MessageToTraceLogTransformer.class);
	
	@Override
	protected Message<TraceLog> doTransform(Message<?> message) throws Exception {
		LOGGER.debug("MessageToTraceLogTransformer payload " + message.getPayload());
		ProbingData probingData = (ProbingData) message.getPayload();
		TraceLog traceLog = new TraceLog();
		traceLog.setPayload(probingData.toString());
		traceLog.setLogtime(new Date());
		traceLog.setTransId(probingData.getTransId());
		return MessageBuilder.withPayload(traceLog)
				.copyHeaders(message.getHeaders())
				.setHeader("service_code", "NOTIFY")
				.build();
	}

}