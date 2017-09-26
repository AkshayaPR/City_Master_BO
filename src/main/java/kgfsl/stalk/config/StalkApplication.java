package kgfsl.stalk.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages = { "kgfsl" })
@EnableEurekaClient
public class StalkApplication {

	public static void main(String[] args) {
		SpringApplication.run(StalkApplication.class, args);
	}
}
