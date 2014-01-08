package client.view;

import javax.swing.*;

import common.User;
import client.model.myclient;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.*;

public class clientlogin extends JFrame implements ActionListener {

	// Component in the north
	JLabel jl1;
	
	// Component in the center
	JTabbedPane jtp;
	JPanel jp2, jp3, jp4;
	JLabel jp2_jl1, jp2_jl2, jp2_jl3, jp2_jl4;
	JButton jp2_jb1;
	JTextField jp2_jtf1;
	JPasswordField jp2_jpf1;
	JCheckBox jp2_jcb1, jp2_jcb2;
	
	// Component in the south
	JPanel jp1;
	JButton jp1_jb1, jp1_jb2, jp1_jb3;

	public static void main(String[] args) {
		
		new clientlogin();
	}

	clientlogin() {
		
		// North
		jl1 = new JLabel(new ImageIcon("image/tou.gif"));
		
		// Center
		jp2 = new JPanel();
		jp2.setLayout(new GridLayout(3, 3));
		jp2_jl1 = new JLabel("QQ number", JLabel.CENTER);
		jp2_jl2 = new JLabel("QQ password", JLabel.CENTER);
		jp2_jl3 = new JLabel("forget password");
		jp2_jl3.setForeground(Color.BLUE);
		jp2_jl4 = new JLabel("pwd protect");
		jp2_jb1 = new JButton(new ImageIcon("image/clear.gif"));
		jp2_jtf1 = new JTextField();
		jp2_jpf1 = new JPasswordField();
		jp2_jcb1 = new JCheckBox("hidden login");
		jp2_jcb2 = new JCheckBox("remember pwd");

		jp2.add(jp2_jl1);
		jp2.add(jp2_jtf1);
		jp2.add(jp2_jb1);
		jp2.add(jp2_jl2);
		jp2.add(jp2_jpf1);
		jp2.add(jp2_jl3);
		jp2.add(jp2_jcb1);
		jp2.add(jp2_jcb2);
		jp2.add(jp2_jl4);
		jtp = new JTabbedPane();
		jtp.add("QQ number", jp2);
		jp3 = new JPanel();
		jp4 = new JPanel();
		jtp.add("phone", jp3);
		jtp.add("e-mail", jp4);

		// South
		jp1 = new JPanel();
		jp1_jb1 = new JButton(new ImageIcon("image/denglu.gif"));
		jp1_jb1.addActionListener(this);
		jp1_jb2 = new JButton(new ImageIcon("image/quxiao.gif"));
		jp1_jb3 = new JButton(new ImageIcon("image/xiangdao.gif"));
		jp1.add(jp1_jb1);
		jp1.add(jp1_jb2);
		jp1.add(jp1_jb3);

		this.add(jl1, BorderLayout.NORTH);
		this.add(jtp);
		this.add(jp1, BorderLayout.SOUTH);

		this.setSize(350, 240);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(Toolkit.getDefaultToolkit().createImage(
				"image/qq.gif"));
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == jp1_jb1) {
			
			myclient qquser = new myclient();
			User u = new User();
			u.setUserid(jp2_jtf1.getText().trim());
			u.setPasswd(new String(jp2_jpf1.getPassword()));
			
			if (qquser.SendLoginInfo(u)) {
				
				new friend(jp2_jtf1.getText().trim());
				this.dispose();

			} else
				JOptionPane.showMessageDialog(this, "Wrong id or password");
		}
	}
}
