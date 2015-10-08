package object.potion;

import static org.junit.Assert.assertEquals;
import object.equipment.Clothes;
import object.equipment.Shield;

import org.junit.Before;
import org.junit.Test;

import entitee.player.Player;

/**
 *
 * @author Mathieu
 */
public class MediumPotionTest {
    MediumPotionLife potion;
    String expected_name;
    int expected_regen;
    float expectedFinalLife;
    
    @Before
    public void createSituation() {
        Player.getInstance().init();
        potion = new MediumPotionLife();
        expected_name = "medium potion life";
        expected_regen = 3;
    }
    
    //We want to test if the potion give the correct amount of health to the player
    @Test
    public void potionRegenLife() {
        Player.getInstance().setLife(1f);
        Player.getInstance().getInventory().setShield(new Shield());
        Player.getInstance().getInventory().setClothes(new Clothes());
        //Now the max health of the player is 7
        expectedFinalLife = Player.getInstance().getLife() + expected_regen;
        potion.action();
        assertEquals(Player.getInstance().getLife(), expectedFinalLife, 0.00001);
    }
    
    //We want to test if the health of the player does not go outside the health bounds
    @Test
    public void potionDoesNotRegenTooMuchLife() {
        expectedFinalLife = Player.getInstance().getMAX_LIFE();
        Player.getInstance().setLife(Player.getInstance().getMAX_LIFE());
        potion.action();
        assertEquals(expectedFinalLife, Player.getInstance().getLife(), 0.00001);
    }
}