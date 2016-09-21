package com.yikang.protal.dao;

import java.util.List;
import java.util.Map;

import com.yikang.protal.entity.User;

public interface UserDao {
    int deleteByPrimaryKey(Long userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    User getUserByLoginName(String userName);
    
    /**
     * @author liushuaic
     * @date 2015/11/18 15:29
     * @desc 邀请码，是根据用户id 获取的
     * 添加用户邀请码
     * */
    int updateInvitationCodeByUserId(Map<String,Object> paramData);
    
    List<User> getAllUsers();
}