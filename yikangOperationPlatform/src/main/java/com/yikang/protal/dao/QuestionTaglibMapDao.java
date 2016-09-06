package com.yikang.protal.dao;

import java.util.List;

import com.yikang.protal.entity.QuestionTaglibMap;
import com.yikang.protal.entity.Taglib;

public interface QuestionTaglibMapDao {
    int deleteByPrimaryKey(Long questionTaglibMapsId);

    int insert(QuestionTaglibMap record);

    int insertSelective(QuestionTaglibMap record);

    QuestionTaglibMap selectByPrimaryKey(Long questionTaglibMapsId);

    int updateByPrimaryKeySelective(QuestionTaglibMap record);

    int updateByPrimaryKey(QuestionTaglibMap record);
    
    
    /**
     * @author liushuaic
     * @date 2016-05-10 18:42
     * @desc 查询某一个问题的所有标签
     * **/
    List<Taglib> getQuestionTaglibsByQuestionId(Long questionid);
    
    
    /**
     * @author liushuaic
     * @date 2016-09-06 17:40
     * @desc 删除某一个问题下的所有标签
     * */
    int deleteQuestionTaglibMapByQuetionId(Long questionId);

}