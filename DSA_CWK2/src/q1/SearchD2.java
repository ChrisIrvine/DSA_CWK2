/*
 * Class:       SearchD2.java
 *
 * Author:      ruw12gbu, 100036248
 *
 * Description: This file holds the search algorithm for finding a given integer
 *              within a 2-D matrix object that has its individual rows sorted
 *              into ascending order and its individual columns sorted into 
 *              asecnding order. File also includes two class variables that 
 *              serve as coordinates for if the desired integer is found within
 *              the matrix. Accessory methods (getFoundR() and getFoundC()) are
 *              available in this class as well.
 * 
 * Version:     v1.0 - Created
 */
package q1;

/**
 *
 * @author Christopher Irvine
 */
public class SearchD2 implements Search
{
    //Class Variables
    private int foundR = 0;
    private int foundC = 0;
    
    /**
     * Accessor method that returns a single integer from the class variable, 
     * foundR, that represents the row in which the search integer (p) is found.
     * @return 
     */
    @Override
    public int getFoundR()
    {
        return foundR;
    }
    
    /**
     * Accessor method that returns a single integer from the class variable, 
     * foundC, that represents the column in which the search integer (c) is
     * found.
     * @return 
     */
    @Override
    public int getFoundC()
    {
        return foundC;
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
    @Override
    public boolean findElement(Matrix A, int n, int p)
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
            foundR = row;
            foundC = column;
            return true;
        }
        return false;
    }
}
