package com.xxt.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.common.page.Pagination;
import com.xxt.dao.TownMapper;
import com.xxt.entity.Town;
import com.xxt.entity.TownQuery;
import com.xxt.service.TownService;

@Service
public class TownServiceImpl implements TownService {

	@Autowired
	TownMapper townMapper;

	@Override
	public Pagination getTownListWithPage(TownQuery townQuery) {
		return new Pagination(townQuery.getPageNo(), townQuery.getPageSize(), townMapper.getTownCount(townQuery), townMapper.getTownListWithPage(townQuery));
	}

	@Override
	public Town getTownById(Integer id) {
		return townMapper.getTownById(id);
	}

	@Override
	public List<Town> getTownList() {
		return townMapper.getTownList();
	}

	@Override
	public void updateTown(Town town) {
		townMapper.updateTown(town);
	}

	@Override
	public void saveTown(Town town) {
		townMapper.saveTown(town);
	}

	@Override
	public void deleteTownById(Integer id) {
		townMapper.deleteTownById(id);
	}
}
