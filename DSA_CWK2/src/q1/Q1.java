/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q1;
import java.util.Scanner;
/**
 *
 * @author ruw12gbu
 */
public class Q1 
{
    static int[] testValues = new int[7];

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        System.out.println("Starting test run:");
        Scanner scan = new Scanner(System.in);
        Search search = new Search();
        testValues[0] = 4;
        testValues[1] = 5;
        testValues[2] = 110;
        testValues[3] = 6;
        testValues[4] = 12;
        testValues[5] = 111;
        testValues[6] = 401;
        
        System.out.println("Enter the size of the Matrix: ");
        int n = scan.nextInt();
        
        Matrix m = new Matrix(n);
        
        System.out.println(m.toString());
        
        for(int i = 0; i < testValues.length; i++)
        {
            if(search.findElementD(m, n, testValues[i]) == true)
            {
                System.out.println(testValues[i] + " found at coordinates "
                        + search.getFoundR() + ", " + search.getFoundC());
            }
            else
            {
                System.out.println(testValues[i] + " could not be found in the "
                        + "Matrix.");
            }
        }
        
        //Formatting
        System.out.println("-------------------------------------------------");
        m.rowOrder();
        
        System.out.println("\nRows ordered in Ascending Order: ");
        System.out.println(m.toString());
        
        for(int i = 0; i < testValues.length; i++)
        {
            if(search.findElementD1(m, n, testValues[i]) == true)
            {
                System.out.println(testValues[i] + " found at coordinates "
                        + search.getFoundR() + ", " + search.getFoundC());
            }
            else
            {
                System.out.println(testValues[i] + " could not be found in the"
                        + " Matrix");
            }
        }
        
        
        m.columnOrder();
        //Formatting
        System.out.println("-------------------------------------------------");
        
        System.out.println("\nColumns ordered in Asecnding Order: ");
        System.out.println(m.toString());
        
        for(int i = 0; i < testValues.length; i++)
        {
            if(search.findElementD2(m, n, testValues[i]) == true)
            {
                System.out.println(testValues[i] + " found at coordinates "
                        + search.getFoundR() + ", " + search.getFoundC());
            }
            else
            {
                System.out.println(testValues[i] + " could not be found in the"
                        + " Matrix");
            }
        }
    }
    
    public double[] timer()
    {
        double[] results = new double[3];
        //Record mean and std deviation of performing an operation reps times
        double sum = 0;
        double s = 0;
        double sumSquared = 0;
        for(int i = 0; i < 400; i++)
        {
            long t1 = System.nanoTime();
            //findElementCall
            long t2 = System.nanoTime() - t1;
            //Recording time in miliseconds to make it more interpratable
            sum += (double)t2/1000000.0;
            sumSquared += (t2/1000000.0) * (t2/1000000.0);
        }
        double mean = sum / 400;
        double variance = sumSquared / 400 - (mean * mean);
        double stdDev = Math.sqrt(variance);
        
        results[0] = mean;
        results[1] = variance;
        results[2] = stdDev;
        
        return results;
    }
}
