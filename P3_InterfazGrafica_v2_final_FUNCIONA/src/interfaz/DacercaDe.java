/**
 * "DacercaDe.java"
 * Course 
 * Practica 3
 * @author David Alarcón Prada
 * Fecha 25/03/2012
 */
package interfaz;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class DacercaDe extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel label1,label2,label3;
	private JPanel auxiliar;
	/**
	 *==English== 
	 * This constructor creates a new window (Acerca de = About)
	 *==Spanish==
	 * Crea una ventana de acerca de.
	 * @param f // window
	 * @param title // title
	 * @param modal // I dont remember
	 */
	public DacercaDe(Frame f,String title,boolean modal){
		super(f,title,modal);
		//GUI	
		//1ºComponentes
		label1=new JLabel("Gestor de correo");
		label2=new JLabel("Version 1.0");
		label3=new JLabel("David Alarcon Prada");
		//2ºContenedores

		auxiliar=new JPanel();
		auxiliar.setBackground(Color.lightGray);
		//3ºGestores de posicion
		auxiliar.setLayout(new GridLayout(3,1));
		auxiliar.add(label1);
		auxiliar.add(label2);
		auxiliar.add(label3);
		
		this.add(auxiliar);
		this.addWindowListener(new Cerrar());
	}
	class Cerrar extends WindowAdapter{
		public void windowClosing(WindowEvent e){
			dispose();
		}
	}

}
