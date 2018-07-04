package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.Console;
import java.security.Key;

public class Controller {


    @FXML
    ConsoleTextWriter ctx_main;

    @FXML
    Button btn_main;

    int lineStartCaretPosition = 0;


    @FXML private void onEnter(KeyEvent event) {
        ctx_main.updateCaretPosition();
        if (event.getCode().equals(KeyCode.ENTER)) {
            ctx_main.onNewLine();
        }
    }

    @FXML private void clearScreen(ActionEvent event) {
        ctx_main.clearScreen();


    }




//    @FXML private void onEnter(KeyEvent event) {
//
//        int caretPosition = ta_main.getCaretPosition();
//        if (event.getCode().equals(KeyCode.ENTER)) {
//
//            // Prints contents of line until the enter button is pressed
//            System.out.println(ta_main.getText(lineStartCaretPosition, caretPosition));
//            lineStartCaretPosition = caretPosition;
//            if (readText().contains("h")) {
//                // int start, int end
//                //ta_main.getText()
//
//                System.out.println("h pressed");
//
//
//            }
//            if (readText().contains("copy")) {
//
//                // selects and copies all text Copies selected tax.
//                ta_main.selectAll();
//                ta_main.copy();
//                ta_main.deselect();
//            }
//
//            //resetPrompt();
//        }


    }

    // TODO capture enter command and respond to it when change text is selected

    // TODO use hotkey to copy text to clipboard

    // TODO allow switching to dark theme with button. (Just CSS file and reload application)

//    @FXML private void enterPressed(KeyEvent event) {
//
//
//
//    }

