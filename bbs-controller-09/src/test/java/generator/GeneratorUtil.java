package generator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GeneratorUtil {
	private static String tableName = "bbs_brand";
	private static String entityName = "Brand";
	
	private static String entityPath = "E:/workspacej2ee/bbs-09/bbs-entity-09/src/main/java";
	private static String mapperxmlPath = "E:/workspacej2ee/bbs-09/bbs-dao-09/src/main/java";
	private static String daoPath = "E:/workspacej2ee/bbs-09/bbs-dao-09/src/main/java";
	private static String servicePath = "E:/workspacej2ee/bbs-09/bbs-service-09/src/main/java";
	private static String controllerPath = "E:/workspacej2ee/bbs-09/bbs-controller-09/src/main/java";
	
	private static List<TableEntity> tablelist = new ArrayList<>();
	private static List<TableEntity> tlist = new ArrayList<>();
	
	private static String Dept;
	private static String dept;
	
	public static void main(String[] args) throws Exception {
		Map<String, String> map = new HashMap<>();
		map.put("bbs_addr", "Addr");
		map.put("bbs_brand", "Brand");
		map.put("bbs_buyer", "Buyer");
		map.put("bbs_city", "City");
		map.put("bbs_color", "Color");
		map.put("bbs_detail", "Detail");
		map.put("bbs_employee", "Employee");
		map.put("bbs_feature", "Feature");
		map.put("bbs_img", "Img");
		map.put("bbs_order", "Order");
		map.put("bbs_product", "Product");
		map.put("bbs_province", "Province");
		map.put("bbs_sku", "Sku");
		map.put("bbs_town", "Town");
		map.put("bbs_type", "Type");
		
		for (Map.Entry<String, String> m : map.entrySet()) {
			tableName = m.getKey();
			entityName = m.getValue();
			
			init();
			getDBInfo();
			genEntity();
			//genEntityQuery();
			genMapperXml();
			genNewEntityQuery();
			genDao();
			genService();
			genServiceImpl();
			genController();
		}
		System.out.println("生成完成，请刷新...............");
	}
	
	public static void getDBInfo() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/bbs-09?useUnicode=true&characterEncoding=UTF-8";
	    String username = "root";
	    String pwd = "123";
		Connection conn = DriverManager.getConnection(url,username,pwd);
	    
	    Statement stat = conn.createStatement();
		String sql = "SHOW FULL COLUMNS FROM " + tableName;
		ResultSet rs = stat.executeQuery(sql);
		tablelist = new ArrayList<>();
		while (rs.next()) {
			TableEntity tableentity = new TableEntity(rs.getString("Field"),rs.getString("Type"),rs.getString("Key"),rs.getString("Comment"));
			tablelist.add(tableentity);
		}
		tlist = new ArrayList<>();
		tlist.addAll(tablelist);
		conn.close();
	}
	
	public static void init() throws Exception {
		File file = new File(entityPath+"/com/xxt/entity");
		if (!file.exists()) {
			file.mkdirs();
		}
		
		file = new File(daoPath+"/com/xxt/dao");
		if (!file.exists()) {
			file.mkdirs();
		}
		
		file = new File(servicePath+"/com/xxt/service/impl");
		if (!file.exists()) {
			file.mkdirs();
		}
		
		file = new File(controllerPath+"/com/xxt/controller");
		if (!file.exists()) {
			file.mkdirs();
		}
		
		Dept = entityName;
		dept = Dept.substring(0, 1).toLowerCase() + Dept.substring(1);
	}
	
	public static String getJavaType(String type) {
		if (type.contains("(")) {
			type = type.substring(0, type.indexOf("("));
		}
		if (type.equals("int")) {
			return "Integer";
		}
		if (type.equals("bigint")) {
			return "Long";
		}
		if (type.equals("tinyint") || type.equals("bit")) {
			return "Short";
		}
		if (type.equals("double")) {
			return "Double";
		}
		if (type.equals("float")) {
			return "Float";
		}
		if (type.equals("varchar") || type.equals("char")) {
			return "String";
		}
		if (type.equals("decimal") || type.equals("numeric")) {
			return "java.math.BigDecimal";
		}
		if (type.equals("datetime") || type.equals("date")) {
			return "java.util.Date";
		}
		return "String";
	}
	
	public static String getJdbcType(String type) {
		if (type.contains("(")) {
			type = type.substring(0, type.indexOf("("));
		}
		if (type.equals("int")) {
			return "INTEGER";
		}
		if (type.equals("bigint")) {
			return "BIGINT";
		}
		if (type.equals("tinyint") || type.equals("bit")) {
			return "SMALLINT";
		}
		if (type.equals("double")) {
			return "DOUBLE";
		}
		if (type.equals("float")) {
			return "FLOAT";
		}
		if (type.equals("varchar") || type.equals("char")) {
			return "VARCHAR";
		}
		if (type.equals("longtext")) {
			return "LONGVARCHAR";
		}
		if (type.equals("decimal") || type.equals("numeric")) {
			return "DECIMAL";
		}
		if (type.equals("datetime") || type.equals("date")) {
			return "TIMESTAMP";
		}
		return "";
	}
	
	public static String firstToUp(String str) {
		return str.substring(0, 1).toUpperCase()+str.substring(1);
	}
	
	public static String delxiahuaxian(String str) {
		String result = str;
		if (str.contains("_")) {
			String[] strarr = str.split("_");
			result = "";
			for (int i=0; i<strarr.length; i++) {
				if (i == 0) {
					result += strarr[i];
				} else {
					result += firstToUp(strarr[i]);
				}
			}
		}
		return result;
	}
	
	public static String getBieming(String str) {
		if (str.contains("_")) {
			return str + " " + delxiahuaxian(str);
		}
		return str;
	}
	
	public static void genNewEntityQuery() throws Exception {
		File f = new File(entityPath+"/com/xxt/entity/" + Dept + "Query.java");
		if (!f.exists()) {
			f.createNewFile();
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
	
			bw.write("package com.xxt.entity;");
			bw.newLine();
			bw.newLine();
			
			bw.write("public class "+Dept+"Query extends "+Dept+" {");
			bw.newLine();
			bw.newLine();
			
			bw.write("	private static final long serialVersionUID = 1L;");
			bw.newLine();
			bw.newLine();
			
			bw.write("}");
			bw.newLine();
			
			bw.flush();
			bw.close();
		}
	}
	
	public static void genController() throws Exception {
		File f = new File(controllerPath+"/com/xxt/controller/" + Dept + "Controller.java");
		if (!f.exists()) {
			f.createNewFile();
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
			
			bw.write("package com.xxt.controller;");
			bw.newLine();
			bw.newLine();
			
			bw.write("import org.apache.commons.lang3.StringUtils;");
			bw.newLine();
			
			bw.write("import org.springframework.beans.factory.annotation.Autowired;");
			bw.newLine();
			
			bw.write("import org.springframework.stereotype.Controller;");
			bw.newLine();
			
			bw.write("import org.springframework.ui.Model;");
			bw.newLine();
			
			bw.write("import org.springframework.web.bind.annotation.RequestMapping;");
			bw.newLine();
			
			bw.write("import org.springframework.web.bind.annotation.ResponseBody;");
			bw.newLine();
			
			bw.write("import com.common.page.Pagination;");
			bw.newLine();
			
			bw.write("import com.xxt.common.result.ResultUtil;");
			bw.newLine();
			
			bw.write("import com.xxt.common.result.SubmitResultInfo;");
			bw.newLine();
			
			bw.write("import com.xxt.entity."+Dept+";");
			bw.newLine();
			
			bw.write("import com.xxt.entity."+Dept+"Query;");
			bw.newLine();
			
			bw.write("import com.xxt.service."+Dept+"Service;");
			bw.newLine();
			bw.newLine();
			
			bw.write("@Controller");
			bw.newLine();
			
			bw.write("public class "+Dept+"Controller {");
			bw.newLine();
			bw.newLine();
			
			bw.write("	@Autowired");
			bw.newLine();
			
			bw.write("	"+Dept+"Service "+dept+"Service;");
			bw.newLine();
			bw.newLine();
			
			bw.write("	@RequestMapping(\"/"+dept+"/list\")");
			bw.newLine();
			
			bw.write("	public String list(Integer pageNo, "+Dept+"Query "+dept+"Query, Model model) {");
			bw.newLine();
			
			bw.write("		"+dept+"Query.setPageNo(Pagination.cpn(pageNo));");
			bw.newLine();
			bw.newLine();
			
			bw.write("		StringBuilder sb = new StringBuilder();");
			bw.newLine();
			
			bw.write("		Pagination pagination = "+dept+"Service.get"+Dept+"ListWithPage("+dept+"Query);");
			bw.newLine();
			
			bw.write("		String params = sb.toString();");
			bw.newLine();
			
			bw.write("		if (StringUtils.isNotBlank(params) && params.startsWith(\"&\")) {");
			bw.newLine();
			
			bw.write("			params = params.substring(1);");
			bw.newLine();
			
			bw.write("		}");
			bw.newLine();
			
			bw.write("		pagination.pageView(\"/"+dept+"/list\", params);");
			bw.newLine();
			bw.newLine();
			
			bw.write("		model.addAttribute(\"pagination\", pagination);");
			bw.newLine();
			
			bw.write("		return \""+dept+"/list\";");
			bw.newLine();
			
			bw.write("	}");
			bw.newLine();
			bw.newLine();
			
			bw.write("	@RequestMapping(\"/"+dept+"/addinput\")");
			bw.newLine();
			
			bw.write("	public String addinput() {");
			bw.newLine();
			
			bw.write("		return \""+dept+"/add\";");
			bw.newLine();
			
			bw.write("	}");
			bw.newLine();
			bw.newLine();
			
			bw.write("	@RequestMapping(\"/"+dept+"/save\")");
			bw.newLine();
			
			bw.write("	public String save("+Dept+" "+dept+") {");
			bw.newLine();
			
			bw.write("		"+dept+"Service.save"+Dept+"("+dept+");");
			bw.newLine();
			
			bw.write("		return \"redirect:/"+dept+"/list.do\";");
			bw.newLine();
			
			bw.write("	}");
			bw.newLine();
			bw.newLine();
			
			bw.write("	@RequestMapping(\"/"+dept+"/edit\")");
			bw.newLine();
			
			bw.write("	public String edit("+getJavaType(tablelist.get(0).type)+" "+tablelist.get(0).field+", Model model) {");
			bw.newLine();
			
			bw.write("		"+Dept+" "+dept+" = "+dept+"Service.get"+Dept+"ById("+tablelist.get(0).field+");");
			bw.newLine();
			
			bw.write("		model.addAttribute(\""+dept+"\", "+dept+");");
			bw.newLine();
			
			bw.write("		return \""+dept+"/edit\";");
			bw.newLine();
			
			bw.write("	}");
			bw.newLine();
			bw.newLine();
			
			bw.write("	@RequestMapping(\"/"+dept+"/update\")");
			bw.newLine();
			
			bw.write("	public String update("+Dept+" "+dept+") {");
			bw.newLine();
			
			bw.write("		"+dept+"Service.update"+Dept+"("+dept+");");
			bw.newLine();
			
			bw.write("		return \"redirect:/"+dept+"/list.do\";");
			bw.newLine();
			
			bw.write("	}");
			bw.newLine();
			bw.newLine();
			
			bw.write("	@RequestMapping(\"/"+dept+"/delete\")");
			bw.newLine();
			
			bw.write("	public String delete("+getJavaType(tablelist.get(0).type)+" "+tablelist.get(0).field+") {");
			bw.newLine();
			
			bw.write("		"+dept+"Service.delete"+Dept+"ById("+tablelist.get(0).field+");");
			bw.newLine();
			
			bw.write("		return \"redirect:/"+dept+"/list.do\";");
			bw.newLine();
			
			bw.write("	}");
			bw.newLine();
			
			bw.write("}");
			bw.newLine();
			
			bw.flush();
			bw.close();
		}
	}
	
	public static void genServiceImpl() throws Exception {
		File f = new File(servicePath+"/com/xxt/service/impl/" + Dept + "ServiceImpl.java");
		if (!f.exists()) {
			f.createNewFile();
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
	
			bw.write("package com.xxt.service.impl;");
			bw.newLine();
			bw.newLine();
			
			bw.write("import java.util.List;");
			bw.newLine();
			
			bw.write("import org.springframework.beans.factory.annotation.Autowired;");
			bw.newLine();
			
			bw.write("import org.springframework.stereotype.Service;");
			bw.newLine();
			
			bw.write("import com.common.page.Pagination;");
			bw.newLine();
			
			bw.write("import com.xxt.dao."+Dept+"Mapper;");
			bw.newLine();
			
			bw.write("import com.xxt.entity."+Dept+";");
			bw.newLine();
			
			bw.write("import com.xxt.entity."+Dept+"Query;");
			bw.newLine();
			
			bw.write("import com.xxt.service."+Dept+"Service;");
			bw.newLine();
			bw.newLine();
			
			bw.write("@Service");
			bw.newLine();
			
			bw.write("public class "+Dept+"ServiceImpl implements "+Dept+"Service {");
			bw.newLine();
			bw.newLine();
			
			bw.write("	@Autowired");
			bw.newLine();
			
			bw.write("	"+Dept+"Mapper "+dept+"Mapper;");
			bw.newLine();
			bw.newLine();
			
			bw.write("	@Override");
			bw.newLine();
			
			bw.write("	public Pagination get"+Dept+"ListWithPage("+Dept+"Query "+dept+"Query) {");
			bw.newLine();
			
			bw.write("		return new Pagination("+dept+"Query.getPageNo(), "+dept+"Query.getPageSize(), "+dept+"Mapper.get"+Dept+"Count("+dept+"Query), "+dept+"Mapper.get"+Dept+"ListWithPage("+dept+"Query));");
			bw.newLine();
			
			bw.write("	}");
			bw.newLine();
			bw.newLine();
			
			bw.write("	@Override");
			bw.newLine();
			
			bw.write("	public "+Dept+" get"+Dept+"ById("+getJavaType(tablelist.get(0).type)+" "+tablelist.get(0).field+") {");
			bw.newLine();
			
			bw.write("		return "+dept+"Mapper.get"+Dept+"ById("+tablelist.get(0).field+");");
			bw.newLine();
			
			bw.write("	}");
			bw.newLine();
			bw.newLine();
			
			bw.write("	@Override");
			bw.newLine();
			
			bw.write("	public List<"+Dept+"> get"+Dept+"List() {");
			bw.newLine();
			
			bw.write("		return "+dept+"Mapper.get"+Dept+"List();");
			bw.newLine();
			
			bw.write("	}");
			bw.newLine();
			bw.newLine();
			
			bw.write("	@Override");
			bw.newLine();
			
			bw.write("	public void update"+Dept+"("+Dept+" "+dept+") {");
			bw.newLine();
			
			bw.write("		"+dept+"Mapper.update"+Dept+"("+dept+");");
			bw.newLine();
			
			bw.write("	}");
			bw.newLine();
			bw.newLine();
			
			bw.write("	@Override");
			bw.newLine();
			
			bw.write("	public void save"+Dept+"("+Dept+" "+dept+") {");
			bw.newLine();
			
			bw.write("		"+dept+"Mapper.save"+Dept+"("+dept+");");
			bw.newLine();
			
			bw.write("	}");
			bw.newLine();
			bw.newLine();
			
			bw.write("	@Override");
			bw.newLine();
			
			bw.write("	public void delete"+Dept+"ById("+getJavaType(tablelist.get(0).type)+" "+tablelist.get(0).field+") {");
			bw.newLine();
			
			bw.write("		"+dept+"Mapper.delete"+Dept+"ById("+tablelist.get(0).field+");");
			bw.newLine();
			
			bw.write("	}");
			bw.newLine();
			
			bw.write("}");
			bw.newLine();
			
			bw.flush();
			bw.close();
		}
	}
	
	public static void genService() throws Exception {
		File f = new File(servicePath+"/com/xxt/service/" + Dept + "Service.java");
		if (!f.exists()) {
			f.createNewFile();
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
	
			bw.write("package com.xxt.service;");
			bw.newLine();
			bw.newLine();
			
			bw.write("import java.util.List;");
			bw.newLine();
			
			bw.write("import com.common.page.Pagination;");
			bw.newLine();
			
			bw.write("import com.xxt.entity."+Dept+";");
			bw.newLine();
			
			bw.write("import com.xxt.entity."+Dept+"Query;");
			bw.newLine();
			bw.newLine();
			
			bw.write("public interface "+Dept+"Service {");
			bw.newLine();
			bw.newLine();
			
			bw.write("	public "+Dept+" get"+Dept+"ById("+getJavaType(tablelist.get(0).type)+" "+tablelist.get(0).field+");");
			bw.newLine();
			
			bw.write("	public Pagination get"+Dept+"ListWithPage("+Dept+"Query "+dept+"Query);");
			bw.newLine();
			
			bw.write("	public List<"+Dept+"> get"+Dept+"List();");
			bw.newLine();
			
			bw.write("	public void update"+Dept+"("+Dept+" "+dept+");");
			bw.newLine();
			
			bw.write("	public void save"+Dept+"("+Dept+" "+dept+");");
			bw.newLine();
			
			bw.write("	public void delete"+Dept+"ById("+getJavaType(tablelist.get(0).type)+" "+tablelist.get(0).field+");");
			bw.newLine();
			
			bw.write("}");
			bw.newLine();
			
			bw.flush();
			bw.close();
		}
	}
	
	public static void genDao() throws Exception {
		File f = new File(daoPath+"/com/xxt/dao/" + Dept + "Mapper.java");
		if (!f.exists()) {
			f.createNewFile();
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
	
			bw.write("package com.xxt.dao;");
			bw.newLine();
			bw.newLine();
			
			bw.write("import java.util.List;");
			bw.newLine();
			
			bw.write("import com.xxt.entity."+Dept+";");
			bw.newLine();
			
			bw.write("import com.xxt.entity."+Dept+"Query;");
			bw.newLine();
			bw.newLine();
			
			bw.write("public interface "+Dept+"Mapper {");
			bw.newLine();
			bw.newLine();
			
			bw.write("	public "+Dept+" get"+Dept+"ById("+getJavaType(tablelist.get(0).type)+" "+tablelist.get(0).field+");");
			bw.newLine();
			
			bw.write("	public List<"+Dept+"> get"+Dept+"ListWithPage("+Dept+"Query "+dept+"Query);");
			bw.newLine();
			
			bw.write("	public List<"+Dept+"> get"+Dept+"List();");
			bw.newLine();
			
			bw.write("	public Integer get"+Dept+"Count("+Dept+"Query "+dept+"Query);");
			bw.newLine();
			
			bw.write("	public void update"+Dept+"("+Dept+" "+dept+");");
			bw.newLine();
			
			bw.write("	public void save"+Dept+"("+Dept+" "+dept+");");
			bw.newLine();
			
			bw.write("	public void delete"+Dept+"ById("+getJavaType(tablelist.get(0).type)+" "+tablelist.get(0).field+");");
			bw.newLine();
			
			bw.write("}");
			bw.newLine();
			
			bw.flush();
			bw.close();
		}
	}
	
	public static void genEntityQuery() throws Exception {
		File f = new File(entityPath+"/com/xxt/entity/" + Dept + "Query.java");
		if (f.exists()) {
			long len = f.length();
			byte[] buf = new byte[(int) len];
			InputStream is = new FileInputStream(f);
			is.read(buf);
			is.close();
			String all = new String(buf);
			
			//属性
			int idx = all.lastIndexOf("        /*field end*/");
			String info = "";
			StringBuilder sb = new StringBuilder();
			for (TableEntity table : tlist) {
				sb.append("        public Criteria and"+firstToUp(delxiahuaxian(table.field))+"IsNull() {\r\n")
					.append("            addCriterion(\""+table.field+" is null\");\r\n")
					.append("            return (Criteria) this;\r\n")
					.append("        }\r\n")
					.append("        public Criteria and"+firstToUp(delxiahuaxian(table.field))+"IsNotNull() {\r\n")
					.append("            addCriterion(\""+table.field+" is not null\");\r\n")
					.append("            return (Criteria) this;\r\n")
					.append("        }\r\n")
					.append("        public Criteria and"+firstToUp(delxiahuaxian(table.field))+"EqualTo("+getJavaType(table.type)+" value) {\r\n")
					.append("            addCriterion(\""+table.field+" =\", value, \""+delxiahuaxian(table.field)+"\");\r\n")
					.append("            return (Criteria) this;")
					.append("        }\r\n")
					.append("        public Criteria and"+firstToUp(delxiahuaxian(table.field))+"NotEqualTo("+getJavaType(table.type)+" value) {\r\n")
					.append("            addCriterion(\""+table.field+" <>\", value, \""+delxiahuaxian(table.field)+"\");\r\n")
					.append("            return (Criteria) this;\r\n")
					.append("        }\r\n")
					.append("        public Criteria and"+firstToUp(delxiahuaxian(table.field))+"GreaterThan("+getJavaType(table.type)+" value) {\r\n")
					.append("            addCriterion(\""+table.field+" >\", value, \""+delxiahuaxian(table.field)+"\");\r\n")
					.append("            return (Criteria) this;\r\n")
					.append("        }\r\n")
					.append("        public Criteria and"+firstToUp(delxiahuaxian(table.field))+"GreaterThanOrEqualTo("+getJavaType(table.type)+" value) {\r\n")
					.append("            addCriterion(\""+table.field+" >=\", value, \""+delxiahuaxian(table.field)+"\");\r\n")
					.append("            return (Criteria) this;\r\n")
					.append("        }")
					.append("        public Criteria and"+firstToUp(delxiahuaxian(table.field))+"LessThan("+getJavaType(table.type)+" value) {\r\n")
					.append("            addCriterion(\""+table.field+" <\", value, \""+delxiahuaxian(table.field)+"\");\r\n")
					.append("            return (Criteria) this;\r\n")
					.append("        }\r\n")
					.append("        public Criteria and"+firstToUp(delxiahuaxian(table.field))+"LessThanOrEqualTo("+getJavaType(table.type)+" value) {\r\n")
					.append("            addCriterion(\""+table.field+" <=\", value, \""+delxiahuaxian(table.field)+"\");\r\n")
					.append("            return (Criteria) this;\r\n")
					.append("        }\r\n")
					.append("        public Criteria and"+firstToUp(delxiahuaxian(table.field))+"In(List<"+getJavaType(table.type)+"> values) {\r\n")
					.append("            addCriterion(\""+table.field+" in\", values, \""+delxiahuaxian(table.field)+"\");\r\n")
					.append("            return (Criteria) this;\r\n")
					.append("        }\r\n")
					.append("        public Criteria and"+firstToUp(delxiahuaxian(table.field))+"NotIn(List<"+getJavaType(table.type)+"> values) {\r\n")
					.append("            addCriterion(\""+table.field+" not in\", values, \""+delxiahuaxian(table.field)+"\");\r\n")
					.append("            return (Criteria) this;\r\n")
					.append("        }\r\n")
					.append("        public Criteria and"+firstToUp(delxiahuaxian(table.field))+"Between("+getJavaType(table.type)+" value1, "+getJavaType(table.type)+" value2) {\r\n")
					.append("            addCriterion(\""+table.field+" between\", value1, value2, \""+delxiahuaxian(table.field)+"\");\r\n")
					.append("            return (Criteria) this;\r\n")
					.append("        }\r\n")
					.append("        public Criteria and"+firstToUp(delxiahuaxian(table.field))+"NotBetween("+getJavaType(table.type)+" value1, "+getJavaType(table.type)+" value2) {\r\n")
					.append("            addCriterion(\""+table.field+" not between\", value1, value2, \""+delxiahuaxian(table.field)+"\");\r\n")
					.append("            return (Criteria) this;\r\n")
					.append("        }\r\n");
					
					if (getJavaType(table.type).equals("String")) {
						sb.append("        public Criteria and"+firstToUp(delxiahuaxian(table.field))+"Like(String value) {\r\n")
							.append("            addCriterion(\""+table.field+" like\", value, \""+delxiahuaxian(table.field)+"\");\r\n")
							.append("            return (Criteria) this;\r\n")
							.append("        }\r\n")
							.append("        public Criteria and"+firstToUp(delxiahuaxian(table.field))+"NotLike(String value) {\r\n")
							.append("            addCriterion(\""+table.field+" not like\", value, \""+delxiahuaxian(table.field)+"\");\r\n")
							.append("            return (Criteria) this;\r\n")
							.append("        }\r\n");
					}
					
				}
				info = sb.toString();
				StringBuilder sbf = new StringBuilder(all);
				sbf.insert(idx, info);
				
				FileOutputStream fos = new FileOutputStream(f);
				fos.write(sbf.toString().getBytes());
				fos.close();
			} else {
				f.createNewFile();
				BufferedWriter bw = new BufferedWriter(new FileWriter(f));
				
				bw.write("package com.xxt.entity;");
				bw.newLine();
				bw.newLine();
				
				bw.write("import java.util.ArrayList;");
				bw.newLine();
				
				bw.write("import com.xxt.common.config.Config;");
				bw.newLine();
				
				bw.write("import java.util.List;");
				bw.newLine();
				bw.newLine();
				
				bw.write("public class "+Dept+"Query extends "+Dept+" {");
				bw.newLine();
				bw.newLine();
				
				bw.write("	private static final long serialVersionUID = 1L;");
				bw.newLine();
				bw.newLine();
				
				bw.write("    protected String orderByClause;");
				bw.newLine();
				
				bw.write("    protected boolean distinct;");
				bw.newLine();
				
				bw.write("    protected List<Criteria> oredCriteria;");
				bw.newLine();
				
				bw.write("    protected Integer pageNo = 1;");
				bw.newLine();
				
				bw.write("    protected Integer startRow;");
				bw.newLine();
				
				bw.write("    protected Integer pageSize = Config.PAGE_SIZE;");
				bw.newLine();
				
				bw.write("    protected String fields;");
				bw.newLine();
				bw.newLine();
				
				bw.write("    public "+Dept+"Query() {");
				bw.newLine();
				
				bw.write("        oredCriteria = new ArrayList<Criteria>();");
				bw.newLine();
				
				bw.write("    }");
				bw.newLine();
				
				bw.write("    public void setOrderByClause(String orderByClause) {");
				bw.newLine();
				
				bw.write("        this.orderByClause = orderByClause;");
				bw.newLine();
				
				bw.write("    }");
				bw.newLine();
				
				bw.write("    public String getOrderByClause() {");
				bw.newLine();
				
				bw.write("        return orderByClause;");
				bw.newLine();
				
				bw.write("    }");
				bw.newLine();
				
				bw.write("    public void setDistinct(boolean distinct) {");
				bw.newLine();
				
				bw.write("        this.distinct = distinct;");
				bw.newLine();
				
				bw.write("    }");
				bw.newLine();
				
				bw.write("    public boolean isDistinct() {");
				bw.newLine();
				
				bw.write("        return distinct;");
				bw.newLine();
				
				bw.write("    }");
				bw.newLine();
				
				bw.write("    public List<Criteria> getOredCriteria() {");
				bw.newLine();
				
				bw.write("        return oredCriteria;");
				bw.newLine();
				
				bw.write("    }");
				bw.newLine();
				
				bw.write("    public void or(Criteria criteria) {");
				bw.newLine();
				
				bw.write("        oredCriteria.add(criteria);");
				bw.newLine();
				
				bw.write("    }");
				bw.newLine();
				
				bw.write("    public Criteria or() {");
				bw.newLine();
				
				bw.write("        Criteria criteria = createCriteriaInternal();");
				bw.newLine();
				
				bw.write("        oredCriteria.add(criteria);");
				bw.newLine();
				
				bw.write("        return criteria;");
				bw.newLine();
				
				bw.write("    }");
				bw.newLine();
				
				bw.write("    public Criteria createCriteria() {");
				bw.newLine();
				
				bw.write("        Criteria criteria = createCriteriaInternal();");
				bw.newLine();
				
				bw.write("        if (oredCriteria.size() == 0) {");
				bw.newLine();
				
				bw.write("            oredCriteria.add(criteria);");
				bw.newLine();
				
				bw.write("        }");
				bw.newLine();
				
				bw.write("        return criteria;");
				bw.newLine();
				
				bw.write("    }");
				bw.newLine();
				
				bw.write("    protected Criteria createCriteriaInternal() {");
				bw.newLine();
				
				bw.write("        Criteria criteria = new Criteria();");
				bw.newLine();
				
				bw.write("        return criteria;");
				bw.newLine();
				
				bw.write("    }");
				bw.newLine();
				
				bw.write("    public void clear() {");
				bw.newLine();
				
				bw.write("        oredCriteria.clear();");
				bw.newLine();
				
				bw.write("        orderByClause = null;");
				bw.newLine();
				
				bw.write("        distinct = false;");
				bw.newLine();
				
				bw.write("    }");
				bw.newLine();
				
				bw.write("    public void setPageNo(Integer pageNo) {");
				bw.newLine();
				
				bw.write("        this.pageNo=pageNo;");
				bw.newLine();
				
				bw.write("        this.startRow = (pageNo-1)*this.pageSize;");
				bw.newLine();
				
				bw.write("    }");
				bw.newLine();
				
				bw.write("    public Integer getPageNo() {");
				bw.newLine();
				
				bw.write("        return pageNo;");
				bw.newLine();
				
				bw.write("    }");
				bw.newLine();
				
				bw.write("    public void setStartRow(Integer startRow) {");
				bw.newLine();
				
				bw.write("        this.startRow=startRow;");
				bw.newLine();
				
				bw.write("    }");
				bw.newLine();
				
				bw.write("    public Integer getStartRow() {");
				bw.newLine();
				
				bw.write("        return startRow;");
				bw.newLine();
				
				bw.write("    }");
				bw.newLine();
				
				bw.write("    public void setPageSize(Integer pageSize) {");
				bw.newLine();
				
				bw.write("        this.pageSize=pageSize;");
				bw.newLine();
				
				bw.write("        this.startRow = (pageNo-1)*this.pageSize;");
				bw.newLine();
				
				bw.write("    }");
				bw.newLine();
				
				bw.write("    public Integer getPageSize() {");
				bw.newLine();
				
				bw.write("        return pageSize;");
				bw.newLine();
				
				bw.write("    }");
				bw.newLine();
				
				bw.write("    public void setFields(String fields) {");
				bw.newLine();
				
				bw.write("        this.fields=fields;");
				bw.newLine();
				
				bw.write("    }");
				bw.newLine();
				
				bw.write("    public String getFields() {");
				bw.newLine();
				
				bw.write("        return fields;");
				bw.newLine();
				
				bw.write("    }");
				bw.newLine();
				
				bw.write("    protected abstract static class GeneratedCriteria {");
				bw.newLine();
				
				bw.write("        protected List<Criterion> criteria;");
				bw.newLine();
				bw.newLine();
				
				bw.write("        protected GeneratedCriteria() {");
				bw.newLine();
				
				bw.write("            criteria = new ArrayList<Criterion>();");
				bw.newLine();
				
				bw.write("        }");
				bw.newLine();
				
				bw.write("        public boolean isValid() {");
				bw.newLine();
				
				bw.write("            return criteria.size() > 0;");
				bw.newLine();
				
				bw.write("        }");
				bw.newLine();
				
				bw.write("        public List<Criterion> getAllCriteria() {");
				bw.newLine();
				
				bw.write("            return criteria;");
				bw.newLine();
				
				bw.write("        }");
				bw.newLine();
				
				bw.write("        public List<Criterion> getCriteria() {");
				bw.newLine();
				
				bw.write("            return criteria;");
				bw.newLine();
				
				bw.write("        }");
				bw.newLine();
				
				bw.write("        protected void addCriterion(String condition) {");
				bw.newLine();
				
				bw.write("            if (condition == null) {");
				bw.newLine();
				
				bw.write("                throw new RuntimeException(\"Value for condition cannot be null\");");
				bw.newLine();
				
				bw.write("            }");
				bw.newLine();
				
				bw.write("            criteria.add(new Criterion(condition));");
				bw.newLine();
				
				bw.write("        }");
				bw.newLine();
				
				bw.write("        protected void addCriterion(String condition, Object value, String property) {");
				bw.newLine();
				
				bw.write("            if (value == null) {");
				bw.newLine();
				
				bw.write("                throw new RuntimeException(\"Value for \" + property + \" cannot be null\");");
				bw.newLine();
				
				bw.write("            }");
				bw.newLine();
				
				bw.write("            criteria.add(new Criterion(condition, value));");
				bw.newLine();
				
				bw.write("        }");
				bw.newLine();
				
				bw.write("        protected void addCriterion(String condition, Object value1, Object value2, String property) {");
				bw.newLine();
				
				bw.write("            if (value1 == null || value2 == null) {");
				bw.newLine();
				
				bw.write("                throw new RuntimeException(\"Between values for \" + property + \" cannot be null\");");
				bw.newLine();
				
				bw.write("            }");
				bw.newLine();
				
				bw.write("            criteria.add(new Criterion(condition, value1, value2));");
				bw.newLine();
				
				bw.write("        }");
				bw.newLine();
				
				for (TableEntity table : tablelist) {
					bw.write("        public Criteria and"+firstToUp(delxiahuaxian(table.field))+"IsNull() {");
					bw.newLine();
					
					bw.write("            addCriterion(\""+table.field+" is null\");");
					bw.newLine();
					
					bw.write("            return (Criteria) this;");
					bw.newLine();
					
					bw.write("        }");
					bw.newLine();
					
					bw.write("        public Criteria and"+firstToUp(delxiahuaxian(table.field))+"IsNotNull() {");
					bw.newLine();
					
					bw.write("            addCriterion(\""+table.field+" is not null\");");
					bw.newLine();
					
					bw.write("            return (Criteria) this;");
					bw.newLine();
					
					bw.write("        }");
					bw.newLine();
					
					bw.write("        public Criteria and"+firstToUp(delxiahuaxian(table.field))+"EqualTo("+getJavaType(table.type)+" value) {");
					bw.newLine();
					
					bw.write("            addCriterion(\""+table.field+" =\", value, \""+delxiahuaxian(table.field)+"\");");
					bw.newLine();
					
					bw.write("            return (Criteria) this;");
					bw.newLine();
					
					bw.write("        }");
					bw.newLine();
					
					bw.write("        public Criteria and"+firstToUp(delxiahuaxian(table.field))+"NotEqualTo("+getJavaType(table.type)+" value) {");
					bw.newLine();
					
					bw.write("            addCriterion(\""+table.field+" <>\", value, \""+delxiahuaxian(table.field)+"\");");
					bw.newLine();
					
					bw.write("            return (Criteria) this;");
					bw.newLine();
					
					bw.write("        }");
					bw.newLine();
					
					bw.write("        public Criteria and"+firstToUp(delxiahuaxian(table.field))+"GreaterThan("+getJavaType(table.type)+" value) {");
					bw.newLine();
					
					bw.write("            addCriterion(\""+table.field+" >\", value, \""+delxiahuaxian(table.field)+"\");");
					bw.newLine();
					
					bw.write("            return (Criteria) this;");
					bw.newLine();
					
					bw.write("        }");
					bw.newLine();
					
					bw.write("        public Criteria and"+firstToUp(delxiahuaxian(table.field))+"GreaterThanOrEqualTo("+getJavaType(table.type)+" value) {");
					bw.newLine();
					
					bw.write("            addCriterion(\""+table.field+" >=\", value, \""+delxiahuaxian(table.field)+"\");");
					bw.newLine();
					
					bw.write("            return (Criteria) this;");
					bw.newLine();
					
					bw.write("        }");
					bw.newLine();
					
					bw.write("        public Criteria and"+firstToUp(delxiahuaxian(table.field))+"LessThan("+getJavaType(table.type)+" value) {");
					bw.newLine();
					
					bw.write("            addCriterion(\""+table.field+" <\", value, \""+delxiahuaxian(table.field)+"\");");
					bw.newLine();
					
					bw.write("            return (Criteria) this;");
					bw.newLine();
					
					bw.write("        }");
					bw.newLine();
					
					bw.write("        public Criteria and"+firstToUp(delxiahuaxian(table.field))+"LessThanOrEqualTo("+getJavaType(table.type)+" value) {");
					bw.newLine();
					
					bw.write("            addCriterion(\""+table.field+" <=\", value, \""+delxiahuaxian(table.field)+"\");");
					bw.newLine();
					
					bw.write("            return (Criteria) this;");
					bw.newLine();
					
					bw.write("        }");
					bw.newLine();
					
					bw.write("        public Criteria and"+firstToUp(delxiahuaxian(table.field))+"In(List<"+getJavaType(table.type)+"> values) {");
					bw.newLine();
					
					bw.write("            addCriterion(\""+table.field+" in\", values, \""+delxiahuaxian(table.field)+"\");");
					bw.newLine();
					
					bw.write("            return (Criteria) this;");
					bw.newLine();
					
					bw.write("        }");
					bw.newLine();
					
					bw.write("        public Criteria and"+firstToUp(delxiahuaxian(table.field))+"NotIn(List<"+getJavaType(table.type)+"> values) {");
					bw.newLine();
					
					bw.write("            addCriterion(\""+table.field+" not in\", values, \""+delxiahuaxian(table.field)+"\");");
					bw.newLine();
					
					bw.write("            return (Criteria) this;");
					bw.newLine();
					
					bw.write("        }");
					bw.newLine();
					
					bw.write("        public Criteria and"+firstToUp(delxiahuaxian(table.field))+"Between("+getJavaType(table.type)+" value1, "+getJavaType(table.type)+" value2) {");
					bw.newLine();
					
					bw.write("            addCriterion(\""+table.field+" between\", value1, value2, \""+delxiahuaxian(table.field)+"\");");
					bw.newLine();
					
					bw.write("            return (Criteria) this;");
					bw.newLine();
					
					bw.write("        }");
					bw.newLine();
					
					bw.write("        public Criteria and"+firstToUp(delxiahuaxian(table.field))+"NotBetween("+getJavaType(table.type)+" value1, "+getJavaType(table.type)+" value2) {");
					bw.newLine();
					
					bw.write("            addCriterion(\""+table.field+" not between\", value1, value2, \""+delxiahuaxian(table.field)+"\");");
					bw.newLine();
					
					bw.write("            return (Criteria) this;");
					bw.newLine();
					
					bw.write("        }");
					bw.newLine();
					if (getJavaType(table.type).equals("String")) {
						bw.write("        public Criteria and"+firstToUp(delxiahuaxian(table.field))+"Like(String value) {");
						bw.newLine();
						
						bw.write("            addCriterion(\""+table.field+" like\", value, \""+delxiahuaxian(table.field)+"\");");
						bw.newLine();
						
						bw.write("            return (Criteria) this;");
						bw.newLine();
						
						bw.write("        }");
						bw.newLine();
						
						bw.write("        public Criteria and"+firstToUp(delxiahuaxian(table.field))+"NotLike(String value) {");
						bw.newLine();
						
						bw.write("            addCriterion(\""+table.field+" not like\", value, \""+delxiahuaxian(table.field)+"\");");
						bw.newLine();
						
						bw.write("            return (Criteria) this;");
						bw.newLine();
						
						bw.write("        }");
						bw.newLine();
					}
					
				}
				bw.write("        /*field end*/");
				bw.newLine();
				
				bw.write("    }");
				bw.newLine();
				
				bw.write("    public static class Criteria extends GeneratedCriteria {");
				bw.newLine();
				
				bw.write("        protected Criteria() {");
				bw.newLine();
				
				bw.write("        }");
				bw.newLine();
				
				bw.write("    }");
				bw.newLine();
				bw.newLine();
				
				bw.write("    public static class Criterion {");
				bw.newLine();
				
				bw.write("        private String condition;");
				bw.newLine();
				
				bw.write("        private Object value;");
				bw.newLine();
				
				bw.write("        private Object secondValue;");
				bw.newLine();
				
				bw.write("        private boolean noValue;");
				bw.newLine();
				
				bw.write("        private boolean singleValue;");
				bw.newLine();
				
				bw.write("        private boolean betweenValue;");
				bw.newLine();
				
				bw.write("        private boolean listValue;");
				bw.newLine();
				
				bw.write("        private String typeHandler;");
				bw.newLine();
				bw.newLine();
				
				bw.write("        public String getCondition() {");
				bw.newLine();
				
				bw.write("            return condition;");
				bw.newLine();
				
				bw.write("        }");
				bw.newLine();
				
				bw.write("        public Object getValue() {");
				bw.newLine();
				
				bw.write("            return value;");
				bw.newLine();
				
				bw.write("        }");
				bw.newLine();
				
				bw.write("        public Object getSecondValue() {");
				bw.newLine();
				
				bw.write("            return secondValue;");
				bw.newLine();
				
				bw.write("        }");
				bw.newLine();
				
				bw.write("        public boolean isNoValue() {");
				bw.newLine();
				
				bw.write("            return noValue;");
				bw.newLine();
				
				bw.write("        }");
				bw.newLine();
				
				bw.write("        public boolean isSingleValue() {");
				bw.newLine();
				
				bw.write("            return singleValue;");
				bw.newLine();
				
				bw.write("        }");
				bw.newLine();
				
				bw.write("        public boolean isBetweenValue() {");
				bw.newLine();
				
				bw.write("            return betweenValue;");
				bw.newLine();
				
				bw.write("        }");
				bw.newLine();
				
				bw.write("        public boolean isListValue() {");
				bw.newLine();
				
				bw.write("            return listValue;");
				bw.newLine();
				
				bw.write("        }");
				bw.newLine();
				
				bw.write("        public String getTypeHandler() {");
				bw.newLine();
				
				bw.write("            return typeHandler;");
				bw.newLine();
				
				bw.write("        }");
				bw.newLine();
				
				bw.write("        protected Criterion(String condition) {");
				bw.newLine();
				
				bw.write("            this.condition = condition;");
				bw.newLine();
				
				bw.write("            this.typeHandler = null;");
				bw.newLine();
				
				bw.write("            this.noValue = true;");
				bw.newLine();
				
				bw.write("        }");
				bw.newLine();
				
				bw.write("        protected Criterion(String condition, Object value, String typeHandler) {");
				bw.newLine();
				
				bw.write("            this.condition = condition;");
				bw.newLine();
				
				bw.write("            this.value = value;");
				bw.newLine();
				
				bw.write("            this.typeHandler = typeHandler;");
				bw.newLine();
				
				bw.write("            if (value instanceof List<?>) {");
				bw.newLine();
				
				bw.write("                this.listValue = true;");
				bw.newLine();
				
				bw.write("            } else {");
				bw.newLine();
				
				bw.write("                this.singleValue = true;");
				bw.newLine();
				
				bw.write("            }");
				bw.newLine();
				
				bw.write("        }");
				bw.newLine();
				
				bw.write("        protected Criterion(String condition, Object value) {");
				bw.newLine();
				
				bw.write("            this(condition, value, null);");
				bw.newLine();
				
				bw.write("        }");
				bw.newLine();
				
				bw.write("        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {");
				bw.newLine();
				
				bw.write("            this.condition = condition;");
				bw.newLine();
				
				bw.write("            this.value = value;");
				bw.newLine();
				
				bw.write("            this.secondValue = secondValue;");
				bw.newLine();
				
				bw.write("            this.typeHandler = typeHandler;");
				bw.newLine();
				
				bw.write("            this.betweenValue = true;");
				bw.newLine();
				
				bw.write("        }");
				bw.newLine();
				
				bw.write("        protected Criterion(String condition, Object value, Object secondValue) {");
				bw.newLine();
				
				bw.write("            this(condition, value, secondValue, null);");
				bw.newLine();
				
				bw.write("        }");
				bw.newLine();
				
				bw.write("    }");
				bw.newLine();
				
				bw.write("}");
				bw.newLine();
				
				bw.flush();
				bw.close();
			}
	}
	
	public static void genMapperXml() throws Exception {
		File f = new File(mapperxmlPath+"/com/xxt/dao/" + Dept + "Mapper.xml");
		if (f.exists()) {
			long len = f.length();
			byte[] buf = new byte[(int) len];
			InputStream is = new FileInputStream(f);
			is.read(buf);
			is.close();
			String all = new String(buf);
			
			int idx = all.lastIndexOf("<!--fields-->");
			String info = "";
			for (TableEntity table : tlist) {
				info += ","+getBieming(table.field);
			}
			StringBuilder sbf = new StringBuilder(all);
			sbf.insert(idx, info);
			
			idx = sbf.toString().lastIndexOf(")<!--table_field-->");
			info = "";
			for (TableEntity table : tlist) {
				info += ","+table.field;
			}
			sbf.insert(idx, info);
			
			idx = sbf.toString().lastIndexOf(")<!--entity_field-->");
			info = "";
			for (TableEntity table : tlist) {
				info += ",#{"+delxiahuaxian(table.field)+",jdbcType="+getJdbcType(table.type)+"}";
			}
			sbf.insert(idx, info);
			
			idx = sbf.toString().lastIndexOf("	  <!--updateif-->");
			info = "";
			StringBuilder sb = new StringBuilder();
			for (TableEntity table : tlist) {
				sb.append("      <if test=\""+delxiahuaxian(table.field)+" != null\" >\r\n")
					.append("        "+table.field+" = #{"+delxiahuaxian(table.field)+",jdbcType="+getJdbcType(table.type)+"},\r\n")
					.append("      </if>\r\n");
			}
			info = sb.toString();
			sbf.insert(idx, info);
			
			FileOutputStream fos = new FileOutputStream(f);
			fos.write(sbf.toString().getBytes());
			fos.close();
		} else {
			f.createNewFile();
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
	
			bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
			bw.newLine();
			
			bw.write("<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\" >");
			bw.newLine();
			
			bw.write("<mapper namespace=\"com.xxt.dao."+Dept+"Mapper\" >");
			bw.newLine();
			bw.newLine();
			
			bw.write("  <sql id=\"fields\" >");
			bw.newLine();
			
			for (int i=0; i<tablelist.size(); i++) {
				if (i == 0) {
					bw.write("      "+getBieming(tablelist.get(i).field));
				} else {
					bw.write(","+getBieming(tablelist.get(i).field));
				}
			}
			bw.write("<!--fields-->");
			bw.newLine();
			
			bw.write("  </sql>");
			bw.newLine();
			bw.newLine();
			
			bw.write("  <sql id=\"where_clause\">");
			bw.newLine();
			
			bw.write("  	<where>");
			bw.newLine();
			
			bw.write("    </where>");
			bw.newLine();
			
			bw.write("  </sql>");
			bw.newLine();
			bw.newLine();
			
			bw.write("  <sql id=\"orderby_clause\">");
			bw.newLine();
			
			bw.write("  	order by id");
			bw.newLine();
			
			bw.write("  </sql>");
			bw.newLine();
			bw.newLine();
			
			/*bw.write("  <sql id=\"query_where_clause\" >");
			bw.newLine();
			
			bw.write("    <where >");
			bw.newLine();
			
			bw.write("      <foreach collection=\"oredCriteria\" item=\"criteria\" separator=\"or\" >");
			bw.newLine();
			
			bw.write("        <if test=\"criteria.valid\" >");
			bw.newLine();
			
			bw.write("          <trim prefix=\"(\" suffix=\")\" prefixOverrides=\"and\" >");
			bw.newLine();
			
			bw.write("            <foreach collection=\"criteria.criteria\" item=\"criterion\" >");
			bw.newLine();
			
			bw.write("              <choose >");
			bw.newLine();
			
			bw.write("                <when test=\"criterion.noValue\" >");
			bw.newLine();
			
			bw.write("                  and ${criterion.condition}");
			bw.newLine();
			
			bw.write("                </when>");
			bw.newLine();
			
			bw.write("                <when test=\"criterion.singleValue\" >");
			bw.newLine();
			
			bw.write("                  and ${criterion.condition} #{criterion.value}");
			bw.newLine();
			
			bw.write("                </when>");
			bw.newLine();
			
			bw.write("                <when test=\"criterion.betweenValue\" >");
			bw.newLine();
			
			bw.write("                  and ${criterion.condition} #{criterion.value} and #{criterion.secondValue}");
			bw.newLine();
			
			bw.write("                </when>");
			bw.newLine();
			
			bw.write("                <when test=\"criterion.listValue\" >");
			bw.newLine();
			
			bw.write("                  and ${criterion.condition}");
			bw.newLine();
			
			bw.write("                  <foreach collection=\"criterion.value\" item=\"listItem\" open=\"(\" close=\")\" separator=\",\" >");
			bw.newLine();
			
			bw.write("                    #{listItem}");
			bw.newLine();
			
			bw.write("                  </foreach>");
			bw.newLine();
			
			bw.write("                </when>");
			bw.newLine();
			
			bw.write("              </choose>");
			bw.newLine();
			
			bw.write("            </foreach>");
			bw.newLine();
			
			bw.write("          </trim>");
			bw.newLine();
			
			bw.write("        </if>");
			bw.newLine();
			
			bw.write("      </foreach>");
			bw.newLine();
			
			bw.write("    </where>");
			bw.newLine();
			
			bw.write("  </sql>");
			bw.newLine();
			bw.newLine();
			
			bw.write("  <sql id=\"orderby_clause\">");
			bw.newLine();
			
			bw.write("  	<if test=\"orderByClause != null and orderByClause != ''\">");
			bw.newLine();
			
			bw.write("  		order by orderByClause");
			bw.newLine();
			
			bw.write("  	</if>");
			bw.newLine();
			
			bw.write("  </sql>");
			bw.newLine();
			bw.newLine();*/
			
			bw.write("  <sql id=\"limit_clause\">");
			bw.newLine();
			
			bw.write("  	limit #{startRow}, #{pageSize}");
			bw.newLine();
			
			bw.write("  </sql>");
			bw.newLine();
			bw.newLine();
			
			bw.write("  <select id=\"get"+Dept+"ById\" resultType=\"com.xxt.entity."+Dept+"\">");
			bw.newLine();
			
			bw.write("    select <include refid=\"fields\"/>");
			bw.newLine();
			
			bw.write("    from "+tableName+"");
			bw.newLine();
			
			bw.write("    where "+tablelist.get(0).field+" = #{"+tablelist.get(0).field+",jdbcType="+getJdbcType(tablelist.get(0).type)+"}");
			bw.newLine();
			
			bw.write("  </select>");
			bw.newLine();
			bw.newLine();
			
			bw.write("  <select id=\"get"+Dept+"ListWithPage\" parameterType=\"com.xxt.entity."+Dept+"Query\" resultType=\"com.xxt.entity."+Dept+"\">");
			bw.newLine();
			
			bw.write("    select <include refid=\"fields\"/>");
			bw.newLine();
			
			bw.write("    from "+tableName+"");
			bw.newLine();
			
			bw.write("    <include refid=\"where_clause\"/>");
			bw.newLine();
			
			bw.write("    <include refid=\"orderby_clause\"/>");
			bw.newLine();
			
			bw.write("    <include refid=\"limit_clause\"/>");
			bw.newLine();
			
			bw.write("  </select>");
			bw.newLine();
			bw.newLine();
			
			bw.write("  <select id=\"get"+Dept+"List\" resultType=\"com.xxt.entity."+Dept+"\">");
			bw.newLine();
			
			bw.write("    select <include refid=\"fields\"/>");
			bw.newLine();
			
			bw.write("    from "+tableName+"");
			bw.newLine();
			
			bw.write("  </select>");
			bw.newLine();
			bw.newLine();
			
			bw.write("  <select id=\"get"+Dept+"Count\" resultType=\"int\">");
			bw.newLine();
			
			bw.write("    select count("+tablelist.get(0).field+")");
			bw.newLine();
			
			bw.write("    from "+tableName+"");
			bw.newLine();
			
			bw.write("    <include refid=\"where_clause\"/>");
			bw.newLine();
			
			bw.write("  </select>");
			bw.newLine();
			bw.newLine();
			
			bw.write("  <delete id=\"delete"+Dept+"ById\">");
			bw.newLine();
			
			bw.write("    delete from "+tableName+"");
			bw.newLine();
			
			bw.write("    where "+tablelist.get(0).field+" = #{"+tablelist.get(0).field+",jdbcType="+getJdbcType(tablelist.get(0).type)+"}");
			bw.newLine();
			
			bw.write("  </delete>");
			bw.newLine();
			bw.newLine();
			
			bw.write("  <insert id=\"save"+Dept+"\" parameterType=\"com.xxt.entity."+Dept+"\" >");
			bw.newLine();
			
			for (int i=0; i<tablelist.size(); i++) {
				if (i == 0) {
					bw.write("    insert into "+tableName+" ("+tablelist.get(i).field+"");
				} else {
					bw.write(","+tablelist.get(i).field);
				}
			}
			bw.write(")");
			bw.write("<!--table_field-->");
			bw.newLine();
			
			for (int i=0; i<tablelist.size(); i++) {
				if (i == 0) {
					bw.write("    values (#{"+delxiahuaxian(tablelist.get(i).field)+",jdbcType="+getJdbcType(tablelist.get(i).type)+"}");
				} else {
					bw.write(",#{"+delxiahuaxian(tablelist.get(i).field)+",jdbcType="+getJdbcType(tablelist.get(i).type)+"}");
				}
			}
			bw.write(")");
			bw.write("<!--entity_field-->");
			bw.newLine();
			
			bw.write("  </insert>");
			bw.newLine();
			bw.newLine();
			
			bw.write("  <update id=\"update"+Dept+"\" parameterType=\"com.xxt.entity."+Dept+"\" >");
			bw.newLine();
			
			bw.write("    update "+tableName+"");
			bw.newLine();
			
			bw.write("    <set >");
			bw.newLine();
			
			for (int i=1; i<tablelist.size(); i++) {
				bw.write("      <if test=\""+delxiahuaxian(tablelist.get(i).field)+" != null\" >");
				bw.newLine();
				
				bw.write("        "+tablelist.get(i).field+" = #{"+delxiahuaxian(tablelist.get(i).field)+",jdbcType="+getJdbcType(tablelist.get(i).type)+"},");
				bw.newLine();
				
				bw.write("      </if>");
				bw.newLine();
			}
			
			bw.write("	  <!--updateif-->");
			bw.newLine();
			
			bw.write("    </set>");
			bw.newLine();
			
			bw.write("    where "+tablelist.get(0).field+" = #{"+tablelist.get(0).field+",jdbcType="+getJdbcType(tablelist.get(0).type)+"}");
			bw.newLine();
			
			bw.write("  </update>");
			bw.newLine();
			
			bw.write("</mapper>");
			bw.newLine();
			
			bw.flush();
			bw.close();
		}
	}
	
	public static void genEntity() throws Exception {
		File f = new File(entityPath+"/com/xxt/entity/" + Dept + ".java");
		if (f.exists()) {
			long len = f.length();
			byte[] buf = new byte[(int) len];
			InputStream is = new FileInputStream(f);
			is.read(buf);
			is.close();
			String all = new String(buf);
			
			for (int i=tlist.size()-1; i>=0; i--) {
				if (all.contains(delxiahuaxian(tlist.get(i).field+";"))) {
					tlist.remove(i);
				}
			}
			//属性
			int idx = all.lastIndexOf("    /*field end*/");
			String info = "";
			for (TableEntity table : tlist) {
				info += "    /** "+table.comment+" */\r\n    private "+getJavaType(table.type)+" "+delxiahuaxian(table.field)+";\r\n\r\n";
			}
			StringBuilder sbf = new StringBuilder(all);
			sbf.insert(idx, info);
			
			//get/set方法
			idx = sbf.toString().lastIndexOf("    /*method end*/");
			StringBuilder sb = new StringBuilder();
			info = "";
			for (TableEntity table : tlist) {
				sb.append("    public "+getJavaType(table.type)+" get"+firstToUp(delxiahuaxian(table.field))+"() {\r\n")
					.append("        return "+delxiahuaxian(table.field)+";\r\n")
					.append("    }\r\n")
					.append("    public void set"+firstToUp(delxiahuaxian(table.field))+"("+getJavaType(table.type)+" "+delxiahuaxian(table.field)+") {\r\n")
					.append("        this."+delxiahuaxian(table.field)+" = "+delxiahuaxian(table.field)+";\r\n")
					.append("    }\r\n")
					.toString();
			}
			info = sb.toString();
			sbf.insert(idx, info);
			
			//toString
			idx = sbf.toString().lastIndexOf("]");
			info = "";
			for (TableEntity table : tlist) {
				info += ", "+delxiahuaxian(table.field)+"=\" + "+delxiahuaxian(table.field) + " + \"";
			}
			sbf.insert(idx, info);
			
			FileOutputStream fos = new FileOutputStream(f);
			fos.write(sbf.toString().getBytes());
			fos.close();
		} else {
			f.createNewFile();
	
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
	
			bw.write("package com.xxt.entity;");
			bw.newLine();
			bw.newLine();
			bw.write("import com.xxt.common.base.BaseEntity;");
			bw.newLine();
			bw.newLine();
	
			bw.write("public class "+Dept+" extends BaseEntity {");
			bw.newLine();
			bw.newLine();
			
			bw.write("    private static final long serialVersionUID = 1L;");
			bw.newLine();
			bw.newLine();
			
			//属性
			for (TableEntity table : tablelist) {
				bw.write("    /** "+table.comment+" */");
				bw.newLine();
				
				bw.write("    private "+getJavaType(table.type)+" "+delxiahuaxian(table.field)+";");
				bw.newLine();
			}
			bw.newLine();
			bw.write("    /*field end*/");
			bw.newLine();
			bw.newLine();
			
			//set/get方法
			for (TableEntity table : tablelist) {
				bw.write("    public "+getJavaType(table.type)+" get"+firstToUp(delxiahuaxian(table.field))+"() {");
				bw.newLine();
				
				bw.write("        return "+delxiahuaxian(table.field)+";");
				bw.newLine();
				
				bw.write("    }");
				bw.newLine();
				
				bw.write("    public void set"+firstToUp(delxiahuaxian(table.field))+"("+getJavaType(table.type)+" "+delxiahuaxian(table.field)+") {");
				bw.newLine();
				
				bw.write("        this."+delxiahuaxian(table.field)+" = "+delxiahuaxian(table.field)+";");
				bw.newLine();
				
				bw.write("    }");
				bw.newLine();
			}
			bw.newLine();
			bw.write("    /*method end*/");
			bw.newLine();
			bw.newLine();
			
			bw.write("	@Override");
			bw.newLine();
			
			bw.write("	public String toString() {");
			bw.newLine();
			
			bw.write("		return \""+entityName + " [");
			
			for (int i=0; i<tablelist.size(); i++) {
				if (i == tablelist.size() -1) {
					bw.write(delxiahuaxian(tablelist.get(i).field)+"=\" + "+delxiahuaxian(tablelist.get(i).field)+"");
				} else {
					bw.write(delxiahuaxian(tablelist.get(i).field)+"=\" + "+delxiahuaxian(tablelist.get(i).field)+" + \", ");
				}
			}
			
			bw.write("+\"]\";");
			bw.newLine();
			
			bw.write("	}");
			bw.newLine();
			
			bw.write("}");
			bw.newLine();
			
			bw.flush();
			bw.close();
		}
	}
	
	
}

class TableEntity {
	public String field;
	public String type;
	public String key;
	public String comment;
	
	public TableEntity() {
	}

	public TableEntity(String field, String type, String key, String comment) {
		super();
		this.field = field;
		this.type = type;
		this.key = key;
		this.comment = comment;
	}
	
}
