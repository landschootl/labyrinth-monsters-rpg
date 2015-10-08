package entitee.monster;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MallocTest {
	Monster monster;
	
	@Before
	public void setUp() throws Exception {
		monster = new Malloc();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInit() {
		assertEquals("Malloc", monster.getName());
		assertEquals(32, monster.getSIZE_HEIGHT());
		assertEquals(32, monster.getSIZE_WIDTH());
		assertEquals(10, (int)monster.getLife());
		assertEquals(40, (int)monster.getSpeed());
		assertEquals(2, (int)monster.getDegat());
	}

}