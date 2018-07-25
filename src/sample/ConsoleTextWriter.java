package sample;

import javafx.event.EventHandler;
import javafx.scene.control.TextArea;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.MouseEvent;

import java.util.HashMap;

public class ConsoleTextWriter extends TextArea {

    private int caretPosition;
    private int lineStartCaretPosition = 0;
    String prompt = "> ";
    HashMap<String, Runnable> commandHashMap;
    String outputText;
    boolean hasBeenClicked = false;

    public ConsoleTextWriter() {

    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public void setCommands(HashMap commands) {
        commandHashMap = commands;
    }
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

    private void replaceLineText(String replacement) {
        // Delete current line
        this.deleteText(lineStartCaretPosition, caretPosition);
        this.appendText(prompt);

        //
        StringBuilder output = new StringBuilder();
        output.append(prompt);

        // Use ^ to represent newline chars Loop through replacment text and identify new line characters
        // If one exists,


        for (short i = 0; i < replacement.length(); i++) {
            if (replacement.charAt(i) == '^') {
                this.appendText("\n");
            }
            else {
                this.appendText(Character.toString(replacement.charAt(i)));
            }
        }

        // Reached end of string. Go to new line.
        this.appendText("\n");

        // Alter state of output
        setOutputText(replacement);
    }

    private void setOutputText(String input) {
        outputText = input;
    }

    private void copyToClipboard(String input) {
        final ClipboardContent content = new ClipboardContent();
        content.putString(input);
        Clipboard.getSystemClipboard().setContent(content);
    }

    public void replaceText(String input, boolean toCopy) {

        this.replaceLineText(input);
        if (toCopy) {
            this.copyToClipboard(input);
        }
    }

    private boolean lineContains(String input) {
        return this.readLine().contains(input);
    }

    private boolean lineEndsWith(String input) {

        /* Must include new line for it to work with return key press */
        return this.readLine().endsWith(input + "\n");

    }

    private void runCommand(String command) {
        try {
            commandHashMap.get(command).run();
        }
        catch (NullPointerException io) {
            System.out.println("Attempted command. Failed. Command: " + command);
        }
    }

    private boolean commandRecognized(String command) {
        return commandHashMap.containsKey(command);
    }

    public String parseCommand() {
        String command = this.readLine().replace(prompt, ""); // strip prompt string
        command = command.replace("\n", "");

        return command;
    }

    public void onNewLine(){
        String command = parseCommand();
        if (this.commandHashMap.containsKey(command)) {

            runCommand(command);
        }

        this.setLineStartCaretPosition();
        this.resetPrompt();
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
        this.requestFocus();
        this.setLineStartCaretPosition();
    }

    protected void newNote() {
        this.copyAll();
        this.clearScreen();
    }

    public void checkPromptCharTextField(PromptCharTextField tf) {

        String tf_promptChar = tf.getPromptChar();
        tf_promptChar += " ";
        this.prompt = tf_promptChar;

    }

    public String getOutputText() {
        return outputText;
    }
}

// TODO although screen is cleared, populte seperate section of app which contains the previous note in condensed form.
