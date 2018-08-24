package com.xxt.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.page.Pagination;
import com.xxt.entity.Img;
import com.xxt.entity.ImgQuery;
import com.xxt.service.ImgService;

@Controller
public class ImgController {

	@Autowired
	ImgService imgService;

	@RequestMapping("/img/list")
	public String list(Integer pageNo, ImgQuery imgQuery, Model model) {
		imgQuery.setPageNo(Pagination.cpn(pageNo));

		StringBuilder sb = new StringBuilder();
		Pagination pagination = imgService.getImgListWithPage(imgQuery);
		String params = sb.toString();
		if (StringUtils.isNotBlank(params) && params.startsWith("&")) {
			params = params.substring(1);
		}
		pagination.pageView("/img/list", params);

		model.addAttribute("pagination", pagination);
		return "img/list";
	}

	@RequestMapping("/img/addinput")
	public String addinput() {
		return "img/add";
	}

	@RequestMapping("/img/save")
	public String save(Img img) {
		imgService.saveImg(img);
		return "redirect:/img/list.do";
	}

	@RequestMapping("/img/edit")
	public String edit(Integer id, Model model) {
		Img img = imgService.getImgById(id);
		model.addAttribute("img", img);
		return "img/edit";
	}

	@RequestMapping("/img/update")
	public String update(Img img) {
		imgService.updateImg(img);
		return "redirect:/img/list.do";
	}

	@RequestMapping("/img/delete")
	public String delete(Integer id) {
		imgService.deleteImgById(id);
		return "redirect:/img/list.do";
	}
}
