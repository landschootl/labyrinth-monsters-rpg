package object.equipment;

import org.jsfml.graphics.Sprite;

public abstract class Equipment extends object.Object{
	private int bonus;
	
	public Equipment(Sprite sprite, String name, int bonus){
		super(sprite, name);
		this.bonus=bonus;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	
}
