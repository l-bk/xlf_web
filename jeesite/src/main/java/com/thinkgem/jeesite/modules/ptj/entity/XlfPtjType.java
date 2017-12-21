/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.ptj.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 兼职类型信息管理Entity
 * @author lbk
 * @version 2017-12-08
 */
public class XlfPtjType extends DataEntity<XlfPtjType> {
	
	private static final long serialVersionUID = 1L;
	private String jobType;		// 兼职类型
	
	public XlfPtjType() {
		super();
	}

	public XlfPtjType(String id){
		super(id);
	}

	@Length(min=0, max=32, message="兼职类型长度必须介于 0 和 32 之间")
	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	
}