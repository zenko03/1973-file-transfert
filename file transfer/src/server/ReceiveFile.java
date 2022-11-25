package server;

import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class ReceiveFile {
	DataInputStream dis;
	public DataInputStream getDis() {
		return dis;
	}

	public void setDis(DataInputStream dis) {
		this.dis = dis;
	}

	
	
	public void receive(String fileName) throws Exception {
		//DataInputStream dataInputStream = null;
		int bytes=0;
		
		
		FileOutputStream fileOutputStream = new FileOutputStream(fileName);
		
		long size =Server.getDataInputStream().readLong(); 
		
		byte[] buffer = new byte[4*1024];
		bytes =Server.getDataInputStream().read(buffer,0,(int) Math.min(buffer.length, size));
		while (size>0 && bytes != -1) {
			//ecrire le fichier;
			
			fileOutputStream.write(buffer,0,bytes);
			size -= bytes; // lire la taille du fichier
		}
		
		//on recoit le fichier ici
		
		System.out.println("fichier recu");
		fileOutputStream.close();
	}
}
