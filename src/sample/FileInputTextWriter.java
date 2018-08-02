package sample;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class FileInputTextWriter extends ConsoleTextWriter {

    private ArrayList<String> inputsList = new ArrayList<>();
    private ArrayList<String> outputsList = new ArrayList<>();
    private ArrayList<Boolean> toCopyList = new ArrayList<>();
    String fileSource = "D:\\Lachlan\\IdeaProjects\\TextHelper\\rules.csv";

    public String finishingChar = "--";
    public FileInputTextWriter() throws IOException {
        populateLists();
        loadCommands();

    }


    private Runnable generateReplaceTextRunnable(String input, boolean toCopy) {
        return () -> this.replaceText(input, toCopy);
    }

    private void populateLists() throws IOException{
        RulesCSVReader csvReader = new RulesCSVReader(fileSource, ",");
        this.inputsList = csvReader.getInputList();
        this.outputsList = csvReader.getOutputList();
        this.toCopyList = csvReader.getToCopyList();

    }

    private void loadCommands() {

        commandHashMap = new HashMap<>();

        // End note

        commandHashMap.put(finishingChar, () -> this.newNote());

        // Load commands from file

        short counter = 0;
        for (String input : inputsList) {

            // TODO change to add toCopy to .csv file
            this.commandHashMap.put(input, generateReplaceTextRunnable(outputsList.get(counter), toCopyList.get(counter)));
            counter++;
        }

    }

    // TODO add reload method so when rules manager screen closes this updates its files

    public void reload() throws IOException {

        // Empty lists and repopulate with new data from file
        this.inputsList.clear();
        this.outputsList.clear();
        this.toCopyList.clear();

        this.populateLists();
        loadCommands();


    }
}
