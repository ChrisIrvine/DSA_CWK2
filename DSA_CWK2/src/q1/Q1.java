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
import java.util.Scanner;

/**
 * @author ruw12gbu, 100036248
 */
public class Q1 
{
    //Array to hold matrix sizes
    static int[] size = new int [22];
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        CSVFileWriter csv = new CSVFileWriter();
        SearchFactory searchF = new SearchFactory();
        Search search = new SearchD();
        boolean valid = false;
        double[] resultsArray = new double[4];
        double[][] resultsMatrix = new double[22][4];
        int[] size = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 200, 300,
                            400, 500, 600, 700, 800, 900, 1000, 2000, 3000, 
                            4000};
        
        System.out.println("What algorithm would you like to test?");
        System.out.println("Your options are the following:");
        System.out.println("'D' = search an unordered matrix");
        System.out.println("'D1' = search a matrix with ordered rows "
                + "(ascending order)");
        System.out.println("'D2' = search a matrix with ordered rows and "
                + "columns (ascending order)");
        System.out.println("Enter your choice now...");
        String choice = scan.next();
        try
        {
            search = searchF.chooseSearch(choice);
        }
        catch(Exception e)
        {
            System.out.println("Please enter either D, D1, D2");
        }
       
        System.out.println("Enter the number of reps the test to take:");
        int reps = scan.nextInt();
        //Start Test...
        for(int n = 0; n < size.length; n++)
        {       
            System.out.println("running test" + n);
            //Record mean and std deviation of performing an operation reps 
            //times
            Matrix m = new Matrix(size[n]);
            if(null != choice)
            switch (choice) 
            {
                case "D1":
                    m.rowOrder();
                    break;
                case "D2":
                    m.rowOrder();
                    m.columnOrder();
                    break;
                default:
                    break;
            }
            double sum = 0;
            double sumSquared = 0;
            for (int k = 0; k < reps; k++)
            {
                long t1 = System.nanoTime();
                search.findElement(m, m.getSize(), 2147483647);
                long   t2 = System.nanoTime() - t1;
                //Recording time in miliseconds to make it more interpratable
                sum += (double)t2/1000000.0;
                sumSquared += (t2/1000000.0) * (t2/1000000.0);
            }
            double mean = sum / reps;
            double variance = sumSquared / reps - (mean * mean);
            double stdDev = Math.sqrt(variance);

            resultsArray[0] = size[n];
            resultsArray[1] = mean;
            resultsArray[2] = variance;
            resultsArray[3] = stdDev;

            for(int j = 0; j < 4; j++)
            {
                System.out.println("adding to matrix");
                resultsMatrix[n][j] = resultsArray[j];
            }
        }
        System.out.println("Enter the name of the File you want to create: ");
        String fileName = scan.next();
        csv.writeCSVFile(fileName, resultsMatrix, size.length, 
                resultsArray.length);
    }
}
