package com.xxt.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.page.Pagination;
import com.xxt.entity.Province;
import com.xxt.entity.ProvinceQuery;
import com.xxt.service.ProvinceService;

@Controller
public class ProvinceController {

	@Autowired
	ProvinceService provinceService;

	@RequestMapping("/province/list")
	public String list(Integer pageNo, ProvinceQuery provinceQuery, Model model) {
		provinceQuery.setPageNo(Pagination.cpn(pageNo));

		StringBuilder sb = new StringBuilder();
		Pagination pagination = provinceService.getProvinceListWithPage(provinceQuery);
		String params = sb.toString();
		if (StringUtils.isNotBlank(params) && params.startsWith("&")) {
			params = params.substring(1);
		}
		pagination.pageView("/province/list", params);

		model.addAttribute("pagination", pagination);
		return "province/list";
	}

	@RequestMapping("/province/addinput")
	public String addinput() {
		return "province/add";
	}

	@RequestMapping("/province/save")
	public String save(Province province) {
		provinceService.saveProvince(province);
		return "redirect:/province/list.do";
	}

	@RequestMapping("/province/edit")
	public String edit(Integer id, Model model) {
		Province province = provinceService.getProvinceById(id);
		model.addAttribute("province", province);
		return "province/edit";
	}

	@RequestMapping("/province/update")
	public String update(Province province) {
		provinceService.updateProvince(province);
		return "redirect:/province/list.do";
	}

	@RequestMapping("/province/delete")
	public String delete(Integer id) {
		provinceService.deleteProvinceById(id);
		return "redirect:/province/list.do";
	}
}
