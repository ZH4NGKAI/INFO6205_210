/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GApro;

import java.util.HashMap;

/**
 *
 * @author wangbaichao
 */
public class Population {
    private int populationSize;
    private HashMap<String,String> population;

    public Population(int populationSize) {
        this.populationSize = populationSize;
        for(int i=0; i<populationSize;i++){
            GenoType genoType = new GenoType(20);
            String gtfStr = genoType.getGftStr();
            String patternStr = genoType.getPetternStr(gtfStr);
            this.population = new HashMap<>();
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
