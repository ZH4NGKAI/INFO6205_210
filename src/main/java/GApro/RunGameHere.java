/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GApro;

import edu.neu.coe.info6205.life.base.Game;
import edu.neu.coe.info6205.life.base.Game.Behavior;
import static edu.neu.coe.info6205.life.base.Game.myRun;
import static edu.neu.coe.info6205.life.base.Game.myRunWithoutPrint;
import io.jenetics.BitGene;
import io.jenetics.EliteSelector;
import io.jenetics.Genotype;
import io.jenetics.Mutator;
import io.jenetics.Optimize;
import io.jenetics.engine.Engine;
import io.jenetics.engine.EvolutionResult;
import io.jenetics.util.Factory;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author wangbaichao
 */
public class RunGameHere {
    
    private static int sizeOfPopulation = 10;
         
    public static void main(String[] args) {
        
        //generate a population
        Population population = new Population(sizeOfPopulation);
        HashMap<String,String> patternMap = population.getPopulation();
        HashMap<String,Double> scoreMap = new HashMap<>();
        //System.out.println(patternMap);
        int genoTypeNo = 1;
       
        for(String genoType : patternMap.keySet()){
            System.out.println("Now running the No. "+genoTypeNo+" Genotype ... please wait");
            String pattern = patternMap.get(genoType);
            
            Long generations = myRunWithoutPrint(pattern);
            
            Fitness fitness = new Fitness(pattern,generations);
            double fitnessScore = fitness.getFitnessScore();
            scoreMap.put(genoType,fitnessScore);
            genoTypeNo++;
        }
        //System.out.println(scoreMap);
        
        //sort by score
        Map<String,Double> sortedMap = scoreMap.entrySet()
              .stream()
              .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
               .collect(Collectors
                          .toMap(Map.Entry::getKey,
                                 Map.Entry::getValue,
                                 (e1, e2) -> e1,
                                 LinkedHashMap::new));

        
        //top 5
        int top = 1;
        for(String pattern : sortedMap.keySet()){
            if(top <= 10){
                System.out.println("top "+top+" genoType is: "+pattern+"\nFitness Score is "+sortedMap.get(pattern));
                top++;
            }
        }



        
    }
    
}
