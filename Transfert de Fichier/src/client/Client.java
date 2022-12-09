package client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Color;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class Client extends JFrame {

	
	JButton choosebtn;
	JButton sendbtn;
	JLabel fileChoosen;
	final File[] fileToSend=new File[1];
	int port = 1234;
	
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public JLabel getFileChoosen() {
		return fileChoosen;
	}
	public void setFileChoosen(JLabel fileChoosen) {
		this.fileChoosen = fileChoosen;
	}
	public JButton getChoosebtn() {
		return choosebtn;
	}
	public void setChoosebtn(JButton choosebtn) {
		this.choosebtn = choosebtn;
	}

	public JButton getSendbtn() {
		return sendbtn;
	}
	public void setSendbtn(JButton sendbtn) {
		this.sendbtn = sendbtn;
	}


	public Client() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 455, 300);
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		

		
		
		JLabel title = new JLabel("TRANSFERT DE FICHIER");
		title.setFont(new Font("Source Sans Pro Black", Font.BOLD, 15));
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		title.setBorder(new EmptyBorder(20,0,10,0));
		
		 fileChoosen = new JLabel("VEUILLER CHOISIR UN FICHIER");
		 fileChoosen.setAlignmentX(Component.CENTER_ALIGNMENT);
		 fileChoosen.setBorder(new EmptyBorder(20, 0, 10, 0));
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(80, 80, 80, 80));
		panel.setBackground(new Color(128, 128, 64));
	
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		
		
		 sendbtn = new JButton("envoyer");
		 sendbtn.setFont(new Font("Leelawadee", Font.BOLD, 11));
		 sendbtn.setIcon(new ImageIcon("C:\\Users\\Toky\\Downloads\\send (1).png"));
		 SendButton sendButton = new SendButton(this);
		 sendbtn.addActionListener(sendButton);
		 
		panel.add(sendbtn);
		
		choosebtn = new JButton("choisir");
		choosebtn.setFont(new Font("Leelawadee", Font.BOLD, 11));
		choosebtn.setIcon(new ImageIcon("C:\\Users\\Toky\\Downloads\\file-folder.png"));
		ChooseButton chooseButton = new ChooseButton(this);
		choosebtn.addActionListener(chooseButton);
		panel.add(choosebtn);
		
		this.add(title);
		this.add(fileChoosen);
		this.add(panel);
		this.setVisible(true);
	}

}
