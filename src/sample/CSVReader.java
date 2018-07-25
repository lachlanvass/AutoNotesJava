package sample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class CSVReader {

    protected String FilePath;
    protected String Separator;
    public CSVReader() {
        // Default constructor for inheritance
    }
    public CSVReader(String filePath, String separator) {
        FilePath = filePath;
        Separator = separator;
    }

    public String getFilePath() {
        return this.FilePath;
    }

    protected BufferedReader getBufferedReader(String fileReaderFilePath) throws FileNotFoundException {
        BufferedReader br;
        FileReader csvFileReader = new FileReader(fileReaderFilePath);
        br = new BufferedReader(csvFileReader);

        return br;
    }
}
