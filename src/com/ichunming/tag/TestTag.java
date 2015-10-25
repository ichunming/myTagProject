/**
 * test tag
 * 2015/08/19
 * chunming
 */
package com.ichunming.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class TestTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7911478045637805858L;

	/**
	 * default constructor
	 */
	public TestTag() {};

	@Override
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try {
			String msg = "test tag!";
			if(null != attr) {
				msg = msg + attr;
			}
			out.write(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//return SKIP_BODY
		return EVAL_BODY_INCLUDE;
	}

	@Override
	public int doEndTag() throws JspException {
		//return EVAL_PAGE;
		return SKIP_PAGE;
	}

	public String attr;

	//need set method
	public void setAttr(String attr) {
		this.attr = attr;
	}
}
