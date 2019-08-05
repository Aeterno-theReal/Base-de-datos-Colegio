
public abstract class Personas {
	
	private String nombreAlumno;
	private String apellidos;
	private int edad;
	
	Personas()
	{
		this.nombreAlumno="Por defecto";
		this.apellidos="Por defecto";
		this.edad=-1;
	}
	
	Personas(String nombreAlumno, String apellidos, int edad)
	{
		this.nombreAlumno=nombreAlumno;
		this.apellidos=apellidos;
		this.edad=edad;
	}
}
