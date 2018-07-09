package sample;

import javafx.scene.Scene;
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
        Scene scene = new Scene(this, 500, 400);
        stage.setScene(scene);
        stage.setTitle("Previous notes");
        stage.initModality(Modality.APPLICATION_MODAL);


    }
    public void show() {
        stage.showAndWait();
    }

    private void populateContents(ArrayList<String> inputs) {

        /* Reverse content so that more recent note is displayed first */
        //Collections.reverse(inputs);

        for (String s : inputs) {

            /* Do not include prompt string. WHY: improve brevity of notes lookup - only useful information respected*/
            if (!s.equals("- \n")) {
                contents.appendText(s);
            }

            // DO not include the --
        }

    }
}
