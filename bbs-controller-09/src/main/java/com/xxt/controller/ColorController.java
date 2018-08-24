package com.xxt.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.page.Pagination;
import com.xxt.entity.Color;
import com.xxt.entity.ColorQuery;
import com.xxt.service.ColorService;

@Controller
public class ColorController {

	@Autowired
	ColorService colorService;

	@RequestMapping("/color/list")
	public String list(Integer pageNo, ColorQuery colorQuery, Model model) {
		colorQuery.setPageNo(Pagination.cpn(pageNo));

		StringBuilder sb = new StringBuilder();
		Pagination pagination = colorService.getColorListWithPage(colorQuery);
		String params = sb.toString();
		if (StringUtils.isNotBlank(params) && params.startsWith("&")) {
			params = params.substring(1);
		}
		pagination.pageView("/color/list", params);

		model.addAttribute("pagination", pagination);
		return "color/list";
	}

	@RequestMapping("/color/addinput")
	public String addinput() {
		return "color/add";
	}

	@RequestMapping("/color/save")
	public String save(Color color) {
		colorService.saveColor(color);
		return "redirect:/color/list.do";
	}

	@RequestMapping("/color/edit")
	public String edit(Integer id, Model model) {
		Color color = colorService.getColorById(id);
		model.addAttribute("color", color);
		return "color/edit";
	}

	@RequestMapping("/color/update")
	public String update(Color color) {
		colorService.updateColor(color);
		return "redirect:/color/list.do";
	}

	@RequestMapping("/color/delete")
	public String delete(Integer id) {
		colorService.deleteColorById(id);
		return "redirect:/color/list.do";
	}
}
