/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-11-01 03:52:44 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.back_005fpage.order;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class list_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/back_page/head.jsp", Long.valueOf(1504319690731L));
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');
      out.write("<link href=\"/res/itcast/css/admin.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("<link href=\"/res/common/css/theme.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("<link href=\"/res/common/css/jquery.validate.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("<link href=\"/res/common/css/jquery.treeview.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("<link href=\"/res/common/css/jquery.ui.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("\r\n");
      out.write("<!-- <script src=\"/thirdparty/ckeditor/ckeditor.js\" type=\"text/javascript\"></script> -->\r\n");
      out.write("<!-- <script src=\"/thirdparty/My97DatePicker/WdatePicker.js\" type=\"text/javascript\"></script> -->\r\n");
      out.write("<script type=\"text/javascript\" src=\"/res/fckeditor/fckeditor.js\"></script>\r\n");
      out.write("<script src=\"/res/common/js/jquery.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"/res/common/js/jquery.ext.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"/res/common/js/jquery.form.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"/res/common/js/itcast.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"/res/itcast/js/admin.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/res/css/style.css\" />\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"/>\r\n");
      out.write("<title>babasport-list</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"box-positon\">\r\n");
      out.write("\t<div class=\"rpos\">当前位置: 订单管理 - 列表</div>\r\n");
      out.write("\t<div class=\"clear\"></div>\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"body-box\">\r\n");
      out.write("<input type=\"hidden\" name=\"pageNo\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageNo}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("<form method=\"post\" id=\"tableForm\">\r\n");
      out.write("<input type=\"hidden\" value=\"\" name=\"pageNo\"/>\r\n");
      out.write("<input type=\"hidden\" value=\"\" name=\"queryName\"/>\r\n");
      out.write("<table cellspacing=\"1\" cellpadding=\"0\" border=\"0\" width=\"100%\" class=\"pn-ltable\">\r\n");
      out.write("\t<thead class=\"pn-lthead\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th width=\"20\"><input type=\"checkbox\" onclick=\"Pn.checkbox('ids',this.checked)\"/></th>\r\n");
      out.write("\t\t\t<th>订单号</th>\r\n");
      out.write("\t\t\t<th>订单金额</th>\r\n");
      out.write("\t\t\t<th>运费</th>\r\n");
      out.write("\t\t\t<th>应付金额</th>\r\n");
      out.write("\t\t\t<th>支付方式</th>\r\n");
      out.write("\t\t\t<th>支付要求</th>\r\n");
      out.write("\t\t\t<th>支付状态</th>\r\n");
      out.write("\t\t\t<th>订单状态</th>\r\n");
      out.write("\t\t\t<th>下单时间</th>\r\n");
      out.write("\t\t\t<th>备注</th>\r\n");
      out.write("\t\t\t<th>操作选项</th>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</thead>\r\n");
      out.write("\t<tbody class=\"pn-ltbody\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<tr bgcolor=\"#ffffff\" onmouseover=\"this.bgColor='#eeeeee'\" onmouseout=\"this.bgColor='#ffffff'\">\r\n");
      out.write("\t\t\t<td><input type=\"checkbox\" name=\"ids\" value=\"73\"/></td>\r\n");
      out.write("\t\t\t<td align=\"center\">20--20141212114007973</td>\r\n");
      out.write("\t\t\t<td align=\"center\">128.0</td>\r\n");
      out.write("\t\t\t<td align=\"center\">0.0</td>\r\n");
      out.write("\t\t\t<td align=\"center\">128.11</td>\r\n");
      out.write("\t\t\t<td align=\"center\">货到到付</td>\r\n");
      out.write("\t\t\t<td align=\"center\">现金</td>\r\n");
      out.write("\t\t\t<td align=\"center\">货到到付</td>\r\n");
      out.write("\t\t\t<td align=\"center\">提交订单</td>\r\n");
      out.write("\t\t\t<td align=\"center\">2014-12-12 11:40:08.0</td>\r\n");
      out.write("\t\t\t<td align=\"center\"></td>\r\n");
      out.write("\t\t\t<td align=\"center\">\r\n");
      out.write("\t\t\t<a href=\"view.jsp\" class=\"pn-opt\">查看</a>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<tr bgcolor=\"#ffffff\" onmouseover=\"this.bgColor='#eeeeee'\" onmouseout=\"this.bgColor='#ffffff'\">\r\n");
      out.write("\t\t\t<td><input type=\"checkbox\" name=\"ids\" value=\"73\"/></td>\r\n");
      out.write("\t\t\t<td align=\"center\">26--20141212170911104</td>\r\n");
      out.write("\t\t\t<td align=\"center\">128.0</td>\r\n");
      out.write("\t\t\t<td align=\"center\">0.0</td>\r\n");
      out.write("\t\t\t<td align=\"center\">128.0</td>\r\n");
      out.write("\t\t\t<td align=\"center\">货到到付</td>\r\n");
      out.write("\t\t\t<td align=\"center\">现金</td>\r\n");
      out.write("\t\t\t<td align=\"center\">货到到付</td>\r\n");
      out.write("\t\t\t<td align=\"center\">提交订单</td>\r\n");
      out.write("\t\t\t<td align=\"center\">2014-12-12 17:09:11.0</td>\r\n");
      out.write("\t\t\t<td align=\"center\"></td>\r\n");
      out.write("\t\t\t<td align=\"center\">\r\n");
      out.write("\t\t\t<a href=\"view.jsp\" class=\"pn-opt\">查看</a>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<tr bgcolor=\"#ffffff\" onmouseover=\"this.bgColor='#eeeeee'\" onmouseout=\"this.bgColor='#ffffff'\">\r\n");
      out.write("\t\t\t<td><input type=\"checkbox\" name=\"ids\" value=\"73\"/></td>\r\n");
      out.write("\t\t\t<td align=\"center\">33--20141212172259427</td>\r\n");
      out.write("\t\t\t<td align=\"center\">328.0</td>\r\n");
      out.write("\t\t\t<td align=\"center\">0.0</td>\r\n");
      out.write("\t\t\t<td align=\"center\">328.0</td>\r\n");
      out.write("\t\t\t<td align=\"center\">货到到付</td>\r\n");
      out.write("\t\t\t<td align=\"center\">现金</td>\r\n");
      out.write("\t\t\t<td align=\"center\">货到到付</td>\r\n");
      out.write("\t\t\t<td align=\"center\">提交订单</td>\r\n");
      out.write("\t\t\t<td align=\"center\">2014-12-12 17:22:59.0</td>\r\n");
      out.write("\t\t\t<td align=\"center\"></td>\r\n");
      out.write("\t\t\t<td align=\"center\">\r\n");
      out.write("\t\t\t<a href=\"view.jsp\" class=\"pn-opt\">查看</a>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<tr bgcolor=\"#ffffff\" onmouseover=\"this.bgColor='#eeeeee'\" onmouseout=\"this.bgColor='#ffffff'\">\r\n");
      out.write("\t\t\t<td><input type=\"checkbox\" name=\"ids\" value=\"73\"/></td>\r\n");
      out.write("\t\t\t<td align=\"center\">34--20141212172311831</td>\r\n");
      out.write("\t\t\t<td align=\"center\">200.0</td>\r\n");
      out.write("\t\t\t<td align=\"center\">0.0</td>\r\n");
      out.write("\t\t\t<td align=\"center\">200.0</td>\r\n");
      out.write("\t\t\t<td align=\"center\">货到到付</td>\r\n");
      out.write("\t\t\t<td align=\"center\">现金</td>\r\n");
      out.write("\t\t\t<td align=\"center\">货到到付</td>\r\n");
      out.write("\t\t\t<td align=\"center\">提交订单</td>\r\n");
      out.write("\t\t\t<td align=\"center\">2014-12-12 17:23:11.0</td>\r\n");
      out.write("\t\t\t<td align=\"center\"></td>\r\n");
      out.write("\t\t\t<td align=\"center\">\r\n");
      out.write("\t\t\t<a href=\"view.jsp\" class=\"pn-opt\">查看</a>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t\r\n");
      out.write("\t</tbody>\r\n");
      out.write("</table>\r\n");
      out.write("<div style=\"margin-top:15px;\">\r\n");
      out.write("<!-- \t<input class=\"del-button\" type=\"button\" value=\"取消\" onclick=\"optCancel();\"/>\r\n");
      out.write("\t<input class=\"submit\" type=\"button\" value=\"通过\" onclick=\"optPass();\"/> -->\r\n");
      out.write("</div>\r\n");
      out.write("</form>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}