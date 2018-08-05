package autonotes;

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
        stage.setMaxWidth(500);
        stage.setMaxHeight(400);
        stage.setScene(scene);
        stage.setTitle("Help");
        stage.initModality(Modality.APPLICATION_MODAL);


    }
    public void show() {
        stage.showAndWait();
    }

    private void populateContents() {

        contents.setText("Welcome to AUTONOTES, an interactive text editor. \n\n" +
                "With AutoNotes you can set shortcut rules within the RULES MANAGER and used inside the main text area. " +
                "NOTE: when setting these rules the '^' character signifies a new line. \n\n" +
                "Set the prompt character using the dropdown menu to the left of the main text area. " +
                "Type '--' and press enter to end the current note and copy it to the clipboard. The contents of that note " +
                "will be saved in the HISTORY screen.\n\n" +
                "For further help or support please email: vass.software@gmail.com" +
                "This is a creation by Vass Software created by Lachlan Vass."
            );

    }

}

