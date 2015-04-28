/**
 * "Denviar.java"
 * Asignatura Programación Avanzada de Aplicaciones
 * Practica 3
 * @author David Alarcón Prada
 * Fecha 25/03/2012
 */
package interfaz;

import java.awt.*;
import java.awt.event.*;
import java.util.Date;

import javax.swing.*;

import almacen.*;
import paa.correo.*;

public class Denviar extends JDialog {
	
	private static final long serialVersionUID = 1L;
	private IAlmacenCorreo mapa;
	private MensajeCorreo sms;
	private JButton aceptar, cancelar;
	private JLabel de, para, asunto,texto;
	private JTextField deText,paraText,asuntoText;
	private JTextArea textoText;
	private String idG;
	private Date   fechaG;	
	private GestorEnvioCorreo envio;
	private ParametrosDeConfigurar enviarM;
	
	/**
	 * ==English== 
	 * This constructor creates a new window (Enviar = To send)
	 *==Spanish==
	 * @param f // window
	 * @param title // Title
	 * @param modal // I dont remember
	 * @param mapa // e-mail store
	 * @param enviarM // Parameters necessary to send/receive messages
	 */
	public Denviar(Frame f,String title,boolean modal, IAlmacenCorreo mapa,ParametrosDeConfigurar enviarM){
		super(f,title,modal);
		this.mapa=mapa;
		this.enviarM=enviarM;
		//GUI	
		//1ºComponentes == Components
		aceptar=new JButton("aceptar");
		cancelar=new JButton("cancelar");
		de=new JLabel("De:       ");
		deText=new JTextField(30);
		para=new JLabel("Para:    ");
		paraText=new JTextField(30);
		asunto=new JLabel("Asunto:");
		asuntoText=new JTextField(30);
		texto=new JLabel("Texto:   ");
		textoText=new JTextArea(2,31);
		
		//2ºContenedores == Containers
		JPanel auxiliar;
		auxiliar=new JPanel();
		auxiliar.setLayout(new FlowLayout(FlowLayout.LEFT));
		auxiliar.setBackground(Color.lightGray);
		Panel auxiliar2;
		auxiliar2=new Panel();
		auxiliar2.setBackground(Color.lightGray);
		Panel auxiliar3;
		auxiliar3=new Panel();
		auxiliar3.setLayout(new FlowLayout(FlowLayout.LEFT));
		auxiliar3.setBackground(Color.lightGray);
		Panel auxiliar4;
		auxiliar4=new Panel();
		auxiliar4.setLayout(new FlowLayout(FlowLayout.LEFT));
		auxiliar4.setBackground(Color.lightGray);
		Panel auxiliar5;
		auxiliar5=new Panel();
		auxiliar5.setLayout(new FlowLayout(FlowLayout.LEFT));
		auxiliar5.setBackground(Color.lightGray);
		Panel auxiliar6;
		auxiliar6=new Panel();
		auxiliar6.setLayout(new FlowLayout(FlowLayout.LEFT));
		auxiliar6.setBackground(Color.lightGray);
		
		//3ºGestores de posicion == Manage the position
		auxiliar.setLayout(new GridLayout(5,1));//ver
		auxiliar3.add(de);
		auxiliar3.add(deText);
		auxiliar.add(auxiliar3);
		auxiliar4.add(para);
		auxiliar4.add(paraText);
		auxiliar.add(auxiliar4);
		auxiliar5.add(asunto);
		auxiliar5.add(asuntoText);
		auxiliar.add(auxiliar5);
		auxiliar6.add(texto);
		auxiliar6.add(textoText);
		auxiliar.add(auxiliar6);
		auxiliar2.add(aceptar);
		auxiliar2.add(cancelar);
		auxiliar.add(auxiliar2);
		
		this.add(auxiliar);
		this.addWindowListener(new Cerrar());
		cancelar.addActionListener(new B1Click());
		aceptar.addActionListener(new Aceptar());
	}
	class Cerrar extends WindowAdapter{
		public void windowClosing(WindowEvent e){
			dispose();
		}
	}
	class B1Click implements ActionListener{
		public void actionPerformed(ActionEvent e){
			dispose();
		}
	}
	class Aceptar implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			
			envio=new GestorEnvioCorreo(enviarM.getHost(),enviarM.getPort(),enviarM.isSsl(),enviarM.getUsername(),enviarM.getPassword(),enviarM.isDebug());
			fechaG=new Date();

			idG="a";
			sms=new MensajeCorreo(asuntoText.getText(),paraText.getText(),fechaG,idG,deText.getText(),textoText.getText());
			
			try {
				envio.send(sms);
				mapa.addMensaje("Enviados", sms);


			} catch (CorreoException e1) {
					Error auxiliar=new Error(Denviar.this,"Error",true);
					auxiliar.pack();
					auxiliar.setResizable(false);
					auxiliar.setVisible(true);
				
			}
			
			setVisible(false);
		}
	}

}
