package com.xxt.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.page.Pagination;
import com.xxt.entity.Feature;
import com.xxt.entity.FeatureQuery;
import com.xxt.service.FeatureService;

@Controller
public class FeatureController {

	@Autowired
	FeatureService featureService;

	@RequestMapping("/feature/list")
	public String list(Integer pageNo, FeatureQuery featureQuery, Model model) {
		featureQuery.setPageNo(Pagination.cpn(pageNo));

		StringBuilder sb = new StringBuilder();
		Pagination pagination = featureService.getFeatureListWithPage(featureQuery);
		String params = sb.toString();
		if (StringUtils.isNotBlank(params) && params.startsWith("&")) {
			params = params.substring(1);
		}
		pagination.pageView("/feature/list.do", params);

		model.addAttribute("pagination", pagination);
		return "feature/list";
	}

	@RequestMapping("/feature/addinput")
	public String addinput() {
		return "feature/add";
	}

	@RequestMapping("/feature/save")
	public String save(Feature feature) {
		featureService.saveFeature(feature);
		return "redirect:/feature/list.do";
	}

	@RequestMapping("/feature/edit")
	public String edit(Integer id, Model model) {
		Feature feature = featureService.getFeatureById(id);
		model.addAttribute("feature", feature);
		return "feature/edit";
	}

	@RequestMapping("/feature/update")
	public String update(Feature feature) {
		featureService.updateFeature(feature);
		return "redirect:/feature/list.do";
	}

	@RequestMapping("/feature/delete")
	public String delete(Integer id) {
		featureService.deleteFeatureById(id);
		return "redirect:/feature/list.do";
	}
}
