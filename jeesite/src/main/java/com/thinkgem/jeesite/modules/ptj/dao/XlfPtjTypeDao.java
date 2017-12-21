/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.ptj.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.ptj.entity.XlfPtjType;

/**
 * 兼职类型信息管理DAO接口
 * @author lbk
 * @version 2017-12-08
 */
@MyBatisDao
public interface XlfPtjTypeDao extends CrudDao<XlfPtjType> {
	
}