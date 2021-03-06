package com.yikang.protal.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yikang.protal.entity.Question;
import com.yikang.protal.manager.QuestionAnswerManager;
import com.yikang.protal.manager.QuestionImageManager;
import com.yikang.protal.manager.QuestionManager;
import com.yikang.protal.manager.QuestionTaglibMapManager;

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
	
	@Autowired
	private QuestionTaglibMapManager questionTaglibMapManager;
	
	@Autowired
	private QuestionImageManager questionImageManager;
	
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
	
/*	*//**
	 * @author liushuaic
	 * @date 2016-05-10 16:30
	 * @desc 添加问题回复
	 * *//*
	public int addQuestionAnswer(Long questionId,Long userId,String detailContent,String htmlDetailContent){
			
			String[] images=new String[0];
			String content=detailContent.length()>100?detailContent.substring(0,100):detailContent;
			List<String> imageArray=MatchHtmlElementAttrValue.getImgSrc(htmlDetailContent);
			images=imageArray.toArray(images);
			questionAnswerManager.insertSelective(questionId, content,detailContent,htmlDetailContent, userId,images,Long.valueOf());
			
			return 1;
	}*/
	
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
	public int saveAnswerOfQuestion(Long userId, String htmlDetailContent, String detailContent, String contentStr,
			String[] images, String questionId,String taglibsId) {
		return questionAnswerManager.insertSelective(Long.valueOf(questionId), contentStr, detailContent, htmlDetailContent, userId,
				images,Long.valueOf(taglibsId));
	}
	
	/**
	 * 根据用户名查询用户的id
	 * @param userName
	 * @return
	 */
	public Long queryUserIdByUserName(String userName){
		return questionManager.queryUserIdByUserName(userName);
	}

	
	/**
	 * 
	 * @author liushuaic
	 * @date 2016-09-06 11:52
	 * @desc 删除某一个问题
	 * @param questionId 问题id
	 * @return int 删除数量
	 * 
	 * */
	public int deleteQuestionByQuestionId(Long questionId){
		questionTaglibMapManager.deleteQuestionTaglibByQuestionId(questionId);
		questionImageManager.deleteQuestionImageByQuestionId(questionId);
		return questionManager.deleteQuestionByQuestionId(questionId);
	}
	
	
}
