package com.xxt.controller;

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
import com.xxt.common.config.Config;
import com.xxt.entity.Brand;
import com.xxt.entity.Color;
import com.xxt.entity.Feature;
import com.xxt.entity.Img;
import com.xxt.entity.Product;
import com.xxt.entity.ProductQuery;
import com.xxt.entity.Sku;
import com.xxt.entity.Type;
import com.xxt.service.BrandService;
import com.xxt.service.ColorService;
import com.xxt.service.FeatureService;
import com.xxt.service.ImgService;
import com.xxt.service.ProductService;
import com.xxt.service.SkuService;
import com.xxt.service.StaticPageService;
import com.xxt.service.TypeService;

@Controller
public class ProductController {
	
	@Autowired
	ProductService productService;
	@Autowired
	BrandService brandService;
	@Autowired
	TypeService typeService;
	@Autowired
	FeatureService featureService;
	@Autowired
	ColorService colorService;
	@Autowired
	ImgService imgService;
	@Autowired
	SkuService skuService;
	@Autowired
	StaticPageService staticPageService;

	
	@RequestMapping("/product/list")
	public String list(Integer pageNo, ProductQuery productQuery, Model model,Integer brandId) {
		productQuery.setPageNo(Pagination.cpn(pageNo));

		StringBuilder sb = new StringBuilder();
		
		if(StringUtils.isNoneBlank(productQuery.getName())){
			sb.append("&name=").append(productQuery.getName());
		}
		if(productQuery.getBrandId()!=null){
			sb.append("&brandId=").append(productQuery.getBrandId());
		}
		if(productQuery.getIsShow()==null){
			productQuery.setIsShow(Config.NO);
		}
		sb.append("&isShow=").append(productQuery.getIsShow());
		
		Pagination pagination = productService.getProductListWithPage(productQuery);
		String params = sb.toString();
		if (StringUtils.isNotBlank(params) && params.startsWith("&")) {
			params = params.substring(1);
		}
		pagination.pageView("/product/list.do", params);
		
		List<Product> productList = productService.getProductList();
		
		List<Brand> brandList = brandService.getBrandList();
		List<Type> typeList = typeService.getTypeList();
		Brand brand = brandService.getBrandById(brandId);
		
		model.addAttribute("brandList",brandList);
		model.addAttribute("typeList",typeList);
		model.addAttribute("brand",brand);
		
		model.addAttribute("path",Config.IMAGE_URL);
		
		model.addAttribute("pagination", pagination);
		model.addAttribute("productQuery", productQuery);
		return "product/list";
	}
	
	@RequestMapping("/product/addinput")
	public String addinput(Model model) {
		List<Feature> featureList = featureService.getFeatureList();
		List<Color> colorList = colorService.getColorList();
		List<Brand> brandList = brandService.getBrandList();
		List<Type> typeList = typeService.getTypeList();
		
		model.addAttribute("brandList",brandList);
		model.addAttribute("typeList",typeList);
		model.addAttribute("featureList",featureList);
		model.addAttribute("colorList",colorList);
		return "product/add";
	}
	
	@RequestMapping("/app/app")
	public String app() {
		
		return "app/app";
	}

	@ResponseBody
	@RequestMapping("/product/save")
	public String save(Product product) {
		productService.saveProduct(product);
		return "0";
	}

	@RequestMapping("/product/edit")
	public String edit(Integer id, Model model) {
		Product product = productService.getProductById(id);
		
		List<Feature> featureList = featureService.getFeatureList();
		List<Color> colorList = colorService.getColorList();
		List<Brand> brandList = brandService.getBrandList();
		List<Type> typeList = typeService.getTypeList();
		Img img = imgService.getImgByProductId(id);
		
		model.addAttribute("brandList",brandList);
		model.addAttribute("typeList",typeList);
		model.addAttribute("featureList",featureList);
		model.addAttribute("colorList",colorList);
		
		
		
		model.addAttribute("product", product);
		model.addAttribute("path",Config.IMAGE_URL);
		model.addAttribute("img", img);
		return "product/edit";
	}

	@ResponseBody
	@RequestMapping("/product/update")
	public String update(Product product) {
		productService.updateProduct(product);
		return "0";
	}

	@ResponseBody
	@RequestMapping("/product/delete")
	public String delete(Integer id) {
		return productService.deleteProductById(id);
	}
	
	@RequestMapping("/product/productDetail")
	public String productDetail(Integer id) {
		return "product/productDetail";
	}
	
	/*@ResponseBody
	@RequestMapping("/product/deleteByIds")
	public String deleteByIds(Integer[] ids) {
		if(ids!=null && ids.length>0){
			for(Integer id : ids){
				productService.deleteProductById(id);
			}
		}
		return "1";
	}*/
	
	@ResponseBody
	@RequestMapping("/product/deleteByIds")
	public String deleteByIds(Integer[] ids) {
		productService.deleteProductByIds(ids);
		return "1";
	}
	
	@ResponseBody
	@RequestMapping("/product/isShow")
	public String isShow(Integer ids) {
		
		Product product = productService.getProductById(ids);
		List<Sku> skuList = skuService.getSkuListByProductId(ids);
		String[] idsstr = null;
		if (StringUtils.isNoneBlank(product.getColor())) {
			idsstr = product.getColor().split(",");
		}
		Integer[] id = null;
		if (idsstr!=null && idsstr.length>0) {
			id = new Integer[idsstr.length];
			for (int i=0; i<idsstr.length; i++) {
				id[i] = Integer.parseInt(idsstr[i]);
			}
		}
		List<Color> colorList = colorService.getColorByIds(id);
		
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("product", product);
		root.put("colorList", colorList);
		root.put("skuList", skuList);
		staticPageService.productIndex(root, product.getId());
		
		return productService.isShow(ids);
	}
	
	@ResponseBody
	@RequestMapping("/product/isDown")
	public String isDown(Integer ids) {
		return productService.isDown(ids);
	}
	
	@RequestMapping("/product/detail")
	public String detail(Integer id, Model model) {
		Product product = productService.getProductById(id);
		List<Sku> skuList = skuService.getSkuListByProductId(id);
		String[] idsstr = null;
		if (StringUtils.isNoneBlank(product.getColor())) {
			idsstr = product.getColor().split(",");
		}
		Integer[] ids = null;
		if (idsstr!=null && idsstr.length>0) {
			ids = new Integer[idsstr.length];
			for (int i=0; i<idsstr.length; i++) {
				ids[i] = Integer.parseInt(idsstr[i]);
			}
		}
		List<Color> colorList = colorService.getColorByIds(ids);
		Img img = imgService.getImgByProductId(id);
		model.addAttribute("product", product);
		model.addAttribute("skuList", skuList);
		model.addAttribute("colorList", colorList);
		model.addAttribute("img", img);
		model.addAttribute("path", Config.IMAGE_URL);
		return "product/productDetail";
	}
	
	
}
