package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	private static DataOutputStream dataOutputStream = null;
	private static DataInputStream dataInputStream = null;
		
	public static DataOutputStream getDataOutputStream() {
		return dataOutputStream;
	}
	public static DataInputStream getDataInputStream() {
		return dataInputStream;
	}



	public static void main(String[] args) {
		int port = 5000;
		try (Socket socket =  new Socket("127.0.0.1",port)){
			SendFile sendFile= new SendFile();
			
			dataInputStream = new DataInputStream(socket.getInputStream());
			dataOutputStream = new DataOutputStream(socket.getOutputStream());
			System.out.println("sending file te the server");
			
			sendFile.send("path to file");
			
			dataInputStream.close();
			dataOutputStream.close();			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
