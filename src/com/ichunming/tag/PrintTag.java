/**
 * print tag
 * 2015/08/19
 * chunming
 */
package com.ichunming.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class PrintTag extends TagSupport {

	private static final long serialVersionUID = -2489044288170153940L;

	/**
	 * default constructor
	 */
	public PrintTag() {
		super();
		init();
	};

    private void init() {
        value = null;
        flg = false;
    }
	
	@Override
	public int doStartTag() throws JspException {
		try {
			if(null != value) {
				pageContext.getOut().write(value.toString());
				return SKIP_BODY;
			}else {
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		if(!flg) {
			return SKIP_BODY;
		}
		return EVAL_BODY_INCLUDE;
	}
	
	public void setValue(Object value) {
		this.value = value;
	}
	public void setFlg(boolean flg) {
		this.flg = flg;
	}
	
	private Object value;
	private boolean flg;
}
