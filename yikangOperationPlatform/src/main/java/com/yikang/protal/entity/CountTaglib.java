package com.yikang.protal.entity;
/**
 * 这个类是当日每个标签下的发帖量，专家说量，回答量，问题量的表格上面要显示的内容
 * @author dell
 *
 */
public class CountTaglib {
	
	//	标签ID
	private int taglibId;
	//	标签名字
	private String taglibName;
	//	数量
	private int number;
	
	public int getTaglibId() {
		return taglibId;
	}
	
	public void setTaglibId(int taglibId) {
		this.taglibId = taglibId;
	}
	
	public String getTaglibName() {
		return taglibName;
	}
	
	public void setTaglibName(String taglibName) {
		this.taglibName = taglibName;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}

}
