/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GApro;

import edu.neu.coe.info6205.life.base.Game;

/**
 *
 * @author wangbaichao
 */
public class Fitness {
    private double fitnessScore;
    private String gtfStr;
    private long generation;
    
    
    public Fitness(String gtfStr, int length, int endlength,long generation){
        this.gtfStr=gtfStr;
        Game game=new Game();
        this.generation = generation;
        if(generation>0){
          double rate = (endlength-length)*1.000/generation;  
          this.fitnessScore = rate;
        }
        else{
            this.fitnessScore = 0;
        }

    }

    public double getFitnessScore() {
        return fitnessScore;
    }

    public String getGtfStr() {
        return gtfStr;
    }

    public long getGeneration() {
    
        return generation;
    }
    
    
}
