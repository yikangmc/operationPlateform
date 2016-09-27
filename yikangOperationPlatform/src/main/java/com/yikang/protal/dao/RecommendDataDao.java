package com.yikang.protal.dao;

import java.util.List;
import java.util.Map;

import com.yikang.protal.entity.RecommendData;
import com.yikang.protal.entity.Taglib;
import com.yikang.protal.entity.UserServiceInfo;

public interface RecommendDataDao {
	int deleteByPrimaryKey(Long recommendDataId);

	int insert(RecommendData record);

	int insertSelective(RecommendData record);

	RecommendData selectByPrimaryKey(Long recommendDataId);

	int updateByPrimaryKeySelective(RecommendData record);

	int updateByPrimaryKey(RecommendData record);

	/**
	 * 根据推荐用户的id查询被推荐人的信息
	 * 
	 * @param userId
	 * @return
	 */
	public List<UserServiceInfo> queryRecommendUserInfo();

	/**
	 * 查询推荐的标签信息
	 * 
	 * @return
	 */
	public List<Taglib> queryRecommendTaglibsInfo();
	/**
	 * 插入热门帖子
	 */
	public int insertTieziByPrimaryKey(Map<String, Object> paramData);
	/**
	 * 热门帖子列表删除
	 */
	public int deleteHotByPrimaryKey(long forumPostsId);
}