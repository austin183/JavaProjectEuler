import java.io.*;
import java.math.BigInteger;

/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 2/10/12
 * Time: 8:34 PM
 */
class BigIntegerMath {
    public BigInteger GetSumOfNumbersInFile(String filePath) {
        BigInteger sum = BigInteger.ZERO;
        FileHelper fileHelper = new FileHelper();
        BufferedReader reader = fileHelper.GetReader(filePath);
        String line;
        try {
            while ((line = reader.readLine()) != null) {
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

        for (int i = 0; i < numberLine.length(); i++) {
            sum += Integer.parseInt(numberLine.substring(i, i + 1));
        }
        return sum;
    }

    public BigInteger GetNthValueInFibonacciSequence(int n, BigInteger primary, BigInteger next) {
        if (n == 1) return primary;
        if (n == 2) return next;

        for (int i = 3; i < n; i++) {
            BigInteger temp = next;
            next = primary.add(next);
            primary = temp;
        }
        return primary.add(next);
    }

    public int GetFirstFibonacciTermWithNumberOfDigits(int number, BigInteger primary, BigInteger next) {
        BigInteger toReturn = primary;
        int i = 3;
        while (toReturn.toString().length() < number) {
            BigInteger temp = next;
            next = primary.add(next);
            primary = temp;
            toReturn = primary.add(next);
            i++;
        }
        return i;
    }
}
