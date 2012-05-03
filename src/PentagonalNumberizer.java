/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 5/2/12
 * Time: 10:35 PM
 */
class PentagonalNumberizer {
    public int GetPentagonalNumberAt(int i) {
        return (i * ((3 * i) -1))/2;
    }

    public boolean IsPentagonalNumber(int i) {
        int index = 1;
        int currentPent;
        do{
            currentPent = GetPentagonalNumberAt(index);
            if(currentPent == i) return true;
            index++;
        }while (currentPent < i);

        return false;
    }
}
