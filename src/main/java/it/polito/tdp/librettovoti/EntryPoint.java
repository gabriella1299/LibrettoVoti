package it.polito.tdp.librettovoti;

import javafx.application.Application;
import static javafx.application.Application.launch;

import it.polito.tdp.librettovoti.model.Libretto;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class EntryPoint extends Application {

    @Override
    public void start(Stage stage) throws Exception {
       
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
    	
    	Parent root = loader.load();//metodo richiamato su un oggetto, non piu' in modo statico su una classe
    								//il nostro oggetto ha un metodo: getController();
    	FXMLController controller = loader.getController(); //ha bisogno di una classe per essere settata
        //parent root sarebbe la scena
        
        Libretto model=new Libretto();//modello su cui il controller richiama i metodi, BISOGNA DECIDERE SOLO LA CLASSE CHE FA IL MODELLO
        controller.setModel(model);
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        
        stage.setTitle("JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
