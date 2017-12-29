/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.pic.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.pic.entity.XlfActPic;
import com.thinkgem.jeesite.modules.pic.dao.XlfActPicDao;

/**
 * 图片信息Service
 * @author lbk
 * @version 2017-12-29
 */
@Service
@Transactional(readOnly = true)
public class XlfActPicService extends CrudService<XlfActPicDao, XlfActPic> {

	public XlfActPic get(String id) {
		return super.get(id);
	}
	
	public List<XlfActPic> findList(XlfActPic xlfActPic) {
		return super.findList(xlfActPic);
	}
	
	public Page<XlfActPic> findPage(Page<XlfActPic> page, XlfActPic xlfActPic) {
		return super.findPage(page, xlfActPic);
	}
	
	@Transactional(readOnly = false)
	public void save(XlfActPic xlfActPic) {
		super.save(xlfActPic);
	}
	
	@Transactional(readOnly = false)
	public void delete(XlfActPic xlfActPic) {
		super.delete(xlfActPic);
	}
	
}