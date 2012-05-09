/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 5/8/12
 * Time: 8:02 PM
 */
class ChristianGoldbachDisprover {

    private PrimeFactorizer _factorizer;

    public ChristianGoldbachDisprover()
    {
        _factorizer = new PrimeFactorizer();
    }

    public boolean IsOddComposite(int value) {
        _factorizer = new PrimeFactorizer();
        return !_factorizer.IsPrime(value) && (value % 2 == 1);
    }

    public boolean IsTwiceASquare(int value)
    {
        double candidate = Math.sqrt(8 * value)/4;
        return candidate % 1 == 0;
    }

    public boolean CanBeWrittenAsTheSumOfAPrimeAndTwiceASquare(int value) {
        for(int i = 2; i < value; i++)
        {
            if(_factorizer.IsPrime(i) && IsTwiceASquare(value - i))
            {
                return true;
            }
        }
        return false;
    }

    public long FindSmallestOddCompositeThatCannotBeWrittenAsTheSumOfPrimeAndTwiceASquare() {
        boolean go = true;
        int current = 9;
        while(go)
        {
            current++;
            if (IsOddComposite(current) && !CanBeWrittenAsTheSumOfAPrimeAndTwiceASquare(current))
                go = false;
        }
        return current;
    }
}
