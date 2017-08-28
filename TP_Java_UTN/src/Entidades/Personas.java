package Entidades;


public class Personas {
	
	private int idPersona;
	private String dni;
	private String nombrePersona;
	private String apellido;
	private String user;
	private String contraseña;
	private Categorias Cat;

	public Personas(){};
	
	public Personas(String nombre,String dni,Categorias categorias,String apellido,String user, String password)
	{
		this.setDni(dni);
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setUser(user);
		this.setContraseña(password);
		this.setCat(categorias);
		
		}
	
	

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public Categorias getCat() {
		return Cat;
	}

	public void setCat(Categorias cat) {
		Cat = cat;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombrePersona;
	}

	public void setNombre(String nombre) {
		this.nombrePersona = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	
}
