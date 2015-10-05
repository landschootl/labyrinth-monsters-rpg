package object.potion;

import entitee.player.Player;
import management.TilesetManager;

public abstract class PotionLife extends object.Object{
	protected int regenereLife;
	
	public PotionLife(int regenereLife, String name) {
		super(TilesetManager.getInstance().getSprite("potionLife"), name);
		// TODO Auto-generated constructor stub
		this.regenereLife=regenereLife;
	}
	
	public boolean action() {
		return Player.getInstance().addLife(regenereLife);
	}
}
