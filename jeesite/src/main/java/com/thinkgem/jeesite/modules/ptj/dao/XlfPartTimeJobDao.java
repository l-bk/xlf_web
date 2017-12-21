/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.ptj.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.ptj.entity.XlfPartTimeJob;

/**
 * 兼职信息DAO接口
 * @author lbk
 * @version 2017-12-10
 */
@MyBatisDao
public interface XlfPartTimeJobDao extends CrudDao<XlfPartTimeJob> {
	int updateStatus(XlfPartTimeJob xlfPartTimeJob);
}