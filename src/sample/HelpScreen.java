package sample;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class HelpScreen extends BorderPane {

    private Stage stage = new Stage();
    private Label contents = new Label();

    public HelpScreen() {

        populateContents();
        contents.setWrapText(true);

        this.setTop(contents);
        this.setPadding(new Insets(40, 40, 40, 40));
        Scene scene = new Scene(this, 500, 400);
        stage.setScene(scene);
        stage.setTitle("Help");
        stage.initModality(Modality.APPLICATION_MODAL);


    }
    public void show() {
        stage.showAndWait();
    }

    private void populateContents() {

        contents.setText("Welcome to AUTONOTES, an interactive text editor specially designed for our work at Australia Post.\n\n" +
                "It helps speed up the process of writing meaningful notes, allowing more detailed casa information to be captured. It also \n\n" +
                "allows agents to focus more on customer interaction and less on typing out the same notes over and over again. \n \n");

    }

}

