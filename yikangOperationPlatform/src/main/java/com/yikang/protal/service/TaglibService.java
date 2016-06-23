package com.yikang.protal.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikang.protal.entity.Taglib;
import com.yikang.protal.manager.TaglibManager;

@Component
public class TaglibService {
	
	@Autowired
	private TaglibManager taglibManager;
	
	 /**
     * @author liushuaic
     * @date 2016-05-19 16:03
     * @desc 获取所有的标签
     * */
	public List<Taglib> getAllTag(Long userId){
    	return taglibManager.getAllTag(userId);
    }
	

	   /**
     * @author liushuaic
     * @date 2016-06-01 14:07
     * @desc 获取所有的二级标签
     * **/
    public  List<Taglib> getSecondAllTaglib(){
    	return taglibManager.getSecondAllTaglib();
    }
	
}
