package client.view;

import javax.imageio.ImageIO;
import javax.swing.*;

import client.model.manageQQchat;
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

public class friend extends JFrame implements ActionListener, MouseListener {
	
	JPanel jp1, jp2;
	CardLayout cardjp1;
	JPanel jp1_1, jp1_2, jp1_3;
	JButton jb1, jb2, jb3;
	JScrollPane jsp;
	int length = 50;
	JLabel jL[] = new JLabel[length];
	Image jp3_bg;
	String myid;

	friend(String a) {
		myid = a;
		cardjp1 = new CardLayout();
		jp1 = new JPanel(cardjp1);
		jp1_2 = new JPanel();
		jp1_3 = new JPanel();
		jp1_1 = new JPanel();
		jp2 = new JPanel();
		jb1 = new JButton("my friend");
		jb1.setActionCommand("1");
		jb1.addActionListener(this);
		jb2 = new JButton("stranger");
		jb2.setActionCommand("2");
		jb2.addActionListener(this);

		jb3 = new JButton("blacklist");
		jb3.setActionCommand("3");
		jb3.addActionListener(this);
		jp2.setLayout(new GridLayout(2, 1));
		jp2.add(jb2);
		jp2.add(jb3);

		jp1_1.setLayout(new GridLayout(length, 1));
		for (int i = 0; i < length; i++) {
			jL[i] = new JLabel(i + 1 + "", new ImageIcon("image/mm.jpg"),
					JLabel.LEFT);
			jL[i].addMouseListener(this);
			jp1_1.add(jL[i]);
		}
		try {
			jp3_bg = ImageIO.read(new File("image/mm.jpg"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		jp1.add(jp1_1, "1");
		jp1.add(jp1_2, "2");
		jp1.add(jp1_3, "3");
		jsp = new JScrollPane(jp1);
		this.add(jsp);
		this.add(jb1, BorderLayout.NORTH);

		this.add(jp2, BorderLayout.SOUTH);

		this.setSize(200, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(a);

		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("1"))
			this.cardjp1.show(jp1, "1");
		else if (e.getActionCommand().equals("2"))
			this.cardjp1.show(jp1, "2");
		else if (e.getActionCommand().equals("3"))
			this.cardjp1.show(jp1, "3");

	}

	public void mouseClicked(MouseEvent e) {
		
		String friendNo = ((JLabel) e.getSource()).getText();
		

		if (manageQQchat.getQQchat(myid + " " + friendNo) == null ){
			
			System.out.println("add a QQchat" + myid + " " 	+ friendNo);
			QQchat qq = new QQchat(myid, friendNo);
			manageQQchat.addQQchat(myid + " " + friendNo, qq);
		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		JLabel jLab = (JLabel) e.getSource();
		jLab.setForeground(Color.red);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		JLabel jLab = (JLabel) e.getSource();
		jLab.setForeground(Color.black);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
