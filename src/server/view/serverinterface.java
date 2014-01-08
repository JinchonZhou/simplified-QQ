/* 
 * File:   serverinterface.java
 * Usage:  The interface to start the server
 * Author: Jinchong Zhou
 *
 * Created on April, 2012
 * Modified on Jan, 2014
 */


package server.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import server.model.myserver;
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

public class serverinterface extends JFrame implements ActionListener {

	/**
	 * @param args
	 */
	JPanel jp1;
	JButton jb1, jb2;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new serverinterface();
	}

	serverinterface() {
		
		jp1 = new JPanel();
		jb1 = new JButton("start the server");
		jb1.addActionListener(this);
		jb2 = new JButton("stop the server");
		jb2.addActionListener(this);
		jp1.add(jb1);
		jp1.add(jb2);
		this.add(jp1);
		this.setSize(300, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == jb1) {
			new myserver();
		}
	}

}
