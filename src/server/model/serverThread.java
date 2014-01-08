/* 
 * File:   serverinterface.java
 * Usage:  The interface to start the server
 * Author: Jinchong Zhou
 * Function: the communication thread between the server and a customer
 * Created on April, 2012
 * Modified on Jan, 2014
 */

package server.model;

import javax.imageio.ImageIO;
import javax.swing.*;

import common.message;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import java.io.PrintWriter;
import java.net.*;

public class serverThread extends Thread {
	
	Socket s;

	public serverThread(Socket s) {
		this.s = s;
	}

	public void run() {
		
		System.out.println("I run");
		while (true) {
			
			// the thread can accept the information from the guest
			try {
				ObjectInputStream ois = new ObjectInputStream(s
						.getInputStream());
				try {
					
					message m = (message) ois.readObject();
					System.out.println("sender is " + m.getSender()
							+ "getter is " + m.getGetter() + "the content is "
							+ m.getInfo());
				
					// get the socket of the guest
					serverThread st = manageclientthread.getClientThread(m
							.getGetter());
					ObjectOutputStream oos = new ObjectOutputStream(st.s
							.getOutputStream());
					oos.writeObject(m);

				} catch (ClassNotFoundException e) {
					
					e.printStackTrace();
				}

			} catch (IOException e) {
				
				e.printStackTrace();
			}

		}
	}

}
