package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFileChooser;

public class ButtonListener implements ActionListener {
	Client client;
	
	
	public ButtonListener(Client client) {
		super();
		this.client = client;
	}

	public void actionPerformed(ActionEvent e) {
	final File[] filesend = new File[1] ;
		if (e.getSource() == client.getChoosebtn() ) {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("Choisir le fichier à envoyer");
			
			if (fileChooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION) {
				filesend[0] = fileChooser.getSelectedFile();
				client.getFileChoosen().setText("le fichier à envoyer est "+"'"+filesend[0].getName()+"'");
			}
		}
		if (e.getSource() == client.getSendbtn()) {
			if (filesend[0]==null) {
				client.getFileChoosen().setText("veuiller choisir un fichier");
				}else {
					//manome acces idirana ao amle chemin amizay afaka manoratra an'izay vo selectionner
					try {
						FileInputStream fileInputStream = new FileInputStream(filesend[0].getAbsolutePath());
						Socket socket = new Socket("127.0.0.1",client.getPort());
						DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
						
						String filename = filesend[0].getName();
						//tsy ilay contenu anle fichier ihany no alefa fa ny anarany ihany koa
						byte[] filenameBytes = filename.getBytes(); //tailler du nom
						
						byte[] filecontentBytes = new byte[(int) filesend[0].length()]; // taille du contenu
						
						fileInputStream.read(filecontentBytes); //remplir la taille par le contenue du fichier
						
						//alefa ny taille anle data en int mba ahafantaranle serveur hoe hatraiza no mijanona
						dataOutputStream.writeInt(filenameBytes.length);//nom du fichier
						dataOutputStream.write(filenameBytes);
						
						dataOutputStream.writeInt(filecontentBytes.length);//contenus du fichier
						dataOutputStream.write(filecontentBytes);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						e1.getMessage();
					}
				}
		}
		
		
	}

}
