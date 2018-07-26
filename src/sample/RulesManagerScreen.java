package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class RulesManagerScreen extends GridPane {

    private Stage stage = new Stage();
    private RulesCSVReader csvReader;
    private HashMap<String, String> shortCutsAndOutputs;
    private static String fileSource = "D:\\Lachlan\\IdeaProjects\\TextHelper\\rules.csv";
    public RulesManagerScreen() throws IOException {
        initData();
        populateShortCutsAndOutputs();
        populateGrid();



    }

    private void initData() throws IOException{
        shortCutsAndOutputs = new HashMap<>();
        csvReader = new RulesCSVReader(fileSource, ",");
        this.setPadding(new Insets(40, 40, 40, 40));
        Scene scene = new Scene(this, 500, 400);
        stage.setScene(scene);
        stage.setTitle("Shortcut Manager");
    }

    private void populateShortCutsAndOutputs() {

        short counter = 0;
        for (String keyString : this.csvReader.getInputList()) {
            this.shortCutsAndOutputs.put(keyString, this.csvReader.getOutputList().get(counter));
            counter++;
        }
    }

    private void populateGrid() throws IOException{
        short rowCounter = 0;
        //Button addRuleButton = new Button("Add");
       // RulesCSVReader.addRule("Hello", "good^^bye", false);
        Iterator it = shortCutsAndOutputs.entrySet().iterator();

        while (it.hasNext()){
            Map.Entry pair = (Map.Entry) it.next();

            // Populate Add Grid content
            RuleOutputPair rop = new RuleOutputPair((String)pair.getKey(),(String)pair.getValue());

            this.add(rop, 0, rowCounter);
            Button deleteButton = new Button("Remove");
            deleteButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    /* Set event to delete the RuleOutputPair */
                    String filePath = RulesManagerScreen.fileSource;
                    String input =  rop.getRuleString();
                    try {
                        RulesCSVReader.deleteRule(filePath, input);
                    }
                    catch (IOException ioe) {
                        System.out.println(ioe.getMessage());
                    }
                    RulesManagerScreen.this.getChildren().removeAll(rop, deleteButton);
                }
            });

            this.add(deleteButton, 1, rowCounter);


            // TODO add button to remove rop. Give it handler so that when it removes it deletes
            // it calls a static csvreader method to search for an delete line
            rowCounter++;
        }
    }

    public void show() {
        stage.show();
    }
}
