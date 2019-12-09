/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GATest;

import GApro.Fitness;
import GApro.GenoType;
import GApro.JeneticsAlgorithm;
import edu.neu.coe.info6205.life.base.Game;
import edu.neu.coe.info6205.life.library.Library;
import io.jenetics.BitChromosome;
import io.jenetics.BitGene;
import io.jenetics.Genotype;
import io.jenetics.util.Factory;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author mac
 */
public class FitnessTest {
    @Test
    public void testFitness1() {
        GenoType genotype = new GenoType(1);
        Genotype<BitGene> gtf = Genotype.of(BitChromosome.of(8,0.8), 5);
        double fitness = JeneticsAlgorithm.eval(gtf);
        System.out.println(fitness);
//        assertEquals(0, fitness);
    }
    
     @Test
    public void testFitness2() {
        GenoType genotype = new GenoType(1);
        Genotype<BitGene> gtf = Genotype.of(BitChromosome.of(8,0.5), 5);
        double fitness = JeneticsAlgorithm.eval(gtf);
        System.out.println(fitness);
//        assertEquals(0, fitness);
    }
    
    @Test
    public void testFitness3() {
        GenoType genotype = new GenoType(1);
        Genotype<BitGene> gtf = Genotype.of(BitChromosome.of(8,0.3), 5);
        double fitness = JeneticsAlgorithm.eval(gtf);
        System.out.println(fitness);
//        assertEquals(0, fitness);
    }
    
    @Test
		public void testFitness4() {
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
