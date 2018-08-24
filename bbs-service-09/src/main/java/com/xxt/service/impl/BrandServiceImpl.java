package com.xxt.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.common.page.Pagination;
import com.xxt.dao.BrandMapper;
import com.xxt.entity.Brand;
import com.xxt.entity.BrandQuery;
import com.xxt.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	BrandMapper brandMapper;

	@Override
	public Pagination getBrandListWithPage(BrandQuery brandQuery) {
		return new Pagination(brandQuery.getPageNo(), brandQuery.getPageSize(), brandMapper.getBrandCount(brandQuery), brandMapper.getBrandListWithPage(brandQuery));
	}

	@Override
	public Brand getBrandById(Integer id) {
		return brandMapper.getBrandById(id);
	}

	@Override
	public List<Brand> getBrandList() {
		return brandMapper.getBrandList();
	}

	@Override
	public void updateBrand(Brand brand) {
		brandMapper.updateBrand(brand);
	}

	@Override
	public void saveBrand(Brand brand) {
		if(brand != null){
			
			brandMapper.saveBrand(brand);
		}
	}

	@Override
	public void deleteBrandById(Integer id) {
		brandMapper.deleteBrandById(id);
	}

	@Override
	public Brand getBrandByName(String name) {
		return brandMapper.getBrandByName(name);
	}
}
