/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 2/11/12
 * Time: 6:39 PM
 */
class NumberToWordTranslator {

    public String GetWord(int number) {
        if (number < 20)
            return GetWordOneThroughTwenty(number);
        return GetWordsTwentyAndAbove(number);

    }

    private String GetWordsTwentyAndAbove(int number) {
        if (number % 10 == 0 && number < 100)
            return GetDoubleDigitWord(number);
        if (number < 100)
            return GetDoubleDigitWord(number - (number % 10)) + GetWordOneThroughTwenty(number % 10);
        if (number < 1000) {
            String currentNumber = GetTripleDigitWord(number - (number % 100));
            if (number % 100 != 0)
                currentNumber = currentNumber + "and";
            if ((number % 100) < 20)
                currentNumber = currentNumber + GetWordOneThroughTwenty(number % 100);
            else
                currentNumber = currentNumber + GetDoubleDigitWord((number % 100) - (number % 10)) + GetWordOneThroughTwenty(number % 10);
            return currentNumber;
        }
        if (number == 1000) {
            return "onethousand";
        }
        return "";
    }

    private String GetTripleDigitWord(int number) {
        return GetWordOneThroughTwenty(number / 100) + "hundred";
    }

    private String GetDoubleDigitWord(int number) {
        switch (number) {
            case 20:
                return "twenty";
            case 30:
                return "thirty";
            case 40:
                return "forty";
            case 50:
                return "fifty";
            case 60:
                return "sixty";
            case 70:
                return "seventy";
            case 80:
                return "eighty";
            case 90:
                return "ninety";
        }
        return "";
    }

    private String GetWordOneThroughTwenty(int number) {
        switch (number) {
            case 1:
                return "one";
            case 2:
                return "two";
            case 3:
                return "three";
            case 4:
                return "four";
            case 5:
                return "five";
            case 6:
                return "six";
            case 7:
                return "seven";
            case 8:
                return "eight";
            case 9:
                return "nine";
            case 10:
                return "ten";
            case 11:
                return "eleven";
            case 12:
                return "twelve";
            case 13:
                return "thirteen";
            case 14:
                return "fourteen";
            case 15:
                return "fifteen";
            case 16:
                return "sixteen";
            case 17:
                return "seventeen";
            case 18:
                return "eighteen";
            case 19:
                return "nineteen";
        }
        return "";
    }
}
