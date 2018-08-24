package com.xxt.service;

import java.util.List;
import com.common.page.Pagination;
import com.xxt.entity.City;
import com.xxt.entity.CityQuery;

public interface CityService {

	public City getCityById(Integer id);
	public Pagination getCityListWithPage(CityQuery cityQuery);
	public List<City> getCityList();
	public void updateCity(City city);
	public void saveCity(City city);
	public void deleteCityById(Integer id);
}
