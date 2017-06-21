package com.ydg.web_taskList.user.service;

import com.ydg.web_taskList.user.po.User;
import com.ydg.web_taskList.user.po.UserCustom;

/**
 * Service层接口
 * @author admin
 *
 */
public interface UserService {
	/**
	 * 通过uid或者账号密码查询User
	 * @param formUserCustom
	 * @return
	 * @throws Exception
	 */
	public User getUser(User formUserCustom) throws Exception;
}
