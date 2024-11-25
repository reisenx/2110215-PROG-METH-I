package logic.card;

import logic.player.Player;

public class OrbCard extends BaseCard{
    private Element orbType;

    public OrbCard(String name, int power, int health, Element orbType) {
        super(name, power, health);
        setOrbType(orbType);
    }

    @Override
    public void play(Player player) {
    }

    @Override
    public boolean canPlay(Player player) {
        return true;
    }

    public Element getOrbType() {
        return orbType;
    }

    public void setOrbType(Element orbType) {
        this.orbType = orbType;
    }
}
