package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


public class RuleOutputPair extends GridPane {

    Button deleteButton = new Button("Remove");
    TextField ruleContents = new TextField();
    TextField outputContents = new TextField();
    Label ruleLabel = new Label("Rule: ");
    Label outputLabel = new Label("Output: ");
    private String RuleString;
    public RuleOutputPair(String rule, String output) {

        RuleString = rule;

        // Strip possible whitespace
        rule = rule.trim();
        output = output.trim();

        ruleContents.setText(rule);
        outputContents.setText(output);

        this.add(ruleLabel, 0, 0);
        this.add(ruleContents, 1, 0);
        this.add(outputLabel, 2, 0);
        this.add(outputContents, 3, 0);

    }

    private void setDeleteButtonHandler() {
        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                RuleOutputPair.this.getChildren().removeAll(ruleLabel, ruleContents, outputLabel, outputContents, deleteButton);
            }
        });
    }

    public String getRuleString() {
        return RuleString;
    }
}
