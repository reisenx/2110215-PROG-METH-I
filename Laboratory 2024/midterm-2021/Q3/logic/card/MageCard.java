package logic.card;

import logic.player.Player;

import java.util.Collections;

public class MageCard extends BaseCard{
    private   Element mageType;


    public MageCard(String name, int power, int health, Element mageType) {
        super(name, power, health);
        setMageType(mageType);
    }

    @Override
    public void play(Player player) {
        int sameElementCard=0;
        for(BaseCard baseCard: player.getField()){//check card in field
            if(baseCard instanceof OrbCard){//check which card is orbcard.
                if(((OrbCard) baseCard).getOrbType().equals(getMageType())){
                    sameElementCard++;
                }
            }
        }
        setPower(getPower()+sameElementCard);

    }

    @Override
    public boolean canPlay(Player player) {
        for(BaseCard baseCard: player.getField()){
            if(baseCard instanceof OrbCard){
                if(((OrbCard) baseCard).getOrbType().equals(getMageType())){
                    return true;
                }
            }
        }
        return false;
    }

    public Element getMageType() {
        return mageType;
    }

    public void setMageType(Element mageType) {
        this.mageType = mageType;
    }
}
