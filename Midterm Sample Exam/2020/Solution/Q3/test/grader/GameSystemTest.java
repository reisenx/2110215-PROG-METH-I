package test.grader;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logic.Fighter;
import logic.GameSystem;
import logic.MotherShip;
import logic.Piece;

class GameSystemTest {

	GameSystem gs;
	
	@BeforeEach
	void setUp() {
		gs = new GameSystem();
	}

	@Test
	void testMotherShipMoveAction() {
		gs.action((Piece)gs.getAllWhitePieces().get(0),false, 0);
		assertEquals(3, gs.getAllWhitePieces().get(0).getCurrentPosition().getX());
		assertEquals(1, gs.getAllWhitePieces().get(0).getCurrentPosition().getY());

	}
	
	@Test
	void testMotherShipAttackAction() {
		gs.action((Piece)gs.getAllWhitePieces().get(0),false, 0);
		gs.action((Piece)gs.getAllWhitePieces().get(0),false, 0);
		gs.action((Piece)gs.getAllWhitePieces().get(0),false, 0);
		gs.action((Piece)gs.getAllWhitePieces().get(0),false, 0);
		gs.action((Piece)gs.getAllWhitePieces().get(0),true, 0);
		boolean check = true;
		for(int i =0;i<gs.getAllRedPieces().size();i++) {
			if(gs.getAllRedPieces().get(i).getName() == "rm1") {
				check = false;
			}
		}
		assertEquals(true, check);
	}
	
	@Test
	void testFighterAction() {
		gs.action((Piece)gs.getAllWhitePieces().get(1),false, 0);
		assertEquals(6, gs.getAllWhitePieces().get(1).getCurrentPosition().getX());
		assertEquals(4, gs.getAllWhitePieces().get(1).getCurrentPosition().getY());
		
		assertEquals(true, ((Fighter)gs.getAllWhitePieces().get(1)).isPromoted());
		
		boolean check = true;
		for(int i =0;i<gs.getAllRedPieces().size();i++) {
			if(gs.getAllRedPieces().get(i).getName() == "rf4") {
				check = false;
			}
		}
		assertEquals(true, check);
	}
}
