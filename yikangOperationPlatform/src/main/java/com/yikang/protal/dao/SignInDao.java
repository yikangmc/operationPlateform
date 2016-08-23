package com.yikang.protal.dao;

import com.yikang.protal.entity.SignIn;

public interface SignInDao {
    int deleteByPrimaryKey(Long signInId);

    int insert(SignIn record);

    int insertSelective(SignIn record);

    SignIn selectByPrimaryKey(Long signInId);

    int updateByPrimaryKeySelective(SignIn record);

    int updateByPrimaryKey(SignIn record);
}