/**
 * "IntefazGrafica.java"
 * Asignatura Programación Avanzada de Aplicaciones
 * Practica 3
 * @author David Alarcón Prada
 * Fecha 25/03/2012
 */
package interfaz;
import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

import javax.swing.*;
import javax.swing.event.*;

import paa.correo.*;
import almacen.*;


public class IntefazGrafica extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private static int ORDENARPORFECHA=1;
	private static int ORDENARPORREMITENTE=2;
	private GestorLecturaCorreo glc;

	private IAlmacenCorreo mapa;
	private ParametrosDeConfigurar enviarM;
	private ParametrosDeConfigurar descargarM;
	
	private JButton botonDescargar,botonEnviar,botonInfo,botonConfigurar,botonSalida,botonFecha,botonRemitente;
	private JList li,lista2;
	private DefaultListModel modeloIzquierda,modeloDerecha;
	private JTextArea ta;
	private JLabel l;
	private ImageIcon imagenEnviar,fotoEnviar,imagenDescargar,fotoDescargar,imagenInfo,fotoInfo;
	private ImageIcon imagenConfigurar,fotoConfigurar,imagenSalida,fotoSalida,imagenRemitente,imagenFecha;
	private ImageIcon fotoRemitente,fotoFecha;
	private JMenuBar barraMenu;
	private JMenu archivo,mensajes,ayuda;
	private JMenuItem configurar,crearCarpeta,borrarCarpeta,salir;
	private JMenuItem enviar,descargar,ordenarPorRemitente,ordenarPorFecha,moverMensaje,borrarMensaje;
	private JMenuItem acercaDe; 
	private String env="Enviados";
	private String rec="Recibidos";
	private JToolBar toolBar;
	private JScrollPane scrollTexto,scrollLista;
	private JSplitPane split1,split2;

	
	/**
	 *==English== 
	 * This constructor creates the main window.
	 *==Spanish==
	 * Constructor. Crea la ventana principal del programa.
	 */
	
	public IntefazGrafica(){
		//Titulo en el constructor //Title
		super("Gestor de correo");	
		
		mapa=recuperar("almacen.ser");
		if(mapa==null){
			mapa=new AlmacenCorreo();
			mapa.addCarpeta("Enviados");
			mapa.addCarpeta("Recibidos");

		}
		//1ºComponentes == Components
		
		
		imagenEnviar = new ImageIcon("images/enviar.jpg");
		fotoEnviar= new ImageIcon(imagenEnviar.getImage().getScaledInstance(30,30,java.awt.Image.SCALE_DEFAULT));
		
		imagenDescargar = new ImageIcon("images/descarga.png");
		fotoDescargar = new ImageIcon(imagenDescargar.getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_DEFAULT));
		imagenInfo=new ImageIcon("images/info.png");
		fotoInfo=new ImageIcon(imagenInfo.getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_DEFAULT));
		
		imagenConfigurar = new ImageIcon("images/configurar.jpg");
		fotoConfigurar = new ImageIcon(imagenConfigurar.getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_DEFAULT));
		
		imagenRemitente=new ImageIcon("images/remitente.png");
		fotoRemitente=new ImageIcon(imagenRemitente.getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_DEFAULT));
		
		imagenFecha=new ImageIcon("images/fecha.png");
		fotoFecha=new ImageIcon(imagenFecha.getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_DEFAULT));
		
		imagenSalida=new ImageIcon("images/salida.png");
		fotoSalida=new ImageIcon(imagenSalida.getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_DEFAULT));
		
		
		botonDescargar=new JButton(fotoDescargar);
		botonEnviar=new JButton(fotoEnviar);
		botonInfo=new JButton(fotoInfo);
		botonConfigurar=new JButton(fotoConfigurar);
		botonSalida=new JButton(fotoSalida);
		botonFecha=new JButton(fotoFecha);
		botonRemitente=new JButton(fotoRemitente);
		
		botonEnviar.setToolTipText("Enviar");
		botonDescargar.setToolTipText("Descargar");
		botonInfo.setToolTipText("Acerca de");
		botonConfigurar.setToolTipText("Configurar");
		botonFecha.setToolTipText("Ordenar por fecha");
		botonRemitente.setToolTipText("Ordenar por remitente");
		botonSalida.setToolTipText("Salida");
		
		modeloIzquierda=new DefaultListModel();
		li=new JList(modeloIzquierda);
		modeloIzquierda.addElement("Recibidos");
		modeloIzquierda.addElement("Enviados");
		
		modeloDerecha=new DefaultListModel();
		lista2=new JList(modeloDerecha);
		scrollLista=new JScrollPane(lista2);
		
		
		ta=new JTextArea("",10,80);
		scrollTexto=new JScrollPane(ta);
		l=new JLabel("Correo Version 1.0");
	
		
		//2ºContenedores == Containers
		barraMenu=new JMenuBar();
		toolBar=new JToolBar();
		split1=new JSplitPane(JSplitPane.VERTICAL_SPLIT,scrollLista,scrollTexto);
		split1.setOneTouchExpandable(true);
		split2=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,li,split1);
		split2.setOneTouchExpandable(true);
		
		archivo=new JMenu("Archivo");
		mensajes=new JMenu("Mensajes");
		ayuda=new JMenu("Ayuda");
		
		configurar=new JMenuItem("Configurar cuenta");
		crearCarpeta=new JMenuItem("Crear Carpeta");
		borrarCarpeta=new JMenuItem("Borrar Carpeta");
		salir=new JMenuItem("Salir");
		
		enviar=new JMenuItem("Enviar");
		descargar=new JMenuItem("Descargar");
		ordenarPorRemitente=new JMenuItem("Ordenar Por Remitente");
		ordenarPorFecha=new JMenuItem("Ordenar Por Fecha");
		moverMensaje=new JMenuItem("Mover Mensaje");
		borrarMensaje=new JMenuItem("Borrar Mensaje");
		
		acercaDe=new JMenuItem("Acerca De");

		archivo.add(configurar);
		archivo.add(crearCarpeta);
		archivo.add(borrarCarpeta);
		archivo.add(salir);
			
		mensajes.add(enviar);	
		mensajes.add(descargar);
		mensajes.add(ordenarPorRemitente);
		mensajes.add(ordenarPorFecha);
		mensajes.add(moverMensaje);
		mensajes.add(borrarMensaje);
		
		ayuda.add(acercaDe);
	
		barraMenu.add(archivo);
		barraMenu.add(mensajes);
		barraMenu.add(ayuda);
		
		toolBar.add(botonDescargar);
		toolBar.add(botonEnviar);
		toolBar.add(botonConfigurar);
		toolBar.add(botonInfo);
		toolBar.add(botonFecha);
		toolBar.add(botonRemitente);
		toolBar.add(botonSalida);
		
		
		
		
		this.setJMenuBar(barraMenu);
		
		//3Gestores de posicion == Manage positions
		this.setLayout(new BorderLayout());
		//Norte
		this.add(toolBar,BorderLayout.NORTH);
		//Sur
		JPanel aux2;
		aux2=new JPanel();
		aux2.setBackground(Color.lightGray);
		aux2.setLayout(new FlowLayout(FlowLayout.LEFT));
		aux2.add(l);
		this.add(aux2,BorderLayout.SOUTH);
		//Centro
		this.add(split2);
		
		//Eventos de la ventana principal == Events in main window
		this.addWindowListener(new Cerrar());
		salir.addActionListener(new Salir());
		configurar.addActionListener(new Configurar());

		enviar.addActionListener(new Enviar());
		descargar.addActionListener(new Descargar());
		ordenarPorFecha.addActionListener(new OrdenarPorFecha());		
		ordenarPorRemitente.addActionListener(new OrdenarPorRemitente());

		acercaDe.addActionListener(new InfoAcercaDe()); 
		botonEnviar.addActionListener(new Enviar());
		botonDescargar.addActionListener(new Descargar());		
		botonInfo.addActionListener(new InfoAcercaDe());
		botonConfigurar.addActionListener(new Configurar());
		botonSalida.addActionListener(new Salir());
		botonFecha.addActionListener(new OrdenarPorFecha());
		botonRemitente.addActionListener(new OrdenarPorRemitente());

		li.addListSelectionListener(new CambioSel());
		lista2.addListSelectionListener(new CambioSelMensaje());

	}
	
	/**
	 *==English== 
	 * Main method of program. It creates an object of the main class with a window size 1024*768, it can not be modified.
	 *==Spanish==
	 * Método main del programa. Crea un objeto de la clase de la ventana principal con tamaño
	 * 1024*768, no se puede modificar su tamaño.
	 * @param args
	 */
	public static void main(String[] args) {
		
		IntefazGrafica gui=new IntefazGrafica();
		gui.setSize(1024, 768);
		gui.setResizable(false);
		gui.setVisible(true);
		
	}
	
	/**
	 *==English== 
	 * Method creates to charge a store that already exists (bin file)
	 *==Spanish==
	 * Metodo creado para cargar un almacen de fichero binario.
	 * @param nombreFichero - nombre del fichero binario que se quiere recuperar. // file that we want to charge.
	 * @return mapaRecuperado - contendrá el almacen si se ha recuperado correctamente, null si no. // True if success, false if not.
	 */
	public IAlmacenCorreo recuperar(String nombreFichero){
        ObjectInputStream entrada=null;
        IAlmacenCorreo mapaRecuperado=null;
        
        //Comprobacion de que el archivo existe == Looking for the file
        try{
            entrada=new ObjectInputStream(new FileInputStream(nombreFichero));
            entrada.close();
        }catch(IOException p){
        //	System.out.println(p.getMessage());
        	//System.out.println("kk");
        }
        //si existe lo devuelvo, si no se devuelve null y se crea uno nuevo arriba // if does not exist, I create a new one.
        if(entrada!=null){
            try{
                entrada=new ObjectInputStream(new FileInputStream(nombreFichero));
            	mapaRecuperado=(IAlmacenCorreo)entrada.readObject();
            }catch(IOException o){
                System.out.println("Error"+o.getMessage());
            }catch(ClassNotFoundException k){
                System.out.println("Error"+k.getMessage());
            }
        }

	return mapaRecuperado;
	}
	
	/**
	 *==English== 
	 * Method creates to save a store (bin file)
	 *==Spanish==
	 * Metodo creado para guardar un archivo binario
	 * @param nombreFichero - es el nombre con el que se guardará el archivo. // file that we want to save.
	 * @param almacen - es el objeto que se guardará en el archivo, en este caso el almacen de correo. // Object that will be saved, in this case the e-mail storage
	 * @return res - true si se ha guardado correctamente, false si no. // True if success, false if not.
	 */
	public void guardar(String nombreFichero,IAlmacenCorreo almacen){
	    ObjectOutputStream salida=null;
	    try{
			salida=new ObjectOutputStream(new FileOutputStream(nombreFichero));
			salida.writeObject(almacen);
	    }catch(FileNotFoundException e){
	    	System.out.println("Error 1 al guardar");
	    }catch(IOException e){
	    	System.out.println("Error 2 al guardar");
	    }finally{
	    	try {
	    		if(salida!=null)
	    			salida.close();
			} catch (IOException e) {
		    	System.out.println("Error 2 al guardar");
			}

	    }
	}
	
	/**
	 *==English== 
	 * Method that update the box where downdoad files appears if something changed.
	 *==Spanish==
	 * Metodo que actualiza el modelo donde aparecen los mensajes descargados, segun se haya realizado
	 * una modificacion en ella.
	 */
	public void actualizar(){
		IMensajeCorreo mAux;
		String añadirCabecera;
		lista2.removeAll();

		if(env.equals(li.getSelectedValue())){
			modeloDerecha.clear();
			for(int i=1;i<=mapa.getNumMensajes("Enviados");i++){
				mAux=mapa.getMensaje("Enviados", i);
				añadirCabecera=mAux.getRemitente()+"     "+mAux.getAsunto()+"     "+mAux.getFecha();
				modeloDerecha.addElement(añadirCabecera);

			}
		}
		if(rec.equals(li.getSelectedValue())){
			modeloDerecha.clear();
			for(int j=1;j<=mapa.getNumMensajes("Recibidos");j++){
				mAux=mapa.getMensaje("Recibidos", j);
				añadirCabecera=mAux.getRemitente()+"     "+mAux.getAsunto()+"     "+mAux.getFecha();
				modeloDerecha.addElement(añadirCabecera);
			}			
		}
		
	}
	
	
	class Configurar implements ActionListener{
		public void actionPerformed(ActionEvent e){
			Dconfigurar auxiliar=new Dconfigurar(IntefazGrafica.this,"Configuracion",true);
			auxiliar.pack();
			auxiliar.setResizable(false);
			auxiliar.setVisible(true);
			enviarM=auxiliar.Enviar();
			descargarM=auxiliar.Descargar();
		}
	}
	
	class Descargar implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String asunto="";
			String destinatario="";
			Date   fecha=new Date();	
			String id="";	
			String remitente="";
			String texto="";
			MensajeCorreo mensaje;

			int numero;
			glc=new GestorLecturaCorreo(descargarM.getHost(),descargarM.getPort(),descargarM.isSsl(),descargarM.getUsername(),descargarM.getPassword(),descargarM.isDebug());
			try{
				numero=glc.open();
				for(int i=numero;i>numero-4;i--){
						mensaje=new MensajeCorreo(asunto,destinatario,fecha,id,remitente,texto);
						glc.get(i,mensaje);
						mapa.addMensaje("Recibidos",mensaje);
				}
				glc.close();
			}catch(CorreoException e1){
				Error auxiliar=new Error(IntefazGrafica.this,"Error",true);
				auxiliar.pack();
				auxiliar.setResizable(false);
				auxiliar.setVisible(true);
			}
		}
	}
	
	class CambioSel implements ListSelectionListener{
		public void valueChanged(ListSelectionEvent e){
			if(li.getSelectedIndex()!=-1){
				actualizar();
			}
		}
		
	}
	class CambioSelMensaje implements ListSelectionListener{

		public void valueChanged(ListSelectionEvent arg0) {
			
			IMensajeCorreo mAux;
			int entero;
			int entero2;
			if(lista2.getSelectedIndex()!=-1){
				if(env.equals(li.getSelectedValue())){
					entero=lista2.getSelectedIndex();
					entero=entero+1;
					mAux=mapa.getMensaje("Enviados", entero);
					ta.setText(mAux.getTexto());
				}
				if(rec.equals(li.getSelectedValue())){
					entero2=lista2.getSelectedIndex();
					entero2=entero2+1;
					mAux=mapa.getMensaje("Recibidos", entero2);
					ta.setText(mAux.getTexto());
				}
			 
			}
		}
	}
		
	
	class OrdenarPorFecha implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String carpeta=(String) li.getSelectedValue();
			if(carpeta!=null){
				mapa.ordenarPor(carpeta,ORDENARPORFECHA);
				actualizar();
			}else{
				Error auxiliar=new Error(IntefazGrafica.this,"Error",true);
				auxiliar.pack();
				auxiliar.setResizable(false);
				auxiliar.setVisible(true);
			}

		}
	
	}

	class OrdenarPorRemitente implements ActionListener{

		public void actionPerformed(ActionEvent e){
			String carpeta=(String)li.getSelectedValue();
			if(carpeta!=null){
				mapa.ordenarPor(carpeta,ORDENARPORREMITENTE);
				actualizar();
			}else{
				Error auxiliar=new Error(IntefazGrafica.this,"Error",true);
				auxiliar.pack();
				auxiliar.setResizable(false);
				auxiliar.setVisible(true);
			}
			
		}
		
	}

	class Cerrar extends WindowAdapter{
		public void windowClosing(WindowEvent e){
			guardar("almacen.ser",mapa);
			System.exit(0);
		}

	}
	class InfoAcercaDe implements ActionListener{
		public void actionPerformed(ActionEvent e){
			DacercaDe auxiliar=new DacercaDe(IntefazGrafica.this,"Acerca de",true);
			auxiliar.pack();
			auxiliar.setResizable(false);
			auxiliar.setVisible(true);
			
		}
		
	}

	
	class Salir implements ActionListener{
		public void actionPerformed(ActionEvent e){
			guardar("almacen.ser",mapa);
			System.exit(0);
		}
	}
	
	class Enviar implements ActionListener{
		public void actionPerformed(ActionEvent e){
			Denviar auxiliar=new Denviar(IntefazGrafica.this,"Enviar",true, mapa,enviarM);
			auxiliar.pack();
			auxiliar.setResizable(false);
			auxiliar.setVisible(true);
		}
	}

}



