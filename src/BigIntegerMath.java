import java.io.*;
import java.math.BigInteger;

/**
 * Created by IntelliJ IDEA.
 * User: Austin
 * Date: 2/10/12
 * Time: 8:34 PM
 * To change this template use File | Settings | File Templates.
 */
class BigIntegerMath {
    public BigInteger GetSumOfNumbersInFile(String filePath) {
        BigInteger sum = BigInteger.ZERO;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        DataInputStream in = new DataInputStream(fileInputStream);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line;
        try {
            while((line = reader.readLine()) != null)
            {
                sum = sum.add(new BigInteger(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sum;
    }

    public int GetSumOfDigitsInNumber(BigInteger number) {
        int sum = 0;
        String numberLine = number.toString();
        
        for(int i = 0; i< numberLine.length(); i++)
        {
            sum += Integer.parseInt(numberLine.substring(i, i + 1));
        }
        return sum;
    }
}
