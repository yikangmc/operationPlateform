package com.yikang.protal.dao;

import com.yikang.protal.entity.FormPostsTaglibsMap;

public interface FormPostsTaglibsMapDao {
    int deleteByPrimaryKey(Long forumPostsTaglibsMapsId);

    int insert(FormPostsTaglibsMap record);

    int insertSelective(FormPostsTaglibsMap record);

    FormPostsTaglibsMap selectByPrimaryKey(Long forumPostsTaglibsMapsId);

    int updateByPrimaryKeySelective(FormPostsTaglibsMap record);

    int updateByPrimaryKey(FormPostsTaglibsMap record);

	int deleteByFormPostId(Long formPostId);
	
	Long selectTagLibIdByFormPostId(Long formPostId);
}