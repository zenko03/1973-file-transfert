package serveur;

public class Fichier {
	private int ID;
	private String name;
	private byte[] data;
	private String extensionFile;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
	public String getExtensionFile() {
		return extensionFile;
	}
	public void setExtensionFile(String extensionFile) {
		this.extensionFile = extensionFile;
	}
	public Fichier(int iD, String name, byte[] data, String extensionFile) {
		super();
		ID = iD;
		this.name = name;
		this.data = data;
		this.extensionFile = extensionFile;
	}
	
	
}
