package com.yikang.protal.dao;

import java.util.List;
import java.util.Map;

import com.yikang.protal.entity.Answer;
import com.yikang.protal.entity.Question;

public interface QuestionDao {
    int deleteByPrimaryKey(Long questionId);

    int insert(Question record);

    int insertSelective(Question record);

    Question selectByPrimaryKey(Long questionId);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKey(Question record);
    
    
    /**
     * @author liushuaic
     * @date 2016-05-11 11:49
     * @desc 查询某一个问题的详情
     * **/
    Question getQuestionDetailByQuestionId(Long questionId);
    
    
    /**
     * @author liushuaic
     * @date 2016-05-24 15:19
     * @desc 查询某一个标签下的所有问题
     * **/
    List<Question> getQuestionByTaglibid(Long taglibId);
    
    
    
    /**
     * @author liushuaic
     * @date 2016-06-07 11:22
     * @desc 获取某一个用户创建的所有问题
     * **/
    List<Question> getQuestionByCreateUserId(Long userId);
    
    /**
     * @author liushuaic
     * @date 2016-07-11 09:41
     * @desc 查询所有问题
     * 
     * */
    List<Question> queryAllQuestionsPage(Map<String,Object> paramMap);
    
    /**
	 * 根据问题id查询问题标题
	 * @param questionId
	 * @return
	 */
	public String queryQuestionTitleById(String questionId);
	
	/**
	 * 保存问题的答案
	 * @param answer
	 * @return
	 */
	public int saveAnswerOfQuestion(Answer answer);
	
	/**
	 * 根据用户名查询用户的id
	 * @param userName
	 * @return
	 */
	public Long queryUserIdByUserName(String userName);
    
}