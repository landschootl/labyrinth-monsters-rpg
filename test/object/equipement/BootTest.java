package object.equipement;

import object.equipment.Boot;

import org.junit.Before;

import entitee.player.Player;

/**
 *
 * @author Mathieu
 */
public class BootTest {
    int expected_bonus;
    Boot bonus;
    
    
    @Before
    public void createSituation() {
        Player.getInstance().init();
        bonus = new Boot();
        expected_bonus = bonus.getBonus();
    }
   
}
