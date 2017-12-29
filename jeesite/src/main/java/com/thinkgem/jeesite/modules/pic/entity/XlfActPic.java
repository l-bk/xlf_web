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
	private String picname;		// 图片名
	private String pictype;		// pictype
	
	public XlfActPic() {
		super();
	}

	public XlfActPic(String id){
		super(id);
	}

	@Length(min=0, max=200, message="图片名长度必须介于 0 和 200 之间")
	public String getPicname() {
		return picname;
	}

	public void setPicname(String picname) {
		this.picname = picname;
	}
	
	@Length(min=0, max=10, message="pictype长度必须介于 0 和 10 之间")
	public String getPictype() {
		return pictype;
	}

	public void setPictype(String pictype) {
		this.pictype = pictype;
	}

	public Integer getPicId() {
		return picId;
	}

	public void setPicId(Integer picId) {
		this.picId = picId;
	}
	
	
}