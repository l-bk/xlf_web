/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.pic.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.pic.entity.XlfActPicType;
import com.thinkgem.jeesite.modules.pic.dao.XlfActPicTypeDao;

/**
 * 图片类型Service
 * @author lbk
 * @version 2017-12-29
 */
@Service
@Transactional(readOnly = true)
public class XlfActPicTypeService extends CrudService<XlfActPicTypeDao, XlfActPicType> {

	public XlfActPicType get(String id) {
		return super.get(id);
	}
	
	public List<XlfActPicType> findList(XlfActPicType xlfActPicType) {
		return super.findList(xlfActPicType);
	}
	
	public Page<XlfActPicType> findPage(Page<XlfActPicType> page, XlfActPicType xlfActPicType) {
		return super.findPage(page, xlfActPicType);
	}
	
	@Transactional(readOnly = false)
	public void save(XlfActPicType xlfActPicType) {
		super.save(xlfActPicType);
	}
	
	@Transactional(readOnly = false)
	public void delete(XlfActPicType xlfActPicType) {
		super.delete(xlfActPicType);
	}
	
}