package entitee.monster;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MonsterTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertNotNull(Monster.generateMonsterById("1"));
		assertNotNull(Monster.generateMonsterById("2"));
		assertNotNull(Monster.generateMonsterById("3"));
		assertNotNull(Monster.generateMonsterById("4"));
		assertNotNull(Monster.generateMonsterById("5"));
		assertNotNull(Monster.generateMonsterById("6"));
	}

}
