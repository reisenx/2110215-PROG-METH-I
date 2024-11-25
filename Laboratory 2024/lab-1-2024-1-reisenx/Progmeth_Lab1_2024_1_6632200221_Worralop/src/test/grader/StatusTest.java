package test.grader;

import static org.junit.jupiter.api.Assertions.*;

import exception.BadStatusException;
import logic.components.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StatusTest {
    @Test
    void testConstructor() {
        try {
            Status status1 = new Status(3, 1, 2, 5);
            assertEquals(3, status1.getHp());
            assertEquals(1, status1.getDurability());
            assertEquals(2, status1.getAttack());
            assertEquals(5, status1.getMagic());
            Status status2 = new Status(0, 0, 0, 0);
            assertEquals(0, status2.getHp());
            assertEquals(0, status2.getDurability());
            assertEquals(0, status2.getAttack());
            assertEquals(0, status2.getMagic());
        } catch (BadStatusException e) {
            fail();
        }
    }

    @Test
    void testConstructorException() {
        Assertions.assertThrows(BadStatusException.class, () -> {
            Status status1 = new Status(-1, 1, 4, 5);
        });

        Assertions.assertThrows(BadStatusException.class, () -> {
            Status status1 = new Status(3, -2, 4, 5);
        });
        Assertions.assertThrows(BadStatusException.class, () -> {
            Status status1 = new Status(3, 1, -3, 5);
        });
        Assertions.assertThrows(BadStatusException.class, () -> {
            Status status1 = new Status(3, 1, 4, -4);
        });

    }

    @Test
    void testAddStatus() {
        try {
            Status status1 = new Status(3, 1, 4, 5);
            Status addStatus = new Status(2, 3, 5, 6);
            status1.addStatus(addStatus);
            assertEquals(5, status1.getHp());
            assertEquals(4, status1.getDurability());
            assertEquals(9, status1.getAttack());
            assertEquals(11, status1.getMagic());
            status1.addStatus(addStatus);
            assertEquals(7, status1.getHp());
            assertEquals(7, status1.getDurability());
            assertEquals(14, status1.getAttack());
            assertEquals(17, status1.getMagic());
        } catch (BadStatusException e) {
            fail();
        }
    }

    @Test
    void testSetHp() {
        try {
            Status status1 = new Status(6, 1, 4, 5);
            status1.setHp(3);
            assertEquals(3, status1.getHp());
            status1.setHp(0);
            assertEquals(0, status1.getHp());
        } catch (BadStatusException e) {
            fail();
        }
    }

    @Test
    void testSetHpException() {
        try {
            Status status1 = new Status(6, 1, 4, 5);
            Assertions.assertThrows(BadStatusException.class, () -> {
                status1.setHp(-1);
            });
        } catch (BadStatusException e) {
            fail();
        }
    }


    @Test
    void testSetDurability() {
        try {
            Status status1 = new Status(6, 1, 4, 5);
            status1.setDurability(5);
            assertEquals(5, status1.getDurability());
            status1.setDurability(0);
            assertEquals(0, status1.getDurability());
        } catch (BadStatusException e) {
            fail();
        }
    }

    @Test
    void testSetDurabilityException() {
        try {
            Status status1 = new Status(6, 1, 4, 5);
            Assertions.assertThrows(BadStatusException.class, () -> {
                status1.setDurability(-1);
            });
        } catch (BadStatusException e) {
            fail();
        }
    }

    @Test
    void testSetAttack() {
        try {
            Status status1 = new Status(3, 2, 5, 1);
            status1.setAttack(5);
            assertEquals(5, status1.getAttack());
            status1.setAttack(0);
            assertEquals(0, status1.getAttack());
        } catch (BadStatusException e) {
            fail();
        }
    }

    @Test
    void testSetAttackException() {
        try {
            Status status1 = new Status(3, 2, 5, 1);
            Assertions.assertThrows(BadStatusException.class, () -> {
                status1.setAttack(-1);
            });
        } catch (BadStatusException e) {
            fail();
        }
    }

    @Test
    void testSetMagic() {
        try {
            Status status1 = new Status(3, 2, 5, 1);
            status1.setMagic(7);
            assertEquals(7, status1.getMagic());
            status1.setMagic(0);
            assertEquals(0, status1.getMagic());
        } catch (BadStatusException e) {
            fail();
        }
    }

    @Test
    void testSetMagicException() {
        try {
            Status status1 = new Status(3, 2, 5, 1);
            Assertions.assertThrows(BadStatusException.class, () -> {
                status1.setMagic(-1);
            });
        } catch (BadStatusException e) {
            fail();
        }
    }
}
