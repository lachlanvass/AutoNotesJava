package sample;

import javafx.scene.control.TextArea;

public class ConsoleTextWriter extends TextArea {

    private int caretPosition;
    private int lineStartCaretPosition = 0;
    private String prompt = "- ";


    public String readLine() {
        this.updateCaretPosition();
        return this.getText(lineStartCaretPosition, caretPosition);
    }

    public void updateCaretPosition() {

        caretPosition = this.getCaretPosition();
    }

    public void setLineStartCaretPosition() {
        lineStartCaretPosition = this.getCaretPosition();
    }
    public String readText() {
        return this.getText();
    }

    private void selectCurrentLine() {
        this.selectRange(lineStartCaretPosition, caretPosition);
    }

    private void resetPrompt(){
        this.appendText(prompt);
    }

    public void onNewLine(){

        if (this.readLine().contains("copy")) {
            this.copyLine();
            this.scrollDown();
        }
        this.setLineStartCaretPosition();
        this.resetPrompt();
    }

    public void copyLine() {
        this.selectCurrentLine();
        this.copy();
        this.deselect();
    }

    public void copyAll() {
        this.selectAll();
        this.copy();
        this.deselect();
    }

    private void scrollDown() {

        for (byte i = 0; i < 5; i++) {
            this.appendText("\n");
        }
    }

    public void clearScreen() {
        this.clear();
        this.positionCaret(0);
    }
}
