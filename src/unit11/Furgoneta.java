/**
 * 
 */
package unit11;

import java.util.Scanner;

/**
 * Clase Furgoneta --> hereda de Vehículo e implementa la interfaz Renting.
 * cuenta con los atributos añadidos de "float plus" y "int plazas."
 * @author Antonio Reche Ramal
 */
public class Furgoneta extends Vehiculo implements Renting {
	
	Scanner teclado=new Scanner(System.in);
	int plazas;
	float plus=40;	
	
	/**
	 * Constructor parametrizado que se basa en el de la clase padre y añade el número de plazas,
	 * además de incializar los atributos precioDia y precioKm;
	 * @param modelo
	 * @param matricula
	 * @param km
	 * @param plazas  --> nº plazas de la furgoneta
	 */
	public Furgoneta(String modelo,String matricula,int km,int plazas){
		super(modelo,matricula,km);
		this.plazas=plazas;
		precioDia=30f;
		precioKm=0.30f;
	}

	@Override
	public boolean alquilar(Cliente cliente) {
		boolean alquilar=false;
		
		if(cliente.getCarnetFurgoneta() && !cliente.getAlquilado())
		{			
			String opcion;
			
			System.out.print("¿Para cuantos días se alquila? ");
			dias=teclado.nextInt();
			System.out.println("El coste del alquiler es de: "+dias*precioDia+"€ + "+precioKm+"€ por km recorrido");
			if(plazas>7)
				System.out.println("Este vehículo tiene un suplemento de "+plus+"€ por ser de más de 7 plazas");
			
			
			do{
				System.out.print("¿Desea alquilar la furgoneta? Si(s) No(n)");
				opcion=teclado.nextLine();
			}while(!super.comprobarOpcion(opcion));
			
			if(opcion.equals("s")){
				cliente.setAlquilado(true);
				alquilar= true;
				System.out.println("Ha aceptado el alquiler.");
			}else
				alquilar= false;			
		}
		else {
			System.out.println("No se puede alquilar el vehículo:");
			if(!cliente.getCarnetFurgoneta())
				System.out.println("El cliente no tiene el carnet necesario para alquilar la furgoneta");
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
		if(plazas>7){
			System.out.println("\t#"+plus+"€ por tener más de 7 plazas");
			precio=(dias*precioDia)+(kmCobrar*precioKm)+plus;
		}else{
			precio=(dias*precioDia)+(kmCobrar*precioKm);
		}
		
		System.out.println("\t#Total: "+precio+"€");
		
		cliente.setAlquilado(false);
		km=kmMarcador;		
		}	
}
