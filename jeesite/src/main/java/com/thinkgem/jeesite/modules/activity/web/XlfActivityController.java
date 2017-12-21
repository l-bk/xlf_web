/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.activity.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.activity.entity.XlfActivity;
import com.thinkgem.jeesite.modules.activity.service.XlfActivityService;

/**
 * 活动信息管理Controller
 * @author lbk
 * @version 2017-12-12
 */
@Controller
@RequestMapping(value = "${adminPath}/activity/xlfActivity")
public class XlfActivityController extends BaseController {

	@Autowired
	private XlfActivityService xlfActivityService;
	
	@ModelAttribute
	public XlfActivity get(@RequestParam(required=false) String id) {
		XlfActivity entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = xlfActivityService.get(id);
		}
		if (entity == null){
			entity = new XlfActivity();
		}
		return entity;
	}
	
	@RequiresPermissions("activity:xlfActivity:view")
	@RequestMapping(value = {"list", ""})
	public String list(XlfActivity xlfActivity, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<XlfActivity> page = xlfActivityService.findPage(new Page<XlfActivity>(request, response), xlfActivity); 
		List<XlfActivity> lite= page.getList();
		for(XlfActivity act:lite) {
			String province = act.getProvince() == null ? "":act.getProvince();
			String city = act.getCity() == null ? "":act.getCity();
			String district = act.getDistrict() == null ? "":act.getDistrict();
			String location=act.getLocation()== null ?"":act.getLocation();
			String door=act.getDoor() == null ?"":act.getDoor();
			act.setAddress(province + city+district +location +door);
			
		}
		model.addAttribute("page", page);
		return "modules/activity/xlfActivityList";
	}

	@RequiresPermissions("activity:xlfActivity:view")
	@RequestMapping(value = "form")
	public String form(XlfActivity xlfActivity, Model model) {
		if(xlfActivity.getActId() != null) {
			xlfActivity = xlfActivityService.selectByActId(xlfActivity.getActId());
		}
		model.addAttribute("xlfActivity", xlfActivity);
		return "modules/activity/xlfActivityForm";
	}

	@RequiresPermissions("activity:xlfActivity:edit")
	@RequestMapping(value = "save")
	public String save(XlfActivity xlfActivity, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, xlfActivity)){
			return form(xlfActivity, model);
		}
		xlfActivityService.save(xlfActivity);
		addMessage(redirectAttributes, "保存活动信息管理成功");
		return "redirect:"+Global.getAdminPath()+"/activity/xlfActivity/?repage";
	}
	
	@RequiresPermissions("activity:xlfActivity:edit")
	@RequestMapping(value = "delete")
	public String delete(XlfActivity xlfActivity, RedirectAttributes redirectAttributes) {
		xlfActivityService.delete(xlfActivity);
		addMessage(redirectAttributes, "删除活动信息管理成功");
		return "redirect:"+Global.getAdminPath()+"/activity/xlfActivity/?repage";
	}

	@RequiresPermissions("activity:xlfActivity:edit")
	@RequestMapping(value = "updateStatus")
	public String updateStatus(XlfActivity xlfActivity, Model model, RedirectAttributes redirectAttributes) {
		int result=xlfActivityService.updateStatus(xlfActivity);
		if("1".equals(xlfActivity.getStatus())) {
			if(result == 1 ) {
				addMessage(redirectAttributes, xlfActivity.getName()+"审核通过操作成功");
			}else {
				addMessage(redirectAttributes, xlfActivity.getName()+"审核通过操作不成功");
			}
		}else  if("2".equals(xlfActivity.getStatus())){
			if(result == 1 ) {
				addMessage(redirectAttributes, xlfActivity.getName()+"审核不通过操作成功");
			}else {
				addMessage(redirectAttributes, xlfActivity.getName()+"审核不通过操作不成功");
			}
		}else if ("0".equals(xlfActivity.getStatus())) {
			if(result == 1 ) {
				addMessage(redirectAttributes, xlfActivity.getName()+"重新审核操作成功");
			}else {
				addMessage(redirectAttributes, xlfActivity.getName()+"重新审核操作不成功");
			}
		}
		return "redirect:"+Global.getAdminPath()+"/activity/xlfActivity/?repage";
	}
	
	
}