/* 
 * File:   manageclientthread.java
 * Usage:  The hashmap to find the client
 * Author: Jinchong Zhou
 *
 * Created on April, 2012
 * Modified on Jan, 2014
 */

package server.model;

import java.util.*;

public class manageclientthread {

	public static HashMap<String, serverThread> hm = new HashMap<String, serverThread>();

	public static void addclientthread(String uid, serverThread ct) {
		hm.put(uid, ct);

	}

	public static serverThread getClientThread(String uid) {
		return (serverThread) hm.get(uid);
	}
}
