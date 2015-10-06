package object.equipment;

import management.TilesetManager;
import entitee.player.Player;

/**
 * Classe qui représente l'equipement Shield.
 * Elle ajoute un point de vie au joueur.
 * @author Ludov_000
 *
 */
public class Shield extends Equipment{
	
	public Shield() {
		super(TilesetManager.getInstance().getSprite("shield"), "shield", 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void pickUp() {
		// TODO Auto-generated method stub
		Player.getInstance().getInventory().setShield(this);
	}

}
