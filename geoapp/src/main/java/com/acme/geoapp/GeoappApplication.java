package com.acme.geoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

/**Initial class Springboot
 * @author vasudevan.kk
 * @since  10-Apr-2022
 * @version 1.0
 */
@SpringBootApplication
@EnableCaching
@EnableScheduling
public class GeoappApplication {
	  
	public static void main(String[] args) {
		SpringApplication.run(GeoappApplication.class, args);
	}
	

}
