package com.xxt.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.common.page.Pagination;
import com.xxt.entity.Color;
import com.xxt.entity.Product;
import com.xxt.entity.Sku;
import com.xxt.entity.SkuQuery;
import com.xxt.service.ColorService;
import com.xxt.service.ProductService;
import com.xxt.service.SkuService;

@Controller
public class SkuController {

	@Autowired
	SkuService skuService;
	@Autowired
	ProductService productService;
	@Autowired
	ColorService colorService;

	//此注解表示类中的响应请求的方法都是以该地址作为父路径。
	@RequestMapping("/sku/list")
	public String list(Integer pageNo, SkuQuery skuQuery, Model model,Integer id) {
		skuQuery.setPageNo(Pagination.cpn(pageNo));

		StringBuilder sb = new StringBuilder();
		if(id!=null){
			sb.append("&productId=").append(id);
		}
		Pagination pagination = skuService.getSkuListWithPage(skuQuery);
		String params = sb.toString();
		
		if (StringUtils.isNotBlank(params) && params.startsWith("&")) {
			params = params.substring(1);
		}
		pagination.pageView("/sku/list.do", params);
		
		Product product = productService.getProductById(id);
		
		List<Sku> skuList = skuService.getSkuList();
		List<Sku> skuLists = new ArrayList<>();
		Map<Integer,Color> colorMap = new HashMap<>();
		for(Sku s : skuList){
			if(s.getProductId().equals(id)){
				skuLists.add(s);
				colorMap.put(s.getColorId(), colorService.getColorById(s.getColorId()));
				
			}
		}
		
		model.addAttribute("skuLists", skuLists);
		model.addAttribute("product", product);
		model.addAttribute("colorMap", colorMap);
		return "sku/list";
	}

	@RequestMapping("/sku/addinput")
	public String addinput() {
		return "sku/add";
	}

	@RequestMapping("/sku/save")
	public String save(Sku sku) {
		skuService.saveSku(sku);
		return "redirect:/sku/list.do";
	}

	@RequestMapping("/sku/edit")
	public String edit(Integer id, Model model) {
		Sku sku = skuService.getSkuById(id);
		model.addAttribute("sku", sku);
		return "sku/edit";
	}

	@ResponseBody
	@RequestMapping("/sku/update")
	//如果前台有很多个参数传入,并且这些参数都是一个对象的,那么直接在方法中声明这个对象,SpringMvc就自动会把属性赋值到这个对象里面
	public String update(Sku sku) {
		skuService.updateSku(sku);
		return "0";
	}

	@RequestMapping("/sku/delete")
	public String delete(Integer id) {
		skuService.deleteSkuById(id);
		return "redirect:/sku/list.do";
	}
}
