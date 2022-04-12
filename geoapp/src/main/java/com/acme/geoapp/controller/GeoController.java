package com.acme.geoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.acme.geoapp.services.GeoService;

/**
 * Rest controller class for used to get different response for Nominatim service
 * 
 * @author vasudevan.kk
 * @since 10-Apr-2022
 * @version 1.0
 */
@RestController
public class GeoController
{

	@Autowired
	private GeoService geoService;

	/**
	 * Method to get reponse for giving two cordinates (latitude and longitude) ponts and getting response from geo
	 * Nominatim service
	 * 
	 * @param cord1 given  latitude value
	 * @param cord2 given longitude value 
	 * @return String value of response
	 */
	@RequestMapping (value = "/geo/{cord1}/{cord2}", method = RequestMethod.GET)
	public String getPlacesWithCordinate(@PathVariable ("cord1") final String cord1,
			@PathVariable ("cord2") final String cord2)
	{
		return geoService.getPlacesWithCordinate(cord1, cord2);

	}

}
