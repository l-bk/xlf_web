/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.join.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.join.entity.XlfJoin;
import com.thinkgem.jeesite.modules.join.dao.XlfJoinDao;

/**
 * 报名信息Service
 * @author lbk
 * @version 2017-12-14
 */
@Service
@Transactional(readOnly = true)
public class XlfJoinService extends CrudService<XlfJoinDao, XlfJoin> {

	@Autowired
	private XlfJoinDao xlfJoinDao;
	
	public XlfJoin get(String id) {
		return super.get(id);
	}
	
	public List<XlfJoin> findList(XlfJoin xlfJoin) {
		return super.findList(xlfJoin);
	}
	
	public Page<XlfJoin> findPage(Page<XlfJoin> page, XlfJoin xlfJoin) {
		return super.findPage(page, xlfJoin);
	}
	
	@Transactional(readOnly = false)
	public void save(XlfJoin xlfJoin) {
		super.save(xlfJoin);
	}
	
	@Transactional(readOnly = false)
	public void delete(XlfJoin xlfJoin) {
		super.delete(xlfJoin);
	}
	
	public int selectCoumnApply(XlfJoin xlfJoin) {
		return xlfJoinDao.selectCoumnApply(xlfJoin);
	}

	public Page<XlfJoin> selectByUserAndModule(Page<XlfJoin> page, XlfJoin entity) {
		entity.setPage(page);
		page.setList(xlfJoinDao.selectByUserAndModule(entity));
		return page;
	}
	
}