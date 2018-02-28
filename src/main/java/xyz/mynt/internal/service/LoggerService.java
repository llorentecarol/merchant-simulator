package xyz.mynt.internal.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.mynt.internal.model.TransactionLog;
import xyz.mynt.internal.repository.TransactionLogJpaRepository;

@Service
public class LoggerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoggerService.class);
	
	@Autowired
	private TransactionLogJpaRepository transactionLogRepository;
	
	public void logTransaction(String transId, String status, Object payload, String channel) {
		
		LOGGER.info("[ "+ transId +" ] payload " + payload.toString());
		
		TransactionLog transaction = new TransactionLog();
		transaction.setTransId(transId);
		transaction.setStatus(status);
		transaction.setChannel(channel);
		transaction.setPayload(payload.toString());
		transaction.setTransactionDate(new Date());

		transactionLogRepository.saveAndFlush(transaction);
	}
	
}
