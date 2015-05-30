/**
 * 
 */
package unit11;

import java.util.Scanner;

/**
 * Clase para los vehículos turismo
 * @author Antonio Reche Ramal
 */
public class Turismo extends Vehiculo implements Renting {
	
	Scanner teclado=new Scanner(System.in);
		
	/**
	 * Constructor parametrizado para indicar modelo, matricula y km, además de inicializar los
	 * valores de precioDia y precioKm
	 * @param modelo
	 * @param matricula
	 * @param km
	 */
	public Turismo(String modelo,String matricula,int km){
		super(modelo,matricula,km);
		precioDia=20f;
		precioKm=0.20f;
	}

	@Override
	public boolean alquilar(Cliente cliente) {
		boolean alquilar=false;
		
		if(cliente.getCarnetTurismo() && !cliente.getAlquilado())
		{			
			String opcion;
			System.out.print("¿Para cuantos días se alquila? ");
			dias=teclado.nextInt();
			System.out.println("El coste del alquiler es de: "+dias*precioDia+"€ + "+precioKm+"€ por km recorrido");
			
			do{
				System.out.print("¿Desea alquilar el turismo? Si(s) No(n)");
				opcion=teclado.nextLine();
			}while(!comprobarOpcion(opcion));
			
			if(opcion.equals("s")){
				cliente.setAlquilado(true);		
				alquilar=true;
				System.out.println("Ha aceptado el alquiler.");
			}else
				alquilar=false;			
		}
		else {
			System.out.println("No se puede alquilar el vehículo:");
			if(!cliente.getCarnetTurismo())
				System.out.println("El cliente no tiene el carnet necesario para alquilar el turismo");
			else
				System.out.println("El cliente ya tiene un vehículo alquilado.");
		}
		return alquilar;
	}

	@Override
	public void devolver(Cliente cliente) {
		float precio;
		int kmMarcador,kmCobrar;
		
		do{
			System.out.print("¿Cuántos Km indica el cuenta kilómetros? ");
			kmMarcador=teclado.nextInt();			
		}while(!compruebaKm(kmMarcador));
		
		kmCobrar=kmMarcador-km;
		
		System.out.println("Ha hecho "+kmCobrar+"Km con un coste total de "+kmCobrar*precioKm+"€" );
		System.out.println("El precio total del alquiler es de: ");
		System.out.println("\t#"+dias*precioDia+"€ por los días de alqiler");
		System.out.println("\t#"+kmCobrar*precioKm+"€ por los Km.");
		precio=(dias*precioDia)+(kmCobrar*precioKm);
		System.out.println("\t#Total: "+precio+"€");
		
		cliente.setAlquilado(false);
		km=kmMarcador;		
		}	
}
