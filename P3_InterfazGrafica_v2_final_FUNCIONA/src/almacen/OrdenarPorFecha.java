/**
 * "OrdenarPorFecha.java"
 * Asignatura Programación Avanzada de Aplicaciones
 * @author David Alarcón Prada
 * Fecha 04/03/2012
 */
package almacen;
import java.io.*;
import java.util.*;

import paa.correo.IMensajeCorreo;

public class OrdenarPorFecha implements Comparator<IMensajeCorreo>,Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 *==English== 
	 * This method is created to implement an order criteria. First by date.
	 *==Spanish==
	 * Metodo creado para implementar un criterio de ordenación: primero por el campo fecha en sentido descendente,
	 * en segundo lugar en caso de igualdad ordenación por remitente en sentido ascendente, y así sucesivamente por el
	 * destinatario, el asunto y el texto en sentido ascendente.
	 * @param arg0 - mensaje 1 para comparar. // Message #1
	 * @param arg1 - mensaje 2 para comparar. // Message #2
	 * @return res - variable entera que valdrá 1, -1, o 0 según el primer elemento sea mayor que el segundo, el segundo
	 * sea mayor que el primero o sean iguales. // Int which value will be 1, -1, 0 depending the order.
	 */
	@Override
	public int compare(IMensajeCorreo arg0, IMensajeCorreo arg1) {
		// TODO Auto-generated method stub
		int res=0;
		if((arg0==null)||(arg1==null))
			throw new NullPointerException();
		
		if(arg0.getId().equals(arg1.getId()))
			res=0;
		else{	
		res=-(arg0.getFecha().compareTo(arg1.getFecha()));
		
		if(res==0)
			res=arg0.getRemitente().compareTo(arg1.getRemitente()); 
		if(res==0)
			res=arg0.getDestinatario().compareTo(arg1.getDestinatario());
		if(res==0)
			res=arg0.getAsunto().compareTo(arg1.getAsunto());
		if(res==0)
			res=arg0.getTexto().compareTo(arg1.getTexto());
		// Este if esta puesto porque si dos mensajes tienen distinto id, pero el resto de campos son iguales
		// y no pongo esto no me lo admite en la carpeta ya que res valdria 0
		if(res==0)
			res=arg0.getId().compareTo(arg1.getId());
		}
		return res;
	}
}
