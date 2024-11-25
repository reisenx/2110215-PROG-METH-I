package logic;

public class Position{
	private int x;
	private int y;
	
	public Position(int x,int y) {
		setX(x);
		setY(y);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public boolean equal(Position temp) {
		if(temp.getX()==getX() && temp.getY() == getY()) {
			return true;
		}
		return false;
	}
	
	public Position addPositionValue(Position addedPosition) {
		int resultX = addedPosition.getX() + this.getX();
		int resultY = addedPosition.getY() + this.getY();
		Position result = new Position(resultX,resultY);
		result.normalizedPosition();
		return result;
	}
	
	public void reverse() {
		this.x = this.x * -1;
		this.y = this.y * -1;
	}
	
	public void normalizedPosition(){
		if(this.x>0)this.x = x%7;
		if(this.y>0)this.y = y%7;
		if(this.x<0)this.x += 7;
		if(this.y<0)this.y += 7;
		
	}
	
	
}
