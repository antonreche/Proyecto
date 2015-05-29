/**
 * 
 */
package unit11;

import java.util.Scanner;

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
	boolean carnetCamion;
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
	public boolean getCarnetFurgoneta() {
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
	public boolean getCarnetCamion() {
		return carnetCamion;
	}

	/**
	 * @param carnetCamión the carnetCamión to set
	 */
	public void setCarnetCamion(boolean carnetCamion) {
		this.carnetCamion = carnetCamion;
	}

	/**
	 * @return the alquilado
	 */
	public boolean getAlquilado() {
		return alquilado;
	}

	/**
	 * @param alquilado the alquilado to set
	 */
	public void setAlquilado(boolean alquilado) {
		this.alquilado = alquilado;
	}
	
	/**
	 * Método para comprobar si la opción es válida ("s" o "n")
	 * @param opcion	-->texto a comprobar
	 * @return true si opcion es "s" o "n" false cualquier otro
	 */
	private boolean comprobarOpcion(String opcion)
	{
		if(opcion.equals("s"))
			return true;
		else if(opcion.equals("n"))
			return true;
		else{
			System.out.println("¡Opción no válida!");
			return false;
		}
	}
	
	/**
	 * Método que va pidiendo por pantalla los datos para rellenar la ficha del cliente.
	 */
	public void rellenarDatos()
	{
		Scanner teclado=new Scanner(System.in);
		String opcion;
		System.out.println("Introduzca los datos del cliente: ");
		System.out.print("\tNombre: ");
		nombre=teclado.nextLine();
		System.out.print("\nDNI: ");
		dni=teclado.nextLine();
		
		do{
			System.out.print("\n¿Tiene carnet para turismos? Si(s) No(n): ");
			opcion=teclado.nextLine();
		}while(!comprobarOpcion(opcion));
		
		if(opcion.equals("s"))
			carnetTurismo=true;
		else
			carnetTurismo=false;
		
		do{
			System.out.print("\n¿Tiene carnet para furgonetas? Si(s) No(n): ");
			opcion=teclado.nextLine();
		}while(!comprobarOpcion(opcion));
		
		if(opcion.equals("s"))
			carnetFurgoneta=true;
		else
			carnetFurgoneta=false;
		
		do{
			System.out.print("\n¿Tiene carnet para camión? Si(s) No(n): ");
			opcion=teclado.nextLine();
		}while(!comprobarOpcion(opcion));
		
		if(opcion.equals("s"))
			carnetCamion=true;
		else
			carnetCamion=false;
		
	}
}
