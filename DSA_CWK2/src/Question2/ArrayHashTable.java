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
     * 
     */
    public ArrayHashTable()
    {
        table = new Object[capacity][];
        counts = new int[capacity];
    }
    
    /**
     * 
     * @param obj
     * @return 
     */
    @Override
    public boolean add(Object obj) 
    {
        //Calculate position
        int position = getPosition(obj);
        
        //Test to see if the position is filled
        if(table[position] == null)
        {
            table[position] = new Object[CHAIN_SIZE];
            table[position][counts[position]] = obj;
            ++counts[position];
            return true;
        }
        else if(counts[position] < table[position].length)
        {
            table[position][counts[position]] = obj;
            ++counts[position];
            return true;
        }
        else
        {
            resizeChain(position);
            table[position][counts[position]] = obj;
            ++counts[position];
            return true;
        }
    }

    /**
     * Searches a chain for a given object; if the given object exists within 
     * the chain the method returns true, false if it does not exist.
     * @param obj
     * @return 
     */
    @Override
    public boolean contains(Object obj) 
    {
        int position = getPosition(obj);
        
        if(table[position] == null)
        {
            return false;
        }
        else
        {
            for (int i = 0; i < counts[position]; i++) 
            {
                if(table[position][i] == obj)
                {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 
     * @param obj
     * @return 
     */
    @Override
    public boolean remove(Object obj) 
    {
        int position = getPosition(obj);
        
        for (int i = 0; i < table[position].length; i++) 
        {
            if(table[position][i] == obj)
            {
                table[position][i] = table[position][counts[position]-1];
                --counts[position];
                return true;
            }
        }
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
        
        for (int i = 0; i < capacity; i++) 
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
