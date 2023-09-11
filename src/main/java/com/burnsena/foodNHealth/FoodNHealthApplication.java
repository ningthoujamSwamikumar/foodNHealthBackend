package com.burnsena.foodNHealth;

import com.burnsena.foodNHealth.configs.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class FoodNHealthApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodNHealthApplication.class, args);
	}

}
