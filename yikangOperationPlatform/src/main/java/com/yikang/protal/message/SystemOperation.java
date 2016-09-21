package com.yikang.protal.message;

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

@Component(value="systemOperation")
public class SystemOperation implements Runnable{
	
	@Autowired
	private MessageManager messageManager;
	
	public void run(){
		while(true){
			try{
				OperationMessage operationMessage = OperationMessageQueue.takeUsersMessage();
				//其他不符合的原因
				String content = operationMessage.getContent();
				//推送标识
				String pushAlias = operationMessage.getPushAlias();
				//推送分类
				String messageGroup = operationMessage.getMessageGroup();
				User user = (User) UsersCache.get(pushAlias);
				Long userId = user.getUserId();
				String multiple1=MessageProperties.getPropertieValue("message_body_1");
				String multipl2=MessageProperties.getPropertieValue("message_body_2");
				content = multiple1+content+multipl2;
				messageManager.insertSystemFollowMessage(userId, content, content, Byte.valueOf("10"));
				Message message = new Message();
				message.setAlias(pushAlias);
				message.setContent(content);
				MessageQueue.put(message);
			}catch(Exception  e){
				e.printStackTrace();
			}
		}
	}

}
