package xyz.mynt.internal.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.mynt.internal.model.TransactionLog;
import xyz.mynt.internal.repository.TransactionLogJpaRepository;
import xyz.mynt.internal.util.SimulatorUtil;

@Service
public class LoggerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoggerService.class);
	
	@Autowired
	private TransactionLogJpaRepository transactionLogRepository;
	
	public void logTransaction(String transId, String status, String payload, String channel) {
		
		LOGGER.info("[ "+ transId +" ] payload " + payload);
		
		TransactionLog transaction = new TransactionLog();
		transaction.setTransactionDate(SimulatorUtil.getTimeStamp());
		transaction.setTransId(transId);
		transaction.setStatus(status);
		transaction.setChannel(channel);
		transactionLogRepository.saveAndFlush(transaction);
	}
	
}
