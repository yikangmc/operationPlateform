package com.yikang.protal.dao;

import com.yikang.protal.entity.UserInfo;

public interface UserInfoDao {
    int deleteByPrimaryKey(Long userInfoId);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Long userInfoId);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
}