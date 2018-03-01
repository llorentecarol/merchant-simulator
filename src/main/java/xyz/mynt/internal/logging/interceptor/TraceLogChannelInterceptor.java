package xyz.mynt.internal.logging.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.ChannelInterceptor;

import lombok.Getter;
import lombok.Setter;
import xyz.mynt.internal.model.ProbingData;
import xyz.mynt.internal.model.TraceLog;

public class TraceLogChannelInterceptor implements ChannelInterceptor {

	private static final Logger LOGGER = LoggerFactory.getLogger(TraceLogChannelInterceptor.class);

	@Getter @Setter private String channelName;
	@Getter @Setter private String direction;

	@Override
	public Message<?> preSend(Message<?> message, MessageChannel arg1) {
		LOGGER.debug("TraceLogChannelInterceptor payload " + message.getPayload());
		ProbingData probingData = (ProbingData) message.getPayload();
		TraceLog traceLog = new TraceLog();
		traceLog.setPayload(probingData.toString());
		traceLog.setChannel(channelName);
		traceLog.setDirection(direction);
		MessageBuilder.withPayload(traceLog).build();
		return null;
	}

	@Override
	public void afterReceiveCompletion(Message<?> arg0, MessageChannel arg1, Exception arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterSendCompletion(Message<?> arg0, MessageChannel arg1, boolean arg2, Exception arg3) {
		// TODO Auto-generated method stub

	}

	@Override
	public Message<?> postReceive(Message<?> arg0, MessageChannel arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void postSend(Message<?> arg0, MessageChannel arg1, boolean arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preReceive(MessageChannel arg0) {
		// TODO Auto-generated method stub
		return false;
	}

}
