package blackjack.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CardTest {

    @Test
    public void testCardValue() {
        Card card = new Card(Card.Suit.HEARTS, Card.Rank.KING);
        assertEquals(10, card.getValue());
    }


}
