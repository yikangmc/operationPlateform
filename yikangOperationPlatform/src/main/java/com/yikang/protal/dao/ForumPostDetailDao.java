package com.yikang.protal.dao;

import com.yikang.protal.entity.ForumPostDetail;

public interface ForumPostDetailDao {
    int deleteByPrimaryKey(Long forumPostDetailId);

    int insert(com.yikang.protal.entity.ForumPostDetail record);

    int insertSelective(ForumPostDetail record);

    ForumPostDetail selectByPrimaryKey(Long forumPostDetailId);

    int updateByPrimaryKeySelective(ForumPostDetail record);

    int updateByPrimaryKey(ForumPostDetail record);
    
    int updateByForumPostId(ForumPostDetail record);
    
    public int deleteByForumPostId(Long forumPostId);
    
}