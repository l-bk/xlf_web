/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.user.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.user.entity.XlfUser;

/**
 * 用户信息模块DAO接口
 * @author lbk
 * @version 2017-12-16
 */
@MyBatisDao
public interface XlfUserDao extends CrudDao<XlfUser> {
	
}