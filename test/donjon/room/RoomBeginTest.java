package donjon.room;

import static org.junit.Assert.*;

import java.util.ArrayList;

import object.Key;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import donjon.door.Door;
import donjon.door.DoorSouth;
import entitee.monster.Monster;
import entitee.monster.Runner;

public class RoomBeginTest {
	RoomBegin room;
	Door door;
	Monster monster;

	@Before
	public void setUp() throws Exception {
		room = new RoomBegin();
		door = new DoorSouth(new RoomTrap(), true);
		monster = new Runner();
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
	
	@Test
	public void testAddMonster() {
		room.addMonster(monster);
		ArrayList<Monster> monsters = room.getMonsters();
		assertEquals(1, monsters.size());
		assertEquals(monster, monsters.get(0));
	}
	
	@Test
	public void testRemoveMonster() {
		room.removeMonster(monster);
		assertEquals(0, room.getMonsters().size());
	}
	
	@Test
	public void testPickUpObject() {
		object.Object object = new Key();
		room.getObjects().add(object);
		room.pickUpObject(object);
		assertEquals(0, room.getObjects().size());
	}

}
