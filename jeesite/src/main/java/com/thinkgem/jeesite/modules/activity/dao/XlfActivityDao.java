/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.activity.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.activity.entity.XlfActivity;

/**
 * 活动信息管理DAO接口
 * @author lbk
 * @version 2017-12-12
 */
@MyBatisDao
public interface XlfActivityDao extends CrudDao<XlfActivity> {
	XlfActivity selectByActId(Integer id);
	
	int updateStatus(XlfActivity xlfActivity);
}