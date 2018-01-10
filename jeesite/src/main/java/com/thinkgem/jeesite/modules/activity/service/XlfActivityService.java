/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.activity.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.common.utils.Encodes;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.activity.entity.XlfActivity;
import com.thinkgem.jeesite.modules.activity.dao.XlfActivityDao;

/**
 * 活动信息管理Service
 * @author lbk
 * @version 2017-12-12
 */
@Service
@Transactional(readOnly = true)
public class XlfActivityService extends CrudService<XlfActivityDao, XlfActivity> {

	@Autowired
	private XlfActivityDao activityDao;

	public XlfActivity get(String id) {
		return super.get(id);
	}

	public List<XlfActivity> findList(XlfActivity xlfActivity) {
		return super.findList(xlfActivity);
	}

	public Page<XlfActivity> findPage(Page<XlfActivity> page, XlfActivity xlfActivity) {
		return super.findPage(page, xlfActivity);
	}

	@Transactional(readOnly = false)
	public void save(XlfActivity xlfActivity) {
		if(xlfActivity.getActId() != null){//修改
			xlfActivity.setId(String.valueOf(xlfActivity.getActId()));
			XlfActivity act=activityDao.get(String.valueOf(xlfActivity.getActId()));

			//给图片拼接完整路径。添加直接sql拼接。修改判断是否有域名存在。
//			if(StringUtils.isNotBlank(xlfActivity.getPic())){
//				if(!xlfActivity.getPic().contains("https://www.xianlaifeng.com")){
//					xlfActivity.setPic("https://www.xianlaifeng.com"+xlfActivity.getPic());
//				}
//			}
//			if(StringUtils.isNotBlank(xlfActivity.getDetails())) {
//				String details=Encodes.unescapeHtml(xlfActivity.getDetails());
//				if(details.contains("<img")) {
//					details=details.replace("src=\"/", "src=\\\"https://www.xianlaifeng.com/");
//					xlfActivity.setDetails(details);
//				}
//			}
			
		}
//		else {
			//给富文本中的图片拼完整域名
//			if(StringUtils.isNotBlank(xlfActivity.getDetails())) {
//				String details=Encodes.unescapeHtml(xlfActivity.getDetails());
//				if(details.contains("<img") && !details.contains("https://www.xianlaifeng.com") ) {
//					details=details.replace("src=\"","src=\"https://www.xianlaifeng.com");
//					xlfActivity.setDetails(details);
//				}
//			}
//		}
		
		
		if(StringUtils.isNotBlank(xlfActivity.getProvince())){
			if(!xlfActivity.getProvince().endsWith("省")){
				xlfActivity.setProvince(xlfActivity.getProvince()+"省");
			}
		}
		
		if(StringUtils.isNotBlank(xlfActivity.getCity())){
			if(!xlfActivity.getCity().endsWith("市")){
				xlfActivity.setCity(xlfActivity.getCity()+"市");
			}
		}
		
		if(StringUtils.isNotBlank(xlfActivity.getDistrict())){
			if(!xlfActivity.getDistrict().endsWith("区")){
				xlfActivity.setDistrict(xlfActivity.getDistrict()+"区");
			}
		}
		
		xlfActivity.setCreateTime(new Date());
		xlfActivity.setStatus("1");
		xlfActivity.setCreateUser(10001);
		super.save(xlfActivity);
	}

	@Transactional(readOnly = false)
	public void delete(XlfActivity xlfActivity) {
		super.delete(xlfActivity);
	}


	public XlfActivity selectByActId(Integer id) {
		return activityDao.selectByActId(id);
	}

	@Transactional(readOnly=false)
	public int updateStatus(XlfActivity xlfActivity) {
		return activityDao.updateStatus( xlfActivity);
	}

}