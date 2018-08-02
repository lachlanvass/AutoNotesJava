package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class PromptCharDropDown extends ComboBox {

    final String promptCharLine = "-";
    final String promptCharArrow = ">";
    final String promptCharDot = "*";
    ObservableList<String> options = FXCollections.observableArrayList();
    public PromptCharDropDown() {

        options.add(promptCharLine);
        options.add(promptCharArrow);
        options.add(promptCharDot);
        this.setItems(options);
        this.getSelectionModel().selectFirst();

    }

}
