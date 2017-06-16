package com.constrants;

import java.util.List;

public class GlobalVariable {
	private static String accessToken;

	private static List<String> memberIds;

	public synchronized static String getAccessToken() {
		return accessToken;
	}

	public synchronized static void setAccessToken(String newAccessToken) {
		accessToken = newAccessToken;
	}

	public synchronized static boolean idsIsNul() {
		return memberIds == null;
	}

	public synchronized static void setMemberIds(List<String> ids) {
		if (memberIds == null) {
			memberIds = ids;
		}
	}

	public synchronized static boolean hasId(String id) {
		return memberIds.contains(id);
	}

	public synchronized static void addIds(String id) {
		memberIds.add(id);
	}
}
