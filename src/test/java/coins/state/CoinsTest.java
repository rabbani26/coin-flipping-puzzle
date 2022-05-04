package coins.state;

import org.junit.jupiter.api.Test;
import java.util.BitSet;
import static org.junit.jupiter.api.Assertions.*;

class CoinsTest {

    private Coins state1 = new Coins(7, 3); // the original initial state

    private Coins state2; // the goal state
    {
        BitSet bs = new BitSet(7);
        bs.set(0, 7);
        state2 = new Coins(7, 3, bs);
    }

    @Test
    void isGoalTest() {
        assertFalse(state1.isGoal());
        assertTrue(state2.isGoal());
    }

    @Test
    void cloneTest() {
        assertEquals(state1, state1.clone());
        assertEquals(state2, state2.clone());
        assertFalse(state1.equals(state2.clone()));
        assertFalse(state2.equals(state1.clone()));
    }
    @Test
    void toStringTest() {
        assertEquals("O|O|O|O|O|O|O", state1.toString());
        assertEquals("1|1|1|1|1|1|1", state2.toString());
    }

    @Test
    void hashCodeTest() {
        assertTrue(state1.hashCode() == state1.hashCode());
        assertTrue(state1.hashCode() == state1.clone().hashCode());
        assertTrue(state2.hashCode() == state2.hashCode());
        assertTrue(state2.hashCode() == state2.clone().hashCode());
    }

    @Test
    void equalsTest() {
        assertTrue(state1.equals(state1));
        assertTrue(state1.equals(state1.clone()));
        assertFalse(state1.equals(null));
        assertFalse(state1.equals(state2));
        assertTrue(state2.equals(state2));
        assertTrue(state2.equals(state2.clone()));
        assertFalse(state2.equals(null));
        assertFalse(state2.equals(state1));
    }

    @Test
    void canFlipTest() {
        BitSet bs = new BitSet();
        bs.flip(4);
        assertTrue(state1.canFlip(bs));
        assertTrue(state1.canFlip(BitSet.valueOf(new long[7].clone())));
    }


}
