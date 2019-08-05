
import java.util.Scanner;

public class Ejercicio1 {
	
	Scanner teclado;

	Alumnos[] alumno;
	Asignaturas[] asignatura;
	
	int contAlumno;
	int contAsignatura;
	
	Ejercicio1()
	{
		teclado=new Scanner(System.in);
		alumno=new Alumnos[100];
		asignatura=new Asignaturas[100];
		contAlumno=0;
		contAsignatura=0;
	}
	
	public void altaAlumno()
	{
		String nombre, apellido;
		boolean tipo=true;
		int edad=0;

		
		if(contAlumno+1 > 100)
			System.out.println("¡¡¡¡No se pueden introducir mas Alumnos!!!!");
		else
		{
			nombre=introducirNombres(tipo, teclado);
			apellido=introducirDatos(tipo, teclado);
			edad=introducirFecha(tipo, teclado);
			alumno[contAlumno]=new Alumnos();
			alumno[contAlumno].setNombreAlumnos(nombre);
			alumno[contAlumno].setApellidoAlumnos(apellido);
			alumno[contAlumno].setEdad(edad);
			contAlumno++;
		}
	}
	
	public void altaAsignatura()
	{
		String nombre, ciclo;
		boolean tipo=false;
		int fecha=0;
		
		if(contAsignatura+1 > 100)
			System.out.println("¡¡¡¡No se pueden introducir mas Asignaturas!!!!");
		else
		{
			nombre=introducirNombres(tipo, teclado);
			ciclo=introducirDatos(tipo, teclado);
			fecha=introducirFecha(tipo, teclado);
			asignatura[contAsignatura]=new Asignaturas();
			asignatura[contAsignatura].setNombreAsignatura(nombre);
			asignatura[contAsignatura].setCicloFormativo(ciclo);
			asignatura[contAsignatura].setAno(fecha);
			contAsignatura++;
		}
	}
	
	public void matricularAlumno()
	{
		int pos1=-1, pos2=-1;
		String nombreasig="", nombrealumn="";
		
		System.out.println("\nProcedemos a mostrar los alumnos almacenados: ");
	
		do {
			mostrarAlumnos();
			System.out.print("\n¿A aque alumno desea asignarle una asignatura?: ");
			nombrealumn=teclado.nextLine();
			pos1=seleccionarAlumno(nombrealumn);
		}while(pos1==-1);
		
		System.out.println("\nDe acuerdo, ha seleccionado al alumno " + alumno[pos1].getNombreAlumnos());
		System.out.println("\nProcedemos a mostrarle las asignaturas almacenadas: ");
		
		do {
			mostrarAsignaturas();
			System.out.print("\n¿Qué asignatura desea asignarle al Alumno?: ");
			nombreasig=teclado.nextLine();
			
			pos2=seleccionarAsignatura(nombreasig);
		}while(pos2==-1);
		
		//alumno[pos1].setAsigxAlum(alumno[pos1].getNumAsignaturas())=new Asignaturas();
		
		alumno[pos1].setAsigxAlum(asignatura[pos2].getNombreAsignatura(), alumno[pos1].getNumAsignaturas());
		
		//alumno[pos1].setAsigxAlum(alumno[pos1].setNombreAsignatura())=asignatura[pos2].getNombreAsignatura();
		
		alumno[pos1].setNumAsignaturas(1);
		
		System.out.println("\nSe ha asignado la asignatura " + asignatura[pos2].getNombreAsignatura() + " al alumno " + alumno[pos1].getNombreAlumnos());
	}
	
	public void mostrarAlumnos()
	{
		System.out.println("\nLos alumnos dados de alta son: ");
		for(int i=0; i<contAlumno; i++)
		{
			System.out.println("Alumno número [" + (i+1) + "]: " + alumno[i].getNombreAlumnos() + " " + alumno[i].getApellidos() + ";");
		}
	}
	
	public void mostrarAsignaturas()
	{
		System.out.println("\nLas asignaturas dadas de alta son: ");
		for(int i=0; i<contAsignatura; i++)
		{
			System.out.println("Asignatura número [" + (i+1) + "]: " + asignatura[i].getNombreAsignatura() + "; ");
		}
	}
	
	public void asignaturasAlumnos()
	{
		int posalumno=-1;
		String nombrealumn="";
		
		do {
			mostrarAlumnos();
			System.out.print("\n¿Para que alumno desea ver sus asignaturas?: ");
			nombrealumn=teclado.nextLine();
			posalumno=seleccionarAlumno(nombrealumn);
		}while(posalumno==-1);
		
		System.out.println("Para el alumno " + alumno[posalumno].getNombreAlumnos() + " las asignaturas asociadas son: ");
		for(int i=0; i<alumno[posalumno].getNumAsignaturas(); i++)
		{
			System.out.println((i+1) + ": " + alumno[posalumno].getAsignaturas(i));
		}
		System.out.println(".");
	}
	
	public void alumnosAsignaturas()
	{
		String nomasignatura="";
		int posasignatura=0;
		boolean axa=false;
		
		do {
			mostrarAsignaturas();
		
			System.out.println("");
	
			System.out.print("Introduzca el nombre de la asignatura para la que desea saber que alumnos están matriculados: ");
			nomasignatura=teclado.nextLine();
			
			posasignatura=seleccionarAsignatura(nomasignatura);
		}while(posasignatura==-1);
		
		System.out.println("Los alumnos que pertenencen a la asignatura " + asignatura[posasignatura].getNombreAsignatura() + " son: ");
		axa=asignaturasEnAlumnos(nomasignatura);
		
		if(!axa)
		{
			System.out.println("Error!, no se han encontrado alumnos matriculados en la asignatura.");
		}
	}
	
	public boolean asignaturasEnAlumnos(String nombreasignatura)
	{
		boolean encontrado=false;
		for(int i=0; i<contAlumno; i++)
		{
			for(int j=0; j<contAsignatura; j++)
			{
				if(alumno[i].getAsignaturas(j).equals(nombreasignatura))
				{
					System.out.println(alumno[i].getNombreAlumnos() + " " + alumno[i].getApellidos() + ";");
					encontrado=true;
				}
			}
		}
		return encontrado;
	}
	
	public void eliminarAlumno()
	{
		String nomalumno="";
		int posalumno=-1;
		
		do {
			mostrarAlumnos();
			
			System.out.print("Indica que alumno deseas eliminar: ");
			nomalumno=teclado.nextLine();
			

			posalumno=seleccionarAlumno(nomalumno);
		}while(posalumno==-1);
			
		for(int i=posalumno; i<alumno.length; i++)
		{
			if((i+1)!=alumno.length && alumno[i+1]!=null)
				alumno[i]=alumno[i+1];
			else
				alumno[i]=null;
		}
		contAlumno--;
		
		System.out.println("El Alumno " + nomalumno + " se ha eliminado correctamente.");
	}
	
	public void eliminarAsignatura()
	{
		String nomasignatura="";
		int posasignatura=-1;
		
		do {
			mostrarAsignaturas();
			
			System.out.print("Indica que asignatura deseas eliminar: ");
			nomasignatura=teclado.nextLine();
			
			posasignatura=seleccionarAsignatura(nomasignatura);
		}while(posasignatura==-1);
		
		for(int i=posasignatura; i<asignatura.length; i++)
		{
			if(asignatura[i+1]!=null)
				asignatura[i]=asignatura[i+1];
			else
				asignatura[i]=null;
		}
		contAsignatura--;
		
		for(int i=0; alumno[i]!=null && i<alumno.length; i++)
		{
			for(int j=0; alumno[i].getAsignaturas(j)!=null && j<alumno[i].getNumAsignaturas()-1; j++)
			{
				if((j+1)!=alumno[i].getNumAsignaturas() && alumno[i].getAsignaturas(j+1)!=null)
					alumno[i].setAsigxAlum(alumno[i].getAsignaturas(j+1), j);
				else
					alumno[i].setAsigxAlum(null, j);
			}
		}
		
		System.out.println("La asignatura " + nomasignatura + " se ha eliminado correctamente.");
	}
	
	static String introducirNombres(boolean tipo, Scanner t)
	{
		String nom="";
		if(tipo)
		{
			System.out.println();
			System.out.print("Introduzca el nombre del Alumno: ");
			nom=t.nextLine();
		}
		else
		{
			System.out.println();
			System.out.print("Introduzca el nombre de la Asignatura: ");
			nom=t.nextLine();
		}
		
		return nom;
	}
	
	static String introducirDatos(boolean tipo, Scanner t)
	{
		String datos="";
		if(tipo)
		{
			System.out.print("Introduzca los apellidos del Alumno: ");
			datos=t.nextLine();
		}
		else
		{
			System.out.print("Introduzca el Ciclo de la Asignatura: ");
			datos=t.nextLine();
		}
		return datos;
	}
	
	static int introducirFecha(boolean tipo, Scanner t)
	{
		int fecha=0;
		
		if(tipo)
		{
			System.out.print("Introduzca la edad del alumno: ");
			fecha=t.nextInt();
			t.nextLine();
		}
		else
		{
			System.out.print("Introduzca el año de la asignatura: ");
			fecha=t.nextInt();
			t.nextLine();
		}
		return fecha;
	}
	
	public int seleccionarAlumno(String nombrealumn)
	{
		String apellidoalumn;
		int numposicion=-1;
		boolean encontrado=false;
		int encontrados=0;

			for(int i=0; i<contAlumno; i++)
			{
				if(alumno[i].getNombreAlumnos().equals(nombrealumn))
				{
					encontrado=true;
					encontrados++;
					numposicion=i;
				}
			}
			if(!encontrado)
			{
				System.out.println("¡Error! - No se han encontrado alumnos coincidentes.\n");
			}
			else
			{
				if(encontrados>1)
				{
					System.out.println("Para el alumno " + nombrealumn + " se ha encontrado mas de un alumno iguales.\n");
					System.out.print("Introduzca el apellido para el alumno " + nombrealumn + ": ");
					apellidoalumn=teclado.nextLine();
					
					encontrado=false;
					for(int i=0; i<contAlumno; i++)
					{
						if(alumno[i].getApellidos().equals(apellidoalumn) && alumno[i].getNombreAlumnos().equals(nombrealumn))
						{
							encontrado=true;
							encontrados++;
							numposicion=i;
						}
					}
					if(!encontrado)
					{
						System.out.println("¡Error! - No se han encontrado alumnos coincidentes.\n");
					}
				}
			}
		
		return numposicion;
	}
	
	public int seleccionarAsignatura(String nombreAsig)
	{
		int numposicion=-1;
		boolean encontrado=false;
		int encontrados=0;
		
			for(int i=0; i<contAsignatura; i++)
			{
				if(asignatura[i].getNombreAsignatura().equals(nombreAsig))
				{
					encontrado=true;
					encontrados++;
					numposicion=i;
				}
			}
			if(!encontrado)
			{
				System.out.println("¡Error! - No se han encontrado asignaturas coincidentes.\n");
			}
		
		return numposicion;
	}
}
