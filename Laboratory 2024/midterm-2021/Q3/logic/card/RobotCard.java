package logic.card;

import logic.player.Player;

public class RobotCard extends BaseCard{
    private  int energyCost;


    public RobotCard(String name, int power, int health,int energyCost) {
        super(name, power, health);
        setEnergyCost(energyCost);
    }

    @Override
    public void play(Player player) {
          player.setEnergy(Math.max(0,player.getEnergy()-getEnergyCost()));
    }

    @Override
    public boolean canPlay(Player player) {
        return player.getEnergy()>=getEnergyCost();
    }

    public void setEnergyCost(int energyCost) {
        this.energyCost = Math.max(0,energyCost);
    }

    public int getEnergyCost() {
        return energyCost;
    }








}
