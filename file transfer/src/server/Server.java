package server;

import java.io.*;
import java.net.*;

public class Server {
	private static DataOutputStream dataOutputStream =null;
	private static DataInputStream dataInputStream = null;
	
	public static DataOutputStream getDataOutputStream() {
		return dataOutputStream;
	}
	public static DataInputStream getDataInputStream() {
		return dataInputStream;
	}


	public static void main(String[] args) {
		ReceiveFile receiveFile = new ReceiveFile();
		int port = 5000;
		try (ServerSocket serverSocket = new ServerSocket(port)) {
			
			System.out.println("server connecter au port "+ port);
			
			Socket clientSocket = serverSocket.accept();
			System.out.println("connected");
			dataInputStream = new DataInputStream(clientSocket.getInputStream());
			dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
			
			receiveFile.receive("fichier a recevoir");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
