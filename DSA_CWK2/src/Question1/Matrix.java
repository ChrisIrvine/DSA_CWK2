/*
 * File:       Matrix.java
 *
 * Author:      ruw12gbu, 100036248
 *
 * Description: This class constructs square matricies of a given size, then 
 *              fills each element with a random integer (of up to a given size)
 *              and will then ensure that given test values are in the matrix.
 *              Also contains; rowOrder() method - to order each row into 
 *              Ascending Order, columnOrder() method - to order each column 
 *              into Ascending Order. 
 *
 * Version:     v1.0 - created.
 */
package Question1;

//Necessary imports
import java.util.Random;

/**
 * @author ruw12gbu, 100036248
 */
public class Matrix 
{
    //Neccessary class variables and objects
    //Random object for number generation
    private final Random random = new Random();
    private final int ML; //integer to store the size of the matrix
    private final int[][] MATRIXT; //variable to store the matrix once created
    
    /**
     * Constructor Method that takes a single integer parameter, the size of the
     * square matrix. Matrix is filled with predominantly 0's, but the second 
     * last and last elements of each row is filled with a 1 and a 3 
     * respectively.
     * @param n 
     */
    public Matrix(int n)
    {
        int[][] matrix = new int[n][n];
        int[] filler = new int[n];
        ML = n;
        
        for (int i = 0; i < n; i++) 
        {
            filler[i] = 0;
        }
        
        filler[n-2] = 1;
        filler[n-1] = 3;
        //Itearte over the matrix, inserting random numbers at each position
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                matrix[i][j] = filler[i];
            }
        }
        MATRIXT = matrix;
    }
    
    /**
     * Accessor method that returns the size of the matrix.
     * @return 
     */
    public int getSize()
    {
        return ML;
    }
    
    /**
     * Accessor method that returns the integer stored at a given set of 
     * coordinates
     * @param row - row where element is located
     * @param column - column where element is located
     * @return 
     */
    public int getElement(int row, int column)
    {
        return MATRIXT[row][column];
    }
    
    /**
     * toString() override method that iterates through the matrix, printing 
     * each element out in a formatted output. 
     * @return 
     */
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        
        sb.append("The Matrix of size ");
        sb.append(ML);
        sb.append(" contains the following elements: \n");
        
        //Iterate through matrix
        for(int i = 0; i < ML; i++)
        {
            for(int j = 0; j < ML; j++)
            {
                sb.append(MATRIXT[i][j]);
                sb.append("\t");
            }
            sb.append("\n");
        }
        
        return sb.toString();
    }
}
