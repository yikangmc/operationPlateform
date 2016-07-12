package com.yikang.protal.manager;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikang.protal.dao.QuestionAnswerImageDao;
import com.yikang.protal.dao.QuestionDao;
import com.yikang.protal.dao.QuestionTaglibMapDao;
import com.yikang.protal.entity.Question;
import com.yikang.protal.entity.QuestionTaglibMap;

@Component
public class QuestionManager {
	
	@Autowired
	private QuestionDao questionDao;


	@Autowired
	private QuestionTaglibMapDao questionTaglibMapDao;
	
	@Autowired
	private QuestionAnswerImageDao questionAnswerImageDao;
	
	@Autowired
	private QuestionImageManager questionImageManager;
	
	/**
	 * @author liushuaic
	 * @date 2016-05-09 11:15
	 * @desc 添加问题
	 * **/
	public int insertQuestion(String title,String content,Long[] taglibIds,Long createUserId,String[] images){
		Date date=Calendar.getInstance().getTime();
		Question question=new Question();
		question.setTitle(title);
		question.setContent(content);
		question.setCreateTime(date);
		question.setUpdateTime(date);
		question.setCreateUserId(createUserId);
		question.setStar(0);
		questionDao.insertSelective(question);
		for(Long taglibId:taglibIds){
			QuestionTaglibMap questionTaglibMap=new QuestionTaglibMap();
			questionTaglibMap.setCreateTime(date);
			questionTaglibMap.setUpdateTime(date);
			questionTaglibMap.setTaglibsId(taglibId);
			questionTaglibMap.setQuestionsId(question.getQuestionId());
			questionTaglibMapDao.insertSelective(questionTaglibMap);
		}
		
		for(String imageId:images){
			 questionImageManager.insertSelective(imageId, question.getQuestionId());
		 }
		return 1;
	}
	
	/**
	 * 浏览问题
	 * @param map
	 * @return
	 */
	public List<Question> queryAllQuestionsPage(Map<String,Object> paramMap){
		return questionDao.queryAllQuestionsPage(paramMap);
	}
}
