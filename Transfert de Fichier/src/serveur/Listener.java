package serveur;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Listener implements MouseListener{
	Serveur serveur;
	
	public Serveur getServeur() {
		return serveur;
	}

	public void setServeur(Serveur serveur) {
		this.serveur = serveur;
	}
	
	public Listener(Serveur serveur) {
		super();
		this.serveur = serveur;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		JPanel panel = (JPanel) e.getSource();
		
		int fileID = Integer.parseInt(panel.getName());
		
		ArrayList<Fichier> files = serveur.getMyfiles();
		
		for (int i = 0; i < files.size(); i++) {
			//micheck oe jpanel iza ilay voakitika
			if (files.get(i).getID()== fileID) {
				JFrame preview =serveur.createFrame(files.get(i).getName(),files.get(i).getData(),files.get(i).getExtensionFile());
				preview.setVisible(true);
			}
			
		}
		
	}
	

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
