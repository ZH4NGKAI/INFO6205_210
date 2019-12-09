/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GATest;

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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.junit.Test;

/**
 *
 * @author mac
 */
public class MutationTest {
    @Test
    public void testMutation(){
        GenoType genotype = new GenoType(1);
        Factory<Genotype<BitGene>> gtf = Genotype.of(BitChromosome.of(8,0.5), 10);
//        ExecutorService executor = Executors.newFixedThreadPool(8);
        Engine<BitGene, Double> engine
                    = Engine.builder(JeneticsAlgorithm::eval, gtf)
                            .offspringFraction(0.2)  
                            .populationSize(1)
//                            .selector()
                            .alterers(new Mutator<>(0.1), new SinglePointCrossover(0.1))
                            .build();

        Genotype<BitGene> result
                    = engine.stream()
                            .limit(Limits.bySteadyFitness(1000))
                            .collect(EvolutionResult.toBestGenotype());
        String pos=getStartingPattern(result);
        System.out.println("Best:"+result);
    }
}
