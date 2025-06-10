package blackjack.game;

import blackjack.model.Card;
import blackjack.model.Deck;
import blackjack.model.Dealer;
import blackjack.model.Player;

public class Game {
    private final Deck deck;
    private final Player player;
    private final Dealer dealer;

    public Game() {
        this.deck = new Deck();
        this.player = new Player();
        this.dealer = new Dealer();
    }

    public void start() {
        // Två kort var
        player.receiveCard(deck.drawCard());
        dealer.receiveCard(deck.drawCard());
        player.receiveCard(deck.drawCard());
        dealer.receiveCard(deck.drawCard());
    }

    public String determineWinner() {
        int playerScore = player.getScore();
        int dealerScore = dealer.getScore();

        boolean playerBlackjack = player.getHand().getCards().size() == 2 && playerScore == 21;
        boolean dealerBlackjack = dealer.getHand().getCards().size() == 2 && dealerScore == 21;

        if (playerBlackjack && !dealerBlackjack) return "Player wins with Blackjack";
        if (dealerBlackjack && !playerBlackjack) return "Dealer wins with Blackjack";
        if (playerScore > 21) return "Dealer wins";
        if (dealerScore > 21) return "Player wins";
        if (playerScore > dealerScore) return "Player wins";
        if (dealerScore > playerScore) return "Dealer wins";
        return "Draw";
    }


    public Player getPlayer() {
        return player;
    }

    public Dealer getDealer() {
        return dealer;
    }
    public Card drawCardForPlayer() {
        Card card = deck.drawCard();
        player.receiveCard(card);
        return card;
    }

    public Card drawCardForDealer() {
        Card card = deck.drawCard();
        dealer.receiveCard(card);
        return card;
    }


}
