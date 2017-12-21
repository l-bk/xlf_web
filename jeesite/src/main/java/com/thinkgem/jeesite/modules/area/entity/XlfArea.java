/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.area.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 区域管理Entity
 * @author lbk
 * @version 2017-12-08
 */
public class XlfArea extends DataEntity<XlfArea> {
	
	private static final long serialVersionUID = 1L;
	private Integer areaId;
	private String province;		// 省
	private String city;		// 市
	private String district;		// 区
	private String cityFirst;		// 区首字母
	private String hotCity;		// 热门城市s
	
	public XlfArea() {
		super();
	}

	public XlfArea(String id){
		super(id);
	}

	
	
	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	@Length(min=0, max=32, message="省长度必须介于 0 和 32 之间")
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}
	
	@Length(min=0, max=32, message="市长度必须介于 0 和 32 之间")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	@Length(min=0, max=32, message="区长度必须介于 0 和 32 之间")
	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}
	
	@Length(min=0, max=2, message="区首字母长度必须介于 0 和 2 之间")
	public String getCityFirst() {
		return cityFirst;
	}

	public void setCityFirst(String cityFirst) {
		this.cityFirst = cityFirst;
	}
	
	@Length(min=0, max=2, message="热门城市s长度必须介于 0 和 2 之间")
	public String getHotCity() {
		return hotCity;
	}

	public void setHotCity(String hotCity) {
		this.hotCity = hotCity;
	}
	
}