package scene;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Text;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;
import org.jsfml.window.event.Event;

import application.Application;
import application.Application.State;
import resources.Texte;
import console.Console;
import donjon.Donjon;
import entitee.player.Player;

/**
 * This class represent the scene of the current game
 * @author Ludov_000
 *
 */
public class SceneGame {
	/**
	 * Pointer on the window of the console
	 */
	private RenderWindow window;
	/**
	 * game level.
	 */
	private int level = 1;
	private Donjon donjon = new Donjon(level);
	private Player player = Player.getInstance();
	/**
	 * The events in the game.
	 * @author Ludov_000
	 *
	 */
	public static enum EventGame {
		NONE,
		PLAYER_FALL_INTO_TRAP,
		PLAYER_IS_DEAD,
		WIN_LEVEL
	};
	/**
	 * The event in the game being triggered.
	 */
	public static EventGame eventOfGame = EventGame.NONE;
	
	public SceneGame(RenderWindow window){
		this.window=window;
	}
	
	/**
	 * Enable to manage the scenes events.
	 * @param event : application event.
	 */
	public void handleEvents(Event event) {
		player.handleEvents(event);
	}

	/**
	 * Enable to manage scene action
	 * @param time : the timer
	 */
	public void update(Time time) {
	    donjon.update(time);
	    player.update();
	    actionEventOfTheGame();
	}

	public void actionEventOfTheGame(){
		switch (eventOfGame) {
		case PLAYER_FALL_INTO_TRAP:
			Console.getInstance().addText("Vous �tes tomb� dans une trap !", Text.REGULAR, Color.RED);
			donjon.returnBeginRoom();
			player.loseLife((int)Player.getInstance().getLife()/3);
			player.initPositionBegin();
			break;
		case WIN_LEVEL:
			Console.getInstance().addText("Bien jouez, niveau termin� !", Text.REGULAR, new Color(49, 126 ,4));
			level+=1;
			Console.getInstance().addText("Vous �tes au niveau : "+level+" !", Text.REGULAR, new Color(49, 126 ,4));
			donjon.generateDonjon(level);
			player.initPositionBegin();
			break;
		case PLAYER_IS_DEAD:
			Console.getInstance().addText("Vous �tes mort !", Text.REGULAR, Color.RED);
			level = 1;
			player.init();
			Console.init();
			donjon.generateDonjon(level);
			Application.setStateOfApp(State.GAMEOVER);
			break;
		default:
			break;
		}
		setEventOfGame(EventGame.NONE);
	}
	
	/**
	 * Show the graphics elements in the windows of the console.
	 */
	public void draw() {
		Console.getInstance().draw(window);
		donjon.draw(window);
		Player.getInstance().draw(window);
		Texte textLevel = new Texte("Level : "+level, 20, new Vector2f(5,3), Color.BLACK, Text.BOLD);
		textLevel.draw(window);
	}
	
	public static void setEventOfGame(EventGame eventGame){
		eventOfGame = eventGame;
	}
	
	public int getLevel() {
		return level;
	}
	
}
