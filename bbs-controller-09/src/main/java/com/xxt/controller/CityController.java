package com.xxt.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.page.Pagination;
import com.xxt.entity.City;
import com.xxt.entity.CityQuery;
import com.xxt.service.CityService;

@Controller
public class CityController {

	@Autowired
	CityService cityService;

	@RequestMapping("/city/list")
	public String list(Integer pageNo, CityQuery cityQuery, Model model) {
		cityQuery.setPageNo(Pagination.cpn(pageNo));

		StringBuilder sb = new StringBuilder();
		Pagination pagination = cityService.getCityListWithPage(cityQuery);
		String params = sb.toString();
		if (StringUtils.isNotBlank(params) && params.startsWith("&")) {
			params = params.substring(1);
		}
		pagination.pageView("/city/list", params);

		model.addAttribute("pagination", pagination);
		return "city/list";
	}

	@RequestMapping("/city/addinput")
	public String addinput() {
		return "city/add";
	}

	@RequestMapping("/city/save")
	public String save(City city) {
		cityService.saveCity(city);
		return "redirect:/city/list.do";
	}

	@RequestMapping("/city/edit")
	public String edit(Integer id, Model model) {
		City city = cityService.getCityById(id);
		model.addAttribute("city", city);
		return "city/edit";
	}

	@RequestMapping("/city/update")
	public String update(City city) {
		cityService.updateCity(city);
		return "redirect:/city/list.do";
	}

	@RequestMapping("/city/delete")
	public String delete(Integer id) {
		cityService.deleteCityById(id);
		return "redirect:/city/list.do";
	}
}
