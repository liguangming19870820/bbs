package com.xxt.service;

import java.util.List;
import com.common.page.Pagination;
import com.xxt.entity.Product;
import com.xxt.entity.ProductQuery;

public interface ProductService {

	public Product getProductById(Integer id);
	public Pagination getProductListWithPage(ProductQuery productQuery);
	public List<Product> getProductList();
	public void updateProduct(Product product);
	public void saveProduct(Product product);
	public String deleteProductById(Integer id);
	
	public String getBrandimgUrlById(Integer id);
	public void deleteProductByIds(Integer[] ids);
	public String isDown(Integer ids);
	public String isShow(Integer ids);
}
