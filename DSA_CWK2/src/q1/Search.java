/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q1;

/**
 *
 * @author Christopher Irvine
 */
public class Search 
{
    private int foundR = 0;
    private int foundC = 0;
    
    public int getFoundR()
    {
        return foundR;
    }
    
    public int getFoundC()
    {
        return foundC;
    }
    
    public boolean findElementD(Matrix A, int n, int p)
    {
        for(int i = 0; i < A.getSize(); i++)
        {
            for(int j = 0; j < A.getSize(); j++)
            {
                if(A.getElement(i, j) == p)
                {
                    foundR = i;
                    foundC = j;
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean findElementD1(Matrix A, int n, int p)
    {
        for(int i = 0; i < A.getSize(); i++)
        {
            if(A.getElement(i, 0) <= p && A.getElement(i, n-1) >= p)
            {
                //System.out.println("\nStarting binary search");
                int low = 0;
                int high = n-1;
                
                while(high >= low)
                {
                    int middle = (low + high) / 2;
                    if(A.getElement(i, middle) == p)
                    {
                        foundR = middle;
                        foundC = i;
                        return true;
                    }
                    else if(A.getElement(i, middle) < p)
                    {
                        low = middle + 1;
                    }
                    else
                    {
                        high = middle - 1;
                    }
                }
            }
        }
        return false;
    }
    
    public boolean findElementD2(Matrix A, int n, int p)
    {
        int row = n-1;
        int column = 0;
        int currentElement = A.getElement(row, column);
        while(currentElement != p && row != -1 && column != n)
        {
            if(currentElement == p)
            {
                break;
            }
            else if (currentElement < p)
            {
                if(column != n-1)
                {
                    column += 1;
                }
                else
                {
                    break;
                }
            }
            else
            {
                if(row != 0)
                {
                    row -= 1;
                }
                else
                {
                    break;
                }
            }
            currentElement = A.getElement(row, column);
        }
        
        if(currentElement == p)
        {
            foundR = row;
            foundC = column;
            return true;
        }
        return false;
    }
}
