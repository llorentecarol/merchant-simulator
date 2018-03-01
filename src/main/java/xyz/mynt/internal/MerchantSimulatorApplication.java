package xyz.mynt.internal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ComponentScan({ "xyz.mynt.internal" })
@ImportResource({ "classpath:probing-mechanism/probing-config.xml",
		"classpath:probing-mechanism/probing-process-barcode-config.xml",
		"classpath:probing-mechanism/trace-log-config.xml"})
public class MerchantSimulatorApplication {
	public static void main(String[] args) {
		SpringApplication.run(MerchantSimulatorApplication.class, args);
	}
}
