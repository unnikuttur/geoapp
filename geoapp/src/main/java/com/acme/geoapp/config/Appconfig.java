package com.acme.geoapp.config;

import javax.management.timer.Timer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import com.acme.geoapp.services.GeoServiceImpl;

@Configuration
public class Appconfig
{
	public static final String GEO_CACHE = "placeWithCordinate";
	  private static final Logger LOGGER=LoggerFactory.getLogger(GeoServiceImpl.class);

		@Bean
		RestTemplate getRestTemplate()
		{
			return new RestTemplate();
		}

		@Scheduled (fixedRate = Timer.ONE_DAY)
		@CacheEvict (value = { GEO_CACHE }, allEntries = true)
		public void clearEvents()
		{
			LOGGER.info("Clearing 'placeWithCordinate' caches");
		}


}
