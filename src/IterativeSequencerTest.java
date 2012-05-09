import junit.framework.Assert;
import org.junit.Test;

/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 2/10/12
 * Time: 8:46 PM
 */
public class IterativeSequencerTest {
    @Test
    public void ShouldGetNumberTermsInChainFor13() {
        IterativeSequencer sequencer = new IterativeSequencer();
        int chainLength = sequencer.GetNumberTermsInChain(13);

        Assert.assertEquals(10, chainLength);
    }

    @Test
    public void ShouldGetNumberTermsInChainFor113383() {
        IterativeSequencer sequencer = new IterativeSequencer();
        int chainLength = sequencer.GetNumberTermsInChain(113383);

        Assert.assertEquals(248, chainLength);
    }

    @Test
    public void ShouldGetLongestChainForNumberUnder113383() {
        IterativeSequencer sequencer = new IterativeSequencer();
        int chainLength = sequencer.GetLongestNumberTermsInChainForStartersUnder(113383);

        Assert.assertEquals(106239, chainLength);
    }

    @Test
    public void ShouldGetLongestChainForNumberUnder20() {
        IterativeSequencer sequencer = new IterativeSequencer();
        int chainLength = sequencer.GetLongestNumberTermsInChainForStartersUnder(20);

        Assert.assertEquals(18, chainLength);
    }

    //Problem 14
    @Test
    public void ShouldGetLongestChainForNumberUnder1000000() {
        IterativeSequencer sequencer = new IterativeSequencer();
        int chainLength = sequencer.GetLongestNumberTermsInChainForStartersUnder(1000000);

        Assert.assertEquals(837799, chainLength);
    }
}
