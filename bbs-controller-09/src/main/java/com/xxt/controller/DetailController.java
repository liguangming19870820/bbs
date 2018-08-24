package com.xxt.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.page.Pagination;
import com.xxt.entity.Detail;
import com.xxt.entity.DetailQuery;
import com.xxt.service.DetailService;

@Controller
public class DetailController {

	@Autowired
	DetailService detailService;

	@RequestMapping("/detail/list")
	public String list(Integer pageNo, DetailQuery detailQuery, Model model) {
		detailQuery.setPageNo(Pagination.cpn(pageNo));

		StringBuilder sb = new StringBuilder();
		Pagination pagination = detailService.getDetailListWithPage(detailQuery);
		String params = sb.toString();
		if (StringUtils.isNotBlank(params) && params.startsWith("&")) {
			params = params.substring(1);
		}
		pagination.pageView("/detail/list", params);

		model.addAttribute("pagination", pagination);
		return "detail/list";
	}

	@RequestMapping("/detail/addinput")
	public String addinput() {
		return "detail/add";
	}

	@RequestMapping("/detail/save")
	public String save(Detail detail) {
		detailService.saveDetail(detail);
		return "redirect:/detail/list.do";
	}

	@RequestMapping("/detail/edit")
	public String edit(Integer id, Model model) {
		Detail detail = detailService.getDetailById(id);
		model.addAttribute("detail", detail);
		return "detail/edit";
	}

	@RequestMapping("/detail/update")
	public String update(Detail detail) {
		detailService.updateDetail(detail);
		return "redirect:/detail/list.do";
	}

	@RequestMapping("/detail/delete")
	public String delete(Integer id) {
		detailService.deleteDetailById(id);
		return "redirect:/detail/list.do";
	}
}
