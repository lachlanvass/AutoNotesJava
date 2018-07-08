package sample;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;

public class PreviousNotesScreen extends BorderPane {
    private Stage stage = new Stage();
    TextArea contents = new TextArea();
    public PreviousNotesScreen(ArrayList<String> inputs) {

        populateContents(inputs);
        contents.setEditable(false);
        this.setCenter(contents);
        Scene scene = new Scene(this, 200, 200);
        stage.setScene(scene);
        stage.setTitle("Previous notes");
        stage.initModality(Modality.APPLICATION_MODAL);


    }
    public void show() {
        stage.showAndWait();
    }

    private void populateContents(ArrayList<String> inputs) {
        for (String s : inputs) {
            contents.appendText(s);
        }
    }
}
