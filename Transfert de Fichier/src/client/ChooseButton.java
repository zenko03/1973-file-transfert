package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

public class ChooseButton implements ActionListener{
	Client client;
	
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}


	public ChooseButton(Client client) {
		super();
		this.client = client;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("rien a envoyer bb");
		
		if (fileChooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION) {
		client.fileToSend[0] = fileChooser.getSelectedFile();
		client.getFileChoosen().setText("le fichier à envoyer est "+"'"+client.fileToSend[0].getName()+"'");
		}
		
	}

}
