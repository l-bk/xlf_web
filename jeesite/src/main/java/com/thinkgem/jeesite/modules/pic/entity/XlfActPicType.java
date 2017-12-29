/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.pic.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 图片类型Entity
 * @author lbk
 * @version 2017-12-29
 */
public class XlfActPicType extends DataEntity<XlfActPicType> {
	
	private static final long serialVersionUID = 1L;
	private Integer picTypeId;
	private String picTypeName;		// 图片类型名称
	
	public XlfActPicType() {
		super();
	}

	public XlfActPicType(String id){
		super(id);
	}


	public Integer getPicTypeId() {
		return picTypeId;
	}

	public void setPicTypeId(Integer picTypeId) {
		this.picTypeId = picTypeId;
	}

	public String getPicTypeName() {
		return picTypeName;
	}

	public void setPicTypeName(String picTypeName) {
		this.picTypeName = picTypeName;
	}
	
	
	
}