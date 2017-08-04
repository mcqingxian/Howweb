package com.hoau.how.module.util.tag;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class PagerTag extends TagSupport {

	private String url; // 请求URI
	private int pageSize = 5; // 每页要显示的记录数
	private int pageNo = 1; // 当前页号
	private int recordCount; // 总记录数

	@Override
	public int doStartTag() throws JspException {
		if (pageSize == 0) {
			pageSize = 1;
		}
		int pageCount = (recordCount + pageSize - 1) / pageSize; // 计算总页数
		// 拼写要输出到页面的HTML文本
		StringBuilder sb = new StringBuilder();
		// sb.append("<style type=\"text/css\">");
		// sb.append(".pagination {padding: 5px;float:right;font-size:12px;}");
		// sb.append(".pagination a, .pagination a:link, .pagination a:visited {padding:2px 5px;margin:2px;border:1px solid #aaaadd;text-decoration:none;color:#006699;}");
		// sb.append(".pagination a:hover, .pagination a:active {border: 1px solid #ff0000;color: #000;text-decoration: none;}");
		// sb.append(".pagination span.current {padding: 2px 5px;margin: 2px;border: 1px solid #ff0000;font-weight: bold;background-color: #ff0000;color: #FFF;}");
		// sb.append(".pagination span.disabled {padding: 2px 5px;margin: 2px;border: 1px solid #eee; color: #ddd;}");
		// sb.append("</style>\r\n");
		// sb.append("<div class=\"pagination\">\r\n");
		sb.append("<div class=\"scott mt15\">\r\n");
		if (recordCount == 0) {
			sb.append("<strong>没有可显示的项目</strong>\r\n");
		} else {
			// 页号越界处理
			if (pageNo > pageCount) {
				pageNo = pageCount;
			}
			if (pageNo < 1) {
				pageNo = 1;
			}

			// 表单请求地址：url
			sb.append("<form method=\"post\" action=\"").append(this.url)
					.append("\" name=\"qPagerForm\">\r\n");

			// 获取请求中的所有参数
			HttpServletRequest request = (HttpServletRequest) pageContext
					.getRequest();
			Enumeration<String> enumeration = request.getParameterNames();
			String name = null; // 参数名
			String value = null; // 参数值
			// 把请求中的所有参数当作隐藏表单域 如 <input type="hidden" name="pageNo" value="1"/>
			while (enumeration.hasMoreElements()) {
				name = enumeration.nextElement();
				value = request.getParameter(name);
				// 去除页号
				if (name.equals("pageNo")) {
					if (null != value && !"".equals(value)) {
						pageNo = Integer.parseInt(value);
					}
					continue;
				}
				sb.append("<input type=\"hidden\" name=\"").append(name)
						.append("\" value=\"").append(value).append("\"/>\r\n");
			}

			// 把当前页号设置成请求参数
			sb.append("<input type=\"hidden\" name=\"").append("pageNo")
					.append("\" value=\"").append(pageNo).append("\"/>\r\n");
			// 共244条 10条/页
			sb.append("<span class=\"pageBox-info\">共").append(recordCount)
					.append("条 ").append(pageCount).append("页</span>");

			// 上一页处理
			if (pageNo == 1) {
				sb.append("<span class=\"disabled\">&lt;上一页</span>\r\n");
			} else {
				sb.append("<a href=\"javascript:turnOverPage(")
						.append((pageNo - 1)).append(")\">&lt;上一页</a>\r\n");
			}

			// 中间页码处理 start:当前页的前一页
			int start = 1;
			if (this.pageNo > 4) {
				// 如果前面页数过多,第1,2显示,跟着显示"..."
				start = this.pageNo - 1;
				sb.append("<a href=\"javascript:turnOverPage(1)\">1</a>\r\n");
				sb.append("<a href=\"javascript:turnOverPage(2)\">2</a>\r\n");
				sb.append("&hellip;\r\n");
			}
			// 中间页码处理 start:当前页的后一页
			int end = this.pageNo + 1;
			if (end > pageCount) {
				// 当前页码的下一页码>总页码是，显示总页码
				end = pageCount;
			}
			// 显示当前页附近的页
			for (int i = start; i <= end; i++) {
				if (pageNo == i) { // 当前页号不需要超链接
					sb.append("<span class=\"current\">").append(i)
							.append("</span>\r\n");
				} else {
					sb.append("<a href=\"javascript:turnOverPage(").append(i)
							.append(")\">").append(i).append("</a>\r\n");
				}
			}
			// 如果后面页数过多,显示"..."
			if (end < pageCount - 2) {
				sb.append("&hellip;\r\n");
			}

			// 显示最后两页页码
			if (end < pageCount - 1) {
				sb.append("<a href=\"javascript:turnOverPage(")
						.append(pageCount - 1).append(")\">")
						.append(pageCount - 1).append("</a>\r\n");
			}
			if (end < pageCount) {
				sb.append("<a href=\"javascript:turnOverPage(")
						.append(pageCount).append(")\">").append(pageCount)
						.append("</a>\r\n");
			}

			// 下一页处理
			if (pageNo == pageCount) {
				sb.append("<span class=\"disabled\">下一页&gt;").append(
						"</span>\r\n");
			} else {
				sb.append("<a href=\"javascript:turnOverPage(")
						.append((pageNo + 1)).append(")\">下一页&gt</a>\r\n");
			}
			sb.append("<span class=\"scott_sel\">\r\n到<input value=\"")
					.append(pageNo)
					.append("\" id=\"txtPageNum\" type=\"text\" />页\r\n</span>");
			sb.append("<input type=\"button\" class=\"submit tosnmiddle_btn\" onclick=\"javascript:turnOverPage($('#txtPageNum').val())\" value=\"确定\" style=\"width:60px;\"/>\r\n");
			sb.append("</form>\r\n");

			// 生成提交表单的JS
			sb.append("<script language=\"javascript\">\r\n");
			sb.append("  function turnOverPage(no){\r\n");
			sb.append("if(!isNaN(no)){\r\n");
			sb.append("    if(no>").append(pageCount).append("){");
			sb.append("      no=").append(pageCount).append(";}\r\n");
			sb.append("    if(no<1){no=1;}\r\n");
			sb.append("    document.qPagerForm.pageNo.value=no;\r\n");
			sb.append("    document.qPagerForm.submit();\r\n");
			sb.append("  }\r\n");
			sb.append("  }\r\n");
			sb.append("</script>\r\n");
		}
		sb.append("</div>\r\n");

		// 把生成的HTML输出到响应中
		try {
			pageContext.getOut().println(sb.toString());
		} catch (IOException e) {
			throw new JspException(e);
		}
		return SKIP_BODY; // 本标签主体为空,所以直接跳过主体 告诉服务器不要处理正文内容

	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
}
