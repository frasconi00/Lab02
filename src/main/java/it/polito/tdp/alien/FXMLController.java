package it.polito.tdp.alien;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
//import java.util.Set;

import it.polito.tdp.alien.model.Translator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Translator model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea txtArea;

    @FXML
    private TextField txtField;

    @FXML
    void handleClearText(ActionEvent event) {
    	txtField.clear();
    	txtArea.clear();
    }

    @FXML
    void handleTranslate(ActionEvent event) {
    	
    	String testo = txtField.getText();
    	
    	if(!testo.equals("")) {
    		String[] parole = testo.split(" ");
    		if(parole.length==1) {
    			
    			parole[0]=parole[0].toLowerCase();
    			
    			if(parole[0].contains("?")) {
    				
    				//conta che ci sia solo un punto interrogativo
    				
    				//funzione vera e propria
    				
    				
    				
    			}
    			
    			List<String> traduzioni = model.traduci(parole[0]);
    			
    			if(traduzioni!=null) {
    				
    				if(parole[0].matches("[a-zA-Z]+")) {
    					String stampa="";
    					for(String s : traduzioni) {
    						if(stampa!="")
    								stampa+="\n";
    					stampa+=s;
    					}
    				
    					txtArea.setText("Traduzioni di "+parole[0]+":\n"+stampa);
    				}
    				else {
    					txtArea.setText("Inserire solo caratteri alfabetici");
    				}
    					
    			}else
    				txtArea.setText("Parola aliena non presente nel dizionario");
    			
    		}else if(parole.length==2) {
    			
    			if(parole[0].matches("[a-zA-Z]+") && parole[1].matches("[a-zA-Z]+")) {
    				parole[0]=parole[0].toLowerCase();
    				parole[1]=parole[1].toLowerCase();
    				model.add(parole[0], parole[1]);
    				txtArea.setText("Nuova traduzione aggiunta:\n"+parole[0]+" : "+parole[1]);
    			}
    			else {
    				txtArea.setText("Inserire solo caratteri alfabetici");
    			}
    			
    		}else {
    			txtArea.setText("Errore. Inserire una parola aliena per averne la traduzione"
    					+ "\no 2 per aggiungere una parola aliena al dizionario");
    		}
    	}

    }
    
    public void setModel(Translator model) {
    	this.model = model;
    }

    @FXML
    void initialize() {
        assert txtArea != null : "fx:id=\"txtArea\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtField != null : "fx:id=\"txtField\" was not injected: check your FXML file 'Scene.fxml'.";

    }

}

