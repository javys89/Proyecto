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
		/*public void borrar(persona p){
			 dataPer.deletePersona(p);
				}

	*/					
		public Personas Mostrar(Personas p){
		
			return dataPer.getByUser(p);
			
			}
}
		/*
		public void update(persona p){
			dataPer.update(p);
		}
}	*/


