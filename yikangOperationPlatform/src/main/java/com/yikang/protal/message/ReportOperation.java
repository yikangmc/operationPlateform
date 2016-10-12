package com.yikang.protal.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikang.base.cache.UsersCache;
import com.yikang.common.message.im.Message;
import com.yikang.common.message.im.MessageQueue;
import com.yikang.common.utils.MessageProperties;
import com.yikang.protal.common.utils.operationmessage.OperationMessage;
import com.yikang.protal.common.utils.operationmessage.OperationMessageQueue;
import com.yikang.protal.entity.User;
import com.yikang.protal.manager.MessageManager;

@Component(value = "reportOperation")
public class ReportOperation implements Runnable {

	@Autowired
	private MessageManager messageManager;

	private Logger logger = LoggerFactory.getLogger(getClass());

	public void run() {
		while (true) {
			try {
				OperationMessage operationMessage = OperationMessageQueue.takeReportMessage();
				// 不符合的原因(举报理由)
				String message = operationMessage.getContent();
				String[] info = message.split("%", 3);
				// 推送标识
				String pushAlias = operationMessage.getPushAlias();
				// 推送消息分类
				String messageGroup = operationMessage.getMessageGroup();
				User user = (User) UsersCache.get(pushAlias);
				Long userId = user.getUserId();
				String multiple3 = MessageProperties.getPropertieValue("message_body_3");
				String multiple4 = MessageProperties.getPropertieValue("message_body_4");
				String multiple5 = MessageProperties.getPropertieValue("message_body_5");
				String multiple6 = MessageProperties.getPropertieValue("message_body_6");
				String multiple7 = MessageProperties.getPropertieValue("message_body_7");
				message = multiple3 + info[0] + multiple4 + info[2] + multiple5 + multiple6 + info[1] + multiple7;
				messageManager.insertSystemFollowMessage(userId, message, message, Byte.valueOf("10"));
				try {
					Message<String> messages = new Message<String>();
					messages.setAlias(pushAlias);
					messages.setContent(message);
					messages.setMessageCategroy(0);
					MessageQueue.put(messages);
				} catch (Exception e) {
					logger.error("举报删除定向推送异常     userId：" + userId + ",message:" + message);
					e.printStackTrace();
				}
			} catch (Exception e) {
				e.printStackTrace();
				logger.error(e.getMessage());
			}
		}
	}

}
