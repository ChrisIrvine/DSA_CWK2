/*
 * Author:      ruw12gbu, 100036248
 *
 * File:        Q2.java
 * 
 * Description: Main class for the Question 2 package to run the testing for the
 *              ArrayHashTable and HashTable classes. Also contains a method 
 *              to save the output of the testing to a .csv file for 
 *              further analysis.
 * 
 * Version:     v1.0 - initial small scale testing
 *              v2.0 - full scale testing added
 *              v2.1 - writeCSVFile() method added
 */
package Question2;

import static Question1.Q1.writeCSVFile;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * @author ruw12gbu, 100036248
 */
public class Q2 
{
    public static void main(String[] args)
    {
        double[] resultsArray = new double[4];
        int[] n = {1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000,
            15000, 20000, 25000, 30000, 35000, 40000, 45000, 50000};
        double[][] resultsMatrix = new double[n.length][4]; 
        Random random = new Random();
        ArrayHashTable aHT = new ArrayHashTable();
        int sum = 0;
        int sumSquared = 0;
        
        for (int i = 0; i < n.length; i++) 
        {
            int[] testValues = new int[n[i]];
            
            for (int j = 0; j < testValues.length; j++) 
            {
                testValues[j] = Math.abs(random.nextInt());
            }
            
            for (int j = 0; j < 100; j++)
            {
                //Start test...
                long t1 = System.nanoTime();

                for (int k = 0; k < testValues.length; k++) 
                {
                    aHT.add(testValues[k]);
                }
                for (int k = 0; k < testValues.length; k++) 
                {
                    aHT.remove(testValues[k]);
                }

                //End test...
                long t2 = System.nanoTime() - t1;
            
                sum += (double)t2/1000000.0;
                sumSquared += (t2/1000000.0) * (t2/1000000.0);
            }
            
            //Calculate Mean
            double mean = sum / 100;
            //Calculate Variance
            double variance = sumSquared / 100 - (mean * mean);
            //Calculate Standard Deviation
            double stdDev = Math.sqrt(variance);
            
            resultsArray[0] = n[i];
            resultsArray[1] = mean;
            resultsArray[2] = variance;
            resultsArray[3] = stdDev;

            //Add the test results to the results matrix
            for(int j = 0; j < 4; j++)
            {
                resultsMatrix[i][j] = resultsArray[j];
            }   
        }
        //Parse data into csv file
        String fileNameD = "Q2_Testing.csv";
        writeCSVFile(fileNameD, resultsMatrix, n.length, 
                resultsArray.length);
        
    }
    
    public static void writeCSVFile(String fileName, double[][] resultsMatrix, 
            int rows, int columns)
    {
        File csvFile = new File(fileName);
        
        try(BufferedWriter bW = new BufferedWriter(new FileWriter(csvFile)))
        {
            bW.write("\n");
            for(int i = 0; i < rows; i++)
            {
                for(int j = 0; j < columns; j++)
                {
                    bW.write(String.format("\"%f\",", resultsMatrix[i][j]));
                }
                bW.write("\n");//now do next row
            }           
        }
        catch(IOException ioex)
        {
            ioex.printStackTrace();
        }
    }
}
