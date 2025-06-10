package blackjack.model;

public abstract class Participant {
    protected final Hand hand = new Hand();

    public void receiveCard(Card card) {
        hand.addCard(card);
    }

    public int getScore() {
        return hand.getScore();
    }

    public Hand getHand() {
        return hand;
    }

    public abstract boolean wantsToHit();
}

