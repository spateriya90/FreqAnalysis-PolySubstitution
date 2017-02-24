/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package compsec;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.*;
import java.util.Set;

/**
 *
 * @author Siddharth1
 */
public class FrequencyAnalyser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        String file = "EncrMonoromeoandjuliet.txt";
        String test = new Scanner(new File(file)).useDelimiter("\\Z").next();

File file2 = new File("FreqAn" + file);
                
    			file2.createNewFile();
    		
                final FileWriter fileWritter2 = new FileWriter(file2.getName(),false);
    	        final BufferedWriter bw = new BufferedWriter(fileWritter2);
        //String test = "aaaabb";
test = test.toUpperCase();
test = test.replaceAll("\r", "");
test = test.replaceAll("(?>-?\\d+(?:[\\./]\\d+)?)", "");
test = test.trim().replaceAll("[\\p{Punct}]", "").replaceAll(" +", "").replaceAll("\\n", "");

int i = test.length();
Map m = findCharacterFrequency(test);

        System.out.println(test.length());
        System.out.println(test);
        //System.out.println(m.entrySet());


//System.out.println(m.values().to);

//}
        System.out.println(m.toString());

        System.out.println(test);

       bw.write("Number of characters: " + test.length());
       bw.newLine();
       bw.newLine();
       bw.write(m.toString());
       bw.newLine();
       bw.newLine();
       bw.write("String Used: \n" + test);
       bw.close();
    }

     private static Map<Character, Integer> findCharacterFrequency(String str) {

        Map<Character, Integer> map = new HashMap<>();

        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
      
        return map;
    }

    }


