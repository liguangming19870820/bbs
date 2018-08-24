package com.xxt.controller;

import java.io.UnsupportedEncodingException;
import java.net.HttpCookie;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xxt.common.config.Config;
import com.xxt.common.utils.CookieUtils;
import com.xxt.common.utils.JsonUtils;
import com.xxt.entity.Cart;
import com.xxt.entity.Sku;
import com.xxt.service.ProductService;
import com.xxt.service.SkuService;

@Controller
public class CartController_cookie {
	
	@Autowired
	SkuService skuService;
	@Autowired
	ProductService productService;

	@RequestMapping("/cart/add")
	public String add(Integer skuId, Integer buyCount,Model model,HttpServletRequest request,HttpServletResponse response) throws Exception {
		 String json = CookieUtils.getCookie(request, "cart");
		 List<Cart> list =null;
		 if(StringUtils.isBlank(json)){
			 Cart cart = skuService.getSkuByIdForCart(skuId);
				cart.setBuycount(buyCount);
				cart.setBuytime(new Date());
				list = new ArrayList<>();
				list.add(cart);
		 }else{
			 json = URLDecoder.decode(json, "utf-8");
			 boolean flag = false;
			 list = JsonUtils.jsonToList(json, Cart.class);
			 if(list!=null){
				 for(Cart c : list){
					 if(c.getSkuId().equals(skuId)){
						 c.setBuycount(c.getBuycount()+buyCount);
						 flag = true;
					 }
				 }
				 if(!flag){
					 Cart cart = skuService.getSkuByIdForCart(skuId);
					 cart.setBuycount(buyCount);
					 cart.setBuytime(new Date());
					 list.add(cart);
				 }
			 }
		 }
		 CookieUtils.addCookie(response, "cart", URLEncoder.encode(JsonUtils.objectToJson(list), "utf-8"), 0);
		 if(list!=null){
			 Collections.sort(list, new Comparator<Cart>() {
				 @Override
				 public int compare(Cart c1, Cart c2) {
					 return (int)(c2.getBuytime().getTime() - c1.getBuytime().getTime());
				 }
			 });
		 }
			Sku sku = skuService.getSkuById(skuId);
			
			model.addAttribute("list", list);
			model.addAttribute("productId", sku.getProductId());
			model.addAttribute("path", Config.IMAGE_URL);
			return "product/cart";
	}
	
	@ResponseBody
	@RequestMapping("/cart/delete")
	public String delete(Integer id,HttpServletRequest request,HttpServletResponse response) throws Exception {
		String json = CookieUtils.getCookie(request, "cart");
		json = URLDecoder.decode(json, "utf-8");
		List<Cart> list = JsonUtils.jsonToList(json, Cart.class);
		if(list != null){
			for(Cart cart : list){
				if(cart.getSkuId().equals(id)){
					list.remove(cart);
					break;
				}
			}
		}
		CookieUtils.addCookie(response, "cart", URLEncoder.encode(JsonUtils.objectToJson(list), "utf-8"), 0);
		return "0";
	}
	
	@ResponseBody
	@RequestMapping("/cart/little")
	public String little(Integer id,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		String json = CookieUtils.getCookie(request, "cart");
		//如果提交的时候编码了，拿的时候一定要转码
		json = URLDecoder.decode(json, "utf-8");
		List<Cart> list = JsonUtils.jsonToList(json, Cart.class);
		int count =0;
		if(list != null){
			for(Cart c : list){
				if(c.getSkuId().equals(id)){
					c.setBuycount(c.getBuycount()-1);
					count=c.getBuycount();
					break;
				}
			}
		}
		 CookieUtils.addCookie(response, "cart", URLEncoder.encode(JsonUtils.objectToJson(list), "utf-8"), 0);
		return  count + "";
	}
	
	@ResponseBody
	@RequestMapping("/cart/many")
	public String many(Integer id,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		String json = CookieUtils.getCookie(request, "cart");
		json = URLDecoder.decode(json, "utf-8");
		List<Cart> list = JsonUtils.jsonToList(json, Cart.class);
		int count =0;
		if(list != null){
			for(Cart c : list){
				if(c.getSkuId().equals(id)){
					c.setBuycount(c.getBuycount()+1);
					count=c.getBuycount();
					break;
				}
			}
		}
		 CookieUtils.addCookie(response, "cart", URLEncoder.encode(JsonUtils.objectToJson(list), "utf-8"), 0);
		return  count + "";
	}
	
	@ResponseBody
	@RequestMapping("/cart/deletes")
	public String deletes(HttpServletRequest request,HttpServletResponse response) {
			CookieUtils.deleteCookie(request, response, "cart");
		return "0";
	}
	
	
	
}