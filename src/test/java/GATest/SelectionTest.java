/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GATest;

import GApro.Fitness;
import GApro.GenoType;
import GApro.JeneticsAlgorithm;
import static GApro.JeneticsAlgorithm.getStartingPattern;
import io.jenetics.BitChromosome;
import io.jenetics.BitGene;
import io.jenetics.Genotype;
import io.jenetics.Mutator;
import io.jenetics.RouletteWheelSelector;
import io.jenetics.SinglePointCrossover;
import io.jenetics.TournamentSelector;
import io.jenetics.engine.Engine;
import io.jenetics.engine.EvolutionResult;
import io.jenetics.engine.Limits;
import io.jenetics.util.Factory;
import org.junit.Test;

/**
 *
 * @author mac
 */
public class SelectionTest {
    @Test
    public void testSelection(){
        GenoType genotype = new GenoType(1);
        Factory<Genotype<BitGene>> gtf = Genotype.of(BitChromosome.of(8,0.5), 5);
//        ExecutorService executor = Executors.newFixedThreadPool(8);
        Engine<BitGene, Long> engine
                    = Engine.builder(JeneticsAlgorithm::eval, gtf)
//                            .offspringFraction(0.3)  
//                            .survivorsFraction(0)
                            .populationSize(5)
                            .survivorsSelector(new TournamentSelector<>(2))
                            .offspringSelector(new TournamentSelector<>(2))
//                            .alterers(new Mutator<>(0.1), new SinglePointCrossover(0.1))
                            .build();

        Genotype<BitGene> result
                    = engine.stream()
                            .limit(Limits.bySteadyFitness(1000))
                            .collect(EvolutionResult.toBestGenotype());
        String pos=getStartingPattern(result);
        
        
        System.out.println("Best:"+pos);
        System.out.println("Generation:" + new Fitness(pos).getGeneration());
    }
}
