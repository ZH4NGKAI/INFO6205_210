/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GApro;

/**
 *
 * @author wangbaichao
 */
public class Fitness {
    private double fitnessScore;
    private String gtfStr;
    private int generation;
    
    
    public Fitness(String gtfStr,int generation){
        this.gtfStr=gtfStr;
        this.generation = generation;
        this.fitnessScore = (double)generation/10000;
    }

    public double getFitnessScore() {
        return fitnessScore;
    }

    public String getGtfStr() {
        return gtfStr;
    }

    public int getGeneration() {
        return generation;
    }
    
    
}
