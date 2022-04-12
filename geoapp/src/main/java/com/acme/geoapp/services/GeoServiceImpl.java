package com.acme.geoapp.services;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.acme.geoapp.model.GeoModel;
import com.acme.geoapp.objects.GeoObject;
import com.acme.geoapp.repository.GeoRepository;

@Service
public class GeoServiceImpl implements GeoService{
	
	private static final Logger LOGGER=LoggerFactory.getLogger(GeoServiceImpl.class);

	@Autowired
	RestTemplate resttemplate;
	@Autowired
	private GeoRepository geoRepository;
	
	
	@Cacheable(cacheNames = "placeWithCordinate",key = "{#cord1,#cord2}",condition = "#cord1 != null && #cord2 != null")
	@Override
	public String getPlacesWithCordinate(final String cord1, final String cord2)
	{
		LOGGER.info("@getPlacesWithCordinate  ");
		final String result = geoRepository.findByPlaceWithCordinates(cord1, cord2);
		// geo loation from library
		final String url = "https://nominatim.openstreetmap.org/reverse?format=jsonv2&lat=" + cord1 + "&lon=" + cord2;
		final GeoObject geoObj = resttemplate.getForObject(url, GeoObject.class);		
		final String name=Optional.ofNullable(geoObj).map(obj->obj.getName()).orElse("");
		final String dispName=Optional.ofNullable(geoObj).map(obj->obj.getDisplay_name()).orElse("");
        
		if (!Objects.nonNull(result))
		{
			LOGGER.info("@getPlacesWithCordinate saving to db ");
			GeoModel model = new GeoModel();
			model.setCordinate1(cord1);
			model.setCordinate2(cord2);			
			model.setName(name);			
			model.setDisplay_name(dispName);
			model.setCreateDate(new Date());
			geoRepository.save(model);
		}
		return dispName;
	}

}
