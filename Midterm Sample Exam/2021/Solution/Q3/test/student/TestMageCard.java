package test.student;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logic.card.Element;
import logic.card.MageCard;
import logic.card.OrbCard;
import logic.player.Player;




public class TestMageCard {
    Player player;
    MageCard mage1;
    MageCard mage2;
    MageCard mage3;
    OrbCard orb1;
    OrbCard orb2;

    @BeforeEach
    void setUp(){
        player = new Player();
        mage1 = new MageCard("Klee", 5, 3, Element.FIRE);
        mage2 = new MageCard("Water Abyss Mage", 3,2, Element.WATER);
        mage3 = new MageCard("Anemo Slime", 2, 7, Element.ICE);
        orb1 = new OrbCard("Fire Orb", 3, 4, Element.FIRE);
        orb2 = new OrbCard("Water Orb", 3, 4, Element.WATER);
    }

    @Test
    void testConstructorLegalValue(){
        assertEquals("Klee", mage1.getName());
        assertEquals(5,mage1.getPower());
        assertEquals(3, mage1.getHealth());
        assertEquals(Element.FIRE, mage1.getMageType());
    }

    @Test
    void testConstructorIllegalValue(){
        MageCard negativeMage = new MageCard("Dark Water Mage", -1, -1, Element.WATER);
        assertEquals(0, negativeMage.getHealth());
        assertEquals(0, negativeMage.getPower());
        assertEquals(Element.WATER, negativeMage.getMageType());
    }

    @Test
    void testCanPlay(){
        assertEquals(false, mage1.canPlay(player));
        player.getField().set(0, orb1);
        assertEquals(true, mage1.canPlay(player));
        assertEquals(false, mage2.canPlay(player));
        player.getField().set(3, orb2);
        assertEquals(true, mage2.canPlay(player));
    }

    @Test
    void testPlay(){
        player.getField().set(1, orb1);
        player.getField().set(3, orb2);
        mage1.play(player);
        assertEquals(null, player.getField().get(0));
        assertEquals(6, mage1.getPower());
        assertEquals(3,mage1.getHealth());
        player.getField().set(0, orb2);
        mage2.play(player);
        assertEquals(5, mage2.getPower());
        assertEquals(2, mage2.getHealth());
    }

    @Test
    void testAttackNoExcess(){
        assertEquals(0, mage1.attack(mage3));
        assertEquals(2, mage3.getHealth());
    }

    @Test
    void testAttackWithExcess() {
        assertEquals(3, mage1.attack(mage2));
        assertEquals(0, mage2.getHealth());
    }

}
