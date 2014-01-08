package client.model;

import javax.imageio.ImageIO;
import javax.swing.*;

import common.User;
import common.message;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import java.io.PrintWriter;
import java.net.*;
import client.model.*;

public class myclient {

	public Socket s;

	public myclient() {	}

	public boolean SendLoginInfo(Object o) {
		
		boolean b = false;

		try {
			s = new Socket("127.0.0.1", 9996);
			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(o);
			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			
			try {
				
				message ms = (message) ois.readObject();
				
				if (ms.getMesType().equals("1")) {
					
					b = true;
					clientThread ct = new clientThread(s);
					manageclientthread2.addclientthread(((User) o).getUserid(),
							ct);
					ct.start();
				}

				else
					s.close();

			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}

		} catch (UnknownHostException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return b;
	}
}
