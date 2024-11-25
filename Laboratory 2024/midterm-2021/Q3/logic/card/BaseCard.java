package logic.card;

import logic.player.Player;

public abstract class BaseCard{//Base of all other card.
    private String name;
    private int power,health;

    public BaseCard(String name, int power, int health) {
        setName(name);
        setPower(power);
        setHealth(health);
    }


    public abstract void play(Player player);//This method will perform action depending on type of cards

    public abstract boolean canPlay(Player player);//The rules are different for each type of
    public int attack(BaseCard target){
        int excessDamage= Math.max(0,getPower()-target.getHealth());//Need to remember excess dmg before reduce health
        target.setHealth(Math.max(0,target.getHealth()-getPower()));
        return excessDamage;
    }
    public void setPower(int power) {
        this.power = Math.max(0,power);
    }

    public void setHealth(int health) {
        this.health = Math.max(0,health);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }



    public int getHealth() {
        return health;
    }








}
