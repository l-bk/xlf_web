/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.ptj.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.entity.Area;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 兼职信息Entity
 * @author lbk
 * @version 2017-12-10
 */
public class XlfPartTimeJob extends DataEntity<XlfPartTimeJob> {
	
	private static final long serialVersionUID = 1L;
	private String jobId;		// 唯一id
	private String jobName;		// 兼职名称
	private String limitNumber;		// 兼职限定人数
	private String sexDemand;		// 性别要求 1：男 ，2：女 3：不限制
	private String jobTypeId;		// 兼职类型id，关联兼职类型表
	private String wage;		// 兼职工资
	private String wageType;		// 工资单位
	private String workStreet;		// 工作街道
	private String calculateMoneyType;		// 结款方式 1：日结 ，2：周结，3：月结
	private String calculateMoneyDate;		// 结款日期
	private String timeType;		// 时间类型 1:短期不包含周末 ，2：短期包含周末，3：长期
	private Date releaseTime;		// 发布时间
	private Date endWorkDate;		// end_work_date
	private Date startWorkDate;		// 开始工作日期
	private String jobContent;		// 工作内容
	private String auditStatus;		// 审核状态，0：未审核，1：审核通过 ，2：已取消
	private String workTime;		// 工作时间段
	private String longitude;		// 经度
	private String latitude;		// 纬度
	private int areaId;
	private int userId;
	
	private String workProvince;
	private String workCity;
	private String workDistrict;
	
	private String address;
	
	
	
	public XlfPartTimeJob() {
		super();
	}

	public XlfPartTimeJob(String id){
		super(id);
	}
	
	
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getWorkProvince() {
		return workProvince;
	}

	public void setWorkProvince(String workProvince) {
		this.workProvince = workProvince;
	}

	public String getWorkCity() {
		return workCity;
	}

	public void setWorkCity(String workCity) {
		this.workCity = workCity;
	}

	public String getWorkDistrict() {
		return workDistrict;
	}

	public void setWorkDistrict(String workDistrict) {
		this.workDistrict = workDistrict;
	}

	public int getAreaId() {
		return areaId;
	}

	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	
	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	
	public String getLimitNumber() {
		return limitNumber;
	}

	public void setLimitNumber(String limitNumber) {
		this.limitNumber = limitNumber;
	}
	
	public String getSexDemand() {
		return sexDemand;
	}

	public void setSexDemand(String sexDemand) {
		this.sexDemand = sexDemand;
	}
	
	public String getJobTypeId() {
		return jobTypeId;
	}

	public void setJobTypeId(String jobTypeId) {
		this.jobTypeId = jobTypeId;
	}
	
	public String getWage() {
		return wage;
	}

	public void setWage(String wage) {
		this.wage = wage;
	}
	
	public String getWageType() {
		return wageType;
	}

	public void setWageType(String wageType) {
		this.wageType = wageType;
	}
	
	public String getWorkStreet() {
		return workStreet;
	}

	public void setWorkStreet(String workStreet) {
		this.workStreet = workStreet;
	}
	
	public String getCalculateMoneyType() {
		return calculateMoneyType;
	}

	public void setCalculateMoneyType(String calculateMoneyType) {
		this.calculateMoneyType = calculateMoneyType;
	}
	
	public String getCalculateMoneyDate() {
		return calculateMoneyDate;
	}
	
	public void setCalculateMoneyDate(String calculateMoneyDate) {
		this.calculateMoneyDate = calculateMoneyDate;
	}
	
	public String getTimeType() {
		return timeType;
	}
	
	public void setTimeType(String timeType) {
		this.timeType = timeType;
	}
	public Date getReleaseTime() {
		return releaseTime;
	}
	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}
	public Date getEndWorkDate() {
		return endWorkDate;
	}
	public void setEndWorkDate(Date endWorkDate) {
		this.endWorkDate = endWorkDate;
	}
	
	public Date getStartWorkDate() {
		return startWorkDate;
	}

	public void setStartWorkDate(Date startWorkDate) {
		this.startWorkDate = startWorkDate;
	}
	
	public String getJobContent() {
		return jobContent;
	}

	public void setJobContent(String jobContent) {
		this.jobContent = jobContent;
	}
	
	public String getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}
	
	
	@Length(min=0, max=128, message="工作时间段长度必须介于 0 和 128 之间")
	public String getWorkTime() {
		return workTime;
	}

	public void setWorkTime(String workTime) {
		this.workTime = workTime;
	}
	
	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
//----------------------------------------------
	private String userName;
	private String userCompany;
	private String userRole;
	private String userPhone;
	private String schoolName;
	private String jobType;
	private String area;
	private Integer applySumNum;  //报名总人数
	private Integer applyUncheck;	//报名未审核人数



	

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
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

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Integer getApplySumNum() {
		return applySumNum;
	}

	public void setApplySumNum(Integer applySumNum) {
		this.applySumNum = applySumNum;
	}

	public Integer getApplyUncheck() {
		return applyUncheck;
	}

	public void setApplyUncheck(Integer applyUncheck) {
		this.applyUncheck = applyUncheck;
	}
	
	
	
	
}