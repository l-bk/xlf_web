/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.area.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.area.entity.XlfArea;

/**
 * 区域管理DAO接口
 * @author lbk
 * @version 2017-12-08
 */
@MyBatisDao
public interface XlfAreaDao extends CrudDao<XlfArea> {
	public int updateByCity(XlfArea xlfArea);
	
	public XlfArea selectByArea(XlfArea xlfArea);
}