package object.equipement;
import static org.junit.Assert.assertEquals;
import object.equipment.Helmet;
import object.potion.LargePotionLife;

import org.junit.Before;
import org.junit.Test;

import entitee.player.Player;
/**
 *
 * @author Mathieu
 */
public class HelmetTest {
    int expected_bonus;
    Helmet bonus;
    
    
    @Before
    public void createSituation() {
        Player.getInstance().init();
        bonus = new Helmet();
        expected_bonus = bonus.getBonus();
    }
    
    //We want to test if the bonus add the correct amount it has to add
    @Test
    public void bonusAddCorrectAmount() {
        LargePotionLife potion = new LargePotionLife();
        float expected_max_life = Player.getInstance().getMAX_LIFE() + bonus.getBonus();
        bonus.pickUp();
        potion.action();
        assertEquals(expected_max_life, Player.getInstance().getLife(), 0.00001); //We simulate the use of a potion te get the life at his maximum state
    }
    
    
    //We want to test if only the maximum life of he player is affected (The current amount of life he have does not have to be higher
    @Test
    public void bonusAddOnlyMaxLfe() {
        float expected_life = Player.getInstance().getLife();
        bonus.pickUp();
        //assertEquals(Player.getInstance().getMAX_LIFE(), 4.0, 0.00001);
        assertEquals(expected_life, Player.getInstance().getLife(), 0.00001); //We simulate the use of a potion te get the life at his maximum state
    }
}