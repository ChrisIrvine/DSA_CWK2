/*
 * File:        HashTable.java
 *
 * Author:      abj & ruw12gbu, 100036248
 *
 * Description: Hash Table interface for the DS&A labs, week 1, semester 2. Note
 *              the emphasis here is to get you to implement the algorithms, not
 *              write fancy code (although feel free to do so! There are 
 *              exercises for Programming 2 to engineer it more.
 * 
 * Version:     v1.0 - Created
 */
package Question2;

/**
 *
 * @author ajb & ruw12gbu, 100036248
 */
public abstract class HashTable
{
    private static final int DEFAULT_CAPACITY = 10;
    protected int capacity;
    protected int size;
    
    public HashTable()
    {
        capacity = DEFAULT_CAPACITY;
        size = 0; 
    }
    
    /**
     * Returns the size of the Hash Table.
     * @return 
     */
    public int size()
    { 
       return size;
    }
    
    /**
     * Adds the specified element to this hash table if it is not already present 
     * 
     * @param obj
     * @return true if the element is successfully added
     */    
    abstract boolean add(Object obj);
    
    /**
     * 
     * @param obj
     * @return  true if this hash table contains the specified element
     */    
    abstract boolean contains(Object obj);
    
    /**
     * 
     * @param obj
     * @return Removes the specified element from this set if it is present 
     */
    abstract  boolean remove(Object obj);  
}
