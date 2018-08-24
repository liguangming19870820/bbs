package com.xxt.dao;

import java.util.List;
import com.xxt.entity.Detail;
import com.xxt.entity.DetailQuery;

public interface DetailMapper {

	public Detail getDetailById(Integer id);
	public List<Detail> getDetailListWithPage(DetailQuery detailQuery);
	public List<Detail> getDetailList();
	public Integer getDetailCount(DetailQuery detailQuery);
	public void updateDetail(Detail detail);
	public void saveDetail(Detail detail);
	public void deleteDetailById(Integer id);
}
