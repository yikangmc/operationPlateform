package com.yikang.protal.manager;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikang.protal.dao.QuestionImageDao;
import com.yikang.protal.entity.QuestionImage;

@Component
public class QuestionImageManager {

	@Autowired
	private QuestionImageDao questionImageDao;
	
	/**
	 * 
	 * @author liushuaic
	 * @date 2016-05-28 17:49
	 * @desc 添加活动图片
	 * 
	 * */
	public int insertSelective(String imageUrl,Long questionId){
		QuestionImage questionImage=new QuestionImage();
		questionImage.setCreateTime(Calendar.getInstance().getTime());
		questionImage.setImageUrl(imageUrl);
		questionImage.setQuestionId(questionId);
		return questionImageDao.insertSelective(questionImage);
	}
	
	
    /**
     * @author liushuaic
     * @date 2016-09-06 17:38
     * @desc 问题删除
     * @param 问题id
     * @return 影响数据数量
     * */
	public int deleteQuestionImageByQuestionId(Long questionId){
		return questionImageDao.deleteQuestionImageByQuestionId(questionId);
	}
	
}
