package scene;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import entitee.player.Player;

/**
 *
 * @author Mathieu
 */
public class SceneGameTest {
    SceneGame sg = new SceneGame(null);
    
    //Trap loseLife
    //win nextLevel/won
    //Playerisdead/state=gameover
    @Before
    public void createSituation(){
        Player.getInstance().init();
        SceneGame.setEventOfGame(SceneGame.EventGame.NONE);
    }
    
    //We want to test if the player loose life when falling in a trap and he have 3 life points (In other ways, we do not lost any life points because the amount is calculated like that : lifelost = maxLife/3
    @Test
    public void lifeIsLostWhenFallingIntoTrap() {
        float expected_final_life = 3f - (Player.getInstance().getMAX_LIFE()/3); //This is equivalent to expeted_final_life = 2
        SceneGame.setEventOfGame(SceneGame.EventGame.PLAYER_FALL_INTO_TRAP);
        sg.actionEventOfTheGame();
        assertEquals(expected_final_life, Player.getInstance().getLife() , 0.0001);
        
    }
    
    //We want to test if the level is changed when winning one
    @Test
    public void goToNewLevelWhenOneIsFinished() {
        //TODO because we can't access the level 
        SceneGame.setEventOfGame(SceneGame.EventGame.NONE);
        int first_level = sg.getLevel();
        SceneGame.setEventOfGame(SceneGame.EventGame.WIN_LEVEL);
        sg.actionEventOfTheGame();
        assertTrue(sg.getLevel() > first_level);
        
    }
    
    //We want to test if the Scene return to level 1 when the player is dead
    @Test
    public void stateIsGameOverWhenPlayerIsDead() {
        //Player.getInstance().loseLife(100);
        //TODO ::Same
        SceneGame.setEventOfGame(SceneGame.EventGame.NONE);
        SceneGame.setEventOfGame(SceneGame.EventGame.WIN_LEVEL);
        sg.actionEventOfTheGame();
        //Now the player is in the level 2
        assertEquals(sg.getLevel(), 2);
        SceneGame.setEventOfGame(SceneGame.EventGame.PLAYER_IS_DEAD);
        sg.actionEventOfTheGame(); //The level must be 1 again
        assertTrue(sg.getLevel() == 1);
    }
}
