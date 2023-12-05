public class MyIntList extends TestIntList implements IntList{

    private int[] intArray;
    private int totalNums = 0;
    private int newCapacity;


    public MyIntList(){
        intArray = new int[30];
    }
   
    /**
     * Adds a value to the end of the list.
     * 
     * @param value the value to add.
     */
   public void add(int value){
    /*
     * Use new array to resize and add values
     */
    resize();
    intArray[totalNums] = value;
    totalNums++;

    // int[] newIntArray = new int[newCapacity];

    // if (totalNums == (intArray.length)){
    //     for (int i = 0; i < intArray.length; i++){
    //         newIntArray[i] = intArray[i];
    //     }
    //     newIntArray[intArray.length] = value;
    //     intArray = newIntArray;
    // }
    //  else{
    //      intArray[totalNums] = value;
    // }
    // totalNums ++;
    }
   

    /**
     * Adds a value to the list at the specific list index.
     * 
     * @param index the index.
     * @param value the value to add.
     */
    public void add(int index, int value){

        /*
         * Use a new array to resize and add values when shifting values to the right of the given index
         * 
         */   
        resize();
        for (int i = 0; i < intArray.length; i++){
            if (i == index){
                if (index < totalNums){
                    for(int j = totalNums; j >= index; j--){
                        intArray[j + 1] = intArray[j];
                    }
                }
                intArray[index] = value;
            }
        }        
        totalNums++;
        /**
         * Old Code b
         */
        // resize();
        // int[] newIntArray = new int[newCapacity];

        // for (int i=0, j = 0; i < intArray.length; i++){
        //     if (i == index){
        //         newIntArray[i] = value;
        //     }
        //     else {
        //         newIntArray[i] = intArray[j++];
        //     }
        // }
        // totalNums++;
        // intArray = newIntArray;
        /**
         * End Old Code
         */
    }
    /**
     * Takes the size of the current array, and doubles it (if it is not 0), then copies the values from the original array into the new one. This allows the array to grow as needed when adding to it.
     */
    private void resize(){
        if (totalNums >= intArray.length){
            // newCapacity = intArray.length * 2;
            // if (intArray.length != 0){
            //     newCapacity = intArray.length * 2;
            // }
            // else{
            //     newCapacity = 1;
            // }
            /*
             * integrating new array to this method
             */
            int[] newIntArray = new int[intArray.length * 2];
            // int[] newIntArray = new int[newCapacity];
            for (int i = 0; i < intArray.length; i++){
                newIntArray[i] = intArray[i];
            }
            intArray = newIntArray;
        }
    }

    /**
     * Returns the value at the specified index.
     * 
     * @param index the index.
     * @return the value at the index.
     */
    public int get(int index){
        for (int i = 0; i < intArray.length; i++){
            if (i == index){
                return intArray[index];
            }
        }
        return intArray[index];
    }
    /**
     * Removes a value at the specified index.
     * 
     * @param index the index.
     * @return the value that was removed.
     */
    public int remove(int index){
        int numberRemoved = intArray[index];
        intArray[index] = 0;
        for (int i = index; i < totalNums-1; i++){
            intArray[i] = intArray[i + 1];
        }
        totalNums--;
        return numberRemoved;
    }

    /**
     * Returns the size of the list.
     * 
     * @return the size of the list.
     */
    @Override
    public int size(){
        return totalNums;
    }
    /**
     * Returns true if the list is empty, false otherwise.
     * 
     * @return true if the list is empty.
     */
    public boolean isEmpty(){
        if (totalNums == 0){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Makes the list empty.
     */
    public void clear(){
        totalNums = 0;
        //intArray = new int[0];
    }

    /**
     * Returns an int[] representation of the list.
     * Creates a new int[] called currentArray, that contains only the elements provided into intArray, and not its available capacity.
     * @return the list as an int[].
     */
    public int[] toArray(){
        int[] currentArray = new int[totalNums];
        for (int i = 0; i < totalNums; i++){
            currentArray[i] = intArray[i];
        }
        return currentArray;
    } 
    
}
