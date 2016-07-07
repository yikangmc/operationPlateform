package com.yikang.common.utils;

import java.util.UUID;

public class UuidGernerator {
	public static String getUuidString(){
		String s = UUID.randomUUID().toString();
		String replace = s.replace("-", "");
		return replace;
	}
}
