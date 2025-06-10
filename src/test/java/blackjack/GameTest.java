package blackjack;

import blackjack.game.Game;
import blackjack.model.Card;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    @Test
    public void testGameInitializesWithTwoCardsEach() {
        Game game = new Game();
        game.start();

        assertEquals(2, game.getPlayer().getHand().getCards().size());
        assertEquals(2, game.getDealer().getHand().getCards().size());
    }

    @Test
    public void testGameDeterminesWinner() {
        Game game = new Game();

        game.getPlayer().receiveCard(new Card(Card.Suit.HEARTS, Card.Rank.TEN));
        game.getPlayer().receiveCard(new Card(Card.Suit.SPADES, Card.Rank.NINE));

        game.getDealer().receiveCard(new Card(Card.Suit.CLUBS, Card.Rank.EIGHT));
        game.getDealer().receiveCard(new Card(Card.Suit.DIAMONDS, Card.Rank.EIGHT));

        assertEquals("Player wins", game.determineWinner());
    }

    @Test
    public void testDrawIsHandled() {
        Game game = new Game();

        game.getPlayer().receiveCard(new Card(Card.Suit.HEARTS, Card.Rank.TEN));
        game.getPlayer().receiveCard(new Card(Card.Suit.SPADES, Card.Rank.SEVEN));

        game.getDealer().receiveCard(new Card(Card.Suit.CLUBS, Card.Rank.NINE));
        game.getDealer().receiveCard(new Card(Card.Suit.DIAMONDS, Card.Rank.EIGHT));

        assertEquals("Draw", game.determineWinner());
    }
    @Test
    public void testPlayerBlackjackWinsImmediately() {
        Game game = new Game();
        game.getPlayer().receiveCard(new Card(Card.Suit.HEARTS, Card.Rank.ACE));
        game.getPlayer().receiveCard(new Card(Card.Suit.SPADES, Card.Rank.JACK));

        game.getDealer().receiveCard(new Card(Card.Suit.CLUBS, Card.Rank.NINE));
        game.getDealer().receiveCard(new Card(Card.Suit.CLUBS, Card.Rank.EIGHT));

        assertEquals("Player wins with Blackjack", game.determineWinner());
    }

    @Test
    public void testPlayerBustsAndLoses() {
        Game game = new Game();
        game.getPlayer().receiveCard(new Card(Card.Suit.HEARTS, Card.Rank.KING));
        game.getPlayer().receiveCard(new Card(Card.Suit.DIAMONDS, Card.Rank.QUEEN));
        game.getPlayer().receiveCard(new Card(Card.Suit.SPADES, Card.Rank.THREE)); // 10+10+3 = 23

        assertEquals("Dealer wins", game.determineWinner());
    }

}
