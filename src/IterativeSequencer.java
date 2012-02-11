/**
 * Created by IntelliJ IDEA.
 * User: Austin
 * Date: 2/10/12
 * Time: 8:45 PM
 * To change this template use File | Settings | File Templates.
 */
class IterativeSequencer {
    public int GetNumberTermsInChain(int number) {
        long i = number;
        int chainLength = 1;
        while(i > 1)
        {
            chainLength ++;
            if(i % 2 == 0) i = i / 2;
            else i = (3 * i) + 1;
            //System.out.println("Testing " + i + " ChainLength: " + chainLength);
        }
        return chainLength;
    }

    public int GetLongestNumberTermsInChainForStartersUnder(int largestStarter) {
        int longestChainLength = 0;
        int startingNumberWithLongestChain = 0;
        for(int i = 1; i <= largestStarter; i++)
        {
            int candidate = GetNumberTermsInChain(i);
            if(candidate > longestChainLength)
            {
                longestChainLength = candidate;
                startingNumberWithLongestChain = i;
            }

            //System.out.println("Testing: " + i + " LongestChain: " + longestChainLength);
        }
        return startingNumberWithLongestChain;
    }
}
