import java.util.Collections;
import java.util.List;

/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 3/18/12
 * Time: 10:53 PM
 */
class CoinPermutizer {
    private int Permutations;

    private final int Target;

    private final List<Integer> Denoms;

    public CoinPermutizer(int target, List<Integer> denoms) {
        Target = target;
        Denoms = denoms;
        Permutations = 0;
        Collections.sort(Denoms);
    }

    private int findAllCombinationsRecursive(int startIndex,
                                             int remainingTarget) {
        for (int i = startIndex; i < Denoms.size(); i++) {
            int differenceCoinAndTarget = remainingTarget - Denoms.get(i);
            if (differenceCoinAndTarget == 0) {
                Permutations++;
            } else if (differenceCoinAndTarget > 0) {
                findAllCombinationsRecursive(i, differenceCoinAndTarget);
            }
        }
        return Permutations;
    }

    public int GetNumberPermutations() {
        return findAllCombinationsRecursive(0, Target);
    }
}
