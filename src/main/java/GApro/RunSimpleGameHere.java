/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GApro;

import edu.neu.coe.info6205.life.base.Game;
import edu.neu.coe.info6205.life.base.Game.Behavior;
import static edu.neu.coe.info6205.life.base.Game.myRun;
//import static edu.neu.coe.info6205.life.base.Game.myRunWithoutPrint;
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
public class RunSimpleGameHere {
    
    private static int sizeOfPopulation = 20;
         
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
            
            Game game=new Game();
            Long generations = game.myRunWithoutPrint(pattern);
            
            Fitness fitness = new Fitness(pattern,genoType.length()/8,game.counted,generations);
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
        
        
        int top = 1;
        String top1Pettern = "";
        for(String genotype : sortedMap.keySet()){
            GenoType geno = new GenoType();
            top1Pettern = geno.getPetternStr(genotype);
            break;
        }
        
//        //run top one for a demo
        System.out.println("\n Here for top1 demo");
        Long demo = myRun(top1Pettern);
        
        //rank
        System.out.println("\n Here for rank");
        for(String genotype : sortedMap.keySet()){
            if(top <= 20){
                if(top == 1){
                    top1Pettern = genotype;
                }
                GenoType geno = new GenoType();
                String pattern = geno.getPetternStr(genotype);
                System.out.println("top "+top+" pattern is: "+pattern+"\nFitness Score is "+sortedMap.get(genotype));
                System.out.println("genoType is: "+genotype);
                top++;
            }
            
        }
        
//        String pos="0 2, 2 2, 3 3, 3 0, 1 -1, -3 0, 0 -2, 0 5, -2 0, 0 -3, -2 -2, 4 4, 0 0, 2 -2, 0 4, 2 0";
//        Game game=new Game();
//        Long generations = game.myRunWithoutPrint(pos);
//        int endlength = game.counted;
//        double rate = 0;
//        if(generations>0){
//          rate = (endlength-20)*1.000/generations;  
//        }
//        else{
//            rate=0;
//        }
//        System.out.println("Score:"+rate);
        

        
    }
    
}
