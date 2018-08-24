package com.xxt.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.common.page.Pagination;
import com.xxt.dao.ProvinceMapper;
import com.xxt.entity.Province;
import com.xxt.entity.ProvinceQuery;
import com.xxt.service.ProvinceService;

@Service
public class ProvinceServiceImpl implements ProvinceService {

	@Autowired
	ProvinceMapper provinceMapper;

	@Override
	public Pagination getProvinceListWithPage(ProvinceQuery provinceQuery) {
		return new Pagination(provinceQuery.getPageNo(), provinceQuery.getPageSize(), provinceMapper.getProvinceCount(provinceQuery), provinceMapper.getProvinceListWithPage(provinceQuery));
	}

	@Override
	public Province getProvinceById(Integer id) {
		return provinceMapper.getProvinceById(id);
	}

	@Override
	public List<Province> getProvinceList() {
		return provinceMapper.getProvinceList();
	}

	@Override
	public void updateProvince(Province province) {
		provinceMapper.updateProvince(province);
	}

	@Override
	public void saveProvince(Province province) {
		provinceMapper.saveProvince(province);
	}

	@Override
	public void deleteProvinceById(Integer id) {
		provinceMapper.deleteProvinceById(id);
	}
}
