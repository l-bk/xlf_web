/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.ptj.web;

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
import com.thinkgem.jeesite.modules.ptj.entity.XlfPtjType;
import com.thinkgem.jeesite.modules.ptj.service.XlfPtjTypeService;

/**
 * 兼职类型信息管理Controller
 * @author lbk
 * @version 2017-12-08
 */
@Controller
@RequestMapping(value = "${adminPath}/ptj/xlfPtjType")
public class XlfPtjTypeController extends BaseController {

	@Autowired
	private XlfPtjTypeService xlfPtjTypeService;
	
	@ModelAttribute
	public XlfPtjType get(@RequestParam(required=false) String id) {
		XlfPtjType entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = xlfPtjTypeService.get(id);
		}
		if (entity == null){
			entity = new XlfPtjType();
		}
		return entity;
	}
	
	@RequiresPermissions("ptj:xlfPtjType:view")
	@RequestMapping(value = {"list", ""})
	public String list(XlfPtjType xlfPtjType, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<XlfPtjType> page = xlfPtjTypeService.findPage(new Page<XlfPtjType>(request, response), xlfPtjType); 
		model.addAttribute("page", page);
		return "modules/ptj/xlfPtjTypeList";
	}

	@RequiresPermissions("ptj:xlfPtjType:view")
	@RequestMapping(value = "form")
	public String form(XlfPtjType xlfPtjType, Model model) {
		if(StringUtils.isNotEmpty(xlfPtjType.getId())) {
			xlfPtjType=xlfPtjTypeService.get(xlfPtjType.getId());
		}
		model.addAttribute("xlfPtjType", xlfPtjType);
		return "modules/ptj/xlfPtjTypeForm";
	}

	@RequiresPermissions("ptj:xlfPtjType:edit")
	@RequestMapping(value = "save")
	public String save(XlfPtjType xlfPtjType, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, xlfPtjType)){
			return form(xlfPtjType, model);
		}
		xlfPtjTypeService.save(xlfPtjType);
		addMessage(redirectAttributes, "保存兼职类型信息管理成功");
		return "redirect:"+Global.getAdminPath()+"/ptj/xlfPtjType/?repage";
	}
	
	@RequiresPermissions("ptj:xlfPtjType:edit")
	@RequestMapping(value = "delete")
	public String delete(XlfPtjType xlfPtjType, RedirectAttributes redirectAttributes) {
		xlfPtjTypeService.delete(xlfPtjType);
		addMessage(redirectAttributes, "删除兼职类型信息管理成功");
		return "redirect:"+Global.getAdminPath()+"/ptj/xlfPtjType/?repage";
	}

}