/**
 * "Dconfigurar.java"
 * Asignatura Programaci�n Avanzada de Aplicaciones
 * Practica 3
 * @author David Alarc�n Prada
 * Fecha 25/03/2012
 */
package interfaz;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;


public class Dconfigurar extends JDialog {

	private static final long serialVersionUID = 1L;
	private JButton aceptarPop,cancelarPop,aceptarSmtp,cancelarSmtp;
	private JLabel hostPop, puertoPop,hostSmtp,puertoSmtp,mostrarMensajePop,mostrarMensajeSmtp;
	private JLabel usuarioPop,contrase�aPop,usuarioSmtp,contrase�aSmtp;
	private JTextField hostFieldPop,puertoFieldPop,hostFieldSmtp,puertoFieldSmtp;
	private JTextField usuarioPopField,usuarioSmtpField;
	private JPasswordField contrase�aPopField,contrase�aSmtpField;
	private JCheckBox sslPop,sslSmtp,siSmtp,noSmtp,siPop,noPop;
	private ButtonGroup cbgSmtp,cbgPop;
	private JPanel principal,panelPop,panelSmtp,panelVacio1,panelVacio2,panelVacio3,panelVacio4;
	private JTabbedPane pesta�as;
	private ParametrosDeConfigurar parametrosEnviar;
	private ParametrosDeConfigurar parametrosDescargar;
	/**
	 * ==English== 
	 * This constructor creates a new window (Configurar = Settings)
	 *==Spanish==
	 * Crea una ventana de configuracion.
	 * @param f // window
	 * @param title // title
	 * @param modal // I dont know = Must be an option... See Java API for more information
	 */
	public Dconfigurar(Frame f,String title,boolean modal){
		super(f,title,modal);
		//GUI	
		//1�Componentes == Components
		aceptarPop=new JButton("aceptar");
		cancelarPop=new JButton("cancelar");
		aceptarSmtp=new JButton("aceptar");
		cancelarSmtp=new JButton("cancelar");
		
		hostPop=new JLabel("Host:");
		hostFieldPop=new JTextField("correo.alumnos.upm.es",20);
		puertoPop=new JLabel("Puerto:");
		puertoFieldPop=new JTextField("995",20);
		usuarioPop=new JLabel("Usuario:");
		usuarioPopField=new JTextField(20);
		contrase�aPop=new JLabel("Contrase�a:");
		contrase�aPopField=new JPasswordField(20);
		sslPop=new JCheckBox("Utilizar SSL para POP",true);
		mostrarMensajePop=new JLabel("Mostrar mensajes de depuracion en POP:");
		siPop=new JCheckBox("si",true);
		noPop=new JCheckBox("no",false);
		cbgPop=new ButtonGroup();
		cbgPop.add(siPop);
		cbgPop.add(noPop);
		

		hostSmtp=new JLabel("Host:");
		hostFieldSmtp=new JTextField("smtp.upm.es",20);
		puertoSmtp=new JLabel("Puerto:");
		puertoFieldSmtp=new JTextField("587",20);
		usuarioSmtp=new JLabel("Usuario:");
		usuarioSmtpField=new JTextField(20);
		contrase�aSmtp=new JLabel("Contrase�a:");
		contrase�aSmtpField=new JPasswordField(20);
		sslSmtp=new JCheckBox("Utilizar SSL para Smtp",true);
		mostrarMensajeSmtp=new JLabel("Mostrar mensajes de depuracion en SMTP:");
		siSmtp=new JCheckBox("si",true);
		noSmtp=new JCheckBox("no",false);
		cbgSmtp=new ButtonGroup();
		cbgSmtp.add(siSmtp);
		cbgSmtp.add(noSmtp);

		//2�Contenedores == Containers
		principal=new JPanel();
		principal.setBackground(Color.lightGray);
		principal.setLayout(new FlowLayout());
		pesta�as=new JTabbedPane();
		
		panelPop=new JPanel();
		panelPop.setBackground(Color.lightGray);
		panelPop.setLayout(new GridLayout(8,2));
		panelPop.add(hostPop);
		panelPop.add(hostFieldPop);
		panelPop.add(puertoPop);
		panelPop.add(puertoFieldPop);
		panelPop.add(usuarioPop);
		panelPop.add(usuarioPopField);
		panelPop.add(contrase�aPop);
		panelPop.add(contrase�aPopField);
		sslPop.setBackground(Color.lightGray);
		panelPop.add(sslPop);
		panelVacio1=new JPanel();
		panelVacio1.setBackground(Color.lightGray);
		panelPop.add(panelVacio1);
		panelPop.add(mostrarMensajePop);
		panelVacio2=new JPanel();
		panelVacio2.setBackground(Color.lightGray);	
		panelPop.add(panelVacio2);
		siPop.setBackground(Color.lightGray);
		panelPop.add(siPop);
		noPop.setBackground(Color.lightGray);
		panelPop.add(noPop);
		panelPop.add(aceptarPop);
		panelPop.add(cancelarPop);
		pesta�as.addTab("Configuracion de POP3:", panelPop);
		
		
		
		panelSmtp=new JPanel();
		panelSmtp.setBackground(Color.lightGray);
		panelSmtp.setLayout(new GridLayout(8,2));
		panelSmtp.add(hostSmtp);
		panelSmtp.add(hostFieldSmtp);
		panelSmtp.add(puertoSmtp);
		panelSmtp.add(puertoFieldSmtp);
		panelSmtp.add(usuarioSmtp);
		panelSmtp.add(usuarioSmtpField);
		panelSmtp.add(contrase�aSmtp);
		panelSmtp.add(contrase�aSmtpField);
		sslSmtp.setBackground(Color.lightGray);
		panelSmtp.add(sslSmtp);
		panelVacio3=new JPanel();
		panelVacio3.setBackground(Color.lightGray);
		panelSmtp.add(panelVacio3);
		panelSmtp.add(mostrarMensajeSmtp);
		panelVacio4=new JPanel();
		panelVacio4.setBackground(Color.lightGray);	
		panelSmtp.add(panelVacio4);
		siSmtp.setBackground(Color.lightGray);
		panelSmtp.add(siSmtp);
		noSmtp.setBackground(Color.lightGray);
		panelSmtp.add(noSmtp);
		panelSmtp.add(aceptarSmtp);
		panelSmtp.add(cancelarSmtp);
		pesta�as.addTab("Configuracion de SMTP:", panelSmtp);
		
		principal.add(pesta�as);

		this.add(principal);
		this.addWindowListener(new Cerrar());
		aceptarPop.addActionListener(new AceptarClick());
		cancelarPop.addActionListener(new B1Click());
		aceptarSmtp.addActionListener(new AceptarClick());
		cancelarSmtp.addActionListener(new B1Click());

		
		
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
	class AceptarClick implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			String hostC=hostFieldSmtp.getText();
			String aux=puertoFieldSmtp.getText();
			int portC=Integer.parseInt(aux);
			boolean sslC=sslSmtp.isSelected(); // est� okey?� no lo he visto en el api?
			String userC=usuarioSmtpField.getText();
			char passChar[]=contrase�aSmtpField.getPassword();
			String passC=new String(passChar);
			boolean auxiliar=siSmtp.isSelected();
			boolean debugC=false;
			if (auxiliar==true)
				debugC=true;
			parametrosEnviar=new ParametrosDeConfigurar(hostC,portC,sslC,userC,passC,debugC);
			
			String h=hostFieldPop.getText();
			String aux2=puertoFieldPop.getText();
			int p=Integer.parseInt(aux2);
			boolean s=sslPop.isSelected();
			String u=usuarioPopField.getText();
			char passChar2[]=contrase�aPopField.getPassword();
			String pp=new String(passChar2);
			boolean auxiliar2=siPop.isSelected();
			boolean d=false;
			if (auxiliar2==true){
				d=true;		
			}
			parametrosDescargar=new ParametrosDeConfigurar(h,p,s,u,pp,d);
			setVisible(false);
		}
		

	}
	/**
	 *==English== 
	 * This method returns an object that contains the necessary parameters to be able to download messages. (This parameters have been
	 * taken by keyboard).
	 *==Spanish==
	 * Metodo que devuelve un objeto que contiene los parametros necesarios para poder descargar un mensaje,
	 * los cuales han sido introducidos por teclado por parte del usuario.
	 * @return parametrosDescargar - // Parameters necessary to download messages
	 */
	public ParametrosDeConfigurar Descargar(){
		return parametrosDescargar;
	}
	
	/**
	 *==English== 
	 * This method returns an object that contains the necessary parameters to be able to send messages. (This parameters have been
	 * taken by keyboard).
	 *==Spanish==
	 * Metodo que devuelve un objeto que contiene los parametros necesarios para poder enviar un mensaje,
	 * los cuales han sido introducidos por teclado por parte del usuario.
	 * @return parametrosEnviar - // Parameters necessary to send messages
	 */
	public ParametrosDeConfigurar Enviar(){
		return parametrosEnviar; 
	}
}

