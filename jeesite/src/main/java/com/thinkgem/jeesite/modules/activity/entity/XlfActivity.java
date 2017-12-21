/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.activity.entity;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 活动信息管理Entity
 * @author lbk
 * @version 2017-12-12
 */
public class XlfActivity extends DataEntity<XlfActivity> {
	
	private static final long serialVersionUID = 1L;
	private Integer actId;
	private String name;		// 活动名称
	private String details;		// 活动详情
	private String ifSchool;		// 是否校园活动
	private String pic;		// 活动图片
	private String province;		// 活动省份
	private String city;		// 活动市
	private String district;		// 活动区
	private String location;		// 活动位置
	private String door;
	private String latitude;		// 纬度
	private String longitude;		// 经度
	private String person;		// 活动人数
	private Date startTime;		// 活动开始时间
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date endTime;		// 活动结束时间

	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createTime;		// 活动创建时间
	private Integer createUser;		// 活动创建人
	private String status;		// 0:未审核，1:通过审核 2:结束报名
	
	private String userName;
	private String address;
	
	public XlfActivity() {
		super();
	}

	public XlfActivity(String id){
		super(id);
	}
	
	

	public Integer getActId() {
		return actId;
	}

	public void setActId(Integer actId) {
		this.actId = actId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getIfSchool() {
		return ifSchool;
	}

	public void setIfSchool(String ifSchool) {
		this.ifSchool = ifSchool;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getCreateUser() {
		return createUser;
	}

	public void setCreateUser(Integer createUser) {
		this.createUser = createUser;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDoor() {
		return door;
	}

	public void setDoor(String door) {
		this.door = door;
	}
	
//--------------------------------------
	private Integer applySumNum;  //报名总人数
	private Integer applyUncheck;	//报名未审核人数

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