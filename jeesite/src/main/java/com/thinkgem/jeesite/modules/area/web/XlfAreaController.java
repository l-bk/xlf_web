/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.area.web;

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
import com.thinkgem.jeesite.modules.area.entity.XlfArea;
import com.thinkgem.jeesite.modules.area.service.XlfAreaService;

/**
 * 区域管理Controller
 * @author lbk
 * @version 2017-12-08
 */
@Controller
@RequestMapping(value = "${adminPath}/area/xlfArea")
public class XlfAreaController extends BaseController {

	@Autowired
	private XlfAreaService xlfAreaService;
	
	@ModelAttribute
	public XlfArea get(@RequestParam(required=false) String id) {
		XlfArea entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = xlfAreaService.get(id);
		}
		if (entity == null){
			entity = new XlfArea();
		}
		return entity;
	}
	
	@RequiresPermissions("area:xlfArea:view")
	@RequestMapping(value = {"list", ""})
	public String list(XlfArea xlfArea, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<XlfArea> page = xlfAreaService.findPage(new Page<XlfArea>(request, response), xlfArea);
		model.addAttribute("page", page);
		return "modules/area/xlfAreaList";
	}

	@RequiresPermissions("area:xlfArea:view")
	@RequestMapping(value = "form")
	public String form(XlfArea xlfArea, Model model) {
		if(xlfArea.getAreaId() != null) {
			xlfArea=xlfAreaService.get(String.valueOf(xlfArea.getAreaId()));
		}
		model.addAttribute("xlfArea", xlfArea);
		return "modules/area/xlfAreaForm";
	}

	@RequiresPermissions("area:xlfArea:edit")
	@RequestMapping(value = "save")
	public String save(XlfArea xlfArea, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, xlfArea)){
			return form(xlfArea, model);
		}
		xlfAreaService.save(xlfArea);
		
		addMessage(redirectAttributes, "保存区域管理成功");
		return "redirect:"+Global.getAdminPath()+"/area/xlfArea/?repage";
	}
	
	@RequiresPermissions("area:xlfArea:edit")
	@RequestMapping(value = "delete")
	public String delete(XlfArea xlfArea, RedirectAttributes redirectAttributes) {
		xlfAreaService.delete(xlfArea);
		addMessage(redirectAttributes, "删除区域管理成功");
		return "redirect:"+Global.getAdminPath()+"/area/xlfArea/?repage";
	}

}