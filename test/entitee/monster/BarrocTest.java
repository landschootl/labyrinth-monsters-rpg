package entitee.monster;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BarrocTest {
	Monster monster;
	
	@Before
	public void setUp() throws Exception {
		monster = new Barroc();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInit() {
		assertEquals("Barroc", monster.getName());
		assertEquals(32, monster.getSIZE_HEIGHT());
		assertEquals(32, monster.getSIZE_WIDTH());
		assertEquals(2, (int)monster.getLife());
		assertEquals(30, (int)monster.getSpeed());
		assertEquals(4, (int)monster.getDegat());
	}

}
