import java.io.*;

/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 5/2/12
 * Time: 9:20 PM
 */
class FileHelper {

    public BufferedReader GetReader(String knownPrimeFile) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(knownPrimeFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        DataInputStream in = new DataInputStream(fileInputStream);
        return new BufferedReader(new InputStreamReader(in));
    }
}
