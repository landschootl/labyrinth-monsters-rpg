package entitee.monster;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RunnerTest {
	Monster monster;
	
	@Before
	public void setUp() throws Exception {
		monster = new Runner();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInit() {
		assertEquals("Runner", monster.getName());
		assertEquals(32, monster.getSIZE_HEIGHT());
		assertEquals(32, monster.getSIZE_WIDTH());
		assertEquals(1, (int)monster.getLife());
		assertEquals(70, (int)monster.getSpeed());
		assertEquals(1, (int)monster.getDegat());
	}

}