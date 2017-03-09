/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q1;
import java.util.Random;

/**
 *
 * @author Christopher Irvine
 */
public class Matrix 
{
    private Random random = new Random();
    private final int ML;
    private int[][] matrixT;
    
    public Matrix(int n)
    {
        int[][] matrix = new int[n][n];
        ML = n;
        
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                matrix[i][j] = random.nextInt(401);
            }
        }
        
        int[] testArray = new int[6];
        testArray[0] = 4;
        testArray[1] = 12;
        testArray[2] = 110;
        testArray[3] = 5;
        testArray[4] = 6;
        testArray[5] = 111;
        
            
            for(int j = 0; j < testArray.length; j++)
            {
                int temp1 = random.nextInt(n);
                int temp2 = random.nextInt(n);
                
                if(matrix[temp1][temp2] != testArray[j])
                {
                    matrix[temp1][temp2] = testArray[j];
                }
            }
            
        
        matrixT = matrix;
    }
    
    public int getSize()
    {
        return ML;
    }
    
    public int getElement(int row, int column)
    {
        return matrixT[row][column];
    }
    
    public void columnOrder()
    {
        for(int i = 0; i < ML; i++)
        {
            for(int j = 0; j < ML; j++)
            {
                for(int k = 0; k < ML; k++)
                {
                    if(matrixT[i][j] < matrixT[k][j])
                    {
                        int tempHold = matrixT[i][j];
                        matrixT[i][j] = matrixT[k][j];
                        matrixT[k][j] = tempHold;
                    }
                }
            }
        }
    }
    
    public void rowOrder()
    {
        for(int i = 0; i < ML; i++)
        {
            for(int j = 0; j < ML; j++)
            {
                for(int k = 0; k < ML; k++)
                {
                    if(matrixT[i][j] < matrixT[i][k])
                    {
                        int tempHold = matrixT[i][j];
                        matrixT[i][j] = matrixT[i][k];
                        matrixT[i][k] = tempHold;
                    }
                }
            }
        }
    }
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        
        sb.append("The Matrix of size ");
        sb.append(ML);
        sb.append(" contains the following elements: \n");
        for(int i = 0; i < ML; i++)
        {
            for(int j = 0; j < ML; j++)
            {
                sb.append(matrixT[i][j]);
                sb.append("\t");
            }
            sb.append("\n");
        }
        
        return sb.toString();
    }
}
