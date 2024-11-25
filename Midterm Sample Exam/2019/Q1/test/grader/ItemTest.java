package test.grader;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import logic.Item;

class ItemTest {

	@Test
	void testConstructor() {
		Item apple = new Item("Apple",30);
		assertEquals("Apple", apple.getName());
	}
	
	@Test
	void testConstructorMinusPrice() {
		Item debt = new Item("Debt",-1);
		assertEquals(1, debt.getPricePerPiece());
	}
	
	@Test
	void testGetPricePerPiece() {
		Item reviveLeaf = new Item("reviveLeaf",4000);
		assertEquals(4000, reviveLeaf.getPricePerPiece());
	}

	@Test
	void testSetPricePerPiece() {
		Item potion = new Item("Potion",100);
		potion.setPricePerPiece(60);
		assertEquals(60, potion.getPricePerPiece());
	}

	@Test
	void testSetPricePerPieceNegative() {
		Item freeMoney = new Item("Money",100);
		freeMoney.setPricePerPiece(-12341);
		assertEquals(1, freeMoney.getPricePerPiece());
	}

	@Test
	void testGetName() {
		Item ironBar = new Item("Iron Bar",100);
		assertEquals("Iron Bar", ironBar.getName());
	}


}
