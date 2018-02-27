package xyz.mynt.internal.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import xyz.mynt.internal.type.ProcessBarcodeRequest;

@Service
public class BarcodeService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BarcodeService.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	public void processBarcode(ProcessBarcodeRequest processBarcodeRequest) {
		
		LOGGER.info("CAROL processBarcodeRequest " + processBarcodeRequest.toString());
		
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
	
	/*
    public Issues retrieveIssues(User user) {
    	
    	//TODO: change this to Criteria Builder to dynamically create json request
    	String requestJSON = "{ \"jql\" : \"project = HRANOMMNL AND assignee in ('pcruz', 'llorente')\" }";
    	
    	ResponseEntity<Issues> responseEntity = null;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        final HttpEntity<String> entity = new HttpEntity<String>(requestJSON,headers);
        
    	try {

    		restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(user.getName(), user.getPassword()));
    		responseEntity = restTemplate.exchange(
    				GET_ISSUE_URI, HttpMethod.POST, entity, Issues.class);
    		
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
    }
    
    
    public WorkLogs logWork(User user, String issueKey, LogWork logWork) {
    	
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
    }
    */
}