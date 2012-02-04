import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Austin
 * Date: 2/2/12
 * Time: 11:07 PM
 * To change this template use File | Settings | File Templates.
 */
class PrimeFactorizer {

    private static final String PRIME_RECORD = "C:\\Temp\\PrimeWork\\Primes.txt";
    private final List<BigInteger> knownPrimes;
    private final BigInteger BigTwo;

    public PrimeFactorizer()
    {
        BigTwo = new BigInteger("2");
        knownPrimes = new ArrayList<BigInteger>();
        //System.out.println("Adding Prime Records (This can take time...)");
        AddPrimesFromRecord();
    }

    private void AddPrimesFromRecord() {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(PRIME_RECORD);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        DataInputStream in = new DataInputStream(fileInputStream);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line;
        try {
            while((line = reader.readLine()) != null)
            {
                if(!knownPrimes.contains(new BigInteger(line)))
                    knownPrimes.add(new BigInteger(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    boolean IsKnownPrime(BigInteger candidate) {
        return knownPrimes.contains(candidate);
    }

    boolean IsPrime(BigInteger candidate) {
        boolean toReturn = true;

        //System.out.println("Testing prime candidate " + candidate.toString() + " to known primes");
        if (IsKnownPrime(candidate)) return true;
        for(int i = 0; i < knownPrimes.size() -1; i++)
        {
            //System.out.println("Testing prime candidate " + candidate.toString() + " to " + knownPrimes.get(i).toString());
            if(candidate.remainder(knownPrimes.get(i)).compareTo(BigInteger.ZERO) == 0)
                toReturn = false;
        }
        if(toReturn)
        {
            for(BigInteger i = candidate.divide(BigTwo).add(BigInteger.ONE); i.compareTo(knownPrimes.get(knownPrimes.size() - 1)) > 0; i = i.subtract(BigInteger.ONE))
            {
                //System.out.println("Testing prime candidate " + candidate.toString() + " to " + i.toString());
                if(candidate.remainder(i).compareTo(BigInteger.ZERO) == 0)
                    toReturn = false;
            }
        }

        if(toReturn)
        {
            knownPrimes.add(candidate);
        }
        return toReturn;
    }

    public BigInteger GetLargestKnownPrimeFactorForValuesUnderMaxKnownPrime(BigInteger maxValue) {
        if(maxValue.compareTo(knownPrimes.get(knownPrimes.size() -1)) < 0)
        {
            for(int knowPrimeIndex = knownPrimes.size() - 1; knowPrimeIndex > 0; knowPrimeIndex--)
            {
                if(knownPrimes.get(knowPrimeIndex).compareTo(maxValue) <= 0 &&
                        maxValue.remainder(knownPrimes.get(knowPrimeIndex)).compareTo(BigInteger.ZERO) == 0)
                    return knownPrimes.get(knowPrimeIndex);
            }
        }
        return null;
    }
    
    public void MakePrimesList(BigInteger upTo)
    {
        for(BigInteger i = knownPrimes.get(knownPrimes.size() -1).add(BigInteger.ONE);i.compareTo(upTo) < 0; i = i.add(BigInteger.ONE))
        {
            if(IsPrime(i))
            {
                try {
                    FileWriter write = new FileWriter(PRIME_RECORD, true);
                    BufferedWriter out = new BufferedWriter(write);
                    out.write(i.toString() + "\n");
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
        
    }

    public BigInteger GetLargetPrimeFactorOverMaxKnowPrime(BigInteger maxValue) {
        BigInteger toReturn = maxValue;
        
        for(int i = 0; i < knownPrimes.size(); i++)
        {
            if(toReturn.compareTo(knownPrimes.get(knownPrimes.size() - 1)) < 0)
                return GetLargestKnownPrimeFactorForValuesUnderMaxKnownPrime(toReturn);

            //System.out.println("CurrentValue: " + toReturn.toString() + "     PrimeDivisor: " + knownPrimes.get(i).toString());
            if(toReturn.remainder(knownPrimes.get(i)).compareTo(BigInteger.ZERO) == 0)
            {
                toReturn = toReturn.divide(knownPrimes.get(i));
                i = -1; //gets reset to 0 once coming around in the for loop
            }
        }
        if(!IsPrime(toReturn))
        {
            System.out.println("Unable to find the largest Prime Factor.  Got as far as " + toReturn);
            return null;
        }
        return toReturn;
    }
}
