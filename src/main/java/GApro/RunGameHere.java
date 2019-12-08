/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GApro;

import edu.neu.coe.info6205.life.base.Game;
import static edu.neu.coe.info6205.life.base.Game.myRun;

/**
 *
 * @author wangbaichao
 */
public class RunGameHere {
    public static void main(String[] args) {
        
        GenoType genoType = new GenoType(20);                            
	System.out.println("Game of Life with starting pattern: " + "ourPattern");
        String gtfStr = genoType.getGftStr();
        System.out.println("my pattern: "+genoType.getPetternStr(gtfStr));
        final String pattern = genoType.getPetternStr(gtfStr);
        Long generations = myRun(pattern);
	System.out.println("Ending Game of Life after " + generations + " generations");
    
    }
    
}
