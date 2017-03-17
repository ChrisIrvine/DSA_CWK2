/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author Christopher Irvine
 */
public class Q2 
{
    public static void main(String[] args)
    {
        //int[] n = {1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000,
        //    15000, 20000, 25000, 30000, 35000, 40000, 45000, 50000};
        Random random = new Random();
        ArrayHashTable aHT = new ArrayHashTable();
        
        int[] testValues = new int[100];
        for (int i = 0; i < testValues.length; i++) 
        {
            testValues[i] = Math.abs(random.nextInt());
        }
        
        for (int i = 0; i < testValues.length; i++) 
        {
            aHT.add(testValues[i]);
        }
        
        System.out.println(aHT.toString());
        
        for (int i = 0; i < testValues.length; i++)
        {
            aHT.remove(testValues[i]);
        }
        
//        for (int i = 0; i < n.length; i++) 
//        {
//            int[] testValues = new int[n[i]];
//            for (int j = 0; j < testValues.length; j++) 
//            {
//                testValues[j] = Math.abs(random.nextInt());
//            }
//            
//            //Start test...
//            long t1 = System.nanoTime();
//            for (int j = 0; j < testValues.length; j++) 
//            {
//                aHT.add(testValues[j]);
//            }
//            for (int j = 0; j < testValues.length; j++) 
//            {
//                aHT.remove(testValues[j]);
//            }
//            //End test...
//            long t2 = System.nanoTime() - t1;
//            
//            System.out.println(t2);
//        }
        
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
