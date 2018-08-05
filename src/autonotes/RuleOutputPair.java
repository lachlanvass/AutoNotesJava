package autonotes;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;


public class RuleOutputPair extends GridPane {

    private TextField ruleContents = new TextField();
    private TextField outputContents = new TextField();
    private Label ruleLabel = new Label("Rule: ");
    private Label outputLabel = new Label("Output: ");
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

        ruleContents.setEditable(false);
        outputContents.setEditable(false);

    }

    public String getRuleString() {
        return RuleString;
    }

    public void styleForDeletion() {
        String styleString = "-fx-background-color: lightgray";
        ruleContents.setStyle(styleString);
        outputContents.setStyle(styleString);
    }
}
