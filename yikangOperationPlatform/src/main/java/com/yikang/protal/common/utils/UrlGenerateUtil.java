package com.yikang.protal.common.utils;

import java.util.UUID;

import com.yikang.common.utils.SystemProperties;


public class UrlGenerateUtil {

	
	/**
	 * @author liushuaic
	 * @date 2016-06-17 18:05
	 * @desc 生成文章分享url
	 * **/
	public static String generateShareForumPostUrl(){
//		String shareUrl=System.getProperty("shareForumPostUrl");
		String shareUrl=SystemProperties.getPropertieValue("shareForumPostUrl");
		String uuid=UUID.randomUUID().toString().replaceAll("-", "");
		return shareUrl+uuid;
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2016-06-17 18:05
	 * @desc 生成文章分享url
	 * **/
	public static String generateShareForumPostUrl(String uuid){
		String shareUrl=SystemProperties.getPropertieValue("shareForumPostUrl");
		//uuid= uuid.replaceAll("-", "");
		return shareUrl+uuid;
	}
	/**
	 * @author liushuaic
	 * @date 2016-06-17 18:09
	 * @desc 生成问题回答分享url
	 * */
	public static String generateShareQuestionAnswerUrl(){
		String shareQuestionAnswerUrl=System.getProperty("shareQuestionAnswerDetailUrl");
		String uuid=UUID.randomUUID().toString();
		return shareQuestionAnswerUrl+uuid;
	}
	
}
