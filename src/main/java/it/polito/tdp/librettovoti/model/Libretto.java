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
	
	public String toString() {
		//return this.voti.toString(); //chiede alla classe voto di stamparsi, ma anche qui indirizzi di memoria
		String s="";
		for(Voto v:this.voti) {//per iterare su una collection
			s = s + v.toString() + "\n";			
		}
		return s;
	}
}
