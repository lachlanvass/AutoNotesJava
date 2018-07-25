package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

public class PromptCharTextField extends TextField {

    String promptChar = "-";
    final String SPACE = " ";
    public PromptCharTextField() {

        addTextLimiter();
        updatePromptCharListener();


    }

    private void addTextLimiter() {
        this.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (PromptCharTextField.this.getText().length() > 1) {
                    String s = PromptCharTextField.this.getText().substring(0, 1);
                    PromptCharTextField.this.setText(s);
                }
            }
        });
    }

    private void updatePromptCharListener() {
        this.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

                String contents = PromptCharTextField.this.getText();
                PromptCharTextField.this.setPromptChar(contents);
            }
        });
    }


    private void setPromptChar(String promptChar) {
        this.promptChar = promptChar;
    }

    public String getPromptChar() {
        return promptChar;
    }
}
