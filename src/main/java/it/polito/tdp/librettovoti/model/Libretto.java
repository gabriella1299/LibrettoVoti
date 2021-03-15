package it.polito.tdp.librettovoti.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Libretto {
	
	//dichiaro variabile
	private List<Voto> voti; //La creo nel momento in cui creo la classe libretto
	private Map<String,Voto> votiMap; //identity map: nome esame in oggetto voto, facilmente accessibili
	
	public Libretto() {
		//metto this per ricordare che non e' una variabile di questo metodo, ma esterna!
		this.voti=new ArrayList<>();//inizializzo variabile creando un oggetto con new
		this.votiMap=new HashMap<>();
	}
	
	public void add(Voto v) { //uso la delega
		this.voti.add(v);
		this.votiMap.put(v.getNome(), v);
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
				risultato.add(v); //aggiorna sia lista sia mappa il metodo add perche' e' mio (guardo riga 20)
			}
		}
		
		return risultato;
	}
	
	public Libretto votiUguali(int punteggio) {
		Libretto risultato=new Libretto();
		for(Voto v:this.voti) {
			if(v.getVoto()==punteggio) {
				risultato.add(v);
			}
		}
		return risultato;
	}
	
	/**
	 * Ricerca un Voto del corso di cui e' specificato il nome
	 * Se il corso non esiste, restituisce null
	 * @param nomeCorso
	 * @return
	 */
	public Voto ricercaCorso(String nomeCorso) {
		/*
		Voto risultato=null;
		for(Voto v:this.voti) {
			if(v.getNome().equals(nomeCorso)) {
				risultato=v;
				break;
			}
		}
		return risultato;
		*/
		return this.votiMap.get(nomeCorso);
		
	}
	
	/**
	 * Verifica se nel libretto c'e' gia' un voto con stesso esame e
	 * stessa votazione.
	 * @param v
	 * @return
	 */
	/*
	public boolean esisteDuplicato(Voto v) { //approccio che va bene per pochi voti
		boolean trovato=false;
		for(Voto voto:this.voti) {
			if(voto.getNome().equals(v.getNome()) && voto.getVoto()==v.getVoto())
				trovato=true;
		}
		return trovato;
	}
	*/
	public boolean esisteDuplicato(Voto v) { //approccio che va bene per pochi voti
		Voto trovato=this.votiMap.get(v.getNome());
		if(trovato==null)
			return false;
		if(trovato.getVoto()==v.getVoto()) 
			return true;
		else 
			return false;
	}
	
	/**
	 * Verifica se nel libretto c'e' gia' un voto con stesso esame ma
	 * votazione diversa.
	 * @param v
	 * @return
	 */
	public boolean esisteConflitto(Voto v) {
		/*
		boolean trovato=false;
		
		for(Voto voto:this.voti) {
			if(voto.getNome().equals(v.getNome()) && voto.getVoto()!=v.getVoto())
				trovato=true;
		}
		return trovato;
		*/
		Voto trovato=this.votiMap.get(v.getNome());
		if(trovato==null)
			return false;
		if(trovato.getVoto()!=v.getVoto()) 
			return true;
		else 
			return false;
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
