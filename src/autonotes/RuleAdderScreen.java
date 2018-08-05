package autonotes;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class RuleAdderScreen extends GridPane {

    private Stage stage = new Stage();

    private TextField shortCut = new TextField();
    private TextField output = new TextField();
    private Button confirm = new Button("Confirm");

    private RulesManagerScreen parent;

    private EventHandler confirmEvent = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            parent.setShortCutString(shortCut.getText());
            parent.setNewOutputString(output.getText());
            try {
                parent.addNewRuleToFile();
            }
            catch (IOException ioe) {
                System.out.println("IO EXCEPTION FROM RULESADDERSCREEN.java");
            }

            stage.close();
            try {
                parent.reload();
            }
            catch (IOException ioe) {
                System.out.println("IO EXCEPTION FROM RULESADDERSCREEN.java");
            }
        }
    };
    public RuleAdderScreen(RulesManagerScreen rulesManager) {
        parent = rulesManager;
        initData();
        displayNodes();

    }

    private void initData() {

        confirm.setOnAction(confirmEvent);
        // Press enter on output text field to activate event
        output.setOnAction(confirmEvent);

        Scene scene = new Scene(this, 400, 100);
        stage.setMaxWidth(400);
        stage.setMaxHeight(100);
        stage.setScene(scene);
        stage.setTitle("Add a new rule...");
    }

    private void displayNodes() {

        this.add(new Label("Shortcut: "), 0, 1);
        this.add(shortCut, 1, 1);
        this.add(new Label("Output: "), 2, 1);
        this.add(output, 3, 1);
        this.add(confirm, 3, 2);


    }

    public void show() {
        stage.show();
    }
}
