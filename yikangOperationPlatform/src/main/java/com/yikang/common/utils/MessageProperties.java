package com.yikang.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author liushuaic
 * @date 2015/12/10 11:55
 * @desc system配置信息
 **/
public class MessageProperties {

	private static Properties msgProperties = new Properties();

	static {
		try {
			InputStream inputStream = MessageProperties.class.getResource("/message.properties").openStream();
			msgProperties.load(inputStream);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @author liushuaic
	 * @date 2015/12/01 11:54
	 * @desc 获取systemProperties 文件中的值
	 */
	public static String getPropertieValue(String key) {
		return msgProperties.getProperty(key);
	}
	
	public static void main(String[] args) {
		String multiple=MessageProperties.getPropertieValue("message_body_1");
		System.out.println(multiple);
		String multiple2=MessageProperties.getPropertieValue("message_body_2");
		System.out.println(multiple2);
	}

}
