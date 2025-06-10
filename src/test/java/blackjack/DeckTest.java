package blackjack;

import blackjack.model.Card;
import blackjack.model.Deck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DeckTest {

    private Deck deck;

    @BeforeEach
    public void setUp() {
        deck = new Deck();
    }

    @Test
    public void testDeckHas52CardsInitially() {
        assertEquals(52, deck.remainingCards());
    }
    @Test
    public void testDrawCardReducesDeckSize() {
        Card drawn = deck.drawCard();
        assertNotNull(drawn);
        assertEquals(51, deck.remainingCards());
    }

    @Test
    public void testDrawAllCardsAndThenFail() {
        for (int i = 0; i < 52; i++) {
            deck.drawCard();
        }
        assertEquals(0, deck.remainingCards());
        assertThrows(IllegalStateException.class, deck::drawCard);
    }
}
