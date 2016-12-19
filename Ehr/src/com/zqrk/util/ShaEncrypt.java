package com.zqrk.util;

import java.security.MessageDigest;

/**
 * @author sivan 
 * 2016��5��9������4:45:58
 * sha���봦����
 */
public class ShaEncrypt {
	/**
	 * 
	 * @param inStr
	 *            ����
	 * @return ����
	 * @throws Exception
	 */
	public static String shaEncode(String inStr) throws Exception {
		MessageDigest sha = null;
		try {
			sha = MessageDigest.getInstance("SHA");
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
			return "";
		}

		byte[] byteArray = inStr.getBytes("UTF-8");
		byte[] md5Bytes = sha.digest(byteArray);
		StringBuffer hexValue = new StringBuffer();
		for (int i = 0; i < md5Bytes.length; i++) {
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16) {
				hexValue.append("0");
			}
			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString();
	}

	/**
	 * ����������
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String args[]) throws Exception {
		String str = new String("123456");
		System.out.println("SHA��" + shaEncode(str));
	}
}
