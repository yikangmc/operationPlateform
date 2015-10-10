package com.yikang.protal.dao;

import com.yikang.protal.entity.UserFrom;

public interface UserFromDao {
    int deleteByPrimaryKey(Long userFromId);

    int insert(UserFrom record);

    int insertSelective(UserFrom record);

    UserFrom selectByPrimaryKey(Long userFromId);

    int updateByPrimaryKeySelective(UserFrom record);

    int updateByPrimaryKey(UserFrom record);
}