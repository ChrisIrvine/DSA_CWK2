/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question2;

/**
 *
 * @author Christopher Irvine
 */
public class ArrayHashTable extends HashTable
{
    private final int CHAIN_SIZE = 5;
    private final Object[][] table;
    private final int[] counts;
    
    /**
     * Constructor for the ArrayHashTable.java class. This initialises a blank, 
     * chained hash table (array of arrays) and a counter array for the hash
     * table. Capacity is set to 10 as a constant.
     */
    public ArrayHashTable()
    {
        table = new Object[CAPACITY][];
        counts = new int[CAPACITY];
    }
    
    /**
     * Override method to add a given object to the Array Hash Table, table. The
     * method calculates the position and decides if the chain needs to be 
     * lengthened, initialised or if the object can simple be added to the 
     * chain.
     * @param obj - object to add to the Array Hash Table.
     * @return true if object added, false if object cannot be added
     */
    @Override
    public boolean add(Object obj) 
    {
        //Calculate position
        int position = getPosition(obj);
        
        //Test to see if the position is filled
        if(table[position] == null)
        {
            /*
             * If not filled, then initialise the chain with the default 
             * CHAIN_SIZE
             */
            table[position] = new Object[CHAIN_SIZE];
            //Add the object to the chain
            table[position][counts[position]] = obj;
            //Pre-increment the counter array, at the correct position
            ++counts[position];
            //Increment the size of the hashtable
            size++;
            //Break out of the if statement, returning true
            return true;
        }
        //If the position is filled but there is space in the chain...
        else if(counts[position] < table[position].length)
        {
            //Assign the position to the next available position in the chain
            table[position][counts[position]] = obj;
            //Adjust variables
            ++counts[position];
            size++;
            return true;
        }
        //Otherwise
        else
        {
            //Resize the chain (double the length)
            resizeChain(position);
            table[position][counts[position]] = obj;
            ++counts[position];
            size++;
            return true;
        }
    }

    /**
     * Searches a chain for a given object, if the chain is not initialised the 
     * element cannot be in the table, if a chain at the supposed position is 
     * present then the chain is iteratively searched. If the given object 
     * exists within the chain the method returns true, false if it does not 
     * exist.
     * @param obj - Object to check the Array Hash Table for
     * @return - returns true if found, false if not found. 
     */
    @Override
    public boolean contains(Object obj) 
    {
        //Calculate position for the object
        int position = getPosition(obj);
        
        //Check to see if a chain exists at that position
        if(table[position] == null)
        {
            //if not break out to return false
            return false;
        }
        //Otherwise
        else
        {
            //Iterate through the chain
            for (int i = 0; i < counts[position]; i++) 
            {
                //for each object, check to see if it object to look for
                if(table[position][i] == obj)
                {
                    //if it is the object to look for, break and return true.
                    return true;
                }
            }
        }
        //default return false
        return false;
    }

    /**
     * Override method to remove a given object from an Array Hash Table, by 
     * calculating the objects position, searching for it, and if found 
     * over-writing it with the last object in the chain
     * @param obj - Object to remove from the Array Hash Table
     * @return - true if removed correctly, false if not.
     */
    @Override
    public boolean remove(Object obj) 
    {
        //Calculate the position
        int position = getPosition(obj);
        
        //Itearte over the chain at the object's position
        for (int i = 0; i < counts[position]; i++) 
        {
            //Check each object in the chain, if it matches object to remove...
            if(table[position][i] == obj)
            {
                //Over-write that position with the last object in the chain
                table[position][i] = table[position][counts[position]-1];
                //Check to see if chain is needing shortened
                if(table[position].length < (table[position].length/2))
                {
                    shortenChain(position);
                }
                //Adjust variables
                --counts[position];
                size--;
                return true;
            }
        }
        //Default return is false
        return false;
    }
    
    /**
     * 
     * @param position 
     */
    public void resizeChain(int position)
    {
        //Create holder Array that is double the length of the chain
        Object[] holderArray = new Object[table[position].length*2];
        System.arraycopy(table[position], 0, holderArray, 0,
                table[position].length);
        table[position] = holderArray;
    }
    
    public void shortenChain(int position)
    {
        Object[] holderArray = new Object[table[position].length/2];
        System.arraycopy(table[position], 0, holderArray, 0, table[position].length);
        table[position] = holderArray;
    }
    
    /**
     * 
     * @param obj
     * @return 
     */
    public int getPosition(Object obj)
    {
        return (obj.hashCode() % table.length);
    }
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < CAPACITY; i++) 
        {
            for (int j = 0; j < counts[i]; j++) 
            {
                sb.append(table[i][j]);
                sb.append("\t");
            }
            sb.append("\n");
        }
        
        return sb.toString();
    }
}
