package infographie.tp;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class FenetreP extends JFrame implements ActionListener{

	String[] TxtButton={"Rectangles","Ligne","Rectangle","Points", "BresenhamCercle", "BresenhamSegment", "BresenhamEtoile",
                               "BresenhamPolygone", "remplissage", "TPdemandé"};
	JButton [] monBouton=new JButton[10];
	JLabel lamgarraj;

	private MyPanel P;

	
	////////////////////////////////////
	public FenetreP() 
	{
		setTitle(" TP1 Infographie BY lamgarraj mohamed");
		setSize(1300, 700);
		Container contenu = getContentPane();
		contenu.setLayout(null);
		this.setResizable(false);
        ////////////////////////////////////
		Font f = new Font("Arial", Font.PLAIN, 16);
		int pa=80;
		for(int i=0;i<10;i++){
			monBouton[i] = new JButton (TxtButton[i]);
			monBouton[i].setBounds(10,35*i+pa,200,25);
			monBouton[i].setBackground(Color.DARK_GRAY);
			monBouton[i].setForeground(Color.WHITE);
			monBouton[i].setFont(f);
			monBouton[i].addActionListener(this);
			contenu.add(monBouton[i]);		
		}
		lamgarraj=new JLabel("tp d'inpgographie réalisé par lamgarraj");
		lamgarraj.setBounds(5,10,320,25);
		lamgarraj.setBackground(Color.lightGray);
        lamgarraj.setFont(f);


		contenu.add(lamgarraj);
		/////////////////////////////////
		P= new MyPanel();
		P.setBounds(220,60,1100,600);
		P.setBackground(Color.LIGHT_GRAY);
    	contenu.add(P);
	}
	
	////////////////////////////////////

	@Override
	public void actionPerformed(ActionEvent ev) {
		String nom=ev.getActionCommand();
		//10 : le nombre des boutons utilis�s
		for(int i=0;i<10;i++)
		if(nom==TxtButton[i]){
			P.setAction(TxtButton[i]);
			break;		
		}
	}
	/////////////////////////////////////////////////////////////////
	public static void main(String args[])
	{
		 
		JFrame fen= new FenetreP();
	    fen.setVisible(true);
	       fen.addWindowListener(new WindowAdapter(){
	        public void windowClosing(WindowEvent e){
	            System.exit(0);
	        }
	    });
	}

}
