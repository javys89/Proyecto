package Entidades;

import java.sql.Date;
import java.sql.Time;

public class TiposElementos {
	
	private int idTipoElemento;
	private String nombreTipoE;
	private Time maxHs;
	private Date diasAnt;
	private int cantReservas;
	
	public TiposElementos(){};
	
	public TiposElementos(int IdTipoElemento,String nombre, Time maxHs,Date diasAnt,int cantReservas){
		
		this.setIdTipoElemento(IdTipoElemento);
		this.setNombreTipoE(nombre);
		this.setCantReservas(cantReservas);
		this.setDiasAnt(diasAnt);
		this.setMaxHs(maxHs);
	}
		
	
	
	public int getIdTipoElemento() {
		return idTipoElemento;
	}

	public void setIdTipoElemento(int idTipoElemento) {
		this.idTipoElemento = idTipoElemento;
	}

	public String getNombreTipoE() {
		return nombreTipoE;
	}
	public void setNombreTipoE(String nombre) {
		this.nombreTipoE = nombre;
	}
	public Time getMaxHs() {
		return maxHs;
	}
	public void setMaxHs(Time maxHs) {
		this.maxHs = maxHs;
	}
	public Date getDiasAnt() {
		return diasAnt;
	}
	public void setDiasAnt(Date diasAnt) {
		this.diasAnt = diasAnt;
	}
	public int getCantReservas() {
		return cantReservas;
	}
	public void setCantReservas(int cantReservas) {
		this.cantReservas = cantReservas;
	}
}