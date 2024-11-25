package test.grader;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logic.Fighter;
import logic.Position;

class FighterTest {

	Fighter f;
	Fighter fBorderLeft;
	Fighter fBorderRight;
	Fighter fBorderUp;
	Fighter fReverse;
	Fighter fPromoted;
	Fighter fPromotedBorderLeft;
	Fighter fPromotedBorderRight;
	Fighter fPromotedBorderUp;
	Fighter fPromotedBorderDown;
	
	@BeforeEach
	void setUp(){
		f = new Fighter(0,2,false,"f");
		fReverse = new Fighter(0,2,true,"f");
		fBorderLeft = new Fighter(0,0,false,"f");
		fBorderRight = new Fighter(6,0,false,"f");
		fBorderUp = new Fighter(0,6,false,"f");
		fPromoted = new Fighter(0,0,false,"f");
		
		fPromotedBorderLeft = new Fighter(0,0,false,"f");
		fPromotedBorderRight = new Fighter(6,0,false,"f");
		fPromotedBorderUp  = new Fighter(0,6,false,"f");
		fPromotedBorderDown = new Fighter(0,0,false,"f");
	}

	@Test
	void testConstructor() {
		//check movePositions
		assertEquals(-1, f.getMovePositions().get(0).getX());
		assertEquals(2, f.getMovePositions().get(0).getY());
		assertEquals(1, f.getMovePositions().get(1).getX());
		assertEquals(2, f.getMovePositions().get(1).getY());
		
		assertEquals(0, f.getPromotedMovePositions().get(0).getX());
		assertEquals(2, f.getPromotedMovePositions().get(0).getY());
		assertEquals(1, f.getPromotedMovePositions().get(1).getX());
		assertEquals(0, f.getPromotedMovePositions().get(1).getY());
		assertEquals(0, f.getPromotedMovePositions().get(2).getX());
		assertEquals(-2, f.getPromotedMovePositions().get(2).getY());
		assertEquals(-1, f.getPromotedMovePositions().get(3).getX());
		assertEquals(0, f.getPromotedMovePositions().get(3).getY());
		
		assertEquals(false, f.isPromoted());
	}
	
	@Test
	void testReversedConstructor() {
		//check movePositions
		assertEquals(1, fReverse.getMovePositions().get(0).getX());
		assertEquals(-2, fReverse.getMovePositions().get(0).getY());
		assertEquals(-1, fReverse.getMovePositions().get(1).getX());
		assertEquals(-2, fReverse.getMovePositions().get(1).getY());
				
		assertEquals(0, fReverse.getPromotedMovePositions().get(0).getX());
		assertEquals(-2, fReverse.getPromotedMovePositions().get(0).getY());
		assertEquals(-1, fReverse.getPromotedMovePositions().get(1).getX());
		assertEquals(0, fReverse.getPromotedMovePositions().get(1).getY());
		assertEquals(0, fReverse.getPromotedMovePositions().get(2).getX());
		assertEquals(2, fReverse.getPromotedMovePositions().get(2).getY());
		assertEquals(1, fReverse.getPromotedMovePositions().get(3).getX());
		assertEquals(0, fReverse.getPromotedMovePositions().get(3).getY());
	}
	
	@Test
	void testSetPromoted() {
		f.setPromoted(true);
		assertEquals(f.isPromoted(),true);
	}
	
	@Test
	void testAttackTargetPosition() {
		Position p = f.attackTargetPosition(1);
		assertEquals(1, p.getX());
		assertEquals(4, p.getY());
		assertEquals(1, f.getCurrentPosition().getX());
		assertEquals(4, f.getCurrentPosition().getY());
	}
	
	@Test
	void testAttackTargetPositionBorder() {
		Position pBorder = fBorderLeft.attackTargetPosition(0);
		assertEquals(6, pBorder.getX());
		assertEquals(2, pBorder.getY());
		assertEquals(6, fBorderLeft.getCurrentPosition().getX());
		assertEquals(2, fBorderLeft.getCurrentPosition().getY());
	}
	
	//move 
	@Test
	void testNormalMove() {
		f.move(1);
		assertEquals(1, f.getCurrentPosition().getX());
		assertEquals(4, f.getCurrentPosition().getY());
	}
	
	@Test
	void testBorderLeft() {
		f.move(0);
		assertEquals(6, f.getCurrentPosition().getX());
		assertEquals(4, f.getCurrentPosition().getY());
	}
	

	@Test
	void testBorderRight() {
		fBorderRight.move(1);
		assertEquals(0, fBorderRight.getCurrentPosition().getX());
		assertEquals(2, fBorderRight.getCurrentPosition().getY());
	}
	

	@Test
	void testBorderUp() {
		fBorderUp.move(1);
		assertEquals(1, fBorderUp.getCurrentPosition().getX());
		assertEquals(1, fBorderUp.getCurrentPosition().getY());
		
	}
	
	
	//testPromoteMove
	@Test
	void testPromotedNormalMove() {
		fPromoted.setPromoted(true);
		fPromoted.move(0);
		assertEquals(0, fPromoted.getCurrentPosition().getX());
		assertEquals(2, fPromoted.getCurrentPosition().getY());
	}
	

	@Test
	void testPromotedBorderLeft() {
		fPromotedBorderLeft.setPromoted(true);
		fPromotedBorderLeft.move(3);
		assertEquals(6, fPromotedBorderLeft.getCurrentPosition().getX());
		assertEquals(0, fPromotedBorderLeft.getCurrentPosition().getY());
		
	}
	

	@Test
	void testPromotedBorderRight() {
		fPromotedBorderRight.setPromoted(true);
		fPromotedBorderRight.move(1);
		assertEquals(0, fPromotedBorderRight.getCurrentPosition().getX());
		assertEquals(0, fPromotedBorderRight.getCurrentPosition().getY());
	}
	

	@Test
	void testPromotedBorderUp() {
		fPromotedBorderUp.setPromoted(true);
		fPromotedBorderUp.move(0);
		assertEquals(0, fPromotedBorderUp.getCurrentPosition().getX());
		assertEquals(1, fPromotedBorderUp.getCurrentPosition().getY());
		
	}
	

	@Test
	void testPromotedBorderDown() {
		fPromotedBorderDown.setPromoted(true);
		fPromotedBorderDown.move(2);
		assertEquals(0, fPromotedBorderDown.getCurrentPosition().getX());
		assertEquals(5, fPromotedBorderDown.getCurrentPosition().getY());
	}
	

}
