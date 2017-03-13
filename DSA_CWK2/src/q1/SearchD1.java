/*
 * Class:       SearchD1.java
 *
 * Author:      ruw12gbu, 100036248
 *
 * Description: This file holds the search algorithm for finding a given integer
 *              within a 2-D matrix object that has its individual rows sorted
 *              into ascending order. File also includes two class variables 
 *              that serve as coordinates for if the desired integer is found 
 *              within the matrix. Accessory methods (getFoundR() and 
 *              getFoundC()) are available in this class as well.
 * 
 * Version:     v1.0 - Created
 */
package q1;

/**
 * @author ruw12gbu, 100036248
 */
public class SearchD1 implements Search
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
    @Override
    public boolean findElement(Matrix A, int n, int p)
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
                        foundR = middle;
                        foundC = i;
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
}
