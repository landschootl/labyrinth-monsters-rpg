package object.equipement;

import static org.junit.Assert.assertTrue;
import object.equipment.Boot;

import org.junit.Before;
import org.junit.Test;

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
    
    //We want to test if the velocity of the player is correctlu increased by the adding of boots in inventory
    @Test
    public void bonusAddVelocityToPlayer(){
        int expected_speed = Player.getInstance().getSpeed() + bonus.getBonus();
        bonus.pickUp();
        assertTrue(Player.getInstance().getSpeed() == expected_speed);
    }
}
