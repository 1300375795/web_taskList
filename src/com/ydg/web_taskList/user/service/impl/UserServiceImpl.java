package com.ydg.web_taskList.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.ydg.web_taskList.user.mapper.UserCustomMapper;
import com.ydg.web_taskList.user.po.NullUser;
import com.ydg.web_taskList.user.po.User;
import com.ydg.web_taskList.user.service.UserService;

/**
 * UserService的实现类
 * @author admin
 *
 */
public class UserServiceImpl implements UserService {
	@Autowired
	private UserCustomMapper userCustomMapper;
	
	/**
	 * 通过uid或者账号密码查询User
	 * 1.判断是否为空是的话返回NullUser
	 * 2.不是的话返回UserCustom
	 * @param formUserCustom
	 * @return
	 * @throws Exception
	 */
	@Override
	public User getUser(User formUserCustom) throws Exception {
		User user = userCustomMapper.getUser(formUserCustom);
		if (user == null) {
			return NullUser.newNullUser();
		}
		return user;
	}
}
