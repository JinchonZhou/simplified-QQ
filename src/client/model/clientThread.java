package client.model;

import javax.imageio.ImageIO;
import javax.swing.*;

import client.view.QQchat;

import server.model.manageclientthread;
import server.model.serverThread;

import common.message;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import java.io.PrintWriter;
import java.net.*;

public class clientThread extends Thread {
	private Socket s;

	public Socket getS() {
		return s;
	}

	public void setS(Socket s) {
		this.s = s;
	}

	public clientThread(Socket s) {
		this.s = s;
	}

	public void run() {
		while (true)

		{
			try {

				ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
				message m = (message) ois.readObject();
				// show on the corresponding QQ chat interface
				QQchat qqgetter = manageQQchat.getQQchat(m.getGetter() + " "
						+ m.getSender());
				QQchat qqsender = manageQQchat.getQQchat(m.getSender() + " "
						+ m.getGetter());
				System.out.println((qqgetter == null) + "        " + (qqsender == null) );
				qqgetter.showinformationobtain(m);
				
				qqsender.showinformationsend(m);

			} catch (Exception e) {
				e.printStackTrace();

			}

		}

	}
}
