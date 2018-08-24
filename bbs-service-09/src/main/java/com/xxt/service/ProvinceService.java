package com.xxt.service;

import java.util.List;
import com.common.page.Pagination;
import com.xxt.entity.Province;
import com.xxt.entity.ProvinceQuery;

public interface ProvinceService {

	public Province getProvinceById(Integer id);
	public Pagination getProvinceListWithPage(ProvinceQuery provinceQuery);
	public List<Province> getProvinceList();
	public void updateProvince(Province province);
	public void saveProvince(Province province);
	public void deleteProvinceById(Integer id);
}
