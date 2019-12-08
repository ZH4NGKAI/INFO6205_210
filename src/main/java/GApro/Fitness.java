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
    private long fitnessScore;
    private String gtfStr;
    private long generation;
    
    
    public Fitness(String gtfStr){
        this.gtfStr=gtfStr;
        Game game=new Game();
        this.generation = Game.myRunWithoutPrint(gtfStr);
        this.fitnessScore = generation;
    
    }

    public long getFitnessScore() {
        return fitnessScore;
    }

    public String getGtfStr() {
        return gtfStr;
    }

    public long getGeneration() {
    
        return generation;
    }
    
    
}
