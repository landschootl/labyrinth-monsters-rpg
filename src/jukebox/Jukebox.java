package jukebox;

import management.ResourceManager;

import org.jsfml.audio.Sound;
import org.jsfml.audio.SoundSource.Status;
import org.jsfml.window.Keyboard;
import org.jsfml.window.Keyboard.Key;
import org.jsfml.window.event.Event;
import org.jsfml.window.event.Event.Type;

public class Jukebox {
	/**
	 * Unique instance of jukebox class
	 */
	private static Jukebox instance = null;

	private Sound sound = new Sound();
	
	private int volume = 50;
	
	private Jukebox(){
		sound.setBuffer(ResourceManager.getSoundBuffer("resource/sound/background.wav"));
		setLoop(true);
	}
	
	/**
	 * Return and create the instance of the class if she dosen't exist.
	 * @return the only one instance of jukebox class.
	 */
	public static Jukebox getInstance(){
		if(instance==null)
			instance = new Jukebox();
		return instance;
	}
	
	/**
	 * Enable to manage the scenes events.
	 * @param event : application event.
	 */
	public void handleEvents(Event event) {
		if(event.type == Type.KEY_PRESSED){
			if(Keyboard.isKeyPressed(Key.NUMPAD1))
				lowerVolume();
			if(Keyboard.isKeyPressed(Key.NUMPAD2))
				upVolume();
			if(Keyboard.isKeyPressed(Key.NUMPAD3)){
				if(sound.getStatus()==Status.PLAYING)
					pause();
				else
					play();
			}
		}
	}
	
	public void play(){
		sound.play();
	}
	
	public void pause(){
		sound.pause();
	}
	
	public void stop(){
		sound.stop();
	}
	
	public void setLoop(boolean bool){
		sound.setLoop(bool);
	}
	
	public void upVolume(){
		if(volume<=90)
			volume+=10;
		setVolume(volume);
	}
	
	public void lowerVolume(){
		if(volume>=10)
			volume-=10;
		setVolume(volume);
	}
	
	public void setVolume(int volume){
		sound.setVolume(volume);
	}
}
