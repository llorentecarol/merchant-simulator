package xyz.mynt.internal.service;

import java.net.SocketTimeoutException;

import org.apache.http.HttpRequestFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import xyz.mynt.internal.ApplicationConstants;
import xyz.mynt.internal.config.AppConfig;
import xyz.mynt.internal.exception.MerchantSimulatorConnectionException;
import xyz.mynt.internal.exception.MerchantSimulatorException;
import xyz.mynt.internal.exception.MerchantSimulatorTimeoutException;
import xyz.mynt.internal.type.NotifyBarcodeRequest;
import xyz.mynt.internal.type.NotifyBarcodeResponse;
import xyz.mynt.internal.type.ProcessBarcodeRequest;
import xyz.mynt.internal.type.ProcessBarcodeResponse;

@Service
public class BarcodeService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BarcodeService.class);
	
	@Autowired
	private AppConfig appConfig;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	public ProcessBarcodeResponse processBarcode(ProcessBarcodeRequest processBarcodeRequest) throws Exception {

		ProcessBarcodeResponse response = null;
		
		int timeout = 10; //processBarcodeRequest.getTimeout();
		HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		httpRequestFactory.setConnectionRequestTimeout(timeout);
		httpRequestFactory.setConnectTimeout(timeout);
		httpRequestFactory.setReadTimeout(timeout);
		RestTemplate restTemplate = new RestTemplate(httpRequestFactory);
		
		try {
			ResponseEntity<ProcessBarcodeResponse> responseEntity = restTemplate.postForEntity(appConfig.getEsbProcessBarcodeUrl(), processBarcodeRequest,
					ProcessBarcodeResponse.class);
			response = responseEntity.getBody();
			
		} catch (HttpClientErrorException e) {
			
			ProcessBarcodeResponse exResponse = objectMapper.readValue(e.getResponseBodyAsString(), ProcessBarcodeResponse.class);

			LOGGER.error("HttpClientErrorException" + exResponse);
			// TODO Add expected error response
			if (null != exResponse && null != exResponse.getStatus() && exResponse.getStatus().equals("ERROR_TEST")) {
				return exResponse;
			}

			throw new MerchantSimulatorException(ApplicationConstants.NOT_FOUND_CODE, "", processBarcodeRequest);

		} catch (ResourceAccessException e) {
			
			if (e.getRootCause() instanceof SocketTimeoutException) {
				throw new MerchantSimulatorTimeoutException("", "", processBarcodeRequest);
			}
			throw new MerchantSimulatorConnectionException("", "", processBarcodeRequest);
		} catch (Exception e) {
			
			throw new MerchantSimulatorConnectionException("", "generic error", processBarcodeRequest);
		}

		return response;
    	/*
    	//TODO: change this to Criteria Builder to dynamically create json request
    	String requestJSON = "{\"timeSpent\" : \"1h\", \"comment\" : \"carol spring test\"}";
    	
    	ResponseEntity<WorkLogs> responseEntity = null;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        final HttpEntity<String> entity = new HttpEntity<String>(requestJSON,headers);
        
    	try {
    		System.out.println("REQUEST JSON: " + requestJSON);
    		System.out.println("USER: " + user);
    		
    		restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(user.getName(), user.getPassword()));
    		responseEntity = restTemplate.exchange(
    				POST_LOG_WORK_URI,
    				HttpMethod.POST, 
    				entity, 
    				WorkLogs.class,
    				issueKey);
    		
    		System.out.println("STATUS CODE " + responseEntity.getStatusCode() + ":  " + responseEntity.getStatusCode().getReasonPhrase());
    		
    		if (responseEntity.getStatusCode() == HttpStatus.CREATED) {
    			System.out.println(responseEntity.getBody());
    	    }  else if (responseEntity.getStatusCode() == HttpStatus.UNAUTHORIZED) {
    		  // nono... bad credentials
    		}
            
    	  } catch (final HttpClientErrorException httpClientErrorException) {
    		  	System.out.println("HttpClientErrorException !!!!!!!!!!!!!!!!!!!!");
    	        throw httpClientErrorException;
    	  } catch (HttpServerErrorException httpServerErrorException) {
  		  		System.out.println("HttpServerErrorException !!!!!!!!!!!!!!!!!!!!");
    	        throw httpServerErrorException;
    	  } catch (Exception exception) {

    		  	System.out.println("GENERIC SHIT !!!!!!!!!!!!!!!!!!!!");    		  	
    	        exception.printStackTrace();
    	  } 

        return responseEntity.getBody();
        */
    }

	public NotifyBarcodeResponse notifyBarcode(NotifyBarcodeRequest request) {
		// TODO
		NotifyBarcodeResponse response = new NotifyBarcodeResponse();
		response.setAmount(request.getAmount());
		return response;
	}
	
}