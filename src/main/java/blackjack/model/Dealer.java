package blackjack.model;

public class Dealer extends Participant {

    @Override
    public boolean wantsToHit() {
        return getScore() < 17;
    }
}
