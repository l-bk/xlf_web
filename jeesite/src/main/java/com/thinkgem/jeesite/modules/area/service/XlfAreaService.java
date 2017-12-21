/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.area.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.area.entity.XlfArea;
import com.thinkgem.jeesite.modules.area.dao.XlfAreaDao;

/**
 * 区域管理Service
 * @author lbk
 * @version 2017-12-08
 */
@Service
@Transactional(readOnly = true)
public class XlfAreaService extends CrudService<XlfAreaDao, XlfArea> {

	@Autowired
	private XlfAreaDao xlfAreaDao;
	
	public XlfArea get(String id) {
		return super.get(id);
	}
	
	public List<XlfArea> findList(XlfArea xlfArea) {
		return super.findList(xlfArea);
	}
	
	public Page<XlfArea> findPage(Page<XlfArea> page, XlfArea xlfArea) {
		if(StringUtils.isNotEmpty(xlfArea.getCityFirst())) {
			xlfArea.setCityFirst(xlfArea.getCityFirst().toUpperCase());
		}
		return super.findPage(page, xlfArea);
	}
	
	@Transactional(readOnly = false)
	public void save(XlfArea xlfArea) {
		if(xlfArea.getAreaId() != null && !"".equals(xlfArea.getAreaId()) ) {
			xlfArea.setId(String.valueOf(xlfArea.getAreaId()));
		}
		if(StringUtils.isNotEmpty(xlfArea.getCityFirst())) {
			xlfArea.setCityFirst(xlfArea.getCityFirst().toUpperCase());
		}
		super.save(xlfArea);
		xlfAreaDao.updateByCity(xlfArea);
	}
	
	@Transactional(readOnly = false)
	public void delete(XlfArea xlfArea) {
		super.delete(xlfArea);
	}
	
}