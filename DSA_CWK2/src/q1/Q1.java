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
 *              v3.0 - Reworked entire project to be procedural, elminated all 
 *              additional classes apart from Matrix.java
 */
package q1;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author ruw12gbu, 100036248
 */
public class Q1 
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        //Necessary Objects and variables
        double[] resultsArray = new double[4];
        double[][] resultsMatrix = new double[22][4];
        int[] size = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 200, 300,
                            400, 500, 600, 700, 800, 900, 1000, 2000, 3000, 
                            4000};
        int reps = 10;
        
        //Start Test...
        for(int n = 0; n < size.length; n++)
        {       
            //Record mean and std deviation of performing an operation reps 
            //times
            Matrix m = new Matrix(size[n]);
            double sum = 0;
            double sumSquared = 0;
            for (int k = 0; k < reps; k++)
            {
                long t1 = System.nanoTime();
                findElementD(m, m.getSize(), 2147483647);
                long   t2 = System.nanoTime() - t1;
                //Recording time in miliseconds to make it more interpratable
                sum += (double)t2/1000000.0;
                sumSquared += (t2/1000000.0) * (t2/1000000.0);
            }
            double mean = sum / reps;
            double variance = sumSquared / reps - (mean * mean);
            double stdDev = Math.sqrt(variance);

            resultsArray[0] = size[n] * size[n];
            resultsArray[1] = mean;
            resultsArray[2] = variance;
            resultsArray[3] = stdDev;

            for(int j = 0; j < 4; j++)
            {
                resultsMatrix[n][j] = resultsArray[j];
            }
        }
        String fileNameD = "testD.csv";
        writeCSVFile(fileNameD, resultsMatrix, size.length, 
                resultsArray.length);
        
        System.out.println("Test 1 Done");
        
        for(int n = 0; n < size.length; n++)
        {       
            //Record mean and std deviation of performing an operation reps 
            //times
            Matrix m = new Matrix(size[n]);
            m.rowOrder();
            double sum = 0;
            double sumSquared = 0;
            for (int k = 0; k < reps; k++)
            {
                long t1 = System.nanoTime();
                findElementD1(m, m.getSize(), 2147483647);
                long   t2 = System.nanoTime() - t1;
                //Recording time in miliseconds to make it more interpratable
                sum += (double)t2/1000000.0;
                sumSquared += (t2/1000000.0) * (t2/1000000.0);
            }
            double mean = sum / reps;
            double variance = sumSquared / reps - (mean * mean);
            double stdDev = Math.sqrt(variance);

            resultsArray[0] = size[n] * size[n];
            resultsArray[1] = mean;
            resultsArray[2] = variance;
            resultsArray[3] = stdDev;

            for(int j = 0; j < 4; j++)
            {
                resultsMatrix[n][j] = resultsArray[j];
            }
        }
        String fileNameD1 = "testD1.csv";
        writeCSVFile(fileNameD1, resultsMatrix, size.length, 
                resultsArray.length);
        
        System.out.println("Test 2 Done");
        
        for(int n = 0; n < size.length; n++)
        {       
            //Record mean and std deviation of performing an operation reps 
            //times
            Matrix m = new Matrix(size[n]);
            m.rowOrder();
            m.columnOrder();
            double sum = 0;
            double sumSquared = 0;
            for (int k = 0; k < reps; k++)
            {
                long t1 = System.nanoTime();
                findElementD2(m, m.getSize(), 2147483647);
                long t2 = System.nanoTime() - t1;
                //Recording time in miliseconds to make it more interpratable
                sum += (double)t2/1000000.0;
                sumSquared += (t2/1000000.0) * (t2/1000000.0);
            }
            double mean = sum / reps;
            double variance = sumSquared / reps - (mean * mean);
            double stdDev = Math.sqrt(variance);

            resultsArray[0] = size[n] * size[n];
            resultsArray[1] = mean;
            resultsArray[2] = variance;
            resultsArray[3] = stdDev;

            for(int j = 0; j < 4; j++)
            {
                resultsMatrix[n][j] = resultsArray[j];
            }
        }
        String fileNameD2 = "testD2.csv";
        writeCSVFile(fileNameD2, resultsMatrix, size.length, 
                resultsArray.length);
        
        System.out.println("Test 3 Done");
        
    }
    
    /**
     * Quadratic time search algorithm to search for a given integer, p, in an 
     * unordered 2-D Matrix object. The algorithm searches through each
     * individual element of the matrix is order until p is found. Worst-case 
     * scenario run-time is O(n^2). 
     * @param A - the matrix to search through
     * @param n - integer size of the matrix, A
     * @param p - integer to search the matrix, A, for
     * @return - boolean value; true if p is found, false if p cannot be found.
     */
    public static boolean findElementD(Matrix A, int n, int p)
    {
        //search through each row
        for(int i = 0; i < A.getSize(); i++)
        {
            //search through each element in that row
            for(int j = 0; j < A.getSize(); j++)
            {
                //if the selected element equals p
                if(A.getElement(i, j) == p)
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Logarithmic time search algorithm to search for a given integer, p, in a
     * 2-D matrix object where the rows have been ordered in ascending order 
     * (but not the columns). The algorithm takes the first and last elements 
     * of a row and checks if p can exist between them. If it can the algorithm 
     * then binary searches that row for p. If it cannot exist between the first
     * and last elements OR cannot be found in the row, the algorithm moves onto
     * the next row. Worst-case run time is O(n(log(n))).
     * @param A - the matrix to search through
     * @param n - integer size of the matrix, A
     * @param p - integer to search the matrix, A, for
     * @return - boolean value; true if p is found, false if not
     */
    public static boolean findElementD1(Matrix A, int n, int p)
    {
        //For every row in the matrix
        for(int i = 0; i < A.getSize(); i++)
        {
            /*
             * If p can exist between the first and last elements of selected 
             * row then binary search, if not then move onto the next row.
             */
            if(A.getElement(i, 0) <= p && A.getElement(i, n-1) >= p)
            {
                //variables for binary search
                int low = 0; //first position in row
                int high = n-1; //last position in row
                
                //whilst high is greater than or equal to low
                while(high >= low)
                {
                    //the middle position of the row
                    int middle = (low + high) / 2;
                    
                    //if the middle value equals p then return true
                    if(A.getElement(i, middle) == p)
                    {
                        return true;
                    }
                    //else if the middle value is less than p then...
                    else if(A.getElement(i, middle) < p)
                    {
                        //refine search to top half of the row
                        low = middle + 1;
                    }
                    //otherwise
                    else
                    {
                        //refine search to the lower half of the row
                        high = middle - 1;
                    }
                }
            }
        }
        return false;
    }
    
    /**
     * Linear time search algorithm to search for a given integer, p, in a 
     * 2-D matrix object where both rows and columns are ordered in ascending
     * order, but the whole matrix is not in ascending order. This algorithm 
     * uses the step search method, as detailed below. Worst-case run-time is
     * O(n).
     * @param A - the matrix to search through
     * @param n - integer size of the matrix
     * @param p - integer to search through the matrix, A, for
     * @return - boolean value; true if p is found, false if not.
     */
    public static boolean findElementD2(Matrix A, int n, int p)
    {
        int row = n-1; //row value, starting at the last row
        int column = 0; //column value, starting at the first column
        //value of the currently selected element
        int currentElement = A.getElement(row, column);
        
        //While currentElement is not p, and within the boundaries of the matrix
        while(currentElement != p && row != -1 && column != n)
        {
            //if currentElement is p then break out of the loop
            if(currentElement == p)
            {
                break;
            }
            /*
             * else if, currentElement is less than p then try to go to the next
             * column in the matrix
             */
            else if (currentElement < p)
            {
                //check not about to go out of bounds
                if(column != n-1)
                {
                    //next column
                    column += 1;
                }
                //if about to go out of bounds then break, p is not in here
                else
                {
                    break;
                }
            }
            //otherwise, attempt to go to the previous row in the matrix
            else
            {
                //check not about to go out of bounds
                if(row != 0)
                {
                    //go to previous row
                    row -= 1;
                }
                //if about to go out of bounds then break, p is not in here
                else
                {
                    break;
                }
            }
            //update the current element
            currentElement = A.getElement(row, column);
        }
        
        //if p has been found then update the class coordinates
        if(currentElement == p)
        {
            return true;
        }
        return false;
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
