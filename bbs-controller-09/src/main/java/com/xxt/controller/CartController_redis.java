/*package com.xxt.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
import com.xxt.common.result.JedisUtils;
import com.xxt.entity.Cart;
import com.xxt.service.SkuService;

@Controller
public class CartController_redis {
	
	@Autowired
	SkuService skuService;

	@RequestMapping("/cart/add")
	public String add(Integer skuId, Integer buyCount, HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		String uuid = CookieUtils.getCookie(request, "cart");
		if (StringUtils.isBlank(uuid)) {
			uuid = UUID.randomUUID().toString();
			CookieUtils.addCookie(response, "cart", uuid, 0);
		}
		//查看uuid（key）中是否存在skuid（Field）
		if (!JedisUtils.hexists("cart:hash:"+uuid, skuId+"")) {
			JedisUtils.zadd("cart:zset:"+uuid, skuId+"", new Double(new Date().getTime()));
		}
		//增加指定Key中指定Field关联的Value的值
		JedisUtils.hincrBy("cart:hash:"+uuid, skuId+"", buyCount);
		
		List<Cart> list = new ArrayList<>();
		//降序排序
		Set<String> cartset = JedisUtils.zrevrange("cart:zset:"+uuid);
		Map<String, String> cartmap = JedisUtils.hgetAll("cart:hash:"+uuid);
		if(cartset !=null){
			for (String sId : cartset) {
				Cart cart = skuService.getSkuByIdForCart(Integer.parseInt(sId));
				cart.setBuycount(Integer.parseInt(cartmap.get(sId)));
				list.add(cart);
			}
		}
		
		model.addAttribute("list", list);
		model.addAttribute("path", Config.IMAGE_URL);
		return "product/cart";
	}
	
	@ResponseBody
	@RequestMapping("/cart/many")
	public String many(Integer skuId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String uuid = CookieUtils.getCookie(request, "cart");
		Long count = JedisUtils.hincrBy("cart:hash:"+uuid, skuId+"", 1);
		
		return count + "";
	}
	
	@ResponseBody
	@RequestMapping("/cart/little")
	public String little(Integer skuId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String uuid = CookieUtils.getCookie(request, "cart");
		Long count = JedisUtils.hincrBy("cart:hash:"+uuid, skuId+"", -1);
		
		return count + "";
	}
	
	@ResponseBody
	@RequestMapping("/cart/delete")
	public String delete(Integer skuId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String uuid = CookieUtils.getCookie(request, "cart");
		JedisUtils.hdel("cart:hash:"+uuid, skuId+"");
		
		return "";
	}
	
	@ResponseBody
	@RequestMapping("/cart/deletes")
	public String deletes(Integer skuId, HttpServletRequest request, HttpServletResponse response) {
		String uuid = CookieUtils.getCookie(request, "cart");
		JedisUtils.del("cart:zset:"+uuid);
		JedisUtils.del("cart:hash:"+uuid);
		
		return "";
	}
}
*/