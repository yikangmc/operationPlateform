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
import com.yikang.protal.entity.Answer;
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
		
		if(null != images){
			for(String imageId:images){
				 questionImageManager.insertSelective(imageId, question.getQuestionId());
			 }
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
	

	/**
	 * 根据问题id查询问题标题
	 * @param questionId
	 * @return
	 */
	public String queryQuestionTitleById(String questionId){
		return questionDao.queryQuestionTitleById(questionId);
	}
	
	/**
	 * 保存问题的答案
	 * @param answer
	 * @return
	 */
	public int saveAnswerOfQuestion(Answer answer){
		return questionDao.saveAnswerOfQuestion(answer);
	}
	
	/**
	 * 根据用户名查询用户的id
	 * @param userName
	 * @return
	 */
	public Long queryUserIdByUserName(String userName){
		return questionDao.queryUserIdByUserName(userName);
	}
	
	/**
	 * @author liushuaic
	 * @date 2016-09-06 11:52
	 * @desc 删除某一个问题
	 * @param questionId 问题id
	 * @return int 删除数量
	 * */
	public int deleteQuestionByQuestionId(Long questionId){
		return questionDao.deleteByPrimaryKey(questionId);
	}
}