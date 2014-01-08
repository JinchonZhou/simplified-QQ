package client.model;

import java.util.HashMap;

import server.model.serverThread;

public class manageclientthread2 {

	public static HashMap<String, clientThread> hm = new HashMap<String, clientThread>();

	public static void addclientthread(String uid, clientThread ct) {
		hm.put(uid, ct);

	}

	public static clientThread getClientThread(String uid) {
		return (clientThread) hm.get(uid);
	}
}