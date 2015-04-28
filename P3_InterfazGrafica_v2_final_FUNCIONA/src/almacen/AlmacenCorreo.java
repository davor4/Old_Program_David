/**
 * "AlmacenCorreo.java"
 * Asignatura Programación Avanzada de Aplicaciones
 * @author David Alarcón Prada
 * Fecha 04/03/2012
 */
package almacen;
import java.io.Serializable;
import java.util.*;


import paa.correo.IAlmacenCorreo;
import paa.correo.IMensajeCorreo;

public class AlmacenCorreo implements IAlmacenCorreo, Serializable{
	private static final long serialVersionUID = 1L;
	private Map<String,TreeSet<IMensajeCorreo>> almacen=new TreeMap<String,TreeSet<IMensajeCorreo>>();
	
	/**
	 *==English== 
	 * This method add a new folder to the store, if it already exists, nothing happen.
	 *==Spanish==
	 * Añade una nueva carpeta al almacen de correo si no está ya presente en el almacén. Si ya había una carpeta del
	 * mismo nombre no se realiza ningún cambio en el almacén y la llamada devuelve false.
	 * @param arg0 - carpeta para añadir. // Folder to add
	 * @return res - true si se ha añadido, false si no. // True if it was added, false if not.
	 */
	@Override
	public boolean addCarpeta(String arg0) {
		// TODO Auto-generated method stub
		boolean res=false;
		
		if (!almacen.containsKey(arg0)){
			TreeSet<IMensajeCorreo> conjuntoMensajes=new TreeSet<IMensajeCorreo>(new OrdenarPorFecha());
			almacen.put(arg0, conjuntoMensajes);
			res=true;
		}
		return res;
	}

	/**
	 *==English== 
	 * This method add a new message into the folder if it doesn't exist (a message with the same ID).
	 * The messages will be stored in the folder according to the standard defined.
	 *==Spanish==
	 * Añade un mensaje a la carpeta correspondiente si el mensaje no existe ya en la carpeta, o sea, no hay otro
	 * mensaje con el mismo identificador. Los mensajes se almacenarán ordenados en la carpeta según el criterio
	 * de ordenación de la misma.
	 * @param arg0 - carpeta a la cual se quiere añadir un mensaje. //Folder which the message will be added.
	 * @param arg1 - mensaje que se quiere añadir. // Message that we want to add.
	 * @return res - true si se ha añadido el mensaje a la carpeta, false si no.  // True if it was added, False if not.
	 */
	@Override
	public boolean addMensaje(String arg0, IMensajeCorreo arg1) {
		// TODO Auto-generated method stub

		boolean res=false;
		TreeSet<IMensajeCorreo> temp;

		if(almacen.containsKey(arg0)){
			temp=almacen.get(arg0);
			if(temp.add(arg1))
				res=true;	

		}
		return res;
	}
	
	/**
	 *==English== 
	 * This method checks if exist a folder into the store.
	 *==Spanish==
	 * Indica si ya existe en el almacén de correo la carpeta correspondiente.
	 * @param arg0 - carpeta que se desea verificar. // Folder that we want check.
	 * @return res - true si se ha verificado correctamente, false si no. // True if it exists, false if not.
	 */
	@Override
	public boolean containsCarpeta(String arg0) {
		// TODO Auto-generated method stub
		boolean res=false;
		
		if(almacen.containsKey(arg0))
			res=true;
		
		return res;
	}
	
	/**
	 *==English== 
	 * This method remove a folder of the store if it exists into. If the folder does not exist, nothing happen and false is returned.
	 *==Spanish==
	 * Borra una carpeta del almacén de correo si está presente en el almacén. Si no hay una carpeta del mismo nombre
	 * no se realiza ningún cambio en el almacén y la llamada devuelve false.
	 * @param arg0 - carpeta que se desea borrar. // Folder which we want to delete.
	 * @return res - true si se ha borrado correctamente, false si no. // True if it was removed, false if not.
	 */
	@Override
	public boolean delCarpeta(String arg0) {
		// TODO Auto-generated method stub
		boolean res=false;
		
		if(almacen.containsKey(arg0)){
			almacen.remove(arg0);
			res=true;
		}
		
		return res;
	}

	/**
	 *==English== 
	 * This method deletes the message situated in an especific position into the folder. The position is an integer between
	 * 1 and the maximun number that the folder has. The position it is changeable because it changes if some message it is removed
	 * or if the folder's order changes.
	 *==Spanish==
	 * Borra el mensaje situado en la posición correspondiente dentro de la carpeta. La posición es un entero
	 * entre 1 y el número de mensajes que contien la carpeta. La posición de un mensaje es variable, puesto que cambia
	 * si se borran mensajes de la carpeta o se reordena.
	 * @param arg0 - carpeta de la cual se quiere borrar un mensaje. // Folder which we want to remove a message.
	 * @param arg1 - numero del mensaje el cual se quiere eliminar.	 // Message's number which we want to remove.
	 * @return res - true si se ha eliminado el mensaje, false si no.// True if it was removed, false if not.
	 */
	@Override
	public boolean delMensaje(String arg0, int arg1) {
		// TODO Auto-generated method stub
		boolean res=false;
		boolean fin=false;
		int contador=1;
		IMensajeCorreo mensajeDevuelto=null;
		TreeSet<IMensajeCorreo> conjuntoTemp;
		Iterator<IMensajeCorreo> i;

		if(almacen.containsKey(arg0)){
			conjuntoTemp=almacen.get(arg0);
			i=conjuntoTemp.iterator();
			if(!conjuntoTemp.isEmpty()){
				if((1<=arg1)&&(arg1<=conjuntoTemp.size())){
					while (i.hasNext() && (fin==false)){
						mensajeDevuelto=i.next();
						if(contador==arg1){
							conjuntoTemp.remove(mensajeDevuelto);
							fin=true;
							res=true;
						}
						else{
							contador++;
							
						}	
						
					}
				
				}	
				
			}

		}		
		return res;
	}

	/**
	 *==English== 
	 * This method returns a set which contains the existing folders into the store.
	 *==Spanish==
	 * Devuelve un conjunto con una vista de las carpetas que existen en el almacén de correo.
	 * @return conjunto - contiene las carpetas si se han recuperado correctamente, null si no. // This contains the set if we could get it, null if not.
	 */
	@Override
	public Set<String> getCarpetas() {
		Set<String> conjunto=null ;
		conjunto = almacen.keySet();
		
		return conjunto;
	}
	/**
	 *==English== 
	 * This method obtains a message of the folder situated in a position. The position is a number between 1 and maximum number of
	 * messages that the folder contains.The position it is changeable because it changes if some message it is removed
	 * or if the folder's order changes.
	 *==Spanish==
	 * Devuelve el mensaje situado en la posición correspondiente dentro de la carpeta. La posición es un entero entre 1
	 * y el número de mensajes que contiene la carpeta. La posición de un mensaje es variable, puesto que cambia si se
	 * borran mensajes de la carpeta o se reordena.
	 * @param arg0 - carpeta de la cual se quiere recuperar un mensaje. // Folder which we want to remove a message.
	 * @param arg1 - numero de mensaje que se quiere recuperar. // Number of message we want to remove
	 * @return mensajeDevuelto - contendrá el mensaje si se ha recuperado o null si no. // It will contain the message if it existed or null if it didnt exist.
	 */
	@Override
	public IMensajeCorreo getMensaje(String arg0, int arg1) { 
		// TODO Auto-generated method stub
		boolean fin=false;
		int contador=1;
		IMensajeCorreo mensajeDevuelto=null;
		TreeSet<IMensajeCorreo> temp;
		Iterator<IMensajeCorreo> i;
		
		if(almacen.containsKey(arg0)){
			temp=almacen.get(arg0);
			i=temp.iterator();
			if(!temp.isEmpty()){
				if((1<=arg1)&&(arg1<=temp.size())){
					while (i.hasNext() && (fin==false)){
						mensajeDevuelto=i.next();
						if(contador==arg1){
							fin=true;
						}
						else{
							contador++;
							
						}	
						
					}
				
				}	
				
			}

		}
			
		
		return mensajeDevuelto;
	}

	/**
	 *==English== 
	 * This method returns the messages that belongs to the folder. It will be order by actual standard.
	 *==Spanish==
	 * Devuelve los mensajes de la carpeta correspondiente ordenados según criterio actual.
	 * @param arg0 - carpeta de la cual se quieren recuperar los mensajes. // Folder which we want to get the messages
	 * @return conjunto - contendrá un conjunto de mensajes si se han podido recuperar o null si no. // True if we could get it, false if not.
	 */
	@Override
	public SortedSet<IMensajeCorreo> getMensajes(String arg0) {
		// TODO Auto-generated method stub
		
		SortedSet<IMensajeCorreo> conjunto=null;
		if(almacen.containsKey(arg0)){
			conjunto=almacen.get(arg0);
		}
		
		return conjunto;
	}

	/**
	 *==English== 
	 * This method obtains the number of messages that the folder has.
	 *==Spanish==
	 * Devuelve el número de mensajes que contiene la carpeta cuyo nombre se indica.
	 * @param arg0 - carpeta de la cual se quiere saber el numero de mensajes existentes en ella. // Folder which we want to get the messages
	 * @return res - contendrá el número de mensajes que hay en la carpeta. // Number of messages.
	 */
	@Override
	public int getNumMensajes(String arg0) {
		// TODO Auto-generated method stub
		TreeSet<IMensajeCorreo> temp;
		int res=0;
		
		if (almacen.containsKey(arg0)){
			temp=almacen.get(arg0);
			res=temp.size();
		}
		
		
		return res;
	}

	/**
	 *==English== 
	 * This method let us change the standard to order the messages into the folder. The criteria is indicated by the parameter
	 * ORDENARPORFECHA => to order by date in ascendant order
	 * ORDENARPORREMITENTE => to order by sender in ascendant order
	 *==Spanish==
	 * Permite cambiar el criterio de ordenacion de la carpeta correspondiente, los mensajes almacenados serán
	 * reordenados según el nuevo criterio de ordenación que se indica como parámetro: ORDENARPORFECHA para ordenar
	 * en primer lugar por el campo fecha en sentido descendente, en segundo lugar en caso de igualdad por el remitente
	 * en sentido ascendente, y así sucesivamente por el destinatario, el asunto y el texto en sentido ascendente,
	 * ORDENARPORREMITENTE para ordenar en primer lugar  por el campo remitente en sentido ascendente, y en segundo
	 * lugar en caso de igualdad por la fecha en sentido descendente y así sucesivamente por el destinatario,
	 * el asunto y el texto en sentido ascendente.
	 * @param arg0 - carpeta la cual se quiere cambiar su criterio de ordenación. // Folder which we want to change the criteria.
	 * @param arg1 - criterio de ordenacion elegido: 1 para ordenar por FECHA, 2 para ordenar por REMITENTE. // Criteria 1=> order by date 2=> order by sender.
	 * @return res - true si se ha cambiado correctamente el criterio, false si no. // true if criteria was changed, false if not.
	 */
	@Override
	public boolean ordenarPor(String arg0, int arg1) {
		// TODO Auto-generated method stub
		TreeSet<IMensajeCorreo> conjuntoTemporal=null;
		TreeSet<IMensajeCorreo> conjuntoNuevo;
		boolean res=false;
		
		if(almacen.containsKey(arg0)){
			conjuntoTemporal=almacen.get(arg0);
			
			if(arg1==ORDENARPORFECHA){
				conjuntoNuevo=new TreeSet<IMensajeCorreo>(new OrdenarPorFecha());
				conjuntoNuevo.addAll(conjuntoTemporal);
				almacen.put(arg0, conjuntoNuevo);
			}
			if(arg1==ORDENARPORREMITENTE){
				conjuntoNuevo=new TreeSet<IMensajeCorreo>(new OrdenarPorRemitente());
				conjuntoNuevo.addAll(conjuntoTemporal);
				almacen.put(arg0, conjuntoNuevo);
			}
			
		}

		return res;
	}
}
