/**
 * "MensajeCorreo.java"
 * Asignatura Programación Avanzada de Aplicaciones
 * @author David Alarcón Prada
 * Fecha 04/03/2012
 */
package almacen;
import java.io.Serializable;
import java.util.Date;
import paa.correo.IMensajeCorreo;

public class MensajeCorreo implements IMensajeCorreo, Serializable{

	private static final long serialVersionUID = 1L;
	private String asunto;
	private String destinatario;
	private Date   fecha;	
	private String id;	
	private String remitente;
	private String texto;

	/**
	 *==English== 
	 * Constructor, it creates a message with:
	 *==Spanish==
	 * Crea un mensaje con los campos especificados. 
	 * @param titulo // Title
	 * @param para	// To
	 * @param date	// Date
	 * @param identificador // iD
	 * @param de	// From
	 * @param mensaje // Message
	 */
	public MensajeCorreo(String titulo, String para, Date date, String identificador, String de, String mensaje){
		asunto=titulo;
		destinatario=para;
		fecha=date;
		id=identificador;
		remitente=de;
		texto=mensaje;
	}
	
	/**
	 * ==English== 
	 *This method returns Title's message
	 *==Spanish==
	 * Devuelve el asunto del mensaje.
     * @return asunto - Asunto del mensaje. // Title's messge
	 */
	@Override
	public String getAsunto() {
		// TODO Auto-generated method stub
		return  asunto;
	}

	/**
	 *==English== 
	 * This method returns Receiver's message
	 *==Spanish==
     * Devuelve el destinatario del mensaje.
     * @return  destinatario - Destinatario del mensaje. // Receiver's message
     */
	@Override
	public String getDestinatario() {
		// TODO Auto-generated method stub
		return destinatario;
	}

	/**
	 *==English== 
	 * This method returns Date's message
	 *==Spanish==
     * Devuelve la fecha del mensaje.
     * @param fecha - Fecha del mensaje. // Date's message
     */
	@Override
	public Date getFecha() {
		// TODO Auto-generated method stub
		return fecha;
	}

	/**
	 *==English== 
	 * This method returns iD's message
	 *==Spanish==
     * Devuelve el identificador del mensaje.
     * @param id - Identificador del mensaje. // iD's message
     */
	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return id;
	}

	/**
	 *==English== 
	 * This method returns Sender's message
	 *==Spanish==
     * Devuelve el remitente del mensaje.
     * @return remitente - Remitente del mensaje. // Sender's message
     */	
	@Override
	public String getRemitente() {
		// TODO Auto-generated method stub
		return remitente;
	}

	/**
	 *==English== 
	 * This method returns Text's message
	 *==Spanish==
     * Devuelve el texto del mensaje.
     * @return texto - Texto del mensaje. // Text's message
     */
	@Override
	public String getTexto() {
		// TODO Auto-generated method stub
		return texto;
	}
	
	/**
	 *==English== 
	 * This method changes Title's message
	 *==Spanish==
	 * Modifica el valor de la variable asunto.
	 * @param arg0 - nuevo valor de la variable asunto. // Title's message
	 */
	@Override
	public void setAsunto(String arg0) {
		// TODO Auto-generated method stub
		asunto=arg0;
		
	}
	
	/**
	 *==English== 
	 * This method changes Receiver's message
	 *==Spanish==
	 * Modifica el valor de la variable destinatario.
	 * @param arg0 - nuevo valor de la variable destinatario. // Receiver's message
	 */
	@Override
	public void setDestinatario(String arg0) {
		// TODO Auto-generated method stub
		destinatario=arg0;
	}
	
	/**
	 *==English== 
	 * This method changes Date's message
	 *==Spanish==
	 * Modifica el valor de la variable fecha.
	 * @param arg0 - nuevo valor de la variable fecha. // Date's message
	 */
	@Override
	public void setFecha(Date arg0) {
		// TODO Auto-generated method stub
		fecha=arg0;
	}
	
	/**
	 *==English== 
	 * This method changes iD's message
	 *==Spanish==
	 * Modifica el valor de la variable id.
	 * @param arg0 - nuevo valor de la variable id. // iD's message
	 */
	@Override
	public void setId(String arg0) {
		// TODO Auto-generated method stub
		id=arg0;
		
	}
	
	/**
	 *==English== 
	 * This method changes Sender's message
	 *==Spanish==
	 * Modifica el valor de la variable remitente.
	 * @param arg0 - nuevo valor de la variable remitente. // Sender's message
	 */
	@Override
	public void setRemitente(String arg0) {
		// TODO Auto-generated method stub
		remitente=arg0;
	}
	
	/**
	 *==English== 
	 * This method changes Text's message
	 *==Spanish==
	 * Modifica el valor de la variable texto.
	 * @param arg0 - nuevo valor de la variable texto. // Text's message
	 */
	@Override
	public void setTexto(String arg0) {
		// TODO Auto-generated method stub
		texto=arg0;
		
	}
	
	/**
	 *==English== 
	 * This method assigns an exlusive ID.
	 *==Spanish==
	 * Metodo que se implementa para que se asigne un identificador único por objeto dentro de un conjunto Set
	 * @return codigo hash (es un entero). // Hash code
	 */
	@Override
	public int hashCode(){
		return id.hashCode();
	}
	
	/**
	 *==English== 
	 * This method let that Set implementations to detect if an element already exists into Set (In this case, if a message is equal to other).
	 *==Spanish==
	 * Metodo necesario para que las implementaciones del Set detecten si un elemento ya esta en el conjunto,
	 * en este caso un mensaje será igual a otro si tiene el mismo id.
	 * @param otro - objeto a comparar.
	 * @return res - true si el objeto es igual, false si no lo es.
	 */
	@Override
	public boolean equals(Object otro){
		boolean res=false;
		MensajeCorreo aux;
		
		if ( (otro != null ) && (otro instanceof MensajeCorreo)){
			aux= (MensajeCorreo) otro;
			res=id.equals(aux.id);	
		}
		return res;
	}

	public String getCabecera(){
		return   remitente+ "     " + asunto+"     " + fecha;
	}
	/**
	 *==English== 
	 * This method let to know all message's content.
	 *==Spanish==
	 * Creado para poder ver todo el contenido de un mensaje.
	 * @return el contenido concatenado. 
	 */
	@Override
	public String toString() {
		return "Asunto:" + asunto + ", Destinatario:"
				+ destinatario + ", Fecha:" + fecha + ", iD=" + id
				+ ", Remitente=" + remitente + "Texto:" +texto;
	}
	

}
