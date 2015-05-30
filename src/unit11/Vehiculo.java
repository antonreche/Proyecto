/**
 * 
 */
package unit11;

/**
 * Clase Vehiculo --> clase padre para los tipos de vehículos
 * @author Antonio Reche Ramal
 * @version Mayo 2015
 */
public class Vehiculo {
	
	protected String matricula;
	protected String marca;
	protected int dias;			//días para los que se alquila
	protected float precioDia;
	protected float precioKm;
	protected int km;			//km antes de salir
	protected boolean alquilado=false;
		
	/**
	 * Constructor parametrizado para añadir los atributos de Vehículo
	 * @param matricula --> matricula
	 * @param marca	--> marca y modelo
	 * @param km	--> km 
	 * @param precioDia	-->precio de alquiler por dia
	 * @param precioKm	-->precio de alquiler por km
	 */
	protected Vehiculo(String marca, String matricula, int km)
	{
		this.matricula=matricula;
		this.marca=marca;
		this.km=km;		
	}
	
	/**
	 * Método get para matricula
	 * @return the matricula
	 */
	public String getMatricula() {
		return matricula;
	}
	
	/**
	 * Método set para alquilado
	 * @param alquilado	--> true cuando se alquila, false cuando se devuelve
	 */
	public void setAlquilado(boolean alquilado){
		this.alquilado=alquilado;
	}
	
	/**
	 * @return true cuando está alquilado, false cuando está disponible
	 */
	public boolean getAlquilado(){
		return alquilado;
	}
	
	/**
	 * Método set para matrícula
	 * @param matricula the matricula to set
	 */
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	/**
	 * método get para marca
	 * @return the marca
	 */
	public String getMarca() {
		return marca;
	}
	
	/**
	 * Método set para marca
	 * @param marca the marca to set
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}
	/**
	 * Método get para dias
	 * @return the dias
	 */
	public int getDias() {
		return dias;
	}
	
	/**
	 * Método set para dias
	 * @param dias the dias to set
	 */
	public void setDias(int dias) {
		this.dias = dias;
	}
	/**
	 * Método get para precioDia
	 * @return the precioDia
	 */
	public float getPrecioDia() {
		return precioDia;
	}
	
	/**
	 * Método set para precioDia
	 * @param precioDia the precioDia to set
	 */
	public void setPrecioDia(float precioDia) {
		this.precioDia = precioDia;
	}
	
	/**
	 * Método get para precioKm
	 * @return the precioKm
	 */
	public float getPrecioKm() {
		return precioKm;
	}
	
	/**
	 * Método set para precioKm
	 * @param precioKm the precioKm to set
	 */
	public void setPrecioKm(float precioKm) {
		this.precioKm = precioKm;
	}
	
	/**
	 * Método get para km
	 * @return the km
	 */
	public int getKm() {
		return km;
	}
	
	/**
	 * Método set para km
	 * @param km the km to set
	 */
	public void setKm(int km) {
		this.km = km;
	}	
	
	/**
	 * Método para mostrar por pantalla los datos de los vehículos
	 */
	public void  MostrarDatos()
	{
		System.out.println("Marca y Modelo: "+marca);
		System.out.println("Matrícula: "+matricula);
		System.out.println("Kilómetros: "+km);
		System.out.println("Precios de alquiler:");
		System.out.println("\tPrecio por día: "+precioDia);
		System.out.println("\tPrecio por Km: "+precioKm);
		
		if(alquilado)
			System.out.println("El vehículo está disponible.");
		else
			System.out.println("El vehículo no está disponible.");		
	}
	
	/**
	 * Método para comprobar si la opción es válida ("s" o "n")
	 * @param opcion	-->texto a comprobar
	 * @return true si opcion es "s" o "n" false cualquier otro
	 */
	protected boolean comprobarOpcion(String opcion)
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
	
	protected boolean compruebaKm(int marcadorKm){
		if(marcadorKm<km){
			System.out.println("Número de kilometros menor que el del marcador antes de alquilar.");
			return false;
		}else
			return true;
	}
}
