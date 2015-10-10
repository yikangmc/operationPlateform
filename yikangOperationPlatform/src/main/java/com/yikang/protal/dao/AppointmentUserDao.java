package com.yikang.protal.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yikang.protal.entity.AppointmentUser;

public interface AppointmentUserDao {
    int deleteByPrimaryKey(Long appointmentUserId);

    int insert(AppointmentUser record);

    int insertSelective(AppointmentUser record);

    AppointmentUser selectByPrimaryKey(Long appointmentUserId);

    int updateByPrimaryKeySelective(AppointmentUser record);

    int updateByPrimaryKey(AppointmentUser record);
    
    
    /**
     * @author liushuaic
     * @date 2015/09/21 14:06 
     * 查询预约列表
     * */
    List<AppointmentUser> getAppointmentUserListPage(Map<String,Object> param);
    
    
    /**
     * @author liushuaic
     * @date 2015/09/21 16:22
     * */
    List<AppointmentUser> findAppointmentUserByMobileNumber(@Param("mobileNumber") String mobileNumber);
    
    

}