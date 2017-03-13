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
package q1;

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
     * square matrix. Matrix is filled with preset test variables and randomly
     * generated variables.
     * @param n 
     */
    public Matrix(int n)
    {
        int[][] matrix = new int[n][n];
        ML = n;
        
        //Itearte over the matrix, inserting random numbers at each position
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                matrix[i][j] = random.nextInt(2147483646);
            }
        }
        
        //add the test elements to the test array
        int[] testArray = new int[6];
        testArray[0] = 4;
        testArray[1] = 12;
        testArray[2] = 110;
        testArray[3] = 5;
        testArray[4] = 6;
        testArray[5] = 111;
        
        //Iterate over the matrix, adding the test values at random locations 
        for(int j = 0; j < testArray.length; j++)
        {
            //generate random coordinates within the array
            int temp1 = random.nextInt(n);
            int temp2 = random.nextInt(n);

            //check that the test element does not already exist at position
            if(matrix[temp1][temp2] != testArray[j])
            {
                matrix[temp1][temp2] = testArray[j];
            }
        }
        
        //store matrix within class varialbe
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
     * Method to sort each column into Ascending Order.
     */
    public void columnOrder()
    {
        //For loops to iterate through Matrix
        for(int i = 0; i < ML; i++)
        {
            for(int j = 0; j < ML; j++)
            {
                for(int k = 0; k < ML; k++)
                {
                    //Checks if the first element is lower than the next
                    if(MATRIXT[i][j] < MATRIXT[k][j])
                    {
                        int tempHold = MATRIXT[i][j];
                        MATRIXT[i][j] = MATRIXT[k][j];
                        MATRIXT[k][j] = tempHold;
                    }
                }
            }
        }
    }
    
    /**
     * Method to sort each row into Ascending order.
     */
    public void rowOrder()
    {
        //For loops to iterate through Matrix
        for(int i = 0; i < ML; i++)
        {
            for(int j = 0; j < ML; j++)
            {
                for(int k = 0; k < ML; k++)
                {
                    //Checks if the first element is lower than the next
                    if(MATRIXT[i][j] < MATRIXT[i][k])
                    {
                        int tempHold = MATRIXT[i][j];
                        MATRIXT[i][j] = MATRIXT[i][k];
                        MATRIXT[i][k] = tempHold;
                    }
                }
            }
        }
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
