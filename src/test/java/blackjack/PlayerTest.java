package blackjack;

import blackjack.model.Card;
import blackjack.model.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    @Test
    public void testInitialWantsToHitTrue() {
        Player player = new Player();
        assertTrue(player.wantsToHit());
    }

    @Test
    public void testSetWantsToHitFalse() {
        Player player = new Player();
        player.setWantsToHit(false);
        assertFalse(player.wantsToHit());
    }

    @Test
    public void testReceiveCardAddsToHand() {
        Player player = new Player();
        player.receiveCard(new Card(Card.Suit.SPADES, Card.Rank.EIGHT));
        assertEquals(1, player.getHand().getCards().size());
    }
}

