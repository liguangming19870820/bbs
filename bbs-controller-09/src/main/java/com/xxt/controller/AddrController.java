package com.xxt.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.page.Pagination;
import com.xxt.entity.Addr;
import com.xxt.entity.AddrQuery;
import com.xxt.service.AddrService;

@Controller
public class AddrController {

	@Autowired
	AddrService addrService;

	@RequestMapping("/addr/list")
	public String list(Integer pageNo, AddrQuery addrQuery, Model model) {
		addrQuery.setPageNo(Pagination.cpn(pageNo));

		StringBuilder sb = new StringBuilder();
		Pagination pagination = addrService.getAddrListWithPage(addrQuery);
		String params = sb.toString();
		if (StringUtils.isNotBlank(params) && params.startsWith("&")) {
			params = params.substring(1);
		}
		pagination.pageView("/addr/list", params);

		model.addAttribute("pagination", pagination);
		return "addr/list";
	}

	@RequestMapping("/addr/addinput")
	public String addinput() {
		return "addr/add";
	}

	@RequestMapping("/addr/save")
	public String save(Addr addr) {
		addrService.saveAddr(addr);
		return "redirect:/addr/list.do";
	}

	@RequestMapping("/addr/edit")
	public String edit(Integer id, Model model) {
		Addr addr = addrService.getAddrById(id);
		model.addAttribute("addr", addr);
		return "addr/edit";
	}

	@RequestMapping("/addr/update")
	public String update(Addr addr) {
		addrService.updateAddr(addr);
		return "redirect:/addr/list.do";
	}

	@RequestMapping("/addr/delete")
	public String delete(Integer id) {
		addrService.deleteAddrById(id);
		return "redirect:/addr/list.do";
	}
}
