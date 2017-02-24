/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package compsec;

import java.io.File;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Siddharth1
 */
public class PolySub {

  static char plain[]  = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
         'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
         'W', 'X', 'Y', 'Z' };
    static char keyodd[] = { 'A', 'D', 'G', 'J', 'M', 'P', 'S', 'V', 'Y',
            'B', 'E', 'H', 'K', 'N', 'Q', 'T', 'W', 'Z', 'C', 'F', 'I', 'L',
            'O', 'R', 'U', 'X' };
 static char keyeven[] = { 'N', 'S', 'X', 'C', 'H', 'M', 'R', 'W', 'B',
            'G', 'L', 'Q', 'V', 'A', 'F', 'K', 'P', 'U', 'Z', 'E', 'J', 'O',
            'T', 'Y', 'D', 'I' };

    public static void main(String[] args) throws FileNotFoundException, IOException {
                 String file1 = "harrypotter.txt";
        String test = new Scanner(new File(file1)).useDelimiter("\\Z").next();

File file2 = new File("EncrPoly" + file1);

    			file2.createNewFile();

                final FileWriter fileWritter2 = new FileWriter(file2.getName(),false);
    	        final BufferedWriter bw = new BufferedWriter(fileWritter2);

        test = test.toUpperCase();
test = test.replaceAll("(?>-?\\d+(?:[\\./]\\d+)?)", "");
test = test.replaceAll("\r", "");
test = test.trim().replaceAll("[\\p{Punct}]", "").replaceAll(" +", "").replaceAll("\\n", "");
String res = null;
boolean first = false;
 char[] ciph = new char[(test.length())];
        for (int i = 0; i < test.length(); i++)
        {
            boolean odd = false;
            boolean even = false;
           
             if(i%2 == 0)           
                odd = true;
            if (i%2 == 1)
                even = true;
            for (int j = 0; j < 26; j++)
            {
                if (plain[j] == test.charAt(i))
                {
                    if (odd == true)
                    ciph[i] = keyodd[j];
                    if (even == true)
                     ciph[i] = keyeven[j];

            //            res = new Stringchar.tciph[i];
                    break;

                }
            }
        }
res = String.valueOf(ciph);
        System.out.println(ciph);
 bw.write(res);
 bw.flush();
 bw.close();

    }

    }




