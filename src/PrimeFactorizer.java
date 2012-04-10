import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 2/5/12
 * Time: 11:05 PM
 */
class PrimeFactorizer {
    private final List<Integer> knownPrimes;

    public PrimeFactorizer() {
        knownPrimes = new ArrayList<Integer>();
    }

    public PrimeFactorizer(String knownPrimeFile) {
        knownPrimes = new ArrayList<Integer>();
        LoadKnownPrimes(knownPrimeFile);
    }

    public List<Integer> GetKnownPrimes() {
        return knownPrimes;
    }

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    public boolean HasNoCache() {
        return knownPrimes.size() == 0;
    }

    private void LoadKnownPrimes(String knownPrimeFile) {
        System.out.println("Loading Primes from " + knownPrimeFile);
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(knownPrimeFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        DataInputStream in = new DataInputStream(fileInputStream);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                if (!line.trim().equals(""))
                    knownPrimes.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Primes Loaded");
    }

    boolean IsKnownPrime(int candidate) {
        return knownPrimes.contains(candidate);
    }

    boolean IsPrime(int candidate) {
        //System.out.printf("Testing prime candidate %d to known primes%n", candidate);
        if (IsKnownPrime(candidate)) return true;

        for (int i = 0; i < knownPrimes.size() - 1; i++) {
            //System.out.printf("Testing prime candidate %d to %s%n", candidate, knownPrimes.get(i).toString());
            if (candidate % knownPrimes.get(i) == 0)
                return false;
        }

        int index = knownPrimes.size() > 0 ? knownPrimes.get(knownPrimes.size() - 1) : 2;
        for (int i = index; i < candidate; i++) {
            //System.out.printf("Testing prime candidate %s to %s%n", Integer.toString(candidate), Integer.toString(i));
            if (candidate % i == 0)
                return false;
        }

        //System.out.printf("%s is Prime%n", Integer.toString(candidate));
        knownPrimes.add(candidate);

        return true;
    }

    boolean IsPrime(int candidate, boolean noCache) {
        if (!noCache)
            return IsPrime(candidate);

        return IsPrimeNoCache(candidate);
    }

    private boolean IsPrimeNoCache(int candidate) {
        for (int i = 2; i < (candidate / 2) + 1; i++) {
            //System.out.printf("Testing prime candidate %s to %s%n", Integer.toString(candidate), Integer.toString(i));
            if (candidate % i == 0)
                return false;
        }
        return true;
    }

    public long GetLargestPrimeFactor(long maxValue) {
        if (knownPrimes.size() > 0) {
            if (maxValue < (knownPrimes.get(knownPrimes.size() - 1))) {
                for (int knowPrimeIndex = knownPrimes.size() - 1; knowPrimeIndex > 0; knowPrimeIndex--) {
                    if ((knownPrimes.get(knowPrimeIndex) <= maxValue) &&
                            ((maxValue % (knownPrimes.get(knowPrimeIndex))) == 0))
                        return knownPrimes.get(knowPrimeIndex);
                }
            }
        }
        for (int i = 2; i < maxValue; i++) {
            if (IsPrime(i)) {
                if (maxValue % i == 0) {
                    return GetLargestPrimeFactor(maxValue / i);
                }
            }
        }
        return maxValue;
    }

    public void MakePrimesList(int upTo, String primeRecord) {
        for (int i = 2; i < upTo; i++) {
            if (IsPrime(i)) {
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

        for (int i = 2; i < maxValue; i++) {
            if (IsPrime(i)) {
                toReturn += i;
            }
            if (i % 10000 == 0) {
                System.out.printf("Sum of Primes:%s\nTesting: %d%n", Long.toString(toReturn), i);
            }
        }
        return toReturn;
    }


}

