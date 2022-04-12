package com.acme.geoapp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;


/**
 * Entity class for geo_model table
 * @author vasudevan.kk
 * @since  10-Apr-2022
 * @version 1.0
 */
@Entity
@Data
public class GeoModel {
	@Column (name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	@Column (name = "cordinate1")
	private String cordinate1;
	@Column (name = "cordinate2")
	private String cordinate2;	
	@Column (name = "name")
	private String name;
	@Column (name = "display_name")
	private String display_name;
	@Column (name = "create_date")
	private Date createDate;
	
	

}
