/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.join.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 报名信息Entity
 * @author lbk
 * @version 2017-12-14
 */
public class XlfJoin extends DataEntity<XlfJoin> {
	
	private static final long serialVersionUID = 1L;
	private Integer joinId;
	private Integer moduleType;		// 报名类型id 2:兼职 1:活动
	private Integer moduleId;		// 活动或兼职id
	private Integer user;		// 用户id
	private Date time;		// 报名时间
	private Integer status;		// 报名状态
	
	public XlfJoin() {
		super();
	}

	public XlfJoin(String id){
		super(id);
	}

	
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Integer getJoinId() {
		return joinId;
	}

	public void setJoinId(Integer joinId) {
		this.joinId = joinId;
	}

	public Integer getModuleType() {
		return moduleType;
	}

	public void setModuleType(Integer moduleType) {
		this.moduleType = moduleType;
	}

	public Integer getModuleId() {
		return moduleId;
	}

	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}

	public Integer getUser() {
		return user;
	}

	public void setUser(Integer user) {
		this.user = user;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
//--------------------------------------------
	private String ptjName;  //兼职名称
	private String jobType; //兼职类型
	
	
	private String userName; //用户名
	private String userCompany; //机构
	private String userSex;//用户性别
	private String userPhone;//用户电话
	private String userRole;
	private String schoolName;
	
	private String actName;//活动名
	private Integer actPerson;//活动人数

	
	public String getPtjName() {
		return ptjName;
	}

	public void setPtjName(String ptjName) {
		this.ptjName = ptjName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserCompany() {
		return userCompany;
	}

	public void setUserCompany(String userCompany) {
		this.userCompany = userCompany;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	
	public String getActName() {
		return actName;
	}

	public void setActName(String actName) {
		this.actName = actName;
	}

	public Integer getActPerson() {
		return actPerson;
	}

	public void setActPerson(Integer actPerson) {
		this.actPerson = actPerson;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	
	
	
}