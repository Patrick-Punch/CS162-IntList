public class MyIntList extends TestIntList implements IntList{

    int[] intArray = new int[30];
    int index;


    public MyIntList(){
        intArray = new int[30];
    }
   
    /**
     * Adds a value to the end of the list.
     * 
     * @param value the value to add.
     */
   public void add(int value){
        intArray[size()-1] = value;
   }

    /**
     * Adds a value to the list at the specific list index.
     * 
     * @param index the index.
     * @param value the value to add.
     */
    public void add(int index, int value){
        //index = this.index;
        intArray[index] = value;
    }

    /**
     * Returns the value at the specified index.
     * 
     * @param index the index.
     * @return the value at the index.
     */
    public int get(int index){
        int indexCount = 0;
        for (int i : intArray){
            if (indexCount != index){
                indexCount += 1;
            }
            else {
            System.out.println("Integer Value at index [" + index + "]: " + i);
            return i;
            }
        }
        return this.index;
    }

    /**
     * Removes a value at the specified index.
     * 
     * @param index the index.
     * @return the value that was removed.
     */
    public int remove(int index){
        this.get(index);

    }

    /**
     * Returns the size of the list.
     * 
     * @return the size of the list.
     */
    @Override
    public int size(){
        int size = intArray.length;
        return size;
        // System.out.println("Current size of intArray: "+ size + " integers.");
        // int indexCount = 0;
        // for (int i : intArray){
        //     indexCount ++;
        //     index = indexCount;
        // }
        // System.out.println("Capacity of intArray: " + index);
        // return index;
    }
    /**
     * Returns true if the list is empty, false otherwise.
     * 
     * @return true if the list is empty.
     */
    public boolean isEmpty(){

    }

    /**
     * Makes the list empty.
     */
    public void clear(){

    }

    /**
     * Returns an int[] representation of the list.
     * 
     * @return the list as an int[].
     */
    public int[] toArray(){

    } 
    
}
