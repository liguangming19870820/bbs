package com.xxt.dao;

import java.util.List;
import com.xxt.entity.Town;
import com.xxt.entity.TownQuery;

public interface TownMapper {

	public Town getTownById(Integer id);
	public List<Town> getTownListWithPage(TownQuery townQuery);
	public List<Town> getTownList();
	public Integer getTownCount(TownQuery townQuery);
	public void updateTown(Town town);
	public void saveTown(Town town);
	public void deleteTownById(Integer id);
}
