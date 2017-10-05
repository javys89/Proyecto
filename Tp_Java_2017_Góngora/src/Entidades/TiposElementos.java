package Entidades;

import java.sql.Date;
import java.sql.Time;

public class TiposElementos {
	
	private int idTipoElemento;
	private String nombreTipoE;
	private String maxHs;
	private String diasAnt;
	private int cantReservas;
	
	public TiposElementos(){};
	
	public TiposElementos(int IdTipoElemento,String nombre, String maxHs,String diasAnt,int cantReservas){
		
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
	

	public String getMaxHs() {
		return maxHs;
	}

	public void setMaxHs(String maxHs) {
		this.maxHs = maxHs;
	}

	public String getDiasAnt() {
		return diasAnt;
	}

	public void setDiasAnt(String diasAnt) {
		this.diasAnt = diasAnt;
	}

	public String getNombreTipoE() {
		return nombreTipoE;
	}
	public void setNombreTipoE(String nombre) {
		this.nombreTipoE = nombre;
	}
	
	public int getCantReservas() {
		return cantReservas;
	}
	public void setCantReservas(int cantReservas) {
		this.cantReservas = cantReservas;
	}
}