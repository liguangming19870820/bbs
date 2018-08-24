package com.xxt.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.page.Pagination;
import com.xxt.entity.Order;
import com.xxt.entity.OrderQuery;
import com.xxt.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	OrderService orderService;

	@RequestMapping("/order/list")
	public String list(Integer pageNo, OrderQuery orderQuery, Model model) {
		orderQuery.setPageNo(Pagination.cpn(pageNo));

		StringBuilder sb = new StringBuilder();
		Pagination pagination = orderService.getOrderListWithPage(orderQuery);
		String params = sb.toString();
		if (StringUtils.isNotBlank(params) && params.startsWith("&")) {
			params = params.substring(1);
		}
		pagination.pageView("/order/list.do", params);

		model.addAttribute("pagination", pagination);
		return "order/list";
	}

	@RequestMapping("/order/addinput")
	public String addinput() {
		return "order/add";
	}

	@RequestMapping("/order/save")
	public String save(Order order) {
		orderService.saveOrder(order);
		return "redirect:/order/list.do";
	}

	@RequestMapping("/order/edit")
	public String edit(Integer id, Model model) {
		Order order = orderService.getOrderById(id);
		model.addAttribute("order", order);
		return "order/edit";
	}

	@RequestMapping("/order/update")
	public String update(Order order) {
		orderService.updateOrder(order);
		return "redirect:/order/list.do";
	}

	@RequestMapping("/order/delete")
	public String delete(Integer id) {
		orderService.deleteOrderById(id);
		return "redirect:/order/list.do";
	}
}
