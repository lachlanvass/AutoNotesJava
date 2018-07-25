package sample;

import java.io.BufferedReader;
import java.io.IOException;
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
            this.toCopyList.add(this.parseBoolean(data[2]));
            }
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
