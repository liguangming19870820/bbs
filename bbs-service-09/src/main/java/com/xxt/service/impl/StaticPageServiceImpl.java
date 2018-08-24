package com.xxt.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.stereotype.Service;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.xxt.common.config.Config;
import com.xxt.service.StaticPageService;

import freemarker.template.Configuration;
import freemarker.template.Template;

@Service
public class StaticPageServiceImpl implements StaticPageService, ServletContextAware {

	private Configuration conf;

	public void setFreeMarkerConfigurer(FreeMarkerConfigurer freeMarkerConfigurer) {
		this.conf = freeMarkerConfigurer.getConfiguration();
	}

	// 静态化方法
	public void productIndex(Map<String, Object> root, Integer id) {
		// String dir = "C:\Users\lx\workspace\babasport12\";
		// 设置模板的目录
		// conf.setDirectoryForTemplateLoading(dir);

		// 输出流 从内存写出去 磁盘上
		Writer out = null;
		File f = null;
		try {
			// 读进来 UTF-8 内存中
			Template template = conf.getTemplate("productDetail.html");
			// 获取Html的路径
			String path = getPath("/html/product/" + id + ".html");// 278.html

			f = new File(path);
			File parentFile = f.getParentFile();
			if (!parentFile.exists()) {
				parentFile.mkdirs();
			}
			// 输出流
			out = new OutputStreamWriter(new FileOutputStream(f), "UTF-8");
			// 处理模板
			template.process(root, out);
			
			//实例化一个Jersey
			Client client = new Client();
			path = "upload/product/" + id + ".html";
			//另一台服务器的请求路径是?
			String url = Config.IMAGE_URL  + path;
			//设置请求路径
			WebResource resource = client.resource(url);
			try {
				resource.delete();
			} catch (Exception e) {}
			resource.put(File.class, f);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (f != null) {
				f.delete();
			}
		}
	}

	// 获取路径
	public String getPath(String name) {
		return servletContext.getRealPath(name);
	}

	private ServletContext servletContext;

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
}
