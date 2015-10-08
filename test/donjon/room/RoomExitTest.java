package donjon.room;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import donjon.door.Door;
import donjon.door.DoorSouth;

public class RoomExitTest {
	Room room;

	@Before
	public void setUp() throws Exception {
		room = new RoomExit();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInit() {
		assertNotNull(room);
		assertNotNull(room.getMap());
		ArrayList<Door> doors = room.getDoors();
		assertNotNull(doors);
		assertEquals(0, doors.size());
	}
	
	@Test
	public void testAddDoor() {
		Door door = new DoorSouth(new RoomTrap(), true);
		room.addDoor(door);
		ArrayList<Door> doors = room.getDoors();
		assertNotNull(doors);
		assertEquals(1, doors.size());
		assertEquals(door, doors.get(0));
	}

}