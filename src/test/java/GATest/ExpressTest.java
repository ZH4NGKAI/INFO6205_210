/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GATest;

import GApro.GenoType;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author mac
 */
public class ExpressTest {
    @Test
    public void testExpress1() {
        GenoType genoType = new GenoType(1);
        String gtfStr = "00000000";
        String pattern = GenoType.getPetternStr(gtfStr);
//        System.out.println(pattern);
        assertEquals("-5 5", pattern);
    }
    @Test
    public void testExpress2() {
        GenoType genoType = new GenoType(1);
        String gtfStr = "11111111";
        String pattern = GenoType.getPetternStr(gtfStr);
//        System.out.println(pattern);
        assertEquals("0 0", pattern);
    }
    
    @Test
    public void testExpress3() {
        GenoType genoType = new GenoType(1);
        String gtfStr = "10101010";
        String pattern = GenoType.getPetternStr(gtfStr);
//        System.out.println(pattern);
        assertEquals("2 2", pattern);
    }
    
    @Test
    public void testExpress4() {
        GenoType genoType = new GenoType(1);
        String gtfStr = "11000011";
        String pattern = GenoType.getPetternStr(gtfStr);
//        System.out.println(pattern);
        assertEquals("3 -3", pattern);
    }
}
