/**
 * "ParametrosDeConfigurar.java"
 * Asignatura Programación Avanzada de Aplicaciones
 * Practica 3
 * @author David Alarcón Prada
 * Fecha 25/03/2012
 */
package interfaz;

import java.io.*;


public class ParametrosDeConfigurar implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String host;
	private int port;
	private boolean ssl;	
	private String username;	
	private String password;
	private boolean debug;
	
	/**
	 *==English== 
	 * This constructor creates a object where storage an e-mail account.
	 *==Spanish==
	 *  Crea un objeto donde se recogeran los parametros para configurar una cuenta de correo
	 * @param host // host
	 * @param port // port
	 * @param ssl  // ssl protocol
	 * @param username // username
	 * @param password // pass
	 * @param debug    // debug
	 */
	public ParametrosDeConfigurar(String host, int port, boolean ssl,String username,String password,boolean debug){
		this.host=host;
		this.port=port;
		this.ssl=ssl;
		this.username=username;
		this.password=password;
		this.debug=debug;
	}
	/**
	 *==English== 
	 * Getters/Setters of atributes, no so relevant.
	 */

	/**
	 * Devuelve el host de una configuracion.
	 * @return host - host de la configuracion.
	 */
	public String getHost() {
		return host;
	}
	/**
	 * Permite modificar el host de una configuracion.
	 * @param host - valor nuevo del host.
	 */
	public void setHost(String host) {
		this.host = host;
	}
	/**
	 * Devuelve el puerto de una configuracion.
	 * @return port - puerto de la configuracion.
	 */
	public int getPort() {
		return port;
	}
	/**
	 * Permite modificar el puerto de una configuracion.
	 * @param port - valor nuevo del puerto.
	 */
	public void setPort(int port) {
		this.port = port;
	}
	/**
	 * Devuelve la variable SSL de una configuracion. 
	 * @return ssl - SSL de la configuracion.
	 */
	public boolean isSsl() {
		return ssl;
	}
	
	/**
	 * Permite modificar el SSL de una configuracion.
	 * @param ssl - valor nuevo de SSL.
	 */
	public void setSsl(boolean ssl) {
		this.ssl = ssl;
	}

	/**
	 * Devuelve el nombre de ususario de una configuracion.
	 * @return username - nombre de usuario de la configuracion.
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Permite modificar el nombre de usuario de una configuracion.
	 * @param username - valor nuevo de nombre de usuario.
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * Devuelve la contraseña de una configuracion.
	 * @return password - contraseña de la configuracion.
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * Permite modificar la contraseña de una configuracion.
	 * @param password - valor nuevo de la contraseña.
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * Devuelve la variable debug de una configuracion.
	 * @return debug - debug de una configuracion.
	 */
	public boolean isDebug() {
		return debug;
	}
	/** 
	 * Permite modificar el valor de la variable debug.
	 * @param debug - valor nuevo de la variable debug.
	 */
	public void setDebug(boolean debug) {
		this.debug = debug;
	}
	
}
