/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package compsec;

/**
 *
 * @author Siddharth1
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class MonoAlphSub {
     static char plain[]  = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
         'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
         'W', 'X', 'Y', 'Z' };
    static char key[] = { 'A', 'D', 'G', 'J', 'M', 'P', 'S', 'V', 'Y',
            'B', 'E', 'H', 'K', 'N', 'Q', 'T', 'W', 'Z', 'C', 'F', 'I', 'L',
            'O', 'R', 'U', 'X' };



    public static void main(String[] args) throws FileNotFoundException, IOException {
          String file1 = "harrypotter.txt";
        String test = new Scanner(new File(file1)).useDelimiter("\\Z").next();

File file2 = new File("EncrMono" + file1);

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
            for (int j = 0; j < 26; j++)
            {
                if (plain[j] == test.charAt(i))
                {
                    ciph[i] = key[j];
                     if (first == false)
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
