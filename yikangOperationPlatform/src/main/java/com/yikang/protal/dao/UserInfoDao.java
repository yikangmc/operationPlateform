package com.yikang.protal.dao;

import java.util.List;
import java.util.Map;

import com.yikang.protal.entity.CountTaglib;
import com.yikang.protal.entity.UserInfo;

public interface UserInfoDao {
    int deleteByPrimaryKey(Long userInfoId);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Long userInfoId);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
      
    /**
     * @author liushuaic
     * @date 2016/1/21 11:04
     * @desc  获取用户信息列表。
     * **/
    List<UserInfo> getUserInfoListPage(Map<String,Object> paramData);
    /**
     * @desc  获取每日用户数量
     * **/
   int getUserCountByDate(Map<String,Object> paramData);
   
   /**
    * @desc  当天每个标签下的发帖量
    * **/
   List<CountTaglib> getCardCountByDate(Map<String,Object> paramData);
   /**
    * @desc  当天每个标签下的专家说量
    * **/
   List<CountTaglib> getExpertCountByDate(Map<String,Object> paramData);
   /**
    * @desc  当天每个标签下的问题的回答量
    * **/
   List<CountTaglib> getAnswerCountByDate(Map<String,Object> paramData);
   /**
    * @desc  当天每个标签下的问题量
    * **/
   List<CountTaglib> getQuestionCountByDate(Map<String,Object> paramData);
    
}