package it.polito.tdp.librettovoti.model;

import java.time.LocalDate;
import java.util.List;

public class TestLibretto {

	public static void main (String[] args) {
		
		System.out.println("Test metodi di Libretto");
		Libretto libretto=new Libretto();
		
		Voto voto1=new Voto("Analisi 1",30,LocalDate.of(2019, 2, 15));
		
		libretto.add(voto1);
		libretto.add(new Voto("Chimica", 25, LocalDate.of(2019, 7, 15)));
		libretto.add(new Voto("Fisica 1", 28, LocalDate.of(2019, 7, 15)));
		libretto.add(new Voto("Informatica", 24, LocalDate.of(2019, 9, 15)));
		
		System.out.println(libretto); //stampa indirizzo di memoria
	
		List<Voto> venticinque=libretto.listaVotiUguali(25);
		System.out.println(venticinque);
		
		Libretto librettoVenticinque= libretto.votiUguali(25); //posso aggiungere altri oggetti
		System.out.println(librettoVenticinque); //usa metodo di stampa della classe libretto
	
		Voto analisi=libretto.ricercaCorso("Analisi 1");
		System.out.println(analisi);
	
		Voto analisi3=libretto.ricercaCorso("Analisi 3");
		System.out.println(analisi3);
		
		Voto chimica = libretto.ricercaCorso("Chimica") ;
		Voto chimica_doppio = new Voto("Chimica", 25, LocalDate.of(2019, 9, 15)) ;
		Voto chimica_conflitto = new Voto("Chimica", 29, LocalDate.of(2019, 9, 15)) ;
		System.out.println(chimica + " doppione di " + chimica_doppio + "? -> "+libretto.esisteDuplicato(chimica_doppio));
		System.out.println(chimica + " doppione di " + chimica_conflitto + "? -> "+libretto.esisteDuplicato(chimica_conflitto));
		System.out.println(chimica + " conflitto di " + chimica_doppio + "? -> "+libretto.esisteConflitto(chimica_doppio));
		System.out.println(chimica + " conflitto di " + chimica_conflitto + "? -> "+libretto.esisteConflitto(chimica_conflitto));
		
	}
	
	
}
