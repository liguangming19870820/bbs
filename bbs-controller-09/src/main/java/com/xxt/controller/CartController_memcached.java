/*package com.xxt.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xxt.common.config.Config;
import com.xxt.common.utils.CookieUtils;
import com.xxt.common.utils.JsonUtils;
import com.xxt.common.utils.MemcachedUtils;
import com.xxt.entity.Cart;
import com.xxt.service.SkuService;

@Controller
public class CartController_memcached {
	
	@Autowired
	SkuService skuService;

	@RequestMapping("/cart/add")
	public String add(Integer skuId, Integer buyCount, HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		String uuid = CookieUtils.getCookie(request, "cart");
		List<Cart> list = null;
		
		if(StringUtils.isBlank(uuid)){
			uuid = UUID.randomUUID().toString();
			CookieUtils.addCookie(response, "cart", uuid,0);
			Cart cart = skuService.getSkuByIdForCart(skuId);
			cart.setBuycount(buyCount);
			cart.setBuytime(new Date());
			list = new ArrayList<>();
			list.add(cart);
		}else{
			String json = MemcachedUtils.get("cart_"+uuid);
			if(StringUtils.isBlank(json)){
				Cart cart = skuService.getSkuByIdForCart(skuId);
				cart.setBuycount(buyCount);
				cart.setBuytime(new Date());
				list = new ArrayList<>();
				list.add(cart);
			}else{
				list = JsonUtils.jsonToList(json, Cart.class);
				boolean flag = false;
				for (Cart c : list) {
					if (c.getSkuId().equals(skuId)) {
						c.setBuycount(c.getBuycount()+buyCount);
						flag = true;
					}
				}
				if (!flag) {
					Cart cart = skuService.getSkuByIdForCart(skuId);
					cart.setBuycount(buyCount);
					cart.setBuytime(new Date());
					list.add(cart);
				}
			}
		}
		
		MemcachedUtils.set("cart_"+uuid, JsonUtils.objectToJson(list));
		
		Collections.sort(list, new Comparator<Cart>() {
			@Override
			public int compare(Cart c1, Cart c2) {
				return (int)(c2.getBuytime().getTime() - c1.getBuytime().getTime());
			}
		});
		
		model.addAttribute("list", list);
		model.addAttribute("path", Config.IMAGE_URL);
		return "product/cart";
	}
	
	@ResponseBody
	@RequestMapping("/cart/many")
	public String many(Integer id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String uuid = CookieUtils.getCookie(request, "cart");
		String json = MemcachedUtils.get("cart_"+uuid);
		List<Cart> list = JsonUtils.jsonToList(json, Cart.class);
		int count = 0;
		for (Cart c : list) {
			if (c.getSkuId().equals(id)) {
				c.setBuycount(c.getBuycount()+1);
				count = c.getBuycount();
				break;
			}
		}
		MemcachedUtils.set("cart_"+uuid, JsonUtils.objectToJson(list));
		
		return count + "";
	}
	
	@ResponseBody
	@RequestMapping("/cart/little")
	public String little(Integer id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String uuid = CookieUtils.getCookie(request, "cart");
		String json = MemcachedUtils.get("cart_"+uuid);
		List<Cart> list = JsonUtils.jsonToList(json, Cart.class);
		int count = 0;
		for (Cart c : list) {
			if (c.getSkuId().equals(id)) {
				c.setBuycount(c.getBuycount()-1);
				count = c.getBuycount();
				break;
			}
		}
		MemcachedUtils.set("cart_"+uuid, JsonUtils.objectToJson(list));
		
		return count + "";
	}
	
	@ResponseBody
	@RequestMapping("/cart/delete")
	public String delete(Integer id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String uuid = CookieUtils.getCookie(request, "cart");
		String json = MemcachedUtils.get("cart_"+uuid);
		List<Cart> list = JsonUtils.jsonToList(json, Cart.class);
		for (Cart c : list) {
			if (c.getSkuId().equals(id)) {
				list.remove(c);
				break;
			}
		}
		MemcachedUtils.set("cart_"+uuid, JsonUtils.objectToJson(list));
		
		return "";
	}
	
	@ResponseBody
	@RequestMapping("/cart/deletes")
	public String deletes(HttpServletRequest request, HttpServletResponse response) {
		String uuid = CookieUtils.getCookie(request, "cart");
		MemcachedUtils.delete("cart_"+uuid);
		
		return "";
	}
}*/
