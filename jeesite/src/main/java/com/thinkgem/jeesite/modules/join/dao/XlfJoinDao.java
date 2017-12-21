/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.join.dao;

import java.util.List;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.join.entity.XlfJoin;

/**
 * 报名信息DAO接口
 * @author lbk
 * @version 2017-12-14
 */
@MyBatisDao
public interface XlfJoinDao extends CrudDao<XlfJoin> {
	int selectCoumnApply(XlfJoin xlfJoin);
	
	List <XlfJoin> selectByUserAndModule(XlfJoin xlfJoin);
}