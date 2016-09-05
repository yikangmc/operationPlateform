package com.yikang.protal.dao;

import java.util.List;
import java.util.Map;

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
    
}