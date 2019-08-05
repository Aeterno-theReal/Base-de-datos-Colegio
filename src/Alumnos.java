
public class Alumnos extends Personas{
	

	private Asignaturas[] asigxalum;
	private int numAsignaturas;

	Alumnos()
	{
		super(); //Usa el constructor por defecto del padre que en este caso es PERSONAS
		
		asigxalum=new Asignaturas[100];
		numAsignaturas=0;
	}
	
	Alumnos(String nombre, String apellidos, int edad, Asignaturas[] asigxalum, int numAsignaturas)
	{
		super(nombre, apellidos, edad); //Usa el constructor sobrecargado del padre que en este caso es PERSONAS
		
		this.asigxalum=asigxalum;
		this.numAsignaturas=numAsignaturas;
	}
	
	public String getNombreAlumnos()
	{
		return nombreAlumno;
	}
	
	public String getApellidos()
	{
		return apellidos;
	}
	
	public int getEdad()
	{
		return edad;
	}
	
	public int getNumAsignaturas()
	{
		return numAsignaturas;
	}
	
	public void setNombreAlumnos(String nom)
	{
		this.nombreAlumno=nom;
	}
	
	public void setApellidoAlumnos(String ape)
	{
		this.apellidos=ape;
	}
	
	public void setEdad(int edad)
	{
		this.edad=edad;
	}
	
	public void setNumAsignaturas(int a)
	{
		this.numAsignaturas=numAsignaturas+a;
	}
	
	public void setAsigxAlum(int pos)
	{
		asigxalum[pos].setNombreAsignatura("Por defecto");
	}
	
	public void setAsigxAlum(String asignatura, int pos)
	{
		asigxalum[pos].setNombreAsignatura(asignatura);
	}
	
	public String getAsignaturas(int i)
	{
		return asigxalum[i].getNombreAsignatura();
	}
	
	public Asignaturas[] getAsignaturas()
	{
		return asigxalum;
	}
	
	public void setAsignaturas(Asignaturas[] asig)
	{
		this.asigxalum=asig;
	}
	
}
