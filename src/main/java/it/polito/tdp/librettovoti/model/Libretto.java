package it.polito.tdp.librettovoti.model;

import java.util.ArrayList;
import java.util.List;

public class Libretto {
	
	//dichiaro variabile
	private List<Voto> voti; //La creo nel momento in cui creo la classe libretto
	
	public Libretto() {
		//metto this per ricordare che non e' una variabile di questo metodo, ma esterna!
		this.voti=new ArrayList<>();//inizializzo variabile creando un oggetto con new
	}
	
	public void add(Voto v) { //uso la delega
		this.voti.add(v);
	}
	
	/*public void stampaVotiUguali(int punteggio) {
		//il libretto stampa da solo i voti
		System.out.println();
	}
	
	public String votiUguali(int punteggio) { //piu' generale, e' meglio!
		//calcola una stringa che contiene i voti
		//sara poi il chiamante a stamparli
		//Solo il nome?
		//e il voto? o la data? tutto il voto.toString()
	}
	*/
	
	public List<Voto> listaVotiUguali(int punteggio){ //ancora meglio del precedente perche' stampa i voti
		//restituisce solo i voti uguali al criterio
		//espone all'esterno la struttura dati utilizzata all'interno
	
		List<Voto> risultato=new ArrayList<>();
		for(Voto v:this.voti) {
			if(v.getVoto()==punteggio) {
				risultato.add(v);
			}
		}
		
		return risultato;
	}
	
	
	public Libretto votiUguali(int punteggio) {
		Libretto risultato=new Libretto();
		for(Voto v:this.voti) {
			if(v.getVoto()==punteggio) {
				risultato.add(v);
				//risultato.voti.add(v);
			}
		}
		return risultato;
	}
	
	
	public String toString() {
		//return this.voti.toString(); //chiede alla classe voto di stamparsi, ma anche qui indirizzi di memoria
		String s="";
		for(Voto v:this.voti) {//per iterare su una collection
			s = s + v.toString() + "\n";			
		}
		return s;
	}
}
