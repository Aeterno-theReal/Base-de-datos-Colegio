
public class Asignaturas {

	private String nombreAsignatura;
	private String cicloFormativo;
	private int ano;
	
	Asignaturas()
	{
		nombreAsignatura="";
		cicloFormativo="";
		ano=-1;
	}
	
	Asignaturas(String nombre, String ciclo, int curso)
	{
		this.nombreAsignatura=nombre;
		this.cicloFormativo=ciclo;
		this.ano=curso;
	}
	
	public String getNombreAsignatura()
	{
		return nombreAsignatura;
	}
	
	public String getCicloFormativo()
	{
		return cicloFormativo;
	}
	
	public int getano()
	{
		return ano;
	}
	
	public void setNombreAsignatura(String nom)
	{
		nombreAsignatura=nom;
	}
	
	public void setCicloFormativo(String ciclo)
	{
		cicloFormativo=ciclo;
	}
	
	public void setAno(int a)
	{
		ano=a;
	}
}


