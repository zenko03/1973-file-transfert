package serveur;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class Serveur extends JFrame {

	
		JPanel panel;
		
	public JPanel getPanel() {
			return panel;
		}

		public void setPanel(JPanel panel) {
			this.panel = panel;
		}
		static ArrayList<Fichier> myfiles = new ArrayList<>();
		
	public ArrayList<Fichier> getMyfiles() {
		return myfiles;
	}

	public void setMyfiles(ArrayList<Fichier> myfiles) {
		Serveur.myfiles = myfiles;
	}

	public Serveur() {
		int IDfile =0;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		setBounds(100, 100, 450, 300);
		panel = new JPanel(); 
//		panel.setBorder(new EmptyBorder(5, 5, 5, 5));

		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JLabel Titre = new JLabel("RECEPTION DE FICHIER");
		Titre.setFont(new Font("Sitka Text", Font.BOLD, 14));
		Titre.setAlignmentX(Component.CENTER_ALIGNMENT);
		Titre.setBorder(new EmptyBorder(20,0,10,0));
		
		this.add(Titre);
		 
		JScrollPane jScrollPane = new JScrollPane(panel);
		jScrollPane.setVerticalScrollBarPolicy(jScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.add(jScrollPane);
		this.setVisible(true);
		try {
			ServerSocket serverSocket = new ServerSocket(1234);
			
			
			//puisqu'on envoie plusieurs fichiers;
			while (true) {
				Socket socket = serverSocket.accept();
				//maka ny donnees avy ao amin'ny client
				DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
				
				int FilenameLength = dataInputStream.readInt(); 
				
				if (FilenameLength > 0) {
					byte[] fileNameBytes = new byte[FilenameLength];
					dataInputStream.readFully(fileNameBytes,0,FilenameLength);
					
					String filename = new String(fileNameBytes);
					
					int FilecontentLenght = dataInputStream.readInt();
					
					if (FilecontentLenght>0) {
						byte[] fileContentBytes = new byte[FilecontentLenght]; 
						dataInputStream.readFully(fileContentBytes,0,FilecontentLenght);
						
						JPanel fileJP = new JPanel();//jpanel file row
						fileJP.setLayout(new BoxLayout(fileJP, BoxLayout.Y_AXIS));
						
						JLabel filenameRow = new JLabel(filename);
						filenameRow.setFont(new Font("Source Sans Pro Black",Font.BOLD,15));
						filenameRow.setBorder(new EmptyBorder(15,0,15,0));
						
						Listener listener = new Listener(this); 
						if (getFileExtension(filename).equals("txt")) {
							fileJP.setName(String.valueOf(IDfile));
							fileJP.addMouseListener(listener);
							fileJP.add(filenameRow);
							panel.add(fileJP);
							this.validate();
						}else {
							fileJP.setName(String.valueOf(IDfile));
							fileJP.addMouseListener(listener);
							
							fileJP.add(filenameRow);
							panel.add(fileJP);
							
							this.validate();
						}
						myfiles.add(new Fichier(IDfile, filename, fileContentBytes, getFileExtension(filename)));
						IDfile++;
					}
				}
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public  JFrame createFrame(String filename,byte[] fileData,String fileExtension) {
		JFrame jFrame = new JFrame();
		
		jFrame.setTitle("file downloader");
		jFrame.setSize(300,300);
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel("File downloader");
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		title.setFont(new Font("Source Sans Pro Black",Font.BOLD,25));
		title.setBorder(new EmptyBorder(20,0,10,0));
	
		JLabel prompt = new JLabel("etes vous sur de telecharger "+"'"+filename+"'");
		prompt.setAlignmentX(Component.CENTER_ALIGNMENT);
		prompt.setFont(new Font("Source Sans Pro Black",Font.BOLD,10));
		prompt.setForeground(Color.white);
	
		prompt.setBorder(new EmptyBorder(20,0,10,0));
		
		JButton yes = new JButton("OUI");
		yes.setPreferredSize(new Dimension(100,30));
		yes.setFont(new Font("Source Sans Pro Black",Font.BOLD,10) );
		
		JButton no = new JButton("NON");
		no.setPreferredSize(new Dimension(100,30));
		no.setFont(new Font("Source Sans Pro Black",Font.BOLD,10));
		
		JLabel filecontent = new JLabel();
		filecontent.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//panel pour les deux boutons
		JPanel panelButtons = new JPanel();
		panelButtons.setBorder(new EmptyBorder(20,0,10,0));
		panelButtons.add(yes);
		panelButtons.add(no);
		
		if (fileExtension.equalsIgnoreCase("txt")) {
			filecontent.setText("<html>"+new String(fileData)+"</html>");
			
		}else {
			filecontent.setIcon(new ImageIcon(fileData));
		}
		
		yes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				File fileToDownload = new File(filename);
				
				FileOutputStream fileOutputStream;
				try {
					fileOutputStream = new FileOutputStream(fileToDownload);
					fileOutputStream.write(fileData);
					fileOutputStream.close();
					jFrame.dispose();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				
			}
		});
		no.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jFrame.dispose();
				
			}
		});
		panel.add(title);
		panel.add(prompt);
		panel.add(filecontent);
		panel.add(panelButtons);
		panel.setBackground(new Color(33,89,122));
		
		
		jFrame.add(panel);
		
		return jFrame;
	}

	public static String getFileExtension(String filename) {
		int i = filename.lastIndexOf('.');
		if (i>0) {
			return filename.substring(i+1);
		}else {
			return "No extension found";
		}
	}
}
