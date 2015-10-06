package object.equipment;

import management.TilesetManager;
import entitee.player.Player;

/**
 * Classe qui représente l'equipement Glove.
 * Elle ajoute un point de vie au joueur.
 * @author Ludov_000
 *
 */
public class Glove extends Equipment{
	
	public Glove() {
		super(TilesetManager.getInstance().getSprite("glove"), "glove", 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void pickUp() {
		// TODO Auto-generated method stub
		Player.getInstance().getInventory().setGlove(this);
	}

}
