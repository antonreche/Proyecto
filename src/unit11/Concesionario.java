/**
 * 
 */
package unit11;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase Concesionario --> contiene la lógica para realizar los alquileres de vehículos.
 * @author Antonio Reche Ramal
 * @version Mayo 2015
 */
public class Concesionario {
	
	static ArrayList<Renting> vehiculos=new ArrayList<Renting>();
	static ArrayList<Cliente> clientes=new ArrayList<Cliente>();
	
	/**
	 * Método estátcio para añadir objetos que tenga el interfaz renting implementado.
	 * @param v	--> vehiculo  a añadir
	 */
	static void anyadirVehiculo(Renting v){
		vehiculos.add(v);		
	}
	
	/**
	 * Método para buscar un vehículo por matricula en el ArrayList
	 * @param matricula	--> matricula del vehículo
	 * @return objeto de la clase vehiculo si lo encuentra si no null
	 */
	static Vehiculo buscarVehiculo(String matricula){
		Vehiculo v=null;
		
		for(int i=0;i<vehiculos.size();i++){
			if(((Vehiculo)vehiculos.get(i)).getMatricula().equals(matricula))		
				v=(Vehiculo)vehiculos.get(i);			
		}		
		return v;
	}
	
	/**
	 * Método para añadir clientes al ArrayList clientes
	 * @param c	--> cliente a añadir
	 */
	static void anyadirCliente(Cliente c){
		clientes.add(c);
	}
	
	/**
	 * Método para buscar clientes por el dni en el ArrayList clientes
	 * @param dni	-->dni de la persona a buscar
	 * @return	cliente si lo encuentra y si no devuelve null
	 */
	static Cliente buscarCliente(String dni){
		
		Cliente c=null;
		
		for(int i=0;i<clientes.size();i++){
			if(clientes.get(i).getDni().equals(dni))		
				c=clientes.get(i);			
		}
		
		return c;
	}	
	
	/**
	 * Método estático para alquilar vehículos 
	 */
	static void alquilar(){
		Scanner teclado=new Scanner(System.in);
		String dni;
		String matricula;
		Cliente c;
		Vehiculo v=null;
		System.out.println("Clientes: ");
		boolean alquilado=false;
		for(int i=0;i<clientes.size();i++){			
			System.out.println("\tNombre: "+(clientes.get(i)).getNombre()+"\tDNI: "+(clientes.get(i)).getDni());
		}
		
		System.out.print("Introduce el DNI del cliente que desea alquilar:");
		dni=teclado.nextLine();
		c=buscarCliente(dni);
		if(c!=null){
			System.out.println("Vehículos: ");
			for(int i=0;i<vehiculos.size();i++)
			{
				System.out.println("Marca: "+(((Vehiculo)vehiculos.get(i)).getMarca()+"\tMatricula: "+(((Vehiculo)vehiculos.get(i)).getMatricula())));
			}
			
			System.out.print("Introduce la matrícula del vehiculo a alquilar: ");
			matricula=teclado.nextLine();
			v=buscarVehiculo(matricula);
			if(v!=null){				
				if(v instanceof Turismo){
					alquilado=((Turismo)v).alquilar(c);	
				v.setAlquilado(alquilado);
			}
				else if(v instanceof Furgoneta){
					alquilado=((Furgoneta)v).alquilar(c);
					v.setAlquilado(alquilado);
					}
				else{
					alquilado=((Camion)v).alquilar(c);
					v.setAlquilado(alquilado);
					}
			}else
				System.out.println("Matrícula no encontrada");
		}else
			System.out.println("DNI no encontrado");
		
	}
	
	/**
	 * Método estático para devolver vehículos 
	 */
	static void devolver(){
		Scanner teclado=new Scanner(System.in);
		String dni;
		String matricula;
		Cliente c;
		Vehiculo v;
		
		System.out.println("Clientes con vehículos alquilados: ");
		
		for(int i=0;i<clientes.size();i++){
			if(clientes.get(i).getAlquilado())
				System.out.println("\tNombre: "+(clientes.get(i)).getNombre()+"\tDNI: "+(clientes.get(i)).getDni());
		}
		System.out.println();
		
		System.out.print("Introduce el DNI del cliente que desea devolver:");
		dni=teclado.nextLine();
		c=buscarCliente(dni);
		if(c!=null){
			System.out.println();
			System.out.println("Vehículos alquilados: ");
			for(int i=0;i<vehiculos.size();i++)
			{
				if(((Vehiculo)vehiculos.get(i)).getAlquilado())
					System.out.println("Marca: "+(((Vehiculo)vehiculos.get(i)).getMarca()+"\tMatricula: "+(((Vehiculo)vehiculos.get(i)).getMatricula())));
			}
			System.out.println();			
			System.out.print("Introduce la matrícula del vehiculo a devolver: ");
			matricula=teclado.nextLine();
			v=buscarVehiculo(matricula);
			if(v!=null){
				if(v instanceof Turismo){
					((Turismo)v).devolver(c);
					v.setAlquilado(false);
				}
				else if(v instanceof Furgoneta){
					((Furgoneta)v).devolver(c);
					v.setAlquilado(false);
				}
				else{
					((Camion)v).devolver(c);
					v.setAlquilado(false);
				}
			}else
				System.out.println("Matrícula no coincide con ningún vehículo alquilado");
		}else
			System.out.println("DNI no coincide con ningún cliente que tenga vehículos alquilados");
	}
	
	
	/**
	 * Función principal del programa, crea los objetos, y muestra un menú de opciones
	 * @param args
	 */
	public static void main(String[] args) {
		
		Turismo coche =new Turismo("Opel", "1111bbb",100);
		Furgoneta furgo=new Furgoneta("Ford","2222ccc",200,8);
		Camion camion=new Camion("Pegaso","333dd",1000,true);
		Cliente cliente1=new Cliente("cliente 1","111A");
		Cliente cliente2=new Cliente("Cliente 2","222B");
		Cliente cliente3=new Cliente("Cliente 3","333C");
		Scanner teclado=new Scanner(System.in);
		
		String opcion;
		boolean salir=false;
		
		anyadirVehiculo(coche);
		anyadirVehiculo(furgo);
		anyadirVehiculo(camion);
		
		cliente1.setCarnetTurismo(true);
		cliente2.setCarnetFurgoneta(true);
		cliente2.setCarnetCamion(true);
		cliente3.setCarnetTurismo(true);
		cliente3.setCarnetFurgoneta(true);
		
		anyadirCliente(cliente1);
		anyadirCliente(cliente2);
		anyadirCliente(cliente3);
		
		do{	
			System.out.println("**********Alquiler de vehículos**********");
			System.out.println("\tPara alquilar vehículo pulsa 1.");
			System.out.println("\tPara devolver vehículo pulsa 2.");
			System.out.println("\tPara añadir un nuevo cliente pulsa 3.");
			System.out.println("\tPara salir pulsa 4.");
			System.out.print("\nEscoge una opción: ");
			opcion=teclado.nextLine();
			
			switch(opcion){
			
			case "1":
				alquilar();
				break;
			case "2":
				devolver();
				break;
			case "3":
				Cliente c=new Cliente();
				c.rellenarDatos();
				anyadirCliente(c);
				break;
			case "4":
				salir=true;
				break;
			default:
					System.out.println("Opción incorrecta");
					break;			
			}			
		}while(!salir);
	}

}
