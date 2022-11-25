package client;

import java.io.*;

public class SendFile {
	public SendFile() {
		
	}
	
	public void send(String path) {
		
		int bytes = 0;
		//ouvrir le fichier au serveur
				File file = new File(path);
				FileInputStream fileInputStream;
				try {
					fileInputStream = new FileInputStream(file);
					
					//envoi du fichier au serveur
					Client.getDataOutputStream().writeLong(file.length());
					byte[] buffer = new byte[4*1024];
					bytes = fileInputStream.read(buffer);
					while ( bytes != -1) {
						Client.getDataOutputStream().write(buffer,0,bytes);
						Client.getDataOutputStream().flush();		
					}
					fileInputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
	}
}
