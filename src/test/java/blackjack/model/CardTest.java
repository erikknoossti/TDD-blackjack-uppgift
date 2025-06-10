package blackjack.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CardTest {

    @Test
    public void testCardValue() {
        Card card = new Card(Card.Suit.HEARTS, Card.Rank.KING);
        assertEquals(10, card.getValue());
    }

    @Test
    public void testAceValue() {
        Card card = new Card(Card.Suit.SPADES, Card.Rank.ACE);
        assertEquals(11, card.getValue());
    }


}
