/* 
 * File:   myserver.java
 * Usage:  a socket
 * Author: Jinchong Zhou
 *
 * Created on April, 2012
 * Modified on Jan, 2014
 */
package server.model;

import javax.imageio.ImageIO;
import javax.swing.*;

import common.User;
import common.message;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;

public class myserver {

	ServerSocket ss;

	public static void main(String[] args) {
		
		new myserver();
	}

	public myserver() {
		
		try {
			
			ss = new ServerSocket(9996);
		
			while (true) {
				
				Socket s = ss.accept();
				
				// get information from the client
				ObjectInputStream ois = new ObjectInputStream(s
						.getInputStream());
				ObjectOutputStream oos = new ObjectOutputStream(s
						.getOutputStream());
				
				try {
					User u = (User) ois.readObject();
					
					System.out.println("I get the user " + u.getUserid()
							+ ", and its password is " + u.getPasswd());
					
					message m = new message();
					
					if (u.getPasswd().equals("123456"))

					{
						serverThread st = new serverThread(s);
						st.start();
						m.setMesType("1");
						oos.writeObject(m);
						manageclientthread.addclientthread(u.getUserid(), st);

					}

					else {
						m.setMesType("2");
						oos.writeObject(m);
						s.close();
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

		catch (IOException e1) {

			e1.printStackTrace();
		}

	}
}
