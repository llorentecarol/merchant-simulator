package xyz.mynt.internal.probing.transformer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.integration.transformer.AbstractTransformer;
import org.springframework.messaging.Message;

import xyz.mynt.internal.model.ProbingData;

public class ProbingDataToRequestTransformer extends AbstractTransformer {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProbingDataToRequestTransformer.class);
	
	@Override
	protected Message<ProbingData> doTransform(Message<?> message) throws Exception {
		LOGGER.debug("ProbingDataToRequestTransformer payload " + message.getPayload());
		ProbingData probingData = (ProbingData) message.getPayload();
		return MessageBuilder.withPayload(probingData)
				.copyHeaders(message.getHeaders())
				.setHeader("service_code", "NOTIFY")
				.build();
	}

}