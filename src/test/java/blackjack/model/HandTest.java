package blackjack.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HandTest {

    private Hand hand;

    @BeforeEach
    public void setUp() {
        hand = new Hand();
    }

    @Test
    public void testAddCardIncreasesSize() {
        hand.addCard(new Card(Card.Suit.HEARTS, Card.Rank.TEN));
        assertEquals(1, hand.getCards().size());
    }

    @Test
    public void testCalculateScoreWithoutAce() {
        hand.addCard(new Card(Card.Suit.SPADES, Card.Rank.KING));
        hand.addCard(new Card(Card.Suit.CLUBS, Card.Rank.SEVEN));
        assertEquals(17, hand.getScore());
    }

    @Test
    public void testCalculateScoreWithAceAsEleven() {
        hand.addCard(new Card(Card.Suit.HEARTS, Card.Rank.ACE));
        hand.addCard(new Card(Card.Suit.DIAMONDS, Card.Rank.SIX));
        assertEquals(17, hand.getScore());
    }

    @Test
    public void testCalculateScoreWithAceAsOne() {
        hand.addCard(new Card(Card.Suit.HEARTS, Card.Rank.ACE));
        hand.addCard(new Card(Card.Suit.DIAMONDS, Card.Rank.KING));
        hand.addCard(new Card(Card.Suit.SPADES, Card.Rank.QUEEN));
        assertEquals(21, hand.getScore()); // A = 1 här
    }
}
