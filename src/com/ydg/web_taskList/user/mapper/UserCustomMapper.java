package com.ydg.web_taskList.user.mapper;

import com.ydg.web_taskList.user.po.User;
import com.ydg.web_taskList.user.po.UserCustom;

/**
 * 增强类的Mapper
 * @author 叶德国
 *
 */
public interface UserCustomMapper {
	/**
	 * 通过账号密码或者uid查询User
	 * @param formUserCustom
	 * @return
	 * @throws Exception
	 */
	public User getUser(User formUserCustom) throws Exception;
}