package com.project.springproject.service;

import java.sql.ResultSet;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.springproject.domain.Marker;

@Service("markerService")
@Transactional
public class MarkerService 
{
	private SimpleJdbcTemplate jdbcTemplate;
	
	@Resource(name="dataSource")
	public void setDataSource(DataSource dataSource)
	{
		this.jdbcTemplate = new SimpleJdbcTemplate(dataSource);
	}
	
	//retrieve markers
	public List<Marker> getAll()
	{
		//Sql
		String sql = "select id, lat, lon, from locationdata";
		
		//map result to rows
		RowMapper<Marker> mapper = new RowMapper<Marker>() 
		{
			public Marker mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				Marker marker = new Marker();
				marker.setId(rs.getInt("id"));
				marker.setLat(rs.getFloat("lat"));
				marker.setLon(rs.getFloat("lon"));
					return marker;
			}
		};
		
			//Retrieve All
			return jdbcTemplate.query(sql, mapper);
	}
}

