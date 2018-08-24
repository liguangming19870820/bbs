package com.xxt.service;

import java.util.List;
import com.common.page.Pagination;
import com.xxt.entity.Cart;
import com.xxt.entity.Product;
import com.xxt.entity.Sku;
import com.xxt.entity.SkuQuery;

public interface SkuService {

	public Sku getSkuById(Integer id);
	public Cart getSkuByIdForCart(Integer id);
	public Pagination getSkuListWithPage(SkuQuery skuQuery);
	public List<Sku> getSkuList();
	public void updateSku(Sku sku);
	public void saveSku(Sku sku);
	public void deleteSkuById(Integer id);
	public Sku getSkuByProductId(Integer id);
	public List<Sku> getSkuListByProductId(Integer id);
	public List<Sku> getSkuListById(Integer id);
}
