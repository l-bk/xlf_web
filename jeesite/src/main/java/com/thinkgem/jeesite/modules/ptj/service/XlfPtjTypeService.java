/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.ptj.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.ptj.entity.XlfPtjType;
import com.thinkgem.jeesite.modules.ptj.dao.XlfPtjTypeDao;

/**
 * 兼职类型信息管理Service
 * @author lbk
 * @version 2017-12-08
 */
@Service
@Transactional(readOnly = true)
public class XlfPtjTypeService extends CrudService<XlfPtjTypeDao, XlfPtjType> {

	public XlfPtjType get(String id) {
		return super.get(id);
	}
	
	public List<XlfPtjType> findList(XlfPtjType xlfPtjType) {
		return super.findList(xlfPtjType);
	}
	
	public Page<XlfPtjType> findPage(Page<XlfPtjType> page, XlfPtjType xlfPtjType) {
		return super.findPage(page, xlfPtjType);
	}
	
	@Transactional(readOnly = false)
	public void save(XlfPtjType xlfPtjType) {
		super.save(xlfPtjType);
	}
	
	@Transactional(readOnly = false)
	public void delete(XlfPtjType xlfPtjType) {
		super.delete(xlfPtjType);
	}
	
}