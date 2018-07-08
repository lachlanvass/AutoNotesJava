package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.Console;
import java.security.Key;
import java.text.SimpleDateFormat;
import java.util.*;

public class Controller {

    /* FXML COMPONENTS */
    @FXML
    AutoNotesTextWriter ctx_main;
    @FXML
    Button btn_main;

    /* GLOBAL DATA */

    HashMap<String, Runnable> commands = new HashMap<>();
    ArrayList<String> notesHistory = new ArrayList<>();

    /* METHODS */

    @FXML private void showPreviousNotes(ActionEvent event){

        PreviousNotesScreen previousNotesScreen = new PreviousNotesScreen(notesHistory);
        previousNotesScreen.show();
    }
    @FXML private void onEnter(KeyEvent event) {

        ctx_main.updateCaretPosition();
        if (event.getCode().equals(KeyCode.ENTER)) {

            boolean endOfLine = false;
            if (ctx_main.parseCommand().equals(ctx_main.finishingChar)) {
                endOfLine = true;
            }

            appendNotesHistoryList(ctx_main.readLine(), endOfLine);
            ctx_main.onNewLine();
        }
    }

    @FXML private void clearScreen(ActionEvent event) {
        ctx_main.clearScreen();
    }

    @FXML private void consoleClicked(MouseEvent event) {

        if (!ctx_main.isFocused()) {
            ctx_main.setText("- ");
        }
    }

    private void appendNotesHistoryList(String input, boolean endOfNote) {
        // TODO Print list backwards - most recent first
        // TODO add output of commands

        notesHistory.add(input);

        if (endOfNote) {
            notesHistory.add("\n");
            Date date = new Date();
            SimpleDateFormat dateFormatted =
                    new SimpleDateFormat("yyyy.MM.dd 'at' hh:mm a");

            notesHistory.add(dateFormatted.format(date));
            notesHistory.add("\n");
        }
    }
}

    // TODO use hotkey to copy text to clipboard

    // TODO allow switching to dark theme with button. (Just CSS file and reload application)

//    @FXML private void enterPressed(KeyEvent event) {
//
//
//
//    }

