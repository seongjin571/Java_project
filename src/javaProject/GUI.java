package javaProject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.border.*;


public class GUI extends JFrame{
	JLabel lb1, la1, la2, la3, la4, status;
	JTextField id, pw;
	JPanel idPanel, paPanel, loginPanel;
	JButton b1, b2;
	JTextArea content;
	Image img = null;
	public GUI() {
		super("Login"); //â �̸� Login
		setLayout(null); //���̾ƿ� ���� ���ϴ� ��ġ��

		picture();
		
		idpw();
		
		Button();
		
		setSize(650,900);//��ü â ũ�� ����
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);//x������ �� ����
		setResizable(false);//â ũ�� ����
	}
	
	void picture() {
		
		try {
			File sourceimage = new File("src\\images\\sejong.png");
			img = ImageIO.read(sourceimage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//�׸����� ��������
			
		la4 = new JLabel(new ImageIcon(img));
		la4.setBounds(35, 10, 550, 550);
		add(la4);// �׸� ����
		
	}
	void idpw(){
		
		idPanel = new JPanel();
		paPanel = new JPanel();
		la3 = new JLabel("  ID ");
		la3.setFont(new Font("",Font.BOLD, 26));
		la2 = new JLabel("PW ");
		la2.setFont(new Font("",Font.BOLD, 26));//ID, PW ���� ����

		id = new JTextField(13);
		id.setFont(new Font("",Font.BOLD, 20));
		pw = new JPasswordField(13);//�Է½� �ܷ� �Էµ�
		pw.setFont(new Font("",Font.BOLD, 20));//id, pw �Է� â ���� ����
		
		idPanel.add(la3);
		idPanel.add(id);
		idPanel.setBounds(80, 620, 300, 80);
		add(idPanel);// ID���ڿ� �ڽ� ����

		paPanel.add(la2);
		paPanel.add(pw);
		paPanel.setBounds(80, 690, 300, 60);
		add(paPanel);// PW���ڿ� �ڽ� ����

		
	}
	
	void Button() {
		
		b1 = new JButton("LOGIN");
		b2 = new JButton("JOIN");//LOGIN, JOIN ��ư ����
		
		b1.setBounds(430,615,100,125);
		b2.setBounds(250,770,120,40);
		add(b1);
		add(b2);//LOGIN, JOIN ��ư ���� �� ����
		
		status = new JLabel();// id+pw ������ label;
		b1.addActionListener(new ActionListener() {//login��ư Ŭ���� �߻��ϴ� �׼�
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String u_id = id.getText();//�Է� �� id ��������
				String u_pw = pw.getText();//�Է� �� pw ��������
				status.setText(u_id+" "+u_pw);// Ȯ�ο�; id+pw�� status ����
			}
		});
		
		status.setBounds(300, 820, 150, 40);
		add(status);// id+pw �� status ���� �� ����
		
		b2.addActionListener(new ActionListener() {//join��ư Ŭ���� �߻��ϴ� �׼�
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				
				if((JButton) obj == b2) {// join��ư�� ������
					Join j2 = new Join("Join");// �� join ����
					j2.setVisible(true);
					j2.setSize(550, 620);//ũ�� ����
					j2.setLocation(500, 100);//������ ��ġ ����
					j2.addWindowListener(new WindowAdapter() {//x������ ��â�� ����ǰ�
						public void windowClosing(WindowEvent e) {
							j2.setVisible(false);
							j2.dispose();
						}
					});
				}
			}
		});
		
	}
	
	
	public static void main(String[] args) {
		GUI j1 = new GUI();
		
		
	}
	
}