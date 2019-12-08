/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GApro;

import edu.neu.coe.info6205.life.base.Game;
import edu.neu.coe.info6205.life.base.Game.Behavior;
import edu.neu.coe.info6205.life.base.Point;
import io.jenetics.BitChromosome;
import io.jenetics.BitGene;
import io.jenetics.EliteSelector;
import io.jenetics.Genotype;
import io.jenetics.IntegerChromosome;
import io.jenetics.Mutator;
import io.jenetics.engine.Engine;
import io.jenetics.engine.EvolutionResult;
import io.jenetics.util.Factory;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author mac
 */
public class GA {
    private static int run;
    public static long eval(Genotype<BitGene> gt) {
        String gtS = gt.toString();
        Pattern p = Pattern.compile("[^0-9]");  
	Matcher m = p.matcher(gtS);
	gtS = (m.replaceAll("").trim()).toString();
        String gtStr = GenoType.getPetternStr(gtS);

        Game game=new Game();
        Long generations = Game.myRun(gtStr);

        run++;
        return generations;
    }
    
    public static void main(String[] args) {
        GenoType genotype = new GenoType(1);
        Factory<Genotype<BitGene>> gtf = Genotype.of(BitChromosome.of(8,0.5), 20);
        ExecutorService executor = Executors.newFixedThreadPool(7);
        Engine<BitGene, Long> engine
                    = Engine.builder(GA::eval, gtf)
                            .offspringFraction(0.7)
                            .populationSize(10)
                            .selector(new EliteSelector<>(5))
                            .alterers(new Mutator<>(0.05))
                            .executor(executor)
                            .build();

        Genotype<BitGene> result
                    = engine.stream()
                            .limit(10)
                            .collect(EvolutionResult.toBestGenotype());
            
        System.out.println("RUN:     "+run);



        String pos=getStartingPattern(result);
        System.out.println("Best:"+result);
    }
    
    public static String getStartingPattern(Genotype<BitGene> result){

       String gtS = result.toString();
        Pattern p = Pattern.compile("[^0-9]");  
	Matcher m = p.matcher(gtS);
	gtS = (m.replaceAll("").trim()).toString();
        String gtStr = GenoType.getPetternStr(gtS);
       return gtStr;
    }
}
