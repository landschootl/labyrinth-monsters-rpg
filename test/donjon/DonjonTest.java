package donjon;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import donjon.door.Door;
import donjon.door.DoorWest;
import donjon.room.Room;
import donjon.room.RoomTrap;

public class DonjonTest {
	protected Donjon donjon;
	
	@Before
	public void setUp() throws Exception {
		donjon = new Donjon(1);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testInit() {
		assertNotNull(donjon.getRooms());
		assertNotNull(donjon.getRoom());
		assertNotNull(donjon.getRoomBegin());
	}
	
	@Test
	public void testChangedRoom() {
		Room room = new RoomTrap();
		Door door = new DoorWest(room, false);
		donjon.changedRoom(door);
		assertEquals(room, donjon.getRoom());
	}

}
