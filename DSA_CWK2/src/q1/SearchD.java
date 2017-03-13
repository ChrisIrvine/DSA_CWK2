/*
 * Class:       SearchD.java
 *
 * Author:      ruw12gbu, 100036248
 *
 * Description: This file holds the search algorithm for finding a given integer
 *              within an unordered 2-D matrix object. File also includes two 
 *              class variables that serve as coordinates for if the desired 
 *              integer is found within the matrix. Accessory methods 
 *              (getFoundR() and getFoundC()) are available in this class as 
 *              well.
 * 
 * Version:     v1.0 - Created
 *              v1.1 - findElementD1 adjusted to be faster
 *              v1.2 - findElementD2 adjusted to be faster
 *              v2.0 - Edited to be Factory Friendly
 */
package q1;

/**
 * @author ruw12gbu, 10036248
 */
public class SearchD implements Search
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
     * Quadratic time search algorithm to search for a given integer, p, in an 
     * unordered 2-D Matrix object. The algorithm searches through each
     * individual element of the matrix is order until p is found. Worst-case 
     * scenario run-time is O(n^2). 
     * @param A - the matrix to search through
     * @param n - integer size of the matrix, A
     * @param p - integer to search the matrix, A, for
     * @return - boolean value; true if p is found, false if p cannot be found.
     */
    @Override
    public boolean findElement(Matrix A, int n, int p)
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
                    //Save the coordinates of the found element
                    foundR = i;
                    foundC = j;
                    return true;
                }
            }
        }
        return false;
    }
}
