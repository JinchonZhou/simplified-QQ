package client.model;

import java.util.HashMap;

import client.view.QQchat;

public class manageQQchat {
	
	public static HashMap<String, QQchat> hm = new HashMap<String, QQchat>();

	public static void addQQchat(String loginidandfriendid, QQchat ct) {
		hm.put(loginidandfriendid, ct);

	}

	public static QQchat getQQchat(String uid) {
		return (QQchat) hm.get(uid);
	}
}