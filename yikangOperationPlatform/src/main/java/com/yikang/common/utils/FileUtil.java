package com.yikang.common.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.UUID;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


public class FileUtil
{
  public static String getFileSuffix(String fileName)
  {
    return fileName.substring(fileName.lastIndexOf("."), fileName.length());
  }

  public static String getUniqueFileName(String fileName)
  {
    String suffix = fileName.substring(fileName.lastIndexOf("."), fileName.length());
    UUID uuid = UUID.randomUUID();
    return uuid + suffix;
  }
  
  
	public static String uploadFile(String Url,File file) throws IOException {

		CloseableHttpClient httpclient = HttpClients.createDefault();
//		String urlStr="http://192.168.1.44:8081/yikangFileManage/fileUpload/imageFileUpload";

		HttpPost httpPost = new HttpPost(Url);
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
		builder.addBinaryBody("files", file, ContentType.DEFAULT_BINARY, file.getName());
		builder.addTextBody("fileGroup", "headImage");
		Charset charset=Charset.forName("utf-8");
		builder.setCharset(charset);
		
		HttpEntity entity = builder.build();
		httpPost.setEntity(entity);
		System.out.println("Executing request " + httpPost.getRequestLine());

		ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
			public String handleResponse(final HttpResponse response) throws ClientProtocolException, IOException {
				int status = response.getStatusLine().getStatusCode();
				if (status >= 200 && status < 300) {
					HttpEntity entity = response.getEntity();
					return entity != null ? EntityUtils.toString(entity) : null;
				} else {
					throw new ClientProtocolException("Unexpected response status: " + status);
				}
			}

		};
		String responseBody = httpclient.execute(httpPost, responseHandler);
		return responseBody;
	}
	
	
	public static String uploadFile(String Url,byte[] file,String fileName) throws IOException {

		CloseableHttpClient httpclient = HttpClients.createDefault();
//		String urlStr="http://192.168.1.44:8081/yikangFileManage/fileUpload/imageFileUpload";

		HttpPost httpPost = new HttpPost(Url);
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
		builder.addBinaryBody("files", file,ContentType.DEFAULT_BINARY,fileName);
		builder.addTextBody("fileGroup", "headImage");
		Charset charset=Charset.forName("utf-8");
		builder.setCharset(charset);
		
		HttpEntity entity = builder.build();
		httpPost.setEntity(entity);
		System.out.println("Executing request " + httpPost.getRequestLine());

		ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
			public String handleResponse(final HttpResponse response) throws ClientProtocolException, IOException {
				int status = response.getStatusLine().getStatusCode();
				if (status >= 200 && status < 300) {
					HttpEntity entity = response.getEntity();
					return entity != null ? EntityUtils.toString(entity) : null;
				} else {
					throw new ClientProtocolException("Unexpected response status: " + status);
				}
			}
		};
		String responseBody = httpclient.execute(httpPost, responseHandler);
		return responseBody;
	}
	
	public static String uploadFile(String Url,InputStream inputStream) throws IOException {

		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(Url);
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
		builder.addBinaryBody("files", inputStream);
		builder.addTextBody("fileGroup", "headImage");
		Charset charset=Charset.forName("utf-8");
		builder.setCharset(charset);
		
		HttpEntity entity = builder.build();
		httpPost.setEntity(entity);
		System.out.println("Executing request " + httpPost.getRequestLine());

		ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
			public String handleResponse(final HttpResponse response) throws ClientProtocolException, IOException {
				int status = response.getStatusLine().getStatusCode();
				if (status >= 200 && status < 300) {
					HttpEntity entity = response.getEntity();
					return entity != null ? EntityUtils.toString(entity) : null;
				} else {
					throw new ClientProtocolException("Unexpected response status: " + status);
				}
			}

		};
		String responseBody = httpclient.execute(httpPost, responseHandler);
		return responseBody;
	}


  /**
   * @author liushuaic
   * @date 2016-05-14 00:39
   * @desc 获取fileUrl 的文件名称 ，主要对于阿里云
   * **/
  public static String getFileName(String fileUrl){
	  int lastIndex=fileUrl.lastIndexOf("/");
	  String fileName=fileUrl.substring(lastIndex+1);
	   return fileName;
  }
  
}