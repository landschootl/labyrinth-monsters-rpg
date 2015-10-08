package entitee.monster;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RodeurTest {
	Monster monster;
	
	@Before
	public void setUp() throws Exception {
		monster = new Rodeur();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInit() {
		assertEquals("Rodeur", monster.getName());
		assertEquals(32, monster.getSIZE_HEIGHT());
		assertEquals(32, monster.getSIZE_WIDTH());
		assertEquals(1, (int)monster.getLife());
		assertEquals(40, (int)monster.getSpeed());
		assertEquals(1, (int)monster.getDegat());
	}

}