/**
 * A simple list data structure that holds int values.
 */
public interface IntList {

    /**
     * Adds a value to the end of the list.
     * 
     * @param value the value to add.
     */
    void add(int value);

    /**
     * Adds a value to the list at the specific list index.
     * 
     * @param index the index.
     * @param value the value to add.
     */
    void add(int index, int value);

    /**
     * Returns the value at the specified index.
     * 
     * @param index the index.
     * @return the value at the index.
     */
    int get(int index);

    /**
     * Removes a value at the specified index.
     * 
     * @param index the index.
     * @return the value that was removed.
     */
    int remove(int index);

    /**
     * Returns the size of the list.
     * 
     * @return the size of the list.
     */
    int size();

    /**
     * Returns true if the list is empty, false otherwise.
     * 
     * @return true if the list is empty.
     */
    boolean isEmpty();

    /**
     * Makes the list empty.
     */
    void clear();

    /**
     * Returns an int[] representation of the list.
     * 
     * @return the list as an int[].
     */
    int[] toArray();  
}