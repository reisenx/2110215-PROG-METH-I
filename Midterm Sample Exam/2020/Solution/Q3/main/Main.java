package main;

import java.util.Scanner;

import logic.Fighter;
import logic.GameSystem;
import logic.MotherShip;

public class Main {

	private static boolean whiteTurn = true;
	
	public static void main(String args[]) {
		
		GameSystem gs = new GameSystem();
		
		System.out.println("Welcome to space chess!");
		Scanner sc = new Scanner(System.in);
		
		while(!gs.isGameEnd()) {
			
			gs.printBoardStatus();
			
			if(whiteTurn) {
				System.out.println("this is white turn.");
				System.out.println("Avaiable Pieces:");
				
				for(int i = 0;i<gs.getAllWhitePieces().size();i++) {
					System.out.println("<"+i+"> "+gs.getAllWhitePieces().get(i).getName());
				}
				int pieceNum = sc.nextInt();
				if(gs.getAllWhitePieces().get(pieceNum).getName() == "wm1") {
					System.out.println("<1> attack/<2> move");
					boolean check = true;
					while(check) {
						int attackMoveNum = sc.nextInt();
						if(attackMoveNum != 1 && attackMoveNum != 2) {
							System.out.println("please select <1> attack or <2> move");
						}else if(attackMoveNum == 1) {
							gs.action((MotherShip)gs.getAllWhitePieces().get(pieceNum), true, 0);
							check = false;
						}else if(attackMoveNum == 2) {
							gs.action((MotherShip)gs.getAllWhitePieces().get(pieceNum), false, 0);
							check = false;
						}
					}
					
				}
				else {
					System.out.println("select the number of move pattern.");
					boolean check = true;
					while(check) {
						int attackMoveNum = sc.nextInt();
						if(((Fighter)gs.getAllWhitePieces().get(pieceNum)).isPromoted() && (attackMoveNum < 0 ||attackMoveNum >3)) {
							System.out.println("please select 0 - 3");
						}else if(!((Fighter)gs.getAllWhitePieces().get(pieceNum)).isPromoted() && (attackMoveNum < 0 ||attackMoveNum >1)) {
							System.out.println("please select 0 - 1");
						}else {
							gs.action((Fighter)gs.getAllWhitePieces().get(pieceNum),true,attackMoveNum);
							check = false;
						}
					}
					
				}
			}
			else if(!whiteTurn) {
				System.out.println("this is red turn.");
				System.out.println("Avaiable Pieces:");
				
				for(int i = 0;i<gs.getAllRedPieces().size();i++) {
					System.out.println("<"+i+"> "+gs.getAllRedPieces().get(i).getName());
				}
				int pieceNum = sc.nextInt();
				if(gs.getAllRedPieces().get(pieceNum).getName() == "rm1") {
					System.out.println("<1> attack/<2> move");
					boolean check = true;
					while(check) {
						int attackMoveNum = sc.nextInt();
						if(attackMoveNum != 1 && attackMoveNum != 2) {
							System.out.println("please select <1> attack or <2> move");
						}else if(attackMoveNum == 1) {
							gs.action((MotherShip)gs.getAllRedPieces().get(pieceNum), true, 0);
							check = false;
						}else if(attackMoveNum == 2) {
							gs.action((MotherShip)gs.getAllRedPieces().get(pieceNum), false, 0);
							check = false;
						}
					}
				}
				else {
					System.out.println("select the number of move pattern.");
					boolean check = true;
					while(check) {
						int attackMoveNum = sc.nextInt();
						if(((Fighter)gs.getAllRedPieces().get(pieceNum)).isPromoted() && (attackMoveNum < 0 ||attackMoveNum >3)) {
							System.out.println("please select 0 - 3");
						}else if(!((Fighter)gs.getAllRedPieces().get(pieceNum)).isPromoted() && (attackMoveNum < 0 ||attackMoveNum >1)) {
							System.out.println("please select 0 - 1");
						}else {
							gs.action((Fighter)gs.getAllRedPieces().get(pieceNum),true,attackMoveNum);
							check = false;
						}
					}
				}
			}
			
			whiteTurn = !whiteTurn;
		}
		System.out.println("Game end.");
		if(gs.getAllRedPieces().isEmpty()) {
			System.out.println("White win!");
		}
		else if(gs.getAllWhitePieces().isEmpty()) {
			System.out.println("Red win!");
		}
		else {
			System.out.println("Draw!");
		}
	}
	
	
}
