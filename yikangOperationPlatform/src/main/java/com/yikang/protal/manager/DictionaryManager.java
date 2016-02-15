package com.yikang.protal.manager;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.yikang.protal.dao.DictionaryDao;
import com.yikang.protal.entity.Dictionary;

public class DictionaryManager {
	
	@Autowired
	private DictionaryDao dictionaryDao;

	
	
	 /**
     * @author liushuaic
     * @date 2016/01/28 16:00
     * @desc 获取数据字典列表
     ***/
    public List<Dictionary> getDictionaryListPage(Map<String,Object> paramData){
    	return dictionaryDao.getDictionaryListPage(paramData);
    }
    
    
    
    
}
