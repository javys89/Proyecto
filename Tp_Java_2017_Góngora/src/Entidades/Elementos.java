package Entidades;

public class Elementos {
	
	public int	idElemento;
	public String nombreElementos;
	public TiposElementos Tipo;

	public Elementos(String nombre, TiposElementos tipo,int idElemento) {
		this.setNombreElementos(nombre);
		this.setIdElemento(idElemento);
		this.setTipo(tipo);
	};

	public String getNombreElementos() {
		return nombreElementos;
	}

	public void setNombreElementos(String nombreElementos) {
		this.nombreElementos = nombreElementos;
	}

	
	public int getIdElemento() {
		return idElemento;
	}

	public void setIdElemento(int idElemento) {
		this.idElemento = idElemento;
	}

	public TiposElementos getTipo() {
		return Tipo;
	}

	public void setTipo(TiposElementos tipo) {
		Tipo = tipo;
	}

	public Elementos() {};
	
}