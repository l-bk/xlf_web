/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.user.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 用户信息模块Entity
 * @author lbk
 * @version 2017-12-16
 */
public class XlfUser extends DataEntity<XlfUser> {
	
	private static final long serialVersionUID = 1L;
	private String userName;		// 用户名称
	private String userSex;		// 用户性别1:male 2:female 0:保密
	private String userRole;		// 用户角色（企业发布，兼职学生）1:公司代理人 0：学生
	private String userCompany;		// user_company
	private String userAge;		// 用户年龄
	private String userHigh;		// user_high
	private String userSchoolId;		// user_school_id
	private String userPhone;		// 用户电话号码
	private String userDetails;		// 用户简历
	private String userImg;		// 用户头像
	private String userWeigh;		// user_weigh
	
	private Integer userId;
	
	public XlfUser() {
		super();
	}

	public XlfUser(String id){
		super(id);
	}
	
	

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Length(min=0, max=20, message="用户名称长度必须介于 0 和 20 之间")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Length(min=0, max=2, message="用户性别1:male 2:female 0:保密长度必须介于 0 和 2 之间")
	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	
	@Length(min=0, max=2, message="用户角色（企业发布，兼职学生）1:公司代理人 0：学生长度必须介于 0 和 2 之间")
	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
	@Length(min=0, max=30, message="user_company长度必须介于 0 和 30 之间")
	public String getUserCompany() {
		return userCompany;
	}

	public void setUserCompany(String userCompany) {
		this.userCompany = userCompany;
	}
	
	@Length(min=0, max=4, message="用户年龄长度必须介于 0 和 4 之间")
	public String getUserAge() {
		return userAge;
	}

	public void setUserAge(String userAge) {
		this.userAge = userAge;
	}
	
	@Length(min=0, max=10, message="user_high长度必须介于 0 和 10 之间")
	public String getUserHigh() {
		return userHigh;
	}

	public void setUserHigh(String userHigh) {
		this.userHigh = userHigh;
	}
	
	@Length(min=0, max=20, message="user_school_id长度必须介于 0 和 20 之间")
	public String getUserSchoolId() {
		return userSchoolId;
	}

	public void setUserSchoolId(String userSchoolId) {
		this.userSchoolId = userSchoolId;
	}
	
	@Length(min=0, max=15, message="用户电话号码长度必须介于 0 和 15 之间")
	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	
	@Length(min=0, max=200, message="用户简历长度必须介于 0 和 200 之间")
	public String getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(String userDetails) {
		this.userDetails = userDetails;
	}
	
	@Length(min=0, max=150, message="用户头像长度必须介于 0 和 150 之间")
	public String getUserImg() {
		return userImg;
	}

	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}
	
	@Length(min=0, max=10, message="user_weigh长度必须介于 0 和 10 之间")
	public String getUserWeigh() {
		return userWeigh;
	}

	public void setUserWeigh(String userWeigh) {
		this.userWeigh = userWeigh;
	}

//	---------------------------
	private String schoolName;

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	
	
	
}