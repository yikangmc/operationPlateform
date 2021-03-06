package com.yikang.common.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.yikang.common.message.im.MessageThreads;
import com.yikang.protal.message.ReportOperation;
import com.yikang.protal.message.SystemOperation;


/**
 * @author liushuaic
 * @date 2015/10/10 10:41
 * @desc 加载一些基本的信息
 * 队列容器，是需要，在一个单独的地方存储的。
 * 这样才不会出现，问题。
 * **/
public class PorpertiesLonder implements ApplicationContextAware {

	
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		
		/**
		 * @author liushuaic
		 * @date 2015/12/08 11:49 信息推送
		 * **/
		MessageThreads messageThreads =new MessageThreads();
		messageThreads.startSendMessage();
		
		
		/**
		 * @author houyt
		 * @date  2016/09/21 11:12
		 * @desc 系统消息推送
		 * 
		 */
		SystemOperation systemOperation = (SystemOperation) applicationContext.getBean("systemOperation");
		Thread systemOperationThread = new Thread(systemOperation);
		systemOperationThread.start();
		/**
		 * @author bry
		 * @date  2016/10/09 11:42
		 * @desc 举报消息推送
		 * 
		 */
		ReportOperation reportOperation = (ReportOperation) applicationContext.getBean("reportOperation");
		Thread reportOperationThread = new Thread(reportOperation);
		reportOperationThread.start();
	}

}
