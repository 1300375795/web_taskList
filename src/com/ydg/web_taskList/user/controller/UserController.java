package com.ydg.web_taskList.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ydg.web_taskList.user.po.User;
import com.ydg.web_taskList.user.po.UserCustom;
import com.ydg.web_taskList.user.service.impl.UserServiceImpl;
import com.ydg.web_taskList.user.validated.validatedGroup1;

/**
 * 用户模块相关的功能实现
 * @author 叶德国
 *
 */
@Controller
public class UserController {
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	/**
	 * 登录功能的实现方法
	 * 1.判断用户填写的信息是否有错误，有的话转发回登录页面
	 * 2.通过用户填写的信息查询数据库是否有这个用户存在，有的话返回UserCustom没有的话返回NullUser
	 * 3.调用user的forward方法，将用户填写的信息传递过去(NullUser需要回写)
	 * @param formUserCustom
	 * @param bindingResult
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/login.action")
	public void login(
			@Validated(value = { validatedGroup1.class }) UserCustom formUserCustom,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (isError(formUserCustom, bindingResult, request, response)) {
			return;
		}

		User user = userServiceImpl.getUser(formUserCustom);

		user.forward(formUserCustom,request, response);
	}

	/**
	 * 判断用户填写的信息是否有错误的方法
	 * 1.判断是否有错误
	 * 2.有的话调用具体的验证的方法
	 * 3.返回是否存在错误的boolean值
	 * @param formUserCustom
	 * @param bindingResult
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	private boolean isError(User formUserCustom, BindingResult bindingResult,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (bindingResult.hasErrors()) {
			validateUser(formUserCustom, bindingResult, request, response);
		}
		return bindingResult.hasErrors();
	}
	
	/**
	 * 错误信息的具体的验证的方法
	 * 1.得到全部的错误信息的集合
	 * 2.遍历全部的错误信息对象
	 * 3.将错误信息设置到request中用于显示在jsp页面
	 * 4.转发回登录页面
	 * @param formUserCustom
	 * @param bindingResult
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	private void validateUser(User formUserCustom, BindingResult bindingResult,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 如果没有通过,跳转提示
		List<FieldError> list = bindingResult.getFieldErrors();
		for (FieldError error : list) {
			setAttribute(error, formUserCustom, request);
		}
		forward(request, response);
	}
	
	/**
	 * 错误信息的保存方法
	 * 1.保存错误信息
	 * 2.保存用户填写的信息用户回写
	 * @param error
	 * @param formUserCustom
	 * @param request
	 */
	private void setAttribute(FieldError error, User formUserCustom,
			HttpServletRequest request) {
		request.setAttribute(error.getField(), error.getDefaultMessage());
		request.setAttribute("user", formUserCustom);
	}
	
	/**
	 * 转发回登录页面
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	private void forward(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.getRequestDispatcher("/WEB-INF/jsps/user/login.jsp").forward(
				request, response);
	}
	
	/**
	 * 注册页面还没写
	 * @return
	 */
	@RequestMapping(value = "/regist.action")
	public String regist() {
		return "user/regist";
	}
}
