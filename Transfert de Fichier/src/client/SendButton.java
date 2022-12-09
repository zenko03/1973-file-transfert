package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

public class SendButton implements ActionListener {
	Client client;
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public SendButton(Client client) {
		super();
		this.client = client;
	}

	public void actionPerformed(ActionEvent e) {
		if (client.fileToSend[0]==null) {
			client.getFileChoosen().setText("veuiller choisir un fichier");
			}else {
				//manome acces idirana ao amle chemin amizay afaka manoratra an'izay vo selectionner
				try {
					FileInputStream fileInputStream = new FileInputStream(client.fileToSend[0].getAbsolutePath());
					try (Socket socket = new Socket("127.0.0.1",client.getPort())) {
						DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
						
						String filename =client.fileToSend[0].getName();
						//tsy ilay contenu anle fichier ihany no alefa fa ny anarany ihany koa
						byte[] filenameBytes = filename.getBytes(); //tailler du nom
						
						byte[] filecontentBytes = new byte[(int) client.fileToSend[0].length()]; // taille du contenu
						
						fileInputStream.read(filecontentBytes); //remplir la taille par le contenue du fichier
						
						//alefa ny taille anle data en int mba ahafantaranle serveur hoe hatraiza no mijanona
						dataOutputStream.writeInt(filenameBytes.length);//nom du fichier
						dataOutputStream.write(filenameBytes);
						
						dataOutputStream.writeInt(filecontentBytes.length);//contenus du fichier
						dataOutputStream.write(filecontentBytes);
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					e1.getMessage();
				}
			}
		
		
	}

}
