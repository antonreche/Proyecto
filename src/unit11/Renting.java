/**
 * 
 */
package unit11;

/**
 * Interfaz Renting --> contiene métodos para alquilar y devolver
 * @author Antonio Reche Ramal
 * @version Mayo 2015
 */

public interface Renting {
	
	/**
	 * Método para decidir alquilar un vehículo. Si es posible el alquiler muestra los detalles
	 * @param cliente	--> cliente al que se le alquila
	 * @param matricula	--> matricula del coche a alquilar
	 * @return true si se puede alquilar, false si no se puede alquilar.
	 */
	public boolean alquilar(Cliente cliente);
	
	
	/**
	 * Método para devolver los vehículos. Muestra el coste total del alquiler desglosado
	 * @param cliente	-->cliente que tenía el vehíclo en alquiler.  
	 * @param matricula -->matricula del vehículo que se le alquiló.
	 * @return devuelve el valor del alquiler
	 */
	public void devolver(Cliente cliente);
}
