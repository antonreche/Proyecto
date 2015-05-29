/**
 * 
 */
package unit11;

/**
 * Clase Cliente con los datos de los datos personales y los tipos de carnet de los clientes
 * @author Antonio Reche Ramal
 * @version Mayo 2015
 */
public class Cliente {	
	
	String nombre;
	String dni;
	boolean carnetTurismo;
	boolean carnetFurgoneta;
	boolean carnetCamión;
	boolean alquilado;		//true indica que tiene un vehículo ya alquilado
	
	/**
	 * Constructor por defecto
	 */
	public Cliente(){		
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * @return the carnetTurismo
	 */
	public boolean isCarnetTurismo() {
		return carnetTurismo;
	}

	/**
	 * @param carnetTurismo the carnetTurismo to set
	 */
	public void setCarnetTurismo(boolean carnetTurismo) {
		this.carnetTurismo = carnetTurismo;
	}

	/**
	 * @return the carnetFurgoneta
	 */
	public boolean isCarnetFurgoneta() {
		return carnetFurgoneta;
	}

	/**
	 * @param carnetFurgoneta the carnetFurgoneta to set
	 */
	public void setCarnetFurgoneta(boolean carnetFurgoneta) {
		this.carnetFurgoneta = carnetFurgoneta;
	}

	/**
	 * @return the carnetCamión
	 */
	public boolean isCarnetCamión() {
		return carnetCamión;
	}

	/**
	 * @param carnetCamión the carnetCamión to set
	 */
	public void setCarnetCamión(boolean carnetCamión) {
		this.carnetCamión = carnetCamión;
	}

	/**
	 * @return the alquilado
	 */
	public boolean isAlquilado() {
		return alquilado;
	}

	/**
	 * @param alquilado the alquilado to set
	 */
	public void setAlquilado(boolean alquilado) {
		this.alquilado = alquilado;
	}
	
	
}
