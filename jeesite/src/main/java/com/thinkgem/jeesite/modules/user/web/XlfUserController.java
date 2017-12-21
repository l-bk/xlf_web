/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.user.web;

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
import com.thinkgem.jeesite.modules.user.entity.XlfUser;
import com.thinkgem.jeesite.modules.user.service.XlfUserService;

/**
 * 用户信息模块Controller
 * @author lbk
 * @version 2017-12-16
 */
@Controller
@RequestMapping(value = "${adminPath}/user/xlfUser")
public class XlfUserController extends BaseController {

	@Autowired
	private XlfUserService xlfUserService;
	
	@ModelAttribute
	public XlfUser get(@RequestParam(required=false) String id) {
		XlfUser entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = xlfUserService.get(id);
		}
		if (entity == null){
			entity = new XlfUser();
		}
		return entity;
	}
	
	@RequiresPermissions("user:xlfUser:view")
	@RequestMapping(value = {"list", ""})
	public String list(XlfUser xlfUser, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<XlfUser> page = xlfUserService.findPage(new Page<XlfUser>(request, response), xlfUser); 
		model.addAttribute("page", page);
		return "modules/user/xlfUserList";
	}

	@RequiresPermissions("user:xlfUser:view")
	@RequestMapping(value = "form")
	public String form(XlfUser xlfUser, Model model) {
		model.addAttribute("xlfUser", xlfUser);
		return "modules/user/xlfUserForm";
	}

	@RequiresPermissions("user:xlfUser:edit")
	@RequestMapping(value = "save")
	public String save(XlfUser xlfUser, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, xlfUser)){
			return form(xlfUser, model);
		}
		xlfUserService.save(xlfUser);
		addMessage(redirectAttributes, "保存用户信息模块成功");
		return "redirect:"+Global.getAdminPath()+"/user/xlfUser/?repage";
	}
	
	@RequiresPermissions("user:xlfUser:edit")
	@RequestMapping(value = "delete")
	public String delete(XlfUser xlfUser, RedirectAttributes redirectAttributes) {
		xlfUserService.delete(xlfUser);
		addMessage(redirectAttributes, "删除用户信息模块成功");
		return "redirect:"+Global.getAdminPath()+"/user/xlfUser/?repage";
	}

	
}