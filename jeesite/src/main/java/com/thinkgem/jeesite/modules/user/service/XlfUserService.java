/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.user.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.user.entity.XlfUser;
import com.thinkgem.jeesite.modules.user.dao.XlfUserDao;

/**
 * 用户信息模块Service
 * @author lbk
 * @version 2017-12-16
 */
@Service
@Transactional(readOnly = true)
public class XlfUserService extends CrudService<XlfUserDao, XlfUser> {

	public XlfUser get(String id) {
		return super.get(id);
	}
	
	public List<XlfUser> findList(XlfUser xlfUser) {
		return super.findList(xlfUser);
	}
	
	public Page<XlfUser> findPage(Page<XlfUser> page, XlfUser xlfUser) {
		return super.findPage(page, xlfUser);
	}
	
	@Transactional(readOnly = false)
	public void save(XlfUser xlfUser) {
		super.save(xlfUser);
	}
	
	@Transactional(readOnly = false)
	public void delete(XlfUser xlfUser) {
		super.delete(xlfUser);
	}
	
}