package entitee.monster;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SirhealTest {
	Monster monster;
	
	@Before
	public void setUp() throws Exception {
		monster = new Sirheal();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInit() {
		assertEquals("Sirheal", monster.getName());
		assertEquals(32, monster.getSIZE_HEIGHT());
		assertEquals(32, monster.getSIZE_WIDTH());
		assertEquals(8, (int)monster.getLife());
		assertEquals(40, (int)monster.getSpeed());
		assertEquals(2, (int)monster.getDegat());
	}

}