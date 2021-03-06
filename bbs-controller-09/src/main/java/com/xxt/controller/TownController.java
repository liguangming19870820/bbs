package com.xxt.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.page.Pagination;
import com.xxt.entity.Town;
import com.xxt.entity.TownQuery;
import com.xxt.service.TownService;

@Controller
public class TownController {

	@Autowired
	TownService townService;

	@RequestMapping("/town/list")
	public String list(Integer pageNo, TownQuery townQuery, Model model) {
		townQuery.setPageNo(Pagination.cpn(pageNo));

		StringBuilder sb = new StringBuilder();
		Pagination pagination = townService.getTownListWithPage(townQuery);
		String params = sb.toString();
		if (StringUtils.isNotBlank(params) && params.startsWith("&")) {
			params = params.substring(1);
		}
		pagination.pageView("/town/list", params);

		model.addAttribute("pagination", pagination);
		return "town/list";
	}

	@RequestMapping("/town/addinput")
	public String addinput() {
		return "town/add";
	}

	@RequestMapping("/town/save")
	public String save(Town town) {
		townService.saveTown(town);
		return "redirect:/town/list.do";
	}

	@RequestMapping("/town/edit")
	public String edit(Integer id, Model model) {
		Town town = townService.getTownById(id);
		model.addAttribute("town", town);
		return "town/edit";
	}

	@RequestMapping("/town/update")
	public String update(Town town) {
		townService.updateTown(town);
		return "redirect:/town/list.do";
	}

	@RequestMapping("/town/delete")
	public String delete(Integer id) {
		townService.deleteTownById(id);
		return "redirect:/town/list.do";
	}
}
