/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.ptj.web;

import java.util.ArrayList;
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

import com.ckfinder.connector.ServletContextFactory;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.Encodes;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.area.entity.XlfArea;
import com.thinkgem.jeesite.modules.area.service.XlfAreaService;
import com.thinkgem.jeesite.modules.ptj.entity.XlfPartTimeJob;
import com.thinkgem.jeesite.modules.ptj.entity.XlfPtjType;
import com.thinkgem.jeesite.modules.ptj.service.XlfPartTimeJobService;
import com.thinkgem.jeesite.modules.ptj.service.XlfPtjTypeService;

/**
 * 兼职信息Controller
 * @author lbk
 * @version 2017-12-10
 */
@Controller
@RequestMapping(value = "${adminPath}/ptj/xlfPartTimeJob")
public class XlfPartTimeJobController extends BaseController {

	@Autowired
	private XlfPartTimeJobService xlfPartTimeJobService;
	
	@Autowired
	private XlfAreaService xlfAreaService;
	
	@Autowired 
	private XlfPtjTypeService typeService;
	
	@ModelAttribute
	public XlfPartTimeJob get(@RequestParam(required=false) String id) {
		XlfPartTimeJob entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = xlfPartTimeJobService.get(id);
		}
		if (entity == null){
			entity = new XlfPartTimeJob();
		}
		return entity;
	}
	
	@RequiresPermissions("ptj:xlfPartTimeJob:view")
	@RequestMapping(value = {"list", ""})
	public String list(XlfPartTimeJob xlfPartTimeJob, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<XlfPartTimeJob> page = xlfPartTimeJobService.findPage(new Page<XlfPartTimeJob>(request, response), xlfPartTimeJob); 
		List<XlfPartTimeJob> list=page.getList();
		for(XlfPartTimeJob ptj:list) {
			/*ptj.setAddress(ptj.getWorkProvince() == null?"":ptj.getWorkProvince() + ptj.getWorkCity() == null?"":ptj.getWorkCity()
					+ptj.getWorkDistrict() == null ?"":ptj.getWorkDistrict() + ptj.getWorkStreet() == null?"":ptj.getWorkStreet());*/
		}
		page.setList(list);
		model.addAttribute("page", page);
		return "modules/ptj/xlfPartTimeJobList";
	}
	@RequiresPermissions("ptj:xlfPartTimeJob:view")
	@RequestMapping(value = "form")
	public String form(XlfPartTimeJob xlfPartTimeJob, Model model) {
		List<XlfPtjType>  typeList = new ArrayList<XlfPtjType>();
		if(StringUtils.isNotBlank(xlfPartTimeJob.getJobId())) {
			xlfPartTimeJob.setId(xlfPartTimeJob.getJobId());
			xlfPartTimeJob = xlfPartTimeJobService.get(xlfPartTimeJob.getJobId());
			XlfPtjType type=typeService.get(xlfPartTimeJob.getJobTypeId());
			typeList.add(type);
		}else {
			 typeList=typeService.findList(new XlfPtjType());
		}
		model.addAttribute("typeList",typeList);
		model.addAttribute("xlfPartTimeJob", xlfPartTimeJob);
		return "modules/ptj/xlfPartTimeJobForm";
	}

	@RequiresPermissions("ptj:xlfPartTimeJob:edit")
	@RequestMapping(value = "save")
	public String save(XlfPartTimeJob xlfPartTimeJob, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, xlfPartTimeJob)){
			return form(xlfPartTimeJob, model);
		}
		xlfPartTimeJobService.save(xlfPartTimeJob);
		addMessage(redirectAttributes, "保存兼职信息成功");
		return "redirect:"+Global.getAdminPath()+"/ptj/xlfPartTimeJob/?repage";
	}
	
	@RequiresPermissions("ptj:xlfPartTimeJob:edit")
	@RequestMapping(value = "delete")
	public String delete(XlfPartTimeJob xlfPartTimeJob, RedirectAttributes redirectAttributes) {
		xlfPartTimeJobService.delete(xlfPartTimeJob);
		addMessage(redirectAttributes, "删除兼职信息成功");
		return "redirect:"+Global.getAdminPath()+"/ptj/xlfPartTimeJob/?repage";
	}

	
	@RequiresPermissions("ptj:xlfPartTimeJob:edit")
	@RequestMapping(value = "updateStatus")
	public String updateStatus(XlfPartTimeJob xlfPartTimeJob, Model model, RedirectAttributes redirectAttributes) {
		int result=xlfPartTimeJobService.updateStatus(xlfPartTimeJob);
		if("1".equals(xlfPartTimeJob.getAuditStatus())) {
			if(result == 1 ) {
				addMessage(redirectAttributes,xlfPartTimeJob.getJobName()+"审核通过操作成功");
			}else {
				addMessage(redirectAttributes, xlfPartTimeJob.getJobName()+"审核通过操作不成功");
			}
		}else  if("2".equals(xlfPartTimeJob.getAuditStatus())){
			if(result == 1 ) {
				addMessage(redirectAttributes, xlfPartTimeJob.getJobName()+"审核不通过操作成功");
			}else {
				addMessage(redirectAttributes, xlfPartTimeJob.getJobName()+"审核不通过操作不成功");
			}
		}else if ("0".equals(xlfPartTimeJob.getAuditStatus())) {
			if(result == 1 ) {
				addMessage(redirectAttributes, xlfPartTimeJob.getJobName()+"重新审核操作成功");
			}else {
				addMessage(redirectAttributes, xlfPartTimeJob.getJobName()+"重新审核操作不成功");
			}
		}
		return "redirect:"+Global.getAdminPath()+"/ptj/xlfPartTimeJob/?repage";
	}
}