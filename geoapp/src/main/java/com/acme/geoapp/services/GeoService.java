package com.acme.geoapp.services;

/**
 * Interface for
 * 
 * @author vasudevan.kk
 * @since 10-Apr-2022
 * @version 1.0
 */
public interface GeoService
{

	/**
	 * Service method to access dispalay name. if request entered , if it is new it will get data from Nominatim service
	 * and it is persisted in to data base and retun display name.
	 * 
	 * @param cord1 given first input value
	 * @param cord2 given second input value
	 * @return String value to be displayes
	 */
	String getPlacesWithCordinate(final String cord1, final String cord2);

}
