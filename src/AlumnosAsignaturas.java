import java.util.Scanner;

public class AlumnosAsignaturas {
	
	static Ejercicio1 trabajos; //Creamos una variable objeto de tipo Ejercicio1
	
	//Principal del programa.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		trabajos=new Ejercicio1(); //Inicializamos el objeto de clase Ejercicio1
		
		//Declaración de variables locales
		Scanner teclado=new Scanner(System.in); 
		int opcionmin=0;
		int opcionmax=7;
		int opcion=-1;


		System.out.println("-----Este programa da de alta a Alumnos y a Asignaturas.-----\n\n");
		
		//Mientras la opción escogida no sea 0 para salir del programa, realizamos las llamadas correspondientes.
		do {
			mostrarMenu();
			opcion=pedirOpcion(teclado, opcionmin, opcionmax);
			
			switch (opcion) 
			{
				case 1:
					//Damos de alta a un nuevo alumno
					trabajos.altaAlumno();
					break;
				case 2:
					//Damos de alta una nueva asignatura
					trabajos.altaAsignatura();
					break;
				case 3:
					//Asignamos a Alumno una asignatura
					trabajos.matricularAlumno();
					break;
				case 4:
					//Mostramos todos los Alumnos de nuestra BD
					trabajos.mostrarAlumnos();
					break;
				case 5:
					//Mostramos todas las asignaturas de nuestra BD
					trabajos.mostrarAsignaturas();
					break;
				case 6:
					//Mostramos las asignaturas que tiene asignadas cada alumno
					trabajos.asignaturasAlumnos();
					break;
				case 7:
					//Mostramos los alumnos que tiene asignados cada asignatura.
					trabajos.alumnosAsignaturas();
					break;
				case 8:
					//Eliminamos un alumno.
					trabajos.eliminarAlumno();
					break;
				case 9: 
					//Eliminamos una asignatura.
					trabajos.eliminarAsignatura();
					break;
				case 0:
					//Si el usuario elije cerrar el programa, mostramos mensaje de despedida
					System.out.println("\n----- Gracias por usar nuestro programa ------");
					break;
				default:
					break;
			}
		}while(opcion!=0);
	}
	
	
	//Mostramos el menú en esta función para que el cliente pueda escoger la opción
	static void mostrarMenu()
	{
		System.out.println();
		System.out.println("Menú de opciones disponibles: ");
		System.out.println("------------------------------");
		System.out.println("1. Crear nuevo alumno.");
		System.out.println("2. Crear nueva asignatura.");
		System.out.println("3. Matricular un alumno en una asignatura.");
		System.out.println("4. Mostrar todos los alumnos en la BD.");
		System.out.println("5. Mostrar todas las asignaturas en la BD.");
		System.out.println("6. Ver asignaturas de un alumno.");
		System.out.println("7. Ver los alumnos de una asignatura.");
		System.out.println("8. Eliminar un alumno.");
		System.out.println("9. Eliminar una asignatura.");
		System.out.println("0. Salir del programa.");
		System.out.println();
	}
	
	//Solicitamos por teclado la opción elegida del menu anterior.
	static int pedirOpcion(Scanner t, int min, int max)
	{
		int opcion=-1;
		do {
			System.out.print("Introduzca la opción que desea realizar: ");
			opcion=t.nextInt();
			t.nextLine();
			if(opcion<0 || opcion>9)
				System.out.println("¡¡Error!!, la opción marcada no es correcta, ha de marcar la opción correcta para continuar.");
		}while(opcion<0 || opcion>9);
		
		return opcion;
	}

}
