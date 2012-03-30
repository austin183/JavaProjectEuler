/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 3/29/12
 * Time: 7:58 AM
 */
class CircularPrimeFinder {
    private final PrimeFactorizer factorizer;

    public CircularPrimeFinder(PrimeFactorizer factorizer) {
        this.factorizer = factorizer;
    }

    public boolean IsCircularPrime(int candidate) {
        if (!factorizer.IsPrime(candidate, factorizer.HasNoCache()))
            return false;

        String testValue = Integer.toString(candidate);
        for (int i = 0; i < testValue.length(); i++) {
            String rotatedValue = RotateValue(testValue);
            if (!factorizer.IsPrime(Integer.parseInt(rotatedValue), factorizer.HasNoCache())) return false;
            testValue = rotatedValue;
        }

        return true;
    }

    private String RotateValue(String value) {
        return value.substring(1, value.length()) + value.substring(0, 1);
    }

    public int GetCountOfAllCircularPrimesInKnownPrimes() {
        int toReturn = 0;
        for (int i : factorizer.GetKnownPrimes()) {
            if (IsCircularPrime(i)) {
                System.out.println("Circular Prime: " + i);
                toReturn++;
            }

        }
        return toReturn;
    }
}
