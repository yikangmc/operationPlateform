package com.yikang.protal.common.utils.operationmessage;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * @author liushuaic
 * @date 2016-06-06 12:10
 * @desc 业务信息发送队列
 **/
public class OperationMessageQueue {

	private static BlockingQueue<OperationMessage> messageQueues = new LinkedBlockingQueue<OperationMessage>();

	private static Logger logger = LoggerFactory.getLogger(OperationMessageQueue.class);

	public static void putMessage(OperationMessage operationMessage) {
		try {
			messageQueues.put(operationMessage);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @author liushuaic
	 * @date 2016-06-06 15:20
	 * @desc 获取信息，阻塞
	 */
	public static OperationMessage takeMessage() {
		try {
			return messageQueues.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

	

	/**
	 * @desc 添加身份认证推送队列
	 **/
	public static BlockingQueue<OperationMessage> usersQueue = new LinkedBlockingQueue<OperationMessage>();

	public static void putUsersQueue(OperationMessage operationMessage) {
		logger.info("OperationMessageQueue -->putUsersQueue-->info--> "
				+ operationMessage.getContent());
		try {
			usersQueue.put(operationMessage);
		} catch (InterruptedException e) {
			logger.info("OperationMessageQueue -->putUsersQueue-->info--> "
					+ operationMessage.getContent());
			e.printStackTrace();
		}
	}
	/**
	 * @author houyt
	 * @date 2016/09/21 11:49
	 * @desc 获取身份认证推送信息
	 * @return
	 */
	public static OperationMessage takeUsersMessage() {
		try {
			return usersQueue.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
