/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-11-01 03:49:08 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.back_005fpage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class right_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>babasport-right</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("  \t    <div class=\"box-positon\">\r\n");
      out.write("        \t <h1>当前位置: 首页 - 欢迎页</h1>\r\n");
      out.write("        </div>\r\n");
      out.write("<div class=\"body-box\">\r\n");
      out.write("        <div class=\"welcom-con\">\r\n");
      out.write("        \t <div class=\"we-txt\">\r\n");
      out.write("             \t  <p>\r\n");
      out.write("                  欢迎使用新巴巴运动网的管理系统！<br />\r\n");
      out.write("                  新巴巴运动网的程序版本： babasportv1.0 【<a href=\"http://localhost:8080\" target=\"_blank\">查看最新版本</a>】<br />\r\n");
      out.write("                  您上次登录的时间是：2014-10-15 <br />\r\n");
      out.write("                  已用内存：<span style=\"color:#0078ff;\">100MB</span>&nbsp;&nbsp;&nbsp;&nbsp;剩余内存：<span style=\"color:#ff8400;\">100MB </span>&nbsp;&nbsp;&nbsp;&nbsp;最大内存：<span style=\"color:#00ac41;\">200MB</span>\r\n");
      out.write("                  </p>\r\n");
      out.write("             </div>\r\n");
      out.write("             <ul class=\"ms\">\r\n");
      out.write("             \t<li class=\"wxx\">访问量</li><li class=\"attribute\">　　　系统属性</li>\r\n");
      out.write("             </ul>\r\n");
      out.write("             <div class=\"ms-xx\">\r\n");
      out.write("                 <div class=\"xx-xx\">\r\n");
      out.write("             \t      <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("             \t       <tr>\r\n");
      out.write("                        <td width=\"20%\" height=\"30\" align=\"right\"></td>\r\n");
      out.write("                        <td width=\"25%\"><b>PV</b></td>\r\n");
      out.write("                        <td width=\"25%\"><b>IP</b></td>\r\n");
      out.write("                        <td width=\"30%\"><b>独立访客</b></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                      <tr>\r\n");
      out.write("                        <td height=\"30\" align=\"right\">今日：</td>\r\n");
      out.write("                     \t<td>0</td>\r\n");
      out.write("                     \t<td>0</td>\r\n");
      out.write("                     \t<td>0</td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                      <tr>\r\n");
      out.write("                        <td height=\"30\" align=\"right\">昨日：</td>\r\n");
      out.write("            \t\t\t<td>0</td>\r\n");
      out.write("                     \t<td>0</td>\r\n");
      out.write("                     \t<td>0</td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                      <tr>\r\n");
      out.write("                        <td height=\"30\" align=\"right\">本周：</td>\r\n");
      out.write("                  \t\t<td>0</td>\r\n");
      out.write("                     \t<td>0</td>\r\n");
      out.write("                     \t<td>0</td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                      <tr>\r\n");
      out.write("                        <td height=\"30\" align=\"right\">本月：</td>\r\n");
      out.write("                  \t\t<td>0</td>\r\n");
      out.write("                     \t<td>0</td>\r\n");
      out.write("                     \t<td>0</td>\r\n");
      out.write("                     </tr>\r\n");
      out.write("                     <tr>\r\n");
      out.write("                        <td height=\"30\" align=\"right\">累计：</td>\r\n");
      out.write("                  \t\t<td>0</td>\r\n");
      out.write("                     \t<td>0</td>\r\n");
      out.write("                     \t<td>0</td>\r\n");
      out.write("                     </tr>\r\n");
      out.write("               </table>\r\n");
      out.write("                 </div>\r\n");
      out.write("                 <div class=\"attribute-xx\" style=\"float:left\">\r\n");
      out.write("                 \t  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("                          <tr>\r\n");
      out.write("                            <td width=\"30%\" height=\"30\" align=\"right\">操作系统版本：</td>\r\n");
      out.write("                            <td height=\"30\"><span class=\"black\">window 7</span></td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                          <tr>\r\n");
      out.write("                            <td width=\"30%\" height=\"30\" align=\"right\">操作系统类型：</td>\r\n");
      out.write("                            <td height=\"30\"><span class=\"black\">64位</span> </td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                          <tr>\r\n");
      out.write("                            <td width=\"30%\" height=\"30\" align=\"right\">用户、目录：</td>\r\n");
      out.write("                            <td height=\"30\"><span class=\"black\"></span></td>\r\n");
      out.write("                        </tr><tr>\r\n");
      out.write("                            <td width=\"30%\" height=\"30\" align=\"right\">JAVA运行环境：</td>\r\n");
      out.write("                            <td height=\"30\"><span></span></td>\r\n");
      out.write("                          </tr>\r\n");
      out.write("                          <tr>\r\n");
      out.write("                            <td width=\"30%\" height=\"30\" align=\"right\">JAVA虚拟机：</td>\r\n");
      out.write("                            <td height=\"30\"> <span></span></td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                   </table>  \r\n");
      out.write("               </div>\r\n");
      out.write("\r\n");
      out.write("             </div>\r\n");
      out.write("             \r\n");
      out.write("  </div>\r\n");
      out.write(" </div>\r\n");
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
