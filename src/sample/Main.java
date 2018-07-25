package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Main extends Application {

    public Stage primaryStge;

    @Override
    public void start(Stage primaryStage) throws Exception{

        // TODO update file path to a more generic version for production version
        RulesCSVReader rules = new RulesCSVReader("D:\\Lachlan\\IdeaProjects\\TextHelper\\src\\rules.csv", ",");

        //TODO Add font size controller

        // TODO add interface for adding and removing shortcuts


        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        primaryStage.setTitle("AutoNotes");
        primaryStage.setScene(new Scene(root, 300, 400));
        primaryStage.setMaxHeight(500);
        primaryStage.setMaxWidth(500);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
