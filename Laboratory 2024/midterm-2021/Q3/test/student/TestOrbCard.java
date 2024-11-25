package test.student;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logic.card.BaseCard;
import logic.card.Element;
import logic.card.OrbCard;
import logic.player.Player;



public class TestOrbCard {
    Player player;
    OrbCard orb1;
    OrbCard orb2;
    BaseCard orb3;


    @BeforeEach
    void setUp(){
        player = new Player();
        orb1 = new OrbCard("Fire Orb", 3, 4, Element.FIRE);
        orb2 = new OrbCard("Water Orb", 5, 5, Element.WATER);
        orb3 = new OrbCard("Earth Orb", 2, 2, Element.EARTH);
    }

    @Test
    void testConstructorLegalValue(){
        assertEquals("Fire Orb", orb1.getName());
        assertEquals(3, orb1.getPower());
        assertEquals(4, orb1.getHealth());
        assertEquals(Element.FIRE, orb1.getOrbType());

        assertEquals(5, orb2.getHealth());
        assertEquals(5, orb2.getHealth());
        assertEquals(5, orb2.getPower());
        assertEquals(Element.WATER, orb2.getOrbType());
    }

    @Test
    void testConstructorIllegalValue(){
        OrbCard negativeOrb = new OrbCard("Darkness Flame", -1, -1,Element.FIRE);
        assertEquals(0, negativeOrb.getHealth());
        assertEquals(0, negativeOrb.getPower());
    }

    @Test
    void testAttackNoExcess(){
        assertEquals(0, orb1.attack(orb2));
        assertEquals(2, orb2.getHealth());
    }

    @Test
    void testAttackWithExcess() {
        assertEquals(1, orb1.attack(orb3));
        assertEquals(0, orb3.getHealth());
    }
}
