/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GApro;

import io.jenetics.BitGene;
import io.jenetics.Genotype;
import io.jenetics.util.Factory;
import java.util.HashMap;

/**
 *
 * @author wangbaichao
 */
public class Population {
    private int populationSize;
    private HashMap<String,String> population ;

    public Population(int populationSize) {
        this.populationSize = populationSize;
        this.population= new HashMap<>();
        for(int i=0; i<populationSize;i++){
            //10 to 30
            int numberOfChromosome = (int) (Math.random()*20+10);
            GenoType genoType = new GenoType(numberOfChromosome);
            Factory<Genotype<BitGene>> gtf = genoType.getGtf();
            String gtfStr=genoType.getGtfStr(gtf);
            System.out.println("my pattern: "+genoType.getPetternStr(gtfStr));
            String patternStr = genoType.getPetternStr(gtfStr);
            this.population.put(gtfStr, patternStr);
        }
    }

    public int getPopulationSize() {
        return populationSize;
    }

    public HashMap<String, String> getPopulation() {
        return population;
    }
    
    
    
}
