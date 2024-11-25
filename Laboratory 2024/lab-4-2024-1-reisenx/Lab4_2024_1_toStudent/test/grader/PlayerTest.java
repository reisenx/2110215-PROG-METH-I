package grader;

import item.armor.Helmet;
import item.armor.Suit;
import item.armor.Boots;
import item.base.BaseWeapon;
import item.consumption.UltimatePotion;
import item.weapon.Stick;
import item.weapon.Sword;
import org.junit.jupiter.api.Test;
import player.NegativePosException;
import player.Player;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void testUseWeapon() throws NegativePosException {
        Player player1 = new Player("Player1");
        player1.setPos(0);

        Player player2 = new Player("Player2");
        player2.setPos(0);

        BaseWeapon stick = new Stick();

        // Test attack within range
        String resultInRange = player1.useWeapon(stick, player2);
        assertEquals("Player1 attacked Player2", resultInRange);
        assertEquals(19, player2.getHp());

        // Test attack out of range
        player2.setPos(10);
        String resultOutOfRange = player1.useWeapon(stick, player2);
        assertEquals("Player2 is not in attackable range", resultOutOfRange);
        assertEquals(19, player2.getHp());

    }

    @Test
    void testBeingAttack() throws NegativePosException {
        Player player1 = new Player("Player1");

        // Test being attacked with positive damage
        player1.beingAttack(5);
        assertEquals(15, player1.getHp());

        // Test being attacked with negative damage (should not decrease HP)
        player1.beingAttack(-5);
        assertEquals(15, player1.getHp());
    }

    @Test
    void testDecreaseArmorDur() throws NegativePosException {
        Player player = new Player("Player");
        Helmet helmet = new Helmet();
        Boots boots = new Boots();

        // Setup player with armor
        player.setHelmetSlot(helmet);
        player.setSuitSlot(null);
        player.setBootsSlot(boots);

        // set durs
        helmet.setDurability(20);
        boots.setDurability(1);

        // call
        player.decreaseArmorDur();

        // assert
        assertEquals(19, helmet.getDurability());
        assertNull(player.getBootsSlot());

    }

    @Test
    void testDecreaseWeaponDur() throws NegativePosException {
        Player player = new Player("Player");
        Sword sword = new Sword();
        sword.setDurability(2);
        player.getInventory().addItem(sword);
        player.decreaseWeaponDur(sword);
        assertEquals(1, sword.getDurability());
        player.decreaseWeaponDur(sword);
        assertFalse(player.getInventory().getItems().contains(sword));
    }

    @Test
    void testUseNonWeaponItemConsumption() throws NegativePosException {
        Player player = new Player("player");
        player.setHp(2);

        // add item
        UltimatePotion ultimatePotion = new UltimatePotion();
        player.getInventory().addItem(ultimatePotion);

        // test UltimatePotion
        String s = player.useNonWeaponItem(ultimatePotion);

        // test heal
        assertTrue(s.contains("player +5 HP"));
        assertEquals(7, player.getHp());

        // test buff
        assertTrue(s.contains("player +5 ATT for next 3 turns"));

        // two "instance of" test \n
        assertTrue(s.contains("\n"));

        // test remove
        assertFalse(player.getInventory().getItems().contains(ultimatePotion));

    }

    @Test
    void testUseNonWeaponEquipArmor() throws NegativePosException {
        Player player = new Player("player");
        Suit suit = new Suit();
        Suit newSuit = new Suit();
        Boots boots = new Boots();
        Boots newBoots = new Boots();
        Helmet helmet = new Helmet();
        Helmet newHelmet = new Helmet();
        player.getInventory().addItem(suit);
        player.getInventory().addItem(newSuit);
        player.getInventory().addItem(boots);
        player.getInventory().addItem(newBoots);
        player.getInventory().addItem(helmet);
        player.getInventory().addItem(newHelmet);

        // test wear suit
        String s1 = player.useNonWeaponItem(suit);
        assertEquals("player wear Suit", s1);
        assertEquals(suit, player.getSuitSlot());
        assertFalse(player.getInventory().getItems().contains(suit));

        // test replace suit
        String s2 = player.useNonWeaponItem(newSuit);
        assertEquals("player wear Suit", s2);
        assertEquals(newSuit, player.getSuitSlot());
        assertFalse(player.getInventory().getItems().contains(newSuit));
        assertTrue(player.getInventory().getItems().contains(suit));

        // test wear boots
        String s3 = player.useNonWeaponItem(boots);
        assertEquals("player wear Boots", s3);
        assertEquals(boots, player.getBootsSlot());
        assertFalse(player.getInventory().getItems().contains(boots));

        // test replace boots
        String s4 = player.useNonWeaponItem(newBoots);
        assertEquals("player wear Boots", s4);
        assertEquals(newBoots, player.getBootsSlot());
        assertFalse(player.getInventory().getItems().contains(newBoots));
        assertTrue(player.getInventory().getItems().contains(boots));

        // test wear helmet
        String s5 = player.useNonWeaponItem(helmet);
        assertEquals("player wear Helmet", s5);
        assertEquals(helmet, player.getHelmetSlot());
        assertFalse(player.getInventory().getItems().contains(helmet));

        // test replace helmet
        String s6 = player.useNonWeaponItem(newHelmet);
        assertEquals("player wear Helmet", s6);
        assertEquals(newHelmet, player.getHelmetSlot());
        assertFalse(player.getInventory().getItems().contains(newHelmet));
        assertTrue(player.getInventory().getItems().contains(helmet));
    }
}
