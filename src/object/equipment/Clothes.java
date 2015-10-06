package object.equipment;

import management.TilesetManager;
import entitee.player.Player;

/**
 * Classe qui représente l'equipement Clothes.
 * Elle ajoute un point de vie au joueur.
 * @author Ludov_000
 *
 */
public class Clothes extends Equipment{
	
	public Clothes() {
		super(TilesetManager.getInstance().getSprite("clothes"), "clothes", 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void pickUp() {
		// TODO Auto-generated method stub
		Player.getInstance().getInventory().setClothes(this);
	}

}
