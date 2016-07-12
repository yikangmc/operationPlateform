package com.yikang.protal.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yikang.common.utils.MatchHtmlElementAttrValue;
import com.yikang.protal.entity.Answer;
import com.yikang.protal.entity.Question;
import com.yikang.protal.manager.QuestionAnswerManager;
import com.yikang.protal.manager.QuestionManager;

/**
 * 问题管理service
 * 
 * @author zxh
 *
 */
@Service
public class QuestionService {

	@Autowired
	private QuestionManager questionManager;
	
	@Autowired
	private QuestionAnswerManager questionAnswerManager;
	/**
	 * 浏览问题
	 * 
	 * @param map
	 * @return
	 */
	public List<Question> queryAllQuestions(Map<String, Object> paramMap) {
		return questionManager.queryAllQuestionsPage(paramMap);
	}

	public int insertQuestion(String title, String content, Long[] taglibIds, Long userId, String[] images) {
		questionManager.insertQuestion(title, content, taglibIds, userId, images);
		return 0;
	}
	
	/**
	 * @author liushuaic
	 * @date 2016-05-10 16:30
	 * @desc 添加问题回复
	 * */
	public int addQuestionAnswer(Long questionId,Long userId,String detailContent,String htmlDetailContent){
			
			String[] images=new String[0];
			String content=detailContent.length()>100?detailContent.substring(0,100):detailContent;
			List<String> imageArray=MatchHtmlElementAttrValue.getImgSrc(htmlDetailContent);
			images=imageArray.toArray(images);
			questionAnswerManager.insertSelective(questionId, content,detailContent,htmlDetailContent, userId,images);
			
			return 1;
	}
	
	/**
	 * 根据问题id查询问题标题
	 * @param questionId
	 * @return
	 */
	public String queryQuestionTitleById(String questionId){
		return questionManager.queryQuestionTitleById(questionId);
	}
	
	/**
	 * 保存问题的答案
	 * @param answer
	 * @return
	 */
	public int saveAnswerOfQuestion(Answer answer){
		Byte b = 0;
		Date date = new Date();
		answer.setAnswersDataSource(b);
		answer.setStarNum(0);
		answer.setIsRecommend(b);
		answer.setCreateTime(date);
		answer.setUpdateTime(date);
		return questionManager.saveAnswerOfQuestion(answer);
	}
	
	/**
	 * 根据用户名查询用户的id
	 * @param userName
	 * @return
	 */
	public Long queryUserIdByUserName(String userName){
		return questionManager.queryUserIdByUserName(userName);
	}

}
