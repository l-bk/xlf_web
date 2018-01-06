/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.pic.web;

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
import com.thinkgem.jeesite.modules.pic.entity.XlfActPic;
import com.thinkgem.jeesite.modules.pic.service.XlfActPicService;

/**
 * 图片信息Controller
 * @author lbk
 * @version 2017-12-29
 */
@Controller
@RequestMapping(value = "${adminPath}/pic/xlfActPic")
public class XlfActPicController extends BaseController {

	@Autowired
	private XlfActPicService xlfActPicService;
	
	@ModelAttribute
	public XlfActPic get(@RequestParam(required=false) String id) {
		XlfActPic entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = xlfActPicService.get(id);
		}
		if (entity == null){
			entity = new XlfActPic();
		}
		return entity;
	}
	
	@RequiresPermissions("pic:xlfActPicType:view")
	@RequestMapping(value = {"list", ""})
	public String list(XlfActPic xlfActPic, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<XlfActPic> page = xlfActPicService.findPage(new Page<XlfActPic>(request, response), xlfActPic); 
		List<XlfActPic> list=page.getList();
		model.addAttribute("typeName",list.get(0).getTypeName());
		model.addAttribute("typeId",list.get(0).getType());
		model.addAttribute("page", page);
		return "modules/pic/xlfActPicList";
	}

	@RequiresPermissions("pic:xlfActPicType:view")
	@RequestMapping(value = "form")
	public String form(XlfActPic xlfActPic, Model model) {
		model.addAttribute("xlfActPic", xlfActPic);
		model.addAttribute("typeId",xlfActPic.getType());
		return "modules/pic/xlfActPicForm";
	}

	@RequiresPermissions("pic:xlfActPicType:view")
	@RequestMapping(value = "save")
	public String save(XlfActPic xlfActPic, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, xlfActPic)){
			return form(xlfActPic, model);
		}
		xlfActPicService.save(xlfActPic);
		addMessage(redirectAttributes, "保存图片信息成功");
		return "redirect:"+Global.getAdminPath()+"/pic/xlfActPic/?type="+xlfActPic.getType()+"&repage";
	}
	
	@RequiresPermissions("pic:xlfActPicType:view")
	@RequestMapping(value = "delete")
	public String delete(XlfActPic xlfActPic, RedirectAttributes redirectAttributes) {
		xlfActPicService.delete(xlfActPic);
		addMessage(redirectAttributes, "删除图片信息成功");
		return "redirect:"+Global.getAdminPath()+"/pic/xlfActPic/?type="+xlfActPic.getType()+"&repage";
	}

}