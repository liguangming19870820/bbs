package com.xxt.dao;

import java.util.List;

import com.xxt.entity.Cart;
import com.xxt.entity.Sku;
import com.xxt.entity.SkuQuery;

public interface SkuMapper {

	public Sku getSkuById(Integer id);
	public List<Sku> getSkuListWithPage(SkuQuery skuQuery);
	public List<Sku> getSkuList();
	public List<Sku> getSkuListById(Integer id);
	public Cart getSkuByIdForCart(Integer id);
	public Integer getSkuCount(SkuQuery skuQuery);
	public void updateSku(Sku sku);
	public void saveSku(Sku sku);
	public void deleteSkuById(Integer id);
	public void deleteSkuByProductId(Integer productId);
	
	public Sku getSkuByProductId(Integer productId);
	public List<Sku> getSkuListByProductId(Integer id);
}
