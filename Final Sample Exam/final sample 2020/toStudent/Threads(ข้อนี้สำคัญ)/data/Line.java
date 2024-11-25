package data;

import java.util.Random;
import application.Main;
import javafx.scene.paint.Color;

public class Line {
	int x, y, r, speedX, speedY;
	Color c;
	public static Random random = new Random();
	
	public Line(int x, int y) {
		this.x = x;
		this.y = y;
		this.c = Color.rgb(random.nextInt(255), random.nextInt(255), random.nextInt(255));
		r = 30 + random.nextInt(50);
		speedX = 16 - random.nextInt(16) - 8;
		speedY = random.nextInt(16) - 8;
	}
	
	public void update() {
		this.x+= speedX;
		this.y+= speedY;
		if(x < 0 || x > Main.width) {
			speedX *= -1;
		}
		if(y < 0 || y > Main.height) {
			speedY *= -1;
		}	
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getR() {
		return r;
	}

	public Color getC() {
		return c;
	}

	
	
}
