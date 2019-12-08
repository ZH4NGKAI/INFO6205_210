
package GApro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.jenetics.BitChromosome;
import io.jenetics.BitGene;
import io.jenetics.Genotype;
import io.jenetics.engine.Engine;
import io.jenetics.engine.EvolutionResult;
import io.jenetics.util.Factory;
import java.util.List;
import java.util.Random;

public class GenoType{
    private int numberOfChromosome;
    private static HashMap<String,String> directionMap;
    private static Factory<Genotype<BitGene>> gtf;
    //private String petternStr;
    private String gftStr;
    
    public GenoType(int numberOfChromosome){
        this.numberOfChromosome=numberOfChromosome;
        Factory<Genotype<BitGene>> gtf =
            Genotype.of(BitChromosome.of(8,0.5),numberOfChromosome);
        this.gtf = gtf;

        String gtfStr = gtf.toString();
	Pattern p = Pattern.compile("[^0-9]");  
	Matcher m = p.matcher(gtfStr);
	gtfStr = (m.replaceAll("").trim()).toString();
        this.gftStr = gtfStr;
        
        //generate direction map       
        this.directionMap = new HashMap<>();
        //left up
        directionMap.put("000", "-1+1");
        //up 
        directionMap.put("001", "+0+1");
        //right up
        directionMap.put("010", "+1+1");
        //right
        directionMap.put("100", "+1+0");
        //right down 
        directionMap.put("011", "+1-1");
        //down
        directionMap.put("101", "+0-1");
        //left down
        directionMap.put("110", "-1-1");
        //left
        directionMap.put("111", "-1+0");

    }
    
    public GenoType(){
        //generate direction map       
        this.directionMap = new HashMap<>();
        //left up
        directionMap.put("000", "-1+1");
        //up 
        directionMap.put("001", "+0+1");
        //right up
        directionMap.put("010", "+1+1");
        //right
        directionMap.put("100", "+1+0");
        //right down 
        directionMap.put("011", "+1-1");
        //down
        directionMap.put("101", "+0-1");
        //left down
        directionMap.put("110", "-1-1");
        //left
        directionMap.put("111", "-1+0");
    }
    
    public static String getGtfStr(Factory<Genotype<BitGene>> gtf){
        // remove ",[]" from gtf
        String gtfStr = gtf.toString();
	Pattern p = Pattern.compile("[^0-9]");  
	Matcher m = p.matcher(gtfStr);
	gtfStr = (m.replaceAll("").trim()).toString();
        return gtfStr;
    }
    
    //gene expression (from gnee to pattern)
    public static String getPetternStr(String gtfStr) {
        //generate pattern String
        String patternStr = "";
        //String gtfStr = this.gftStr;
        List<String> dup = new ArrayList<>();
        while(gtfStr.length()>0){
            //transform gtf to point
            String thisChromosome = gtfStr.substring(0,8);
            //first 5 for step
            String stepStr = thisChromosome.substring(0,5);
            //laster 3 for direction
            String directionStr = thisChromosome.substring(5,8);
            int stepCount = 0;
        
            //count steps
            for(char s :stepStr.toCharArray()){
                if(Character.toString(s).equals("0")){
                    stepCount++;
                }
            }
        
            //generate x and y
            String direction = directionMap.get(directionStr);
            String dir1 = direction.substring(0,2);
            String dir2 = direction.substring(2,4);
            int x = stepCount*Integer.parseInt(dir1);
            int y = stepCount*Integer.parseInt(dir2);


            //position of this cell
            String thisCell =  "";
            thisCell=thisCell.concat(Integer.toString(x)).concat(" ").concat(Integer.toString(y));
            gtfStr=gtfStr.substring(8);
            if(!dup.contains(thisCell)){
                dup.add(thisCell);
            }
            else{
                continue;
            }
            patternStr=patternStr.concat(thisCell);
                      
            if(gtfStr.length()>0) patternStr=patternStr.concat(", ");
             
        }
        return patternStr;
    }



    public Factory<Genotype<BitGene>> getGtf() {
        return gtf;
    }
    
    
    
	
}
