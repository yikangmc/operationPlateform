package com.yikang.protal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yikang.protal.common.page.PageParameter;
import com.yikang.protal.manager.DictionaryManager;

@Controller
public class DictionaryController {

	@Autowired
	private DictionaryManager dictionaryManager; 
	
	@RequestMapping
	public String dictionaryList(ModelMap modelMap,PageParameter page){
		
		modelMap.put("page",page);
		dictionaryManager.getDictionaryListPage(modelMap);
		modelMap.put("page", page);
		
		return "dictionary/dictionaryList";
	}
	
	
	@RequestMapping
	public String addDcitionary(ModelMap modelMap){
		
		return "";
	}
	
	@RequestMapping
	public String editDictionary(ModelMap modelMap){
		
		return "";
	}
	
	
}
