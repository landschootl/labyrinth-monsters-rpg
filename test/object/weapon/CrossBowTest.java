package object.weapon;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import entitee.monster.Malloc;

/**
 *
 * @author Mathieu
 */
public class CrossBowTest {
    protected CrossBow weapon;
    String expected_name;
    int expected_damage, expected_speed;
    float expected_shoot_interval;
    
    @Before
    public void createWeapon() {
        weapon = new CrossBow();
        expected_name = "crossBow";
        expected_damage = 3;
        expected_speed = 200;
        expected_shoot_interval = 0.60f;
    }
    
    @Test
    public void weaponHasGoodValues() {
        // Weapon(Sprite sprite, String name, int damage, int speed, float intervalShoot){
        
        
        assertEquals(expected_name, weapon.getName());
        assertEquals(expected_damage, weapon.getDamage());
        assertEquals(expected_speed, weapon.getSpeed());
        assertTrue(expected_shoot_interval == weapon.getIntervalShoot()); //If we didn't used assertTrue, the test would fail because float cannot be a precise unit
    }
    
    //We want to test if the weapon do the correct amount of damages to the monster
    @Test
    public void weaponDealDamages() {
        //public Monster(String name, int SIZE_WIDTH, int SIZE_HEIGHT, int life, String pathSprite, int speed, int degat){
        Malloc test_monster = new Malloc(); // We used the Malloc monster because he has 10 life points, and we know how much this weapon deals damages, so we can expect a value for the monster's life
        float expected_life = test_monster.getLife()-expected_damage; // We evaluate how much life the monster should have in the end
        test_monster.loseLife(weapon.getDamage());
        //assertTrue((test_monster.getLife()-expected_damage) == test_monster.getLife());
        assertEquals(expected_life, test_monster.getLife(), 0.00001);
    }
}
