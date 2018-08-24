package com.xxt.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.common.page.Pagination;
import com.xxt.common.config.Config;
import com.xxt.dao.ImgMapper;
import com.xxt.dao.ProductMapper;
import com.xxt.dao.SkuMapper;
import com.xxt.entity.Img;
import com.xxt.entity.Product;
import com.xxt.entity.ProductQuery;
import com.xxt.entity.Sku;
import com.xxt.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductMapper productMapper;
	@Autowired
	ImgMapper imgMapper;
	@Autowired
	SkuMapper skuMapper;

	@Override
	public Pagination getProductListWithPage(ProductQuery productQuery) {
		return new Pagination(productQuery.getPageNo(), productQuery.getPageSize(), productMapper.getProductCount(productQuery), productMapper.getProductListWithPage(productQuery));
	}

	@Override
	public Product getProductById(Integer id) {
		return productMapper.getProductById(id);
	}

	@Override
	public List<Product> getProductList() {
		return productMapper.getProductList();
	}

	@Override
	public void updateProduct(Product product) {
		if (product.getIsNew() == null) {
			product.setIsNew(Config.NO);
		}
		if (product.getIsCommend() == null) {
			product.setIsCommend(Config.NO);
		}
		if (product.getIsHot() == null) {
			product.setIsHot(Config.NO);
		}
		productMapper.updateProduct(product);
		
		imgMapper.deleteImgByProductId(product.getId());
		Img img = new Img();
		img.setProductId(product.getId());
		img.setUrl(product.getImgUrl());
		img.setIsDef(Config.YES);
		imgMapper.saveImg(img);
		
		skuMapper.deleteSkuByProductId(product.getId());
		String[] colorarr = product.getColor().split(",");
		String[] sizearr = product.getSize().split(",");
		Sku sku = null;
		for (String color : colorarr) {
			for (String size : sizearr) {
				sku = new Sku();
				sku.setProductId(product.getId());
				sku.setColorId(Integer.parseInt(color));
				sku.setSize(size);
				sku.setSkuPrice(10.0);
				sku.setStockInventory(10);
				sku.setSkuUpperLimit(10);
				sku.setCreateTime(new Date());
				sku.setLastStatus(1);
				sku.setSkuType(1);
				sku.setSales(0);
				skuMapper.saveSku(sku);
			}
		}
	}

	@Override
	public void saveProduct(Product product) {
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String format = df.format(new Date());
		product.setNo(format);
		
		if (product.getIsNew() == null) {
			product.setIsNew(Config.NO);
		}
		if (product.getIsCommend() == null) {
			product.setIsCommend(Config.NO);
		}
		if (product.getIsHot() == null) {
			product.setIsHot(Config.NO);
		}
		
		product.setCreateTime(new Date());
		product.setIsShow(Config.NO);
		product.setIsDel(Config.YES);
		product.setSales(0);
		
		productMapper.saveProduct(product);
		
		Img img = new Img();
		img.setProductId(product.getId());
		img.setUrl(product.getImgUrl());
		img.setIsDef(Config.YES);
		imgMapper.saveImg(img);
		
		String[] colorarr = product.getColor().split(",");
		String[] sizearr = product.getSize().split(",");
		Sku sku = null;
		for (String color : colorarr) {
			for (String size : sizearr) {
				sku = new Sku();
				sku.setProductId(product.getId());
				sku.setColorId(Integer.parseInt(color));
				sku.setSize(size);
				sku.setSkuPrice(10.0);
				sku.setStockInventory(10);
				sku.setSkuUpperLimit(10);
				sku.setCreateTime(new Date());
				sku.setLastStatus(1);
				sku.setSkuType(1);
				sku.setSales(0);
				skuMapper.saveSku(sku);
			}
		}
	}
	
	@Override
	public String deleteProductById(Integer id) {
		Product product = productMapper.getProductById(id);
		if (product == null) {
			return "1";
		}
		if (product.getIsShow().equals(Config.YES)) {
			return "2";
		}
		if (product.getIsDel().equals(Config.NO)) {
			return "3";
		}
		Product p = new Product();
		p.setId(id);
		p.setIsDel(Config.NO);
		productMapper.updateProduct(p);
		return "0";
	}
	
	
	@Override
	public String getBrandimgUrlById(Integer id) {
		return productMapper.getBrandimgUrlById(id);
	}

	@Override
	public void deleteProductByIds(Integer[] ids) {
		productMapper.deleteProductByIds(ids);
	}
	
	@Override
	public String isShow(Integer ids) {
		Product product = productMapper.getProductById(ids);
		if (product == null) {
			return "1";
		}
		if (product.getIsDel().equals(Config.NO)) {
			return "2";
		}
		if (product.getIsShow().equals(Config.YES)) {
			return "3";
		}
		Product p = new Product();
		p.setId(ids);
		p.setIsShow(Config.YES);
		productMapper.updateProduct(p);
		return "0";
	}

	@Override
	public String isDown(Integer ids) {
		
		Product product = productMapper.getProductById(ids);
		if (product == null) {
			return "1";
		}
		if (product.getIsDel().equals(Config.NO)) {
			return "2";
		}
		if (product.getIsShow().equals(Config.NO)) {
			return "3";
		}
		Product p = new Product();
		p.setId(ids);
		p.setIsShow(Config.NO);
		productMapper.updateProduct(p);
		return "0";
	}
}
