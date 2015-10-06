package object;

import entitee.player.Player;
import management.TilesetManager;

/**
 * Classe qui représente un objet clé.
 * @author Ludov_000
 *
 */
public class Key extends Object{

	public Key() {
		super(TilesetManager.getInstance().getSprite("key"), "key");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void pickUp() {
		// TODO Auto-generated method stub
		Player.getInstance().getInventory().addKey(this);
	}

}
