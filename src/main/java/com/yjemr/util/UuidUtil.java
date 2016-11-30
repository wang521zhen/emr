package com.yjemr.util;

import java.util.UUID;

/**
 * 获取32位UUID
 * @author Administrator
 *
 */
public class UuidUtil {

	public static String get32UUID() {
		String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
		return uuid;
	}

	public static void main(String[] args) {
		System.out.println(get32UUID());
	}
}
