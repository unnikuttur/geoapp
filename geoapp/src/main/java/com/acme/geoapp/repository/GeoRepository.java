package com.acme.geoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.acme.geoapp.model.GeoModel;

/**
 * Repositiory clss for persisting Nominatim data
 * @author vasudevan.kk
 * @since  10-Apr-2022
 * @version 1.0
 */
@Repository
public interface GeoRepository extends JpaRepository<GeoModel, Integer>{

	/**
	 * method to find data from database when given the coordinates
	 * @param cord1 given input coordinate1
	 * @param cord2 given input coodinate2
	 * @return string value
	 */
	@Query("SELECT display_name FROM GeoModel p WHERE p.cordinate1=:cord1 and p.cordinate2=:cord2")
	String findByPlaceWithCordinates(final String cord1, final String cord2);

}
