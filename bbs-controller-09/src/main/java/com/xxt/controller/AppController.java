package com.xxt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xxt.entity.SkuQuery;

@Controller
public class AppController {

	@RequestMapping("/app/list")
	public String list(Integer pageNo, SkuQuery skuQuery, Model model,Integer id) {
		return "app";
	}
}
