/*package com.xxt.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xxt.common.config.Config;
import com.xxt.entity.Cart;
import com.xxt.entity.Sku;
import com.xxt.service.ProductService;
import com.xxt.service.SkuService;

@Controller
public class CartController_session {
	
	@Autowired
	SkuService skuService;
	@Autowired
	ProductService productService;

	@RequestMapping("/cart/add")
	public String add(Integer skuId, Integer buyCount,Model model,HttpSession session) {
		 Map<Integer,Cart> cartMap = (Map<Integer,Cart>)session.getAttribute("cart");
		 if(cartMap == null){
			 cartMap = new HashMap<>();
			 session.setAttribute("cart", cartMap);
		 }
		 Cart c = cartMap.get(skuId);
		 if(c == null){
			 Cart cart = skuService.getSkuByIdForCart(skuId);
				cart.setBuycount(buyCount);
				cart.setBuytime(new Date());
				cartMap.put(skuId, cart);
		 }else{
			 c.setBuycount(c.getBuycount()+buyCount);
		 }
		 
		 List<Cart> list = new ArrayList<>(cartMap.values());
			Collections.sort(list, new Comparator<Cart>() {
				@Override
				public int compare(Cart c1, Cart c2) {
					return (int)(c2.getBuytime().getTime() - c1.getBuytime().getTime());
				}
			});
			Sku sku = skuService.getSkuById(skuId);
			
			model.addAttribute("list", list);
			model.addAttribute("productId", sku.getProductId());
			model.addAttribute("path", Config.IMAGE_URL);
			return "product/cart";
	}
	
	@ResponseBody
	@RequestMapping("/cart/delete")
	public String delete(Integer id,HttpSession session) {
		Map<Integer,Cart> cartMap = (Map<Integer,Cart>)session.getAttribute("cart");
		if(cartMap.get(id) != null){
			cartMap.remove(id);
		}
		return "0";
	}
	
	@ResponseBody
	@RequestMapping("/cart/little")
	public String little(Integer id,HttpSession session) {
		Map<Integer,Cart> cartMap = (Map<Integer,Cart>)session.getAttribute("cart");
			Cart c = cartMap.get(id);
			c.setBuycount(c.getBuycount()-1);
			cartMap.put(id, c);
		return  c.getBuycount() + "";
	}
	
	@ResponseBody
	@RequestMapping("/cart/many")
	public String many(Integer id,HttpSession session) {
		Map<Integer,Cart> cartMap = (Map<Integer,Cart>)session.getAttribute("cart");
			Cart c = cartMap.get(id);
			c.setBuycount(c.getBuycount()+1);
			cartMap.put(id, c);
			return c.getBuycount() + "";
	}
	
	@ResponseBody
	@RequestMapping("/cart/deletes")
	public String deletes(HttpSession session) {
			session.removeAttribute("cart");
		return "0";
	}
	
	
	
}
*/