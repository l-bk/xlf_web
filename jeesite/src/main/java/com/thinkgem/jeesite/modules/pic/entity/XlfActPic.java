/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.pic.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 图片信息Entity
 * @author lbk
 * @version 2017-12-29
 */
public class XlfActPic extends DataEntity<XlfActPic> {
	
	private static final long serialVersionUID = 1L;
	private Integer picId; 
	private String name;		// 图片名
	private String type;		// 类型
	
	public XlfActPic() {
		super();
	}

	public XlfActPic(String id){
		super(id);
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getPicId() {
		return picId;
	}

	public void setPicId(Integer picId) {
		this.picId = picId;
	}
//--------------------------------
	private String typeName;

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	
	
}