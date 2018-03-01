package xyz.mynt.internal.service;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.mynt.internal.ApplicationConstants;
import xyz.mynt.internal.config.AppConfig;
import xyz.mynt.internal.model.ProbingData;
import xyz.mynt.internal.model.TransactionLog;
import xyz.mynt.internal.repository.ProbingDataRepository;
import xyz.mynt.internal.repository.TransactionLogJpaRepository;
import xyz.mynt.internal.type.ProcessBarcodeRequest;

@Service
public class LoggerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoggerService.class);
	
	@Autowired
	private TransactionLogJpaRepository transactionLogRepository;
	
	@Autowired
	private ProbingDataRepository probingDataRepository;
	
	@Autowired
	private AppConfig appConfig;
	
	public void logTransaction(String transId, String status, Object payload, String channel) {
		
		LOGGER.info("[ "+ transId +" ] logTransaction payload " + payload.toString());
		
		TransactionLog transaction = new TransactionLog();
		transaction.setTransId(transId);
		transaction.setStatus(status);
		transaction.setChannel(channel);
		transaction.setPayload(payload.toString());
		transaction.setTransactionDate(new Date());

		transactionLogRepository.saveAndFlush(transaction);
	}
	
	public void probeTransaction(String transId, String status, String channel, Object payload) {
		
		LOGGER.info("[ "+ transId +" ] probeTransaction payload " + payload.toString());
		ProcessBarcodeRequest originalRequest = (ProcessBarcodeRequest) payload;
		ProbingData probingData = new ProbingData();
		
		// TODO: externalize and move to util class
		long FIVE_MINUTE_IN_MILLIS=300000;//millisecs

		Calendar date = Calendar.getInstance();
		long t= date.getTimeInMillis() + appConfig.getFirstProbingDateConfig();
		Date probingDate = new Date(t);
		
		probingData.setProbeDate(probingDate);
		probingData.setProbeCounter(0);
		probingData.setTransId(transId);
		probingData.setStatus(status);
		// TODO
		probingData.setTransactionDate(new Date());
		probingDataRepository.saveAndFlush(probingData);
	}
	
}
