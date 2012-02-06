import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Austin
 * Date: 2/5/12
 * Time: 11:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class PrimeFactorizer {
    private final List<Integer> knownPrimes;
    
    public PrimeFactorizer()
    {
        knownPrimes = new ArrayList<Integer>();
    }

    public PrimeFactorizer(String PrimeRecord)
    {
        knownPrimes = new ArrayList<Integer>();
        //System.out.println("Adding Prime Records (This can take time...)");
        AddPrimesFromRecord(PrimeRecord);
    }

    private void AddPrimesFromRecord(String primeRecord) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(primeRecord);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        DataInputStream in = new DataInputStream(fileInputStream);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line;
        try {
            while((line = reader.readLine()) != null)
            {
                if(!knownPrimes.contains(Integer.parseInt(line)))
                    knownPrimes.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    boolean IsKnownPrime(int candidate) {
        return knownPrimes.contains(candidate);
    }

    boolean IsPrime(int candidate) {
        boolean toReturn = true;

        //System.out.printf("Testing prime candidate %d to known primes%n", candidate);
        if (IsKnownPrime(candidate)) return true;
        for(int i = 0; i < knownPrimes.size() -1; i++)
        {
            //System.out.printf("Testing prime candidate %d to %s%n", candidate, knownPrimes.get(i).toString());
            if(candidate % knownPrimes.get(i) == 0)
                return false;
        }
        if(toReturn)
        {
            int index = 2;
            if(knownPrimes.size() > 0) index = knownPrimes.get(knownPrimes.size() -1);
            for(int i= index; i < candidate; i++)
            {
                //System.out.printf("Testing prime candidate %s to %s%n", Integer.toString(candidate), Integer.toString(i));
                if(candidate % i == 0)
                    return false;
            }
        }

        if(toReturn)
        {
            //System.out.printf("%s is Prime%n", Integer.toString(candidate));
            knownPrimes.add(candidate);
        }
        return toReturn;
    }

    public int GetLargestKnownPrimeFactorForValuesUnderMaxKnownPrime(int maxValue) {
        if(maxValue < (knownPrimes.get(knownPrimes.size() -1)))
        {
            for(int knowPrimeIndex = knownPrimes.size() - 1; knowPrimeIndex > 0; knowPrimeIndex--)
            {
                if((knownPrimes.get(knowPrimeIndex).compareTo(maxValue) <= 0) &&
                        ((maxValue % (knownPrimes.get(knowPrimeIndex))) == 0))
                    return knownPrimes.get(knowPrimeIndex);
            }
        }
        return -1;
    }

    public void MakePrimesList(int upTo, String primeRecord)
    {
        for(int i = 2;i < upTo; i++)
        {
            if(IsPrime(i))
            {
                try {
                    FileWriter write = new FileWriter(primeRecord, true);
                    BufferedWriter out = new BufferedWriter(write);
                    out.write(Integer.toString(i) + "\n");
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public long GetSumPrimesUnderMaxValue(int maxValue) {
        long toReturn = 0;

        for(int i = 2;i < maxValue; i++)
        {
            if(IsPrime(i))
            {
                toReturn += i;
            }
            if(i % 10000 == 0)
            {
                System.out.printf("Sum of Primes:%s\nTesting: %d%n", Long.toString(toReturn), i);
            }
        }
        return toReturn;
    }
}

