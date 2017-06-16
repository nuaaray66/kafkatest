package com.pay.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Util {

	public static String getMd5(String input) {
		MessageDigest alg = null;
		try {
			alg = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		alg.update(input.getBytes());
		byte[] digesta = alg.digest();
		StringBuffer localStringBuffer = new StringBuffer();
		String str = "";
		for (int i = 0; i < digesta.length; ++i) {
			str = Integer.toHexString(digesta[i] & 0xFF);
			if (str.length() == 1)
				localStringBuffer.append("0");
			localStringBuffer.append(str);
		}
		return localStringBuffer.toString().toUpperCase();
	}

}
