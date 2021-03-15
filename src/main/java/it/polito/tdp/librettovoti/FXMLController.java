package it.polito.tdp.librettovoti;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ResourceBundle;

import it.polito.tdp.librettovoti.model.Libretto;
import it.polito.tdp.librettovoti.model.Voto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Libretto model;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtEsame;

    @FXML
    private TextField txtVoto;

    @FXML
    private DatePicker pickerEsame;

    @FXML
    private Button Inserisci;

    @FXML
    private TextArea txtResult;

    @FXML
    void handleInserisci(ActionEvent event) {
    	
    	//LEGGI E CONTROLLA I DATI
    	String nomeEsame=txtEsame.getText();
    	if(nomeEsame.length()==0) {
    		txtResult.setText("Errore: nome esame vuoto!");
    		return;//Per non andare avanti
    	}
    	
    	String votoEsame=txtVoto.getText();
    	int votoInt=0;
    	try {
    		votoInt=Integer.parseInt(votoEsame);
    	}catch(NumberFormatException ex) { //fa gia' tutti i controlli su cio' che inseriamo
    		txtResult.setText("Errore: il voto deve essere intero!");
    		return ;
    	}
    	if(votoInt<18 || votoInt>30) {
    		txtResult.setText("Errore: il voto deve essere compreso tra 18 e 30!");
    		return;
    	}
    	
//    	String dataEsame=txtData.getText();
//    	LocalDate data;
//    	try {
//    		data=LocalDate.parse(dataEsame);
//    	}catch(DateTimeParseException ex) {
//    		txtResult.setText("Errore: la data non e' nel formato corretto!");
//    		return;
//    	}
    	LocalDate data = pickerEsame.getValue();
    	if(data==null) {
    		txtResult.setText("Errore: la data e' obbligatoria!");
    		return;
    	}
    	
    	//ESEGUI L'AZIONE
    	Voto voto=new Voto(nomeEsame, votoInt, data);
    	model.add(voto);
    	
    	//AGGIORNA I RISULTATI (nella View)
    	txtResult.setText(model.toString());
    	txtEsame.clear();
    	txtVoto.clear();
    	pickerEsame.setValue(null);
    }

    public void setModel(Libretto model) {
    	this.model=model;
    }
    @FXML
    void initialize() {
    	 assert txtEsame != null : "fx:id=\"txtEsame\" was not injected: check your FXML file 'Scene.fxml'.";
         assert txtVoto != null : "fx:id=\"txtVoto\" was not injected: check your FXML file 'Scene.fxml'.";
         assert pickerEsame != null : "fx:id=\"pickerEsame\" was not injected: check your FXML file 'Scene.fxml'.";
         assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
