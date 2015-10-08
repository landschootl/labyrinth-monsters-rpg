package application;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import application.Application.State;

public class ApplicationTest {
	protected Application app;

	@Before
	public void setUp() throws Exception {
		app = new Application();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInit() {
		assertEquals(State.MENU, Application.getStateOfApp());
	}
	
	@Test
	public void testSetStateOfApp() {
		Application.setStateOfApp(State.GAME);
		assertEquals(State.GAME, Application.getStateOfApp());
		Application.setStateOfApp(State.GAMEOVER);
		assertEquals(State.GAMEOVER, Application.getStateOfApp());
		Application.setStateOfApp(State.MENU);
		assertEquals(State.MENU, Application.getStateOfApp());
		Application.setStateOfApp(State.PAUSE);
		assertEquals(State.PAUSE, Application.getStateOfApp());
	}

}
