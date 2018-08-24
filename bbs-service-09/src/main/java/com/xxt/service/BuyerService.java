package com.xxt.service;

import java.util.List;
import com.common.page.Pagination;
import com.xxt.entity.Buyer;
import com.xxt.entity.BuyerQuery;

public interface BuyerService {

	public Buyer getBuyerById(String username);
	public Pagination getBuyerListWithPage(BuyerQuery buyerQuery);
	public List<Buyer> getBuyerList();
	public void updateBuyer(Buyer buyer);
	public void saveBuyer(Buyer buyer);
	public void deleteBuyerById(String username);
}
