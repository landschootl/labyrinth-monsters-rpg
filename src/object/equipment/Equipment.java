package object.equipment;

import org.jsfml.graphics.Sprite;

public abstract class Equipment extends object.Object{
	private int bonus;
	
	public Equipment(Sprite sprite, int bonus){
		super(sprite);
		this.bonus=bonus;
	}

	public int getBonusLife() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	
}
