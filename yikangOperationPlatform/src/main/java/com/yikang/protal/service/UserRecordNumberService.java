package com.yikang.protal.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikang.protal.manager.UserRecordNumberManager;
import com.yikang.protal.entity.UserRecordNumber;
@Component
public class UserRecordNumberService {

	@Autowired
	private UserRecordNumberManager userRecordNumberManager;

	/**
	 * 按账号查询任意日期区间个人的记录条数（ a.提出的问题 b.回答过的问题数量 c.发过的帖子数量 d.发过的专家说数量 ）
	 * 
	 * @param modelMap
	 * @return 
	 */
	public UserRecordNumber userRecordNumber(Map<String, Object> modelMap) {
		// TODO Auto-generated method stub
		UserRecordNumber recordNumber=userRecordNumberManager.userRecordNumber(modelMap);
		return recordNumber;
	}

}
