package com.yikang.protal.message;
<<<<<<< Updated upstream
=======

>>>>>>> Stashed changes
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

@Component(value="systemOperation")
public class SystemOperation implements Runnable{
	
	@Autowired
	private MessageManager messageManager;
	
	
	private Logger logger=LoggerFactory.getLogger(getClass());
	
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
				try{
					Message<String> messages=new Message<String>();
					messages.setAlias(pushAlias);
					messages.setContent(content);
					messages.setMessageCategroy(0);
					MessageQueue.put(messages);
				}catch(Exception e){ 
					logger.error("身份认证推送异常     userId："+userId+",message:"+content);
					e.printStackTrace();
				}
			}catch(Exception  e){
				e.printStackTrace();
				logger.error(e.getMessage());
			}
		}
	}

}
