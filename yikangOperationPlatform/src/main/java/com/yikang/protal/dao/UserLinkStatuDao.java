package com.yikang.protal.dao;

import java.util.List;
import java.util.Map;

import com.yikang.protal.entity.UserLinkStatu;

public interface UserLinkStatuDao {
    int deleteByPrimaryKey(Long userStatusId);

    int insert(UserLinkStatu record);

    int insertSelective(UserLinkStatu record);

    UserLinkStatu selectByPrimaryKey(Long userStatusId);

    int updateByPrimaryKeySelective(UserLinkStatu record);

    int updateByPrimaryKey(UserLinkStatu record);
    
    
    List<Map<String,Object>> getUserLinkUserStatus();
}