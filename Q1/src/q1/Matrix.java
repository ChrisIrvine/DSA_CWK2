/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q1;
import java.util.Random;

/**
 *
 * @author christopherirvine
 */
public class Matrix {
    
    private final Random random = new Random();
    private int size = 0;
    private final int[][] masterMatrix;
    
    /**
     * Constructor method that takes two integer parameters, one being the size 
     * of the matrix and the other being the test variable. The test variable
     * will be placed at a random location within the matrix.
     * @param n -> Size of Matrix
     */
    public Matrix(int n)
    {
        size = n;
        int[][] matrix = new int[n][n];
        for(int row = 0; row < n; row++)
        {
            for(int element = 0; element < n; element++)
            {
                matrix[row][element] = random.nextInt(400);
            }
        }
        
        int[] testArray = new int[6];
        testArray[0] = 4;
        testArray[1] = 12;
        testArray[2] = 110;
        testArray[3] = 5;
        testArray[4] = 6;
        testArray[5] = 111;
        
        for(int i = 0; i < testArray.length; i++)
        {
            //check to see if the test element already exist
            if(matrix[random.nextInt(n)][random.nextInt(n)] != testArray[0] 
                    || matrix[random.nextInt(n)][random.nextInt(n)] != 
                    testArray[1] || 
                    matrix[random.nextInt(n)][random.nextInt(n)] != 
                    testArray[2] || 
                    matrix[random.nextInt(n)][random.nextInt(n)] != 
                    testArray[3] || 
                    matrix[random.nextInt(n)][random.nextInt(n)] != 
                    testArray[4] || 
                    matrix[random.nextInt(n)][random.nextInt(n)] != 
                    testArray[5])
            {
                matrix[random.nextInt(n)][random.nextInt(n)] = testArray[i];
            }
        }
        
        masterMatrix = matrix;
    }
    
    public void rowOrder()
    {
        for(int i = 0; i < size; i++)
        {
            for(int j = 0; j < size; j++)
            {
                for(int k = j + 1; k < size; k++)
                {
                    if(masterMatrix[i][j] > masterMatrix[i][k])
                    {
                        int a = masterMatrix[i][j];
                        masterMatrix[i][j] = masterMatrix[i][k];
                        masterMatrix[i][k] = a;
                    }
                }
            }
        }
    }
    
    public void columnOrder()
    {
        for(int j = 0; j < size; j++)
        {
            for(int i = 0; i < size; i++)
            {
                for(int k = i + 1; k < size; k++)
                {
                    if(masterMatrix[i][j] > masterMatrix[k][j])
                    {
                        int a = masterMatrix[i][j];
                        masterMatrix[i][j] = masterMatrix[k][j];
                        masterMatrix[k][j] = a;
                    }
                }
            }
        }
    }
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Square Matrix of Size ");
        sb.append(size);
        sb.append(" contains the elements: \n");
        for(int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++) 
            {
                sb.append(masterMatrix[i][j]);
                sb.append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    
}
