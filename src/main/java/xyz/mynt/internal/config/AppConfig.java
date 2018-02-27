package xyz.mynt.internal.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Getter;
import lombok.Setter;

@Configuration
public class AppConfig
{
	@Value("${esb.barcode.connection-request-to}")
	private int connectionRequestTimeout;

	@Value("${esb.barcode.connection-to}")
	private int connectionTimeout;

	@Value("${esb.barcode.socket-to}")
	private int socketTimeout;
	
	@Value("${esb.barcode.process.barcode.url}")
	@Getter @Setter  private String esbProcessBarcodeUrl;
	
	@Value("${esb.barcode.notify.barcode.url}")
	@Getter @Setter private String esbNotifyBarcodeUrl;
	
	@Autowired
	private DataSource dataSource;
	
	@Bean
	public RestTemplate restTemplate() {
		HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		httpRequestFactory.setConnectionRequestTimeout(10000);
		httpRequestFactory.setConnectTimeout(10000);
		httpRequestFactory.setReadTimeout(10000);
		RestTemplate restTemplate = new RestTemplate(httpRequestFactory);
		return restTemplate;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(){
		return new JdbcTemplate(dataSource);
	}
	
	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}

}