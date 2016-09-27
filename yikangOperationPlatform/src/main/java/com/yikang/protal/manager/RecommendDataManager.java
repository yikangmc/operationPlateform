package com.yikang.protal.manager;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikang.protal.dao.RecommendDataDao;
import com.yikang.protal.entity.Taglib;
import com.yikang.protal.entity.UserServiceInfo;

@Component
public class RecommendDataManager {
	@Autowired
	private RecommendDataDao recommendDataDao;

	/**
	 * 查询被推荐人的信息
	 * 
	 * @return
	 */
	public List<UserServiceInfo> queryRecommendUserInfo() {
		return recommendDataDao.queryRecommendUserInfo();
	}

	/**
	 * 查询热门标签
	 * 
	 * @return
	 */
	public List<Taglib> queryRecommendTaglibsInfo() {
		return recommendDataDao.queryRecommendTaglibsInfo();
	}

	/**
	 * 插入热门帖子
	 */
	public int insertTieziByPrimaryKey(long forumPostsId, Date createTime, String orders) {
		Map<String, Object> paramData = new HashMap<String, Object>();
		paramData.put("recomendGroup", Byte.valueOf((byte) 2));
		paramData.put("dataId", forumPostsId);
		paramData.put("createTime", createTime);
		paramData.put("updateTime", createTime);
		paramData.put("orders", Integer.valueOf(orders));
		paramData.put("isDelete", Byte.valueOf((byte) 0));
		recommendDataDao.insertTieziByPrimaryKey(paramData);
		return 1;
	}

	/**
	 * 热门帖子列表删除
	 */
	public int deleteHotByPrimaryKey(long forumPostsId) {
		recommendDataDao.deleteHotByPrimaryKey(forumPostsId);
		return 1;
	}
}
