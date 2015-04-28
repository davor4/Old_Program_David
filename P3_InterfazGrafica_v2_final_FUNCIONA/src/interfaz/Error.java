/**
 * "Error.java"
 * Asignatura Programación Avanzada de Aplicaciones
 * Practica 3
 * @author David Alarcón Prada
 * Fecha 25/03/2012
 */
package interfaz;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class Error extends JDialog{
	private static final long serialVersionUID = 1L;
	private JButton aceptar;
	private JLabel mensaje;
	
	/**
	 *==English== 
	 * This constructor creates a new window (Error = Error). When something wrong occurs in a dialog
	 *==Spanish==
	 * Crea un mensaje de error procedente de un dialogo.
	 * @param d // 
	 * @param title // title
	 * @param modal // I dont remember
	 */
	public Error(Dialog d,String title,boolean modal){
		super(d,title,modal);
		//1 Componentes
		aceptar=new JButton("aceptar");
		mensaje=new JLabel("Error! no se ha podido realizar la operacion");
		//2 Contenedores
		JPanel auxiliar;
		auxiliar=new JPanel();
		auxiliar.setLayout(new FlowLayout(FlowLayout.LEFT));
		auxiliar.setBackground(Color.lightGray);
		//3 Gestores de posicion
		auxiliar.setLayout(new GridLayout(2,1));
		auxiliar.add(mensaje);
		auxiliar.add(aceptar);
		
		this.add(auxiliar);
		this.addWindowListener(new Cerrar());
		aceptar.addActionListener(new Aceptar());
		
	}
	/**
	 *==English== 
	 * This constructor creates a new window (Error = Error). When something wrong occurs in a window
	 *==Spanish==
	 * Crea un mensaje de error procedente del dialogo principal.
	 * @param f //
	 * @param title // title
	 * @param modal // I dont know
	 */
	public Error(Frame f,String title,boolean modal){
		super(f,title,modal);
		//1 Componentes
		aceptar=new JButton("aceptar");
		mensaje=new JLabel("Error! no se ha podido realizar la operacion");
		//2 Contenedores
		JPanel auxiliar;
		auxiliar=new JPanel();
		auxiliar.setLayout(new FlowLayout(FlowLayout.LEFT));
		auxiliar.setBackground(Color.lightGray);
		//3 Gestores de posicion
		auxiliar.setLayout(new GridLayout(2,1));
		auxiliar.add(mensaje);
		auxiliar.add(aceptar);
		
		this.add(auxiliar);
		this.addWindowListener(new Cerrar());
		aceptar.addActionListener(new Aceptar());
		
	}
	
	class Cerrar extends WindowAdapter{
		public void windowClosing(WindowEvent e){
			dispose();
		}
	}
	class Aceptar implements ActionListener{
		public void actionPerformed(ActionEvent e){
			dispose();
		}
	}

}
