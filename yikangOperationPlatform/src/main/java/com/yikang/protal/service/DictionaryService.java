package com.yikang.protal.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yikang.protal.entity.Dictionary;
import com.yikang.protal.manager.DictionaryManager;

@Service
public class DictionaryService {
	
	@Autowired
	private DictionaryManager dictionaryManager;

	
	
	/**
     * @author liushuaic
     * @date 2016/01/28 16:00
     * @desc 获取数据字典列表
     ***/
	public  List<Dictionary> getDictionaryListPage(Map<String,Object> paramData){
    	return dictionaryManager.getDictionaryListPage(paramData);
    }
	
	
	
}
