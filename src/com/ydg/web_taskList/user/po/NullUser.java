package com.ydg.web_taskList.user.po;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * User的空对象类
 * @author 叶德国
 *
 */
public class NullUser extends User implements Nullable {
	
	/**
	 * NullUser工厂
	 * @return
	 */
	public static NullUser newNullUser() throws Exception {
		return new NullUser();
	}

	/**
	 * 判断是否为空对象
	 */
	@Override
	public boolean isnull() throws Exception  {
		return true;
	}


	/**
	 * 空对象的转发页面
	 *1.保存用户填写的信息到request
	 *2.保存错误信息
	 *3.转发回登录页面
	 */
	public void forward(User formUserCustom, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setAttribute("user", formUserCustom);
		request.setAttribute("username", "用户名或者密码错误");
		request.getRequestDispatcher("/WEB-INF/jsps/user/login.jsp").forward(
				request, response);
	}
}
