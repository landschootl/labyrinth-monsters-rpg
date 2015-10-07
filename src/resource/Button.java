package resource;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Text;
import org.jsfml.system.Vector2f;
import org.jsfml.window.event.Event;

import application.Application;
import application.Application.State;

public class Button {
	
	private boolean click = false;
	private RectangleShape button;
	private Texte text;
	
	public Button(int size, float border ,Color fillColor, Color outlineColor ,Vector2f position, String message){
		button = new RectangleShape();
		
		text = new Texte(message, size-10, position, outlineColor, Text.BOLD);
		text.getText().setOrigin(text.getText().getGlobalBounds().width/2,text.getText().getGlobalBounds().height);
		
		button.setSize(new Vector2f(text.getText().getGlobalBounds().width+30,size));
		button.setFillColor(fillColor);
		button.setOutlineThickness(border);
		button.setOutlineColor(outlineColor);
		button.setPosition(position);
		button.setOrigin(button.getGlobalBounds().width/2-10, button.getGlobalBounds().height/2);
	}
	
	// Fonction qui permet de gérer les événements.
	public void handleEvents(Event event) {
		if (event.type == Event.Type.MOUSE_BUTTON_PRESSED) {
			if(button.getGlobalBounds().contains(event.asMouseEvent().position.x, event.asMouseEvent().position.y))
				click=true;
			else
				click=false;
		}
	}

	// Fonction qui permet d'afficher le rendu graphique dans la fenetre.
	public void draw(RenderWindow window) {
		window.draw(button);
		text.draw(window);
	}
	
	public boolean isClick(){
		return click;
	}

}
