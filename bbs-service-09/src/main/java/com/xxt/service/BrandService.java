package com.xxt.service;

import java.util.List;
import com.common.page.Pagination;
import com.xxt.entity.Brand;
import com.xxt.entity.BrandQuery;

public interface BrandService {

	public Brand getBrandById(Integer id);
	public Pagination getBrandListWithPage(BrandQuery brandQuery);
	public List<Brand> getBrandList();
	public void updateBrand(Brand brand);
	public void saveBrand(Brand brand);
	public void deleteBrandById(Integer id);
	public Brand getBrandByName(String name);
}
