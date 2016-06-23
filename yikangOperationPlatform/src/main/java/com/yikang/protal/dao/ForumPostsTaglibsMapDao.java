package com.yikang.protal.dao;

import com.yikang.protal.entity.ForumPostsTaglibsMap;

public interface ForumPostsTaglibsMapDao {
    int deleteByPrimaryKey(Long forumPostsTaglibsMapsId);

    int insert(ForumPostsTaglibsMap record);

    int insertSelective(ForumPostsTaglibsMap record);

    ForumPostsTaglibsMap selectByPrimaryKey(Long forumPostsTaglibsMapsId);

    int updateByPrimaryKeySelective(ForumPostsTaglibsMap record);

    int updateByPrimaryKey(ForumPostsTaglibsMap record);
}