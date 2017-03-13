/*
 * File:        Q1.java
 *
 * Author:      ruw12gbu, 100036248
 *
 * Description: Test driver for the Question 1 Algorithms. For testing purposes
 *              the Matrix constructor is limited to filling individual elements
 *              to 400.
 *
 * Version:     v1.0 - Created
 *              v2.0 - Added the timer() method
 */
package q1;

//Necessary imports
import java.util.Scanner;

/**
 * @author ruw12gbu, 100036248
 */
public class Q1 
{
    //Array to hold test values
    static int[] testValues = new int[7];

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        //Necessary variables and objects for testing
        System.out.println("Starting test run:");
        Scanner scan = new Scanner(System.in);
        Search search = new Search();
        testValues[0] = 4;
        testValues[1] = 5;
        testValues[2] = 110;
        testValues[3] = 6;
        testValues[4] = 12;
        testValues[5] = 111;
        testValues[6] = 401; //value that should always fail to be found
        
        //Prompt the user to set the size of the Square Matrix
        System.out.println("Enter the size of the Matrix: ");
        int n = scan.nextInt();
        
        //Create a Square Matrix of size n called m
        Matrix m = new Matrix(n);
        
        //Print out matrix to test custom toString() method
        System.out.println(m.toString());
        
        /*
         * Iterate over the test array, searching for each of the values one at 
         * a time and printing out their location within the array. 
         * Using findElementD()
         */
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
        
        /*
         * Order the rows of the matrix into ascending order (Columns are not 
         * ordered at this stage).
         */
        m.rowOrder();
        
        //Print out the ordered Matrix
        System.out.println("\nRows ordered in Ascending Order: ");
        System.out.println(m.toString());
        
        /*
         * Iterate over the test array, searching for each of the values one at 
         * a time and printing out their location within the array. 
         * Using findElementD1().
         */
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
        
        //Formatting
        System.out.println("-------------------------------------------------");
        
        /*
         * Order the columns of the matrix into Ascending Order, rows remain in 
         * ascending order.
         */
        m.columnOrder();
        System.out.println("\nColumns ordered in Asecnding Order: ");
        System.out.println(m.toString());
        
        /*
         * Iterate over the test array, searching for each of the values one at 
         * a time and printing out their location within the array. 
         * Using findElementD2().
         */
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
    
    /**
     * Method to record the times of each experiment run, whilst calculating the
     * mean, standard deviation and variance of the operation run times.
     * @return 
     */
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
