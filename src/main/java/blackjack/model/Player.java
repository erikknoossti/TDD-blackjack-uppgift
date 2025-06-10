package blackjack.model;

public class Player extends Participant {
    private boolean wantsToHit = true;

    public void setWantsToHit(boolean value) {
        this.wantsToHit = value;
    }

    @Override
    public boolean wantsToHit() {
        return wantsToHit;
    }
}

