package com.xxt.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.common.page.Pagination;
import com.xxt.dao.BuyerMapper;
import com.xxt.entity.Buyer;
import com.xxt.entity.BuyerQuery;
import com.xxt.service.BuyerService;

@Service
public class BuyerServiceImpl implements BuyerService {

	@Autowired
	BuyerMapper buyerMapper;

	@Override
	public Pagination getBuyerListWithPage(BuyerQuery buyerQuery) {
		return new Pagination(buyerQuery.getPageNo(), buyerQuery.getPageSize(), buyerMapper.getBuyerCount(buyerQuery), buyerMapper.getBuyerListWithPage(buyerQuery));
	}

	@Override
	public Buyer getBuyerById(String username) {
		return buyerMapper.getBuyerById(username);
	}

	@Override
	public List<Buyer> getBuyerList() {
		return buyerMapper.getBuyerList();
	}

	@Override
	public void updateBuyer(Buyer buyer) {
		buyerMapper.updateBuyer(buyer);
	}

	@Override
	public void saveBuyer(Buyer buyer) {
		buyerMapper.saveBuyer(buyer);
	}

	@Override
	public void deleteBuyerById(String username) {
		buyerMapper.deleteBuyerById(username);
	}
}
