package xyz.mynt.internal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"xyz.mynt.internal"})
public class MerchantSimulatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MerchantSimulatorApplication.class, args);
	}
}
