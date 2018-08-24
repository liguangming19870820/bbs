package com.xxt.dao;

import java.util.List;

import com.xxt.entity.Product;
import com.xxt.entity.ProductQuery;

public interface ProductMapper {

	public Product getProductById(Integer id);
	public List<Product> getProductListWithPage(ProductQuery productQuery);
	public List<Product> getProductList();
	public Integer getProductCount(ProductQuery productQuery);
	public void updateProduct(Product product);
	public void saveProduct(Product product);
	public void deleteProductById(Integer id);
	
	public String getBrandimgUrlById(Integer id);
	public void deleteProductByIds(Integer[] ids);
}
