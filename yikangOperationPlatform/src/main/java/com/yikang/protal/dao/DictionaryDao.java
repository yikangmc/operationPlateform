package com.yikang.protal.dao;

import java.util.List;
import java.util.Map;

import com.yikang.protal.entity.Dictionary;

public interface DictionaryDao {
    int deleteByPrimaryKey(Long dictionaryId);

    int insert(Dictionary record);

    int insertSelective(Dictionary record);

    Dictionary selectByPrimaryKey(Long dictionaryId);

    int updateByPrimaryKeySelective(Dictionary record);

    int updateByPrimaryKey(Dictionary record);
    
    
    /**
     * @author liushuaic
     * @date 2016/01/28 16:00
     * @desc 获取数据字典列表
     * 
     * **/
    List<Dictionary> getDictionaryListPage(Map<String,Object> paramData);
}