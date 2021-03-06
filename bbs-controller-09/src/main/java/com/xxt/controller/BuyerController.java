package com.xxt.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.page.Pagination;
import com.xxt.entity.Buyer;
import com.xxt.entity.BuyerQuery;
import com.xxt.service.BuyerService;

@Controller
public class BuyerController {

	@Autowired
	BuyerService buyerService;

	@RequestMapping("/buyer/list")
	public String list(Integer pageNo, BuyerQuery buyerQuery, Model model) {
		buyerQuery.setPageNo(Pagination.cpn(pageNo));

		StringBuilder sb = new StringBuilder();
		Pagination pagination = buyerService.getBuyerListWithPage(buyerQuery);
		String params = sb.toString();
		if (StringUtils.isNotBlank(params) && params.startsWith("&")) {
			params = params.substring(1);
		}
		pagination.pageView("/buyer/list", params);

		model.addAttribute("pagination", pagination);
		return "buyer/list";
	}

	@RequestMapping("/buyer/addinput")
	public String addinput() {
		return "buyer/add";
	}

	@RequestMapping("/buyer/save")
	public String save(Buyer buyer) {
		buyerService.saveBuyer(buyer);
		return "redirect:/buyer/list.do";
	}

	@RequestMapping("/buyer/edit")
	public String edit(String username, Model model) {
		Buyer buyer = buyerService.getBuyerById(username);
		model.addAttribute("buyer", buyer);
		return "buyer/edit";
	}

	@RequestMapping("/buyer/update")
	public String update(Buyer buyer) {
		buyerService.updateBuyer(buyer);
		return "redirect:/buyer/list.do";
	}

	@RequestMapping("/buyer/delete")
	public String delete(String username) {
		buyerService.deleteBuyerById(username);
		return "redirect:/buyer/list.do";
	}
}
