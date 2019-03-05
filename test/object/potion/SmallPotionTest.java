package object.potion;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import entitee.player.Player;

/**
 *
 * @author Mathieu
 */
public class SmallPotionTest {
    SmallPotionLife potion;
    String expected_name;
    int expected_regen;
    float expectedFinalLife;
    
    @Before
    public void createSituation() {
        Player.getInstance().init();
        potion = new SmallPotionLife();
        expected_name = "small potion life";
        expected_regen = 1;
    }
    
    //We want to test if the potion give the correct amount of health to the player
    @Test
    public void potionRegenLife() {
        Player.getInstance().setLife(1f);
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