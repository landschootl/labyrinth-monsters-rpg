package donjon.door;

import org.jsfml.system.Vector2f;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import donjon.room.Room;
import donjon.room.RoomTrap;

public class DoorEastTest {
	Door door;
	Room room;

	@Before
	public void setUp() throws Exception {
		room = new RoomTrap();
		door = new DoorEast(room, true);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInit() {
		Assert.assertNotNull(door);
		Assert.assertEquals(room, door.getNextRoom());
		Assert.assertTrue(door.isLocked());
		Assert.assertEquals(new Vector2f(3*32,9*32), door.getNextPositionPlayer());
	}
	
	@Test
	public void testUnlock() {
		door.unlock();
		Assert.assertFalse(door.isLocked());
	}

}
