/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GATest;

import GApro.Fitness;
import edu.neu.coe.info6205.life.base.Game;
import edu.neu.coe.info6205.life.library.Library;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author mac
 */
public class FitnessTest {
    @Test
    public void testFitness1() {
        String patternName = "Blip";
        System.out.println("Game of Life with starting pattern: " + patternName);
        final String pattern = Library.get(patternName);
        Fitness fitness = new Fitness(pattern);
	assertEquals(0, fitness.getFitnessScore());
    }
    
    @Test
		public void testFitness2() {
				String patternName = "Blinker";
				System.out.println("Game of Life with starting pattern: " + patternName);
				final String pattern = Library.get(patternName);
				Fitness fitness = new Fitness(pattern);
                                Game game=new Game();
                                long generation = Game.myRunWithoutPrint(pattern);
                                //double rate = game.growthRate();
                                long result = generation;
				assertEquals(result, fitness.getFitnessScore());
		}
}
