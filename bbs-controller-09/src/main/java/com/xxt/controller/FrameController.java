package com.xxt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrameController {

	@RequestMapping("/index")
	public String index(){
		return "index";
	}
	@RequestMapping("/top")
	public String top(){
		return "top";
	}
	@RequestMapping("/main")
	public String main(){
		return "main";
	}
	@RequestMapping("/left")
	public String left(){
		return "left";
	}
	@RequestMapping("/right")
	public String right(){
		return "right";
	}
	@RequestMapping("/product_left")
	public String product_left(){
		return "frame/product_left";
	}
	@RequestMapping("/frame/product_main")
	public String product_main(){
		return "frame/product_main";
	}
	@RequestMapping("/order_left")
	public String order_left(){
		return "frame/order_left";
	}
	@RequestMapping("/frame/order_main")
	public String order_main(){
		return "frame/order_main";
	}
	
}
