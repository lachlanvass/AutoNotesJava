package sample;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

public class RulesCSVReader extends CSVReader {

    private BufferedReader br;

    private ArrayList<String> inputList = new ArrayList<>();
    private ArrayList<String> outputList = new ArrayList<>();
    private ArrayList<Boolean> toCopyList = new ArrayList<>();
    public RulesCSVReader(String filePath, String separator) throws IOException {

        FilePath = filePath;
        Separator = separator;
        br = getBufferedReader(this.FilePath);
        this.loadData();
    }

    private Boolean parseBoolean(String input) {
        Boolean result;

        if (input.equals("true") || input.equals("True")){
            result = true;
            return result;
        }
        else if (input.equals("false") || input.equals("False")) {
            result = false;
            return result;
        }

        return null;
    }
    private void loadData() throws IOException {
        String line = "";

        while ((line = this.br.readLine()) != null) {
            String[] data = line.split(this.Separator);
            this.inputList.add(data[0]);
            this.outputList.add(data[1]);

            try {
                // If missing data, set to false.
                this.toCopyList.add(this.parseBoolean(data[2]));
            }
            catch (IndexOutOfBoundsException e){
                this.toCopyList.add(false);
            }
        }

            br.close();
    }

    public static void deleteRule(String filePath, String input) throws IOException {
        File inputFile = new File(filePath);
        File tempFile = new File("tmp.csv");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String currentLine;

        while ((currentLine = reader.readLine()) != null) {
            String[] data = currentLine.split(",");
            if (data[0].equals(input)) continue;
            writer.write(currentLine + System.getProperty("line.separator"));
        }

        writer.close();
        reader.close();

        // Replace tempFile contents to inputFile contents to update rules.csv
        Files.move(tempFile.toPath(), inputFile.toPath(), StandardCopyOption.REPLACE_EXISTING);


    }

    public static void addRule(String shortCut, String output, boolean toCopy) throws IOException {
        File rulesFile = new File("rules.csv");
        BufferedWriter bw = new BufferedWriter(new FileWriter(rulesFile, true));
        String toCopyString;

        if (toCopy){
            toCopyString = "true";
        }
        else {
            toCopyString = "false";
        }
        bw.write(shortCut + "," + output + "," + toCopyString + System.lineSeparator());

        bw.close();
    }

    public ArrayList<String> getInputList() {
        return inputList;
    }

    public ArrayList<String> getOutputList() {
        return outputList;
    }

    public ArrayList<Boolean> getToCopyList() {
        return toCopyList;
    }
}

/*
* pp, bookedPassport,true
someTHing, HEllo there,true
*
* */