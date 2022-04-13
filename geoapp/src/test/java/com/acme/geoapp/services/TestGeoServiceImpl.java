package com.acme.geoapp.services;

import static org.mockito.Mockito.times;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import com.acme.geoapp.objects.GeoObject;
import com.acme.geoapp.repository.GeoRepository;

@SpringBootTest
class TestGeoServiceImpl
{
	@Autowired
	private GeoService geoService;
	@MockBean
	RestTemplate resttemplate;
	@MockBean
	private GeoRepository geoRepository;

	@Test
	void testGetPlacesWithCordinate() throws InterruptedException
	{
		GeoObject first = new GeoObject();
		first.setDisplay_name("first");
		GeoObject second = new GeoObject();
		second.setDisplay_name("second");

		    // Set up the mock to return *different* objects for the first and second call
		 Mockito.when(resttemplate.getForObject(Mockito.any(String.class),Mockito.any())).thenReturn(first, second);
		 Object result = geoService.getPlacesWithCordinate("9.999", "10.545");
		 Assertions.assertTrue(result.equals(first.getDisplay_name()));
		 result = geoService.getPlacesWithCordinate("9.999", "10.545");
		 Assertions.assertTrue(result.equals(first.getDisplay_name()));
		 
		 /*
		 result = geoService.getPlacesWithCordinate("9.999", "10.545");
		 Assertions.assertTrue(result.equals(first.getDisplay_name()));
		 Thread.sleep((1000*60*60*60)-1);
		 result = geoService.getPlacesWithCordinate("9.999", "10.545");
		 Assertions.assertTrue(result.equals(first.getDisplay_name()));
		 */
		 
		 /*
		 result = geoService.getPlacesWithCordinate("9.999", "10.545");
		 Assertions.assertTrue(result.equals(first.getDisplay_name()));
		 Thread.sleep((1000*60*60*60)+1);
		 result = geoService.getPlacesWithCordinate("9.999", "10.545");
		 Assertions.assertTrue(result.equals(second.getDisplay_name()));
		 */
		 
		 //-ve
		 Assertions.assertNotNull(geoService.getPlacesWithCordinate(null, null));
	}

}
