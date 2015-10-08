package donjon.room;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RoomTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertNotNull(Room.generateRoomById("1"));
		assertNotNull(Room.generateRoomById("2"));
		assertNotNull(Room.generateRoomById("3"));
		assertNotNull(Room.generateRoomById("4"));
	}

}
