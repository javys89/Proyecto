package Entidades;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class Reservas {

	private int idReserva;
	private Time hora;
	private Date fecha;
	private ArrayList<Elementos> listaElementos;
	private Personas persona;
	
	public Reservas(){}

	
	public int getIdReserva() {
		return idReserva;
	}


	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}


	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public ArrayList<Elementos> getListaElementos() {
		return listaElementos;
	}

	public void setListaElementos(ArrayList<Elementos> listaElementos) {
		this.listaElementos = listaElementos;
	}

	public Personas getPersona() {
		return persona;
	}

	public void setPersona(Personas persona) {
		this.persona = persona;
	};
	
	
	
}