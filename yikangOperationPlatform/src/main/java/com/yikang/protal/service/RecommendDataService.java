package com.yikang.protal.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yikang.protal.common.response.ResponseMessage;
import com.yikang.protal.entity.Taglib;
import com.yikang.protal.entity.UserServiceInfo;
import com.yikang.protal.manager.RecommendDataManager;

@Service("recommendDataService")
public class RecommendDataService {
	@Autowired
	private RecommendDataManager recommendDataManager;

	/**
	 * 查询推荐人的相关信息
	 * 
	 * @param paramMap
	 * @return
	 */
	public ResponseMessage<List<UserServiceInfo>> queryRecommedUserInfo(Map<String, Object> paramMap) {
		ResponseMessage<List<UserServiceInfo>> info = new ResponseMessage<List<UserServiceInfo>>();
		List<UserServiceInfo> userInfos = recommendDataManager.queryRecommendUserInfo();
		info.setData(userInfos);

		return info;
	}

	/**
	 * 查询热门标签
	 * 
	 * @param paramMap
	 * @return
	 */
	public ResponseMessage<List<Taglib>> queryRecommendTaglibsInfo(Map<String, Object> paramMap) {
		ResponseMessage<List<Taglib>> taglibs = new ResponseMessage<List<Taglib>>();
		List<Taglib> taglibsInfo = recommendDataManager.queryRecommendTaglibsInfo();
		taglibs.setData(taglibsInfo);
		return taglibs;
	}

	/**
	 * 添加热门帖子
	 */
	public int insertTieziByPrimaryKey(long forumPostsId, String orders) {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 创建时间
		String createTime = formatter.format(currentTime);
		try {
			Date date = formatter.parse(createTime);
			recommendDataManager.insertTieziByPrimaryKey(forumPostsId, date, orders);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 1;
	}

	/**
	 * 热门帖子列表删除
	 */
	public int deleteHotByPrimaryKey(long forumPostsId) {
		recommendDataManager.deleteHotByPrimaryKey(forumPostsId);
		return 1;
	}
}
