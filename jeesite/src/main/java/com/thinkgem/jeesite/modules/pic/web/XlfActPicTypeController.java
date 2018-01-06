/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.pic.web;

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
import com.thinkgem.jeesite.modules.pic.entity.XlfActPicType;
import com.thinkgem.jeesite.modules.pic.service.XlfActPicTypeService;

/**
 * 图片类型Controller
 * @author lbk
 * @version 2017-12-29
 */
@Controller
@RequestMapping(value = "${adminPath}/pic/xlfActPicType")
public class XlfActPicTypeController extends BaseController {

	@Autowired
	private XlfActPicTypeService xlfActPicTypeService;
	
	@ModelAttribute
	public XlfActPicType get(@RequestParam(required=false) String id) {
		XlfActPicType entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = xlfActPicTypeService.get(id);
		}
		if (entity == null){
			entity = new XlfActPicType();
		}
		return entity;
	}
	
	@RequiresPermissions("pic:xlfActPicType:view")
	@RequestMapping(value = {"list", ""})
	public String list(XlfActPicType xlfActPicType, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<XlfActPicType> page = xlfActPicTypeService.findPage(new Page<XlfActPicType>(request, response), xlfActPicType); 
		model.addAttribute("page", page);
		return "modules/pic/xlfActPicTypeList";
	}

	@RequiresPermissions("pic:xlfActPicType:view")
	@RequestMapping(value = "form")
	public String form(XlfActPicType xlfActPicType, Model model) {
		if(xlfActPicType.getPicTypeId() != null) {
			xlfActPicType=xlfActPicTypeService.get(String.valueOf(xlfActPicType.getPicTypeId()));
		}
		model.addAttribute("xlfActPicType", xlfActPicType);
		return "modules/pic/xlfActPicTypeForm";
	}

	@RequiresPermissions("pic:xlfActPicType:edit")
	@RequestMapping(value = "save")
	public String save(XlfActPicType xlfActPicType, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, xlfActPicType)){
			return form(xlfActPicType, model);
		}
		xlfActPicTypeService.save(xlfActPicType);
		addMessage(redirectAttributes, "保存图片类型成功");
		return "redirect:"+Global.getAdminPath()+"/pic/xlfActPicType/?repage";
	}
	
	@RequiresPermissions("pic:xlfActPicType:edit")
	@RequestMapping(value = "delete")
	public String delete(XlfActPicType xlfActPicType, RedirectAttributes redirectAttributes) {
		xlfActPicTypeService.delete(xlfActPicType);
		addMessage(redirectAttributes, "删除图片类型成功");
		return "redirect:"+Global.getAdminPath()+"/pic/xlfActPicType/?repage";
	}

}