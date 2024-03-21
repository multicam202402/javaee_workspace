package com.sds.newsapp.swing;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//뉴스 기사 게시판 등록 폼 
public class WriteForm extends JFrame{
	JTextField t_title, t_writer;
	JTextArea area;
	JScrollPane scroll;
	JButton bt;
	
	public WriteForm() {
		
		//생성 
		t_title = new JTextField();
		t_writer = new JTextField();
		area = new JTextArea();
		scroll = new JScrollPane(area);
		bt = new JButton("등록");
		
		//스타일 
		Dimension d = new Dimension(280, 40);
		
		t_title.setPreferredSize(d);
		t_writer.setPreferredSize(d);
		scroll.setPreferredSize(new Dimension(280, 200));
		
		//부착 
		setLayout(new FlowLayout());
		add(t_title);
		add(t_writer);
		add(scroll);
		add(bt);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300,400);
		setVisible(true);		
	}
	
	public static void main(String[] args) {
		new WriteForm();
	}

}
