package blackjack.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DealerTest {

    @Test
    public void testDealerHitsUnder17() {
        Dealer dealer = new Dealer();
        dealer.receiveCard(new Card(Card.Suit.CLUBS, Card.Rank.SIX));
        assertTrue(dealer.wantsToHit());
    }

    @Test
    public void testDealerStandsAt17() {
        Dealer dealer = new Dealer();
        dealer.receiveCard(new Card(Card.Suit.CLUBS, Card.Rank.TEN));
        dealer.receiveCard(new Card(Card.Suit.HEARTS, Card.Rank.SEVEN));
        assertFalse(dealer.wantsToHit());
    }
}

