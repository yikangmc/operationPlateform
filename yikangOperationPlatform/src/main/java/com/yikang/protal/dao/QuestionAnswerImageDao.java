package com.yikang.protal.dao;

import com.yikang.protal.entity.QuestionAnswerImage;

public interface QuestionAnswerImageDao {
    int deleteByPrimaryKey(Long questionAnswerImageId);

    int insert(QuestionAnswerImage record);

    int insertSelective(QuestionAnswerImage record);

    QuestionAnswerImage selectByPrimaryKey(Long questionAnswerImageId);

    int updateByPrimaryKeySelective(QuestionAnswerImage record);

    int updateByPrimaryKey(QuestionAnswerImage record);
}