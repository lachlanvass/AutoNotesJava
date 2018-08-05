package autonotes;

import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;

// TODO Save output of commands, not just the command shortcuts

public class PreviousNotesScreen extends BorderPane {
    private Stage stage = new Stage();
    private TextArea contents = new TextArea();
    public PreviousNotesScreen(ArrayList<String> inputs) {

        populateContents(inputs);
        contents.setEditable(false);
        this.setCenter(contents);
        Scene scene = new Scene(this, 500, 400);
        stage.setMaxWidth(500);
        stage.setMaxHeight(400);
        stage.setScene(scene);
        stage.setTitle("Previous notes");
        stage.initModality(Modality.APPLICATION_MODAL);


    }
    void show() {
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
