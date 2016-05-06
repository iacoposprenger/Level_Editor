
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Frame extends JFrame implements ActionListener {
	
	private JToolBar barreOutil;
	private JButton ennemi, vide, personnage, fin, block, pos[][];
	private JMenuBar barreMenu;
	private JMenu fichier, edition, affichage;
	private JMenuItem nouveau, ouvrir, enregistrer, enregistrer_sous, quitter, annuler, retablir, deselectionner, selectionner,  masquer_barreOutil  ;
	private JPanel panneau; 
	public int selectx[] = new int[50];
	public int selecty[] = new int[50];
	
	public Frame() {
		this.setSize(1000, 800);
		this.setVisible(true);
		this.setTitle("Level Editor");
		Container contenu = getContentPane();
		//declarations
		panneau = new JPanel();
		panneau.setLayout(new GridLayout(50,50));
		barreMenu = new JMenuBar();
		setJMenuBar(barreMenu);
		barreOutil = new JToolBar();
		fichier = new JMenu("Fichier");
		edition = new JMenu("Edition");
		affichage = new JMenu("Affichage");
		block = new JButton("Block");
		ennemi = new JButton("Enemi");
		vide = new JButton("Vide");
		personnage = new JButton("Personnage");
		fin = new JButton("Fin");
		nouveau = new JMenuItem("Nouveau");
		ouvrir = new JMenuItem("Ouvrir");
		enregistrer = new JMenuItem("Enregistrer");
		enregistrer_sous = new JMenuItem("Enregistrer Sous");
		quitter = new JMenuItem("Quitter");
		annuler = new JMenuItem("Annuler");
		retablir = new JMenuItem("Rétablir");
		deselectionner = new JMenuItem("Tout Déselectionner");
		selectionner = new JMenuItem("Tout Selectionner");
		masquer_barreOutil = new JMenuItem("Afficher/Masquer la barre d'outils");
		pos = new JButton[50][50];
		for (int i=0; i<50; i++){
			for(int j=0; j<50; j++){
				pos[i][j] = new JButton ("");
				panneau.add(pos[i][j]);
				pos[i][j].setBorderPainted(false);
				pos[i][j].setBackground(Color.white);
				pos[i][j].addActionListener(this);
			}
		}
		//position
		
		barreOutil.add(block);
		barreOutil.add(ennemi);
		barreOutil.add(vide);
		barreOutil.add(personnage);
		barreOutil.add(fin);
		contenu.add(barreOutil, "North");
		contenu.add(panneau);
		barreMenu.add(fichier);
		barreMenu.add(edition);
		barreMenu.add(affichage);
		fichier.add(nouveau);
		fichier.add(ouvrir);
		fichier.add(enregistrer);
		fichier.add(enregistrer_sous);
		fichier.add(quitter);
		edition.add(annuler);
		edition.add(retablir);
		edition.add(selectionner);
		edition.add(deselectionner);
		affichage.add(masquer_barreOutil);
		//ecouteurs
		block.addActionListener(this);
		ennemi.addActionListener(this);
		vide.addActionListener(this);
		personnage.addActionListener(this);
		masquer_barreOutil.addActionListener(this);
		quitter.addActionListener(this);
		fin.addActionListener(this);
		selectionner.addActionListener(this);
		deselectionner.addActionListener(this);
		
	}
	public void actionPerformed (ActionEvent ev)
	{
		// actions
		if (ev.getSource() == quitter) {
			int rep;
			rep = JOptionPane.showConfirmDialog(null, "Êtes vous sur de vouloir quitter ?", "Quitter ?", JOptionPane.YES_NO_OPTION);
			if (rep == 0) System.exit(0);}
		if (ev.getSource() == masquer_barreOutil)
			if (barreOutil.isVisible() == true)
				barreOutil.setVisible(false);
			else 
				barreOutil.setVisible(true);
			for (int i=0; i<50; i++){
				for(int j=0; j<50; j++){
					if (ev.getSource() == pos[i][j]){
						System.out.print(i);
						System.out.print("       ");
						System.out.println(j);
						
						if (pos[i][j].isBorderPainted() == false)
							pos[i][j].setBorderPainted(true);
						else
							pos[i][j].setBorderPainted(false);
							
					}	
				}
			}
		if (ev.getSource() == vide){
			for (int i=0; i<50; i++){
				for(int j=0; j<50; j++){
					if (pos[i][j].isBorderPainted() == true){
						pos[i][j].setBackground(Color.white);
						pos[i][j].setBorderPainted(false);
					}
				}
			}
		}
		if (ev.getSource() == block){
			for (int i=0; i<50; i++){
				for(int j=0; j<50; j++){
					if (pos[i][j].isBorderPainted() == true){
						pos[i][j].setBackground(Color.darkGray);
						pos[i][j].setBorderPainted(false);
					}
				}
			}
		}
		if (ev.getSource() == fin){
			for (int i=0; i<50; i++){
				for(int j=0; j<50; j++){
					if (pos[i][j].isBorderPainted() == true){
						pos[i][j].setBackground(Color.red);
						pos[i][j].setBorderPainted(false);
					}
				}
			}
		}
		if (ev.getSource() == personnage){
			for (int i=0; i<50; i++){
				for(int j=0; j<50; j++){
					if (pos[i][j].isBorderPainted() == true){
						pos[i][j].setBackground(Color.blue);
						pos[i][j].setBorderPainted(false);
					}
				}
			}
		}
		if (ev.getSource() == ennemi){
			for (int i=0; i<50; i++){
				for(int j=0; j<50; j++){
					if (pos[i][j].isBorderPainted() == true){
						pos[i][j].setBackground(Color.green);
						pos[i][j].setBorderPainted(false);
					}
				}
			}
		}
		if (ev.getSource() == selectionner){
			for (int i=0; i<50; i++){
				for(int j=0; j<50; j++){
					pos[i][j].setBorderPainted(true);
				}
			}
		}
		if (ev.getSource() == deselectionner){
			for (int i=0; i<50; i++){
				for(int j=0; j<50; j++){
					pos[i][j].setBorderPainted(false);
				}
			}
		}



	

	}
}
