package client.view;

import javax.imageio.ImageIO;
import javax.swing.*;

import common.message;
import client.model.*;
import client.tools.*;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class QQchat extends JFrame implements ActionListener {

	JTextArea jta;
	JTextField jtf;
	JButton jb;
	JPanel jp;
	String OwnerId;
	String FriendId;

	QQchat(){}
	QQchat(String myid, String friendid) {
		
		OwnerId = myid;
		FriendId = friendid;
		jta = new JTextArea();
		jtf = new JTextField(15);

		jb = new JButton("send");
		jb.addActionListener(this);
		jp = new JPanel();
		jp.add(jtf);
		jp.add(jb);
		this.add(jta, BorderLayout.CENTER);
		this.add(jp, BorderLayout.SOUTH);

		this.setSize(360, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(myid + " is chatting with " + friendid);
		this.setIconImage(Toolkit.getDefaultToolkit().createImage(
				"image/qq.gif"));
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == jb) {
		
			message m = new message();
			m.setSender(OwnerId);
			m.setGetter(FriendId);
			m.setInfo(jtf.getText());
			m.setTime(new java.util.Date().toString());
			ObjectOutputStream oos;
			
			try {
				oos = new ObjectOutputStream(manageclientthread2
						.getClientThread(OwnerId).getS().getOutputStream());
				oos.writeObject(m);
				
			} catch (IOException e1) {

				e1.printStackTrace();
			}
		}
	}

	public void showinformationobtain(message m) {
		
		String info = m.getGetter() + " said at+" + m.getTime() + ": "
				+ m.getInfo() + "\r\n";
		this.jta.append(info);

	}

	public void showinformationsend(message m) {
		
		String info = m.getSender() + " said at+" + m.getTime() + ": "
				+ m.getInfo() + "\r\n";
		this.jta.append(info);
	}
}

