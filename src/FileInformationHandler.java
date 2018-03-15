import java.io.*;

/**
 * Created by jonss on 2018-03-13.
 */
public class FileInformationHandler {

    private final String CHARSETNAME = "utf-8";

    private Writer writer = null;

    public FileInformationHandler(String filename) throws FileNotFoundException,
                                                    UnsupportedEncodingException {

        writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(filename), CHARSETNAME));

    }

    public void writeToFile(String info) throws IOException {
        writer.write(info);
    }

    public void closeWriter() throws IOException {
        writer.close();
    }


}
