package com.project.springproject.domain;

import java.util.Date;

public class Marker {
	
	private int id;
	private float lat;
	private float lon;
	
	public int getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id=id;
	}
	
	public float getLat()
	{
		return lat;
	}
	
	public void setLat(float lat)
	{
		this.lat=lat;
	}
	
	public float getLon()
	{
		return lon;
	}
	
	public void setLon(float lon)
	{
		this.lon=lon;
	}
}
