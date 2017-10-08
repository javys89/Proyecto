package Controlador;

import Data.DataPersonas;
import Entidades.Personas;

public class CtrlABMCPersona {
		private DataPersonas dataPer;

	public CtrlABMCPersona(){
			dataPer = new DataPersonas();
		}
	
		public void listadoPersonas(){
			dataPer.getAll();
		}			
		
		public void alta(Personas p){
				dataPer.addPersona(p);
		}
		public void borrar(Personas p){
			 dataPer.deletePersona(p);
				}
		
	
		public Personas Mostrar(Personas p){
		
			return dataPer.getByUser(p);
			
			}
		public int categoriaUser(Personas p){
				return p.getCat().getIdCat();
			}
			
		public Personas buscaPersona(String usser){
			Personas p=new Personas();
			p.setUser(usser);
			p=this.Mostrar(p);
			return p;
		}
		public Personas buscaPersonaDni(String dni){
			Personas p=new Personas();
			p.setDni(dni);
			p=this.Mostrar(p);
			return p;
		}
}
		/*
		public void update(persona p){
			dataPer.update(p);
		}
}	*/
