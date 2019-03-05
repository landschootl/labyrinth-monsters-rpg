package console;

import java.util.ArrayList;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.Text;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import resources.Texte;

public class ConsoleTest {
	protected Console console;

	@Before
	public void setUp() throws Exception {
		console = Console.getInstance();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInit() {
		Assert.assertNotNull(Console.getInstance());
	}
	
	@Test
	public void testGetTexts() {
		ArrayList<Texte> texts = console.getTexts();
		Assert.assertNotNull(texts);
		Assert.assertEquals(8, texts.size());
		Texte text = texts.get(0);
		Assert.assertNotNull(text);
	}
	
	@Test
	public void testAddText() {
		console.addText("Ludovic", Text.BOLD, Color.BLACK);
		ArrayList<Texte> texts = console.getTexts();
		Assert.assertNotNull(texts);
		Assert.assertEquals(8, texts.size());
		Text text = console.getTexts().get(7).getText();
		Assert.assertEquals(Color.BLACK, text.getColor());
		Assert.assertEquals(Text.BOLD, text.getStyle());
		Assert.assertEquals("> Ludovic", text.getString());
		Assert.assertEquals(15, text.getCharacterSize());
	}
	
	@Test
	public void testRemoveText() {
		console.removeText(0);
		ArrayList<Texte> texts = console.getTexts();
		Assert.assertNotNull(texts);
		Assert.assertEquals(7, texts.size());
	}

}