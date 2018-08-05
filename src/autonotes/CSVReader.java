package autonotes;

import java.io.*;

public class CSVReader {

    protected String FilePath;
    protected String Separator;
    public CSVReader() {
        // Default constructor for inheritance
    }
    public CSVReader(String filePath, String separator) throws IOException {
        FilePath = filePath;
        Separator = separator;

    }

    public String getFilePath() {
        return this.FilePath;
    }

    protected BufferedReader getBufferedReader(String fileReaderFilePath) throws IOException {
        File file = new File(fileReaderFilePath);
        file.createNewFile();
        BufferedReader br;
        FileReader csvFileReader = new FileReader(fileReaderFilePath);
        br = new BufferedReader(csvFileReader);

        return br;
    }
}
