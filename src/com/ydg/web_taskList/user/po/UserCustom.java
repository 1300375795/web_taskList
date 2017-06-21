package com.ydg.web_taskList.user.po;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * User的增强类
 * @author 叶德国
 *
 */
public class UserCustom extends User implements Nullable {
	private String cookie;//用于判断是否需要保存账号密码

	public UserCustom() {
		super();
	}
	
	public UserCustom(String cookie) {
		super();
		this.cookie = cookie;
	}

	
	public String getCookie() {
		return cookie;
	}

	public void setCookie(String cookie) {
		this.cookie = cookie;
	}

	/**
	 * 判断是否为空对象
	 */
	@Override
	public boolean isnull() throws Exception {
		return false;
	}
	
	/**
	 * 增强类的转发方法
	 * 1.设置session
	 * 2.设置cookie
	 * 3.转发到主界面
	 */
	public void forward(User formUserCustom, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.getSession().setAttribute("sessionUser", this);
		// Cookie cookie = new Cookie("username",this.getUsername());
		request.getRequestDispatcher("/WEB-INF/jsps/main/main.jsp").forward(
				request, response);
	}

}
