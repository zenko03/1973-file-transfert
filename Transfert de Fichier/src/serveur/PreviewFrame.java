//package serveur;
//
//import java.awt.Component;
//import java.awt.Dimension;
//import java.awt.Font;
//import java.awt.HeadlessException;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//
//import javax.swing.BoxLayout;
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//
//public class PreviewFrame extends JFrame {
//	String filename;
//	byte[] fileData;
//	String fileExtension;
//	public String getFilename() {
//		return filename;
//	}
//	public void setFilename(String filename) {
//		this.filename = filename;
//	}
//	public byte[] getFileData() {
//		return fileData;
//	}
//	public void setFileData(byte[] fileData) {
//		this.fileData = fileData;
//	}
//	public String getFileExtension() {
//		return fileExtension;
//	}
//	public void setFileExtension(String fileExtension) {
//		this.fileExtension = fileExtension;
//	}
//	public PreviewFrame(String filename, byte[] fileData, String fileExtension) throws HeadlessException {
//		super();
//		this.filename = filename;
//		this.fileData = fileData;
//		this.fileExtension = fileExtension;
//		
//		setTitle("file downloader");
//		setSize(400,400);
//		JPanel panel = new JPanel();
//		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
//		
//		JLabel title = new JLabel("File downloader");
//		title.setAlignmentX(Component.CENTER_ALIGNMENT);
//		title.setFont(new Font("Arial",Font.BOLD,25));
//		title.setBorder(new EmptyBorder(20,0,10,0));
//		
//		JLabel prompt = new JLabel("etes vous sur de telecharger "+filename);
//		prompt.setAlignmentX(Component.CENTER_ALIGNMENT);
//		prompt.setFont(new Font("Arial",Font.BOLD,25));
//		prompt.setBorder(new EmptyBorder(20,0,10,0));
//		
//		JButton yes = new JButton("OUI");
//		yes.setPreferredSize(new Dimension(150,75));
//		yes.setFont(new Font("Arial",Font.BOLD,20) );
//		
//		JButton no = new JButton("NON");
//		no.setPreferredSize(new Dimension(150,75));
//		no.setFont(new Font("Arial",Font.BOLD,20));
//		
//		JLabel filecontent = new JLabel();
//		filecontent.setAlignmentX(Component.CENTER_ALIGNMENT);
//		
//		//panel pour les deux boutons
//		JPanel panelButtons = new JPanel();
//		panelButtons.setBorder(new EmptyBorder(20,0,10,0));
//		panelButtons.add(yes);
//		panelButtons.add(no);
//		
//		if (fileExtension.equalsIgnoreCase("txt")) {
//			filecontent.setText("<html>"+new String(fileData)+"</html>");
//			
//		}else {
//			filecontent.setIcon(new ImageIcon(fileData));
//		}
//		
//		yes.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				File fileToDownload = new File(filename);
//				
//				FileOutputStream fileOutputStream;
//				try {
//					fileOutputStream = new FileOutputStream(fileToDownload);
//					fileOutputStream.write(fileData);
//					fileOutputStream.close();
//					
//					
//				} catch (IOException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}	
//			}
//		});
//	}
//	
//	
//}
