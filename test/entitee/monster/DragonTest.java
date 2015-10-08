package entitee.monster;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DragonTest {
	Monster monster;
	
	@Before
	public void setUp() throws Exception {
		monster = new Dragon();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInit() {
		assertEquals("Dragon", monster.getName());
		assertEquals(96, monster.getSIZE_HEIGHT());
		assertEquals(96, monster.getSIZE_WIDTH());
		assertEquals(40, (int)monster.getLife());
		assertEquals(30, (int)monster.getSpeed());
		assertEquals(6, (int)monster.getDegat());
	}

}