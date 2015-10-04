package object.potion;

import entitee.player.Player;
import management.TilesetManager;

public abstract class PotionLife extends object.Object{
	protected int regenereLife;
	
	public PotionLife(int regenereLife) {
		super(TilesetManager.getInstance().getSprite("potionLife"));
		// TODO Auto-generated constructor stub
		this.regenereLife=regenereLife;
	}
	
	public boolean action() {
		return Player.getInstance().addLife(regenereLife);
	}
}
