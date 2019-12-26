
package hanoi_hw;

import java.util.Scanner;
/**
 *
 * @author USER
 */
public class Hanoi_hw 
{


    private static int count;           // to keep track of rings moved    
    private static String indent = "";  // indentation for trace     
        public static void main(String[] args)    
        {
            while(true)
            {
                int nrRings = getInt("Input the number of rings: (or 0 to exit) ", 2, 10);
                if (nrRings == 0)
                {
                    break;
                }
                boolean traceOn = false; //getBool("Show Recusion Trace? ");
                System.out.println("Towers of Hanoi with " + nrRings + " rings\n");
                doTowers(nrRings, 1, 2, 3, traceOn); 
                System.out.println("Moves used to complete the tower: " + count);
                System.out.println("Towers of Hanoi with " + nrRings + " rings\n");
            }
        }

        /**     
        * doTowers - recursively solve the Tower of Hanoi puzzle     
        *     
        * @param nrRings - int: number of rings to use     
        * @param startPeg - int: peg on which the rings are stacked: 0, 1, or 2     
        * @param auxPeg - int: empty peg: 0, 1, or 2     
        * @param endPeg - int: peg into which the rings are to be transferred     
        * @param traceOn - boolean: display recursive calls or not     
        */    
        public static void doTowers(            
                int nrRings, // Number of rings to move            
                int startPeg, // Peg containing rings to move            
                int auxPeg, // Peg holding rings temporarily            
                int endPeg, // Peg receiving rings being moved            
                boolean traceOn)    // show recursion trace or not flag    
        {        
            if (nrRings > 0)        
            {
                if (traceOn)            
                {                
                    indent = indent + "  ";      
                    System.out.println(indent                        
                    + "Get " + nrRings                        
                    + " rings moved from peg " + startPeg                        
                    + " to peg " + endPeg);            
                }         
            // Move nrRings - 1 rings from starting peg to auxiliary peg            
            doTowers(nrRings - 1, startPeg, endPeg, auxPeg, traceOn);        

            // Move nth ring from starting peg to ending peg            
            //System.out.println(indent + "Move ring " + nrRings                    
            //        + " from peg " + startPeg                    
            //        + " to peg " + endPeg);            
            ++count;            

            // Move nrRings - 1 rings from auxiliary peg to ending peg            
            doTowers(nrRings - 1, auxPeg, startPeg, endPeg, traceOn);            
            if (traceOn)            
            {                
                indent = indent.substring(2);            
            }        
        }    
    }

    /**     
     * getInt - get integer input from the user     
     *     
     * @param lBound - int: minimal acceptible     
     * @param uBound - int: maximal acceptible     
     * @return int - user input     
     */    
    private static int getInt(int lBound, int uBound)    
    {        
        return getInt("Please enter an integer between ", lBound, uBound);    
    }    

    private static int getInt(String prompt, int lBound, int uBound)    
    {        
        int intRV = 0;        
        System.out.printf(prompt);        
        System.out.printf("between %d  and  %d\n",                
        lBound, uBound);        
        Scanner kbd = new Scanner(System.in);        
        String usrInput = "";        
        do        
        {            
            usrInput = kbd.nextLine();            
            try            
            {                
                intRV = Integer.parseInt(usrInput);      
                if (intRV == 0)
                {
                    break;
                }
                if (intRV < lBound || intRV > uBound)                
                {                    
                    System.out.println(usrInput + " is not a valid number");                
                }
            }
            catch (Exception ex)            
            {                
                System.out.println(usrInput + " is not a number");            
            }        
        }        
        while (lBound > intRV || uBound < intRV);        
        return intRV;    
    }

    /**     
    * getBool - get a yeah or nay response from the user     
    *     
    * @param prompt     
    * @return     
    */    
    public static boolean getBool(String prompt)    
    {        
        boolean blnRV = false;  // defaulting to false        
        Scanner kbd = new Scanner(System.in);        
        String usrInput = "";        
        System.out.println(prompt);        
        usrInput = kbd.nextLine();        
        char yY = usrInput.charAt(0);        
        blnRV = yY == 'y' || yY == 'Y';        
        return blnRV;    
    }
}

