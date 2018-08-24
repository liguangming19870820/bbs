package com.xxt.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.common.page.Pagination;
import com.xxt.dao.CityMapper;
import com.xxt.entity.City;
import com.xxt.entity.CityQuery;
import com.xxt.service.CityService;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	CityMapper cityMapper;

	@Override
	public Pagination getCityListWithPage(CityQuery cityQuery) {
		return new Pagination(cityQuery.getPageNo(), cityQuery.getPageSize(), cityMapper.getCityCount(cityQuery), cityMapper.getCityListWithPage(cityQuery));
	}

	@Override
	public City getCityById(Integer id) {
		return cityMapper.getCityById(id);
	}

	@Override
	public List<City> getCityList() {
		return cityMapper.getCityList();
	}

	@Override
	public void updateCity(City city) {
		cityMapper.updateCity(city);
	}

	@Override
	public void saveCity(City city) {
		cityMapper.saveCity(city);
	}

	@Override
	public void deleteCityById(Integer id) {
		cityMapper.deleteCityById(id);
	}
}
