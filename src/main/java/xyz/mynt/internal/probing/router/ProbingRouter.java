package xyz.mynt.internal.probing.router;

import java.util.Map;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

/*
 * @author: cllorente
 */
public class ProbingRouter {
	
	private Map<String, String> probingMap;
	private String defaultChannel = "";

	public ProbingRouter(Map<String, String> probingMap) {
		this.probingMap = probingMap;
	}

	public String route(Message<?> message) {
		MessageHeaders headers = message.getHeaders();
		if(headers.get("service_code") != null) {
			probingMap.forEach((k, v) -> {
				if (headers.get("service_code").equals(k))
					defaultChannel = v;
			});
		}
		return defaultChannel;
	}
}