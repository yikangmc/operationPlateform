package com.yikang.protal.common.utils.operationmessage;


/**
 * 
 * @author houyt
 * @date 2016-09-21 11:26
 * @desc 业务信息类
 * 
 * */
public class OperationMessage {

	//信息内容
	private String content;
	
	/**
	 * 推送标识
	 * */
	private String pushAlias;

	/**
	 * 消息分类
	 * 1 佳佳产品通知
	 * 2 佳佳团队通知
	 */
	private String messageGroup;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPushAlias() {
		return pushAlias;
	}

	public void setPushAlias(String pushAlias) {
		this.pushAlias = pushAlias;
	}

	public String getMessageGroup() {
		return messageGroup;
	}

	public void setMessageGroup(String messageGroup) {
		this.messageGroup = messageGroup;
	}
}
