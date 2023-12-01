public class MyIntList extends TestIntList implements IntList{

    int[] intArray = new int[30];
    int index;
    int numBooks; // This variable keeps track of the number of items in the array; while the items are integers, referring to them as books helps me conceptually understand how to add/remove them.


    public MyIntList(){
        intArray = new int[30];
    }
   
    /**
     * Adds a value to the end of the list.
     * 
     * @param value the value to add.
     */
   public void add(int value){
        intArray[intArray.length -1] = value;
        numBooks += 1;
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
        numBooks +=1;
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
           // System.out.println("Integer Value at index [" + index + "]: " + i);
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

        for (int indexNum = 0; indexNum < intArray.length-1; indexNum++){
            if (indexNum == index){
                intArray[indexNum] = intArray[intArray.length - 1];
                numBooks--;
            }
        }
        return get(index);
    }

    /**
     * Returns the size of the list.
     * 
     * @return the size of the list.
     */
    @Override
    public int size(){
        //numOfInts = currentIndex
        int currentIndex = 0;
        currentIndex = numBooks;
        return numBooks;
        // int value;
        // for (int i = 0; i < intArray.length - 1; i++){
        //     //resize bookshelf (if needed)
        //     //
        //     //this.add(value){ 
        //     intArray[currentIndex] = value;
        //     currentIndex ++;
        // }
    }
        // System.out.println("Current size of intArray: "+ size + " integers.");
        // int indexCount = 0;
        // for (int i : intArray){
        //     indexCount ++;
        //     index = indexCount;
        // }
        // System.out.println("Capacity of intArray: " + index);
        // return index;
    //}
    /**
     * Returns true if the list is empty, false otherwise.
     * 
     * @return true if the list is empty.
     */
    public boolean isEmpty(){
        if (numBooks == 0){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Makes the list empty.
     */
    @Override
    public void clear(){
        numBooks = 0;
        // for (int indexNum = 0; indexNum < intArray.length-1; indexNum++){
        //     remove(indexNum);
        //     System.out.println(numBooks);
        //     numBooks --;
        // }
    }

    /**
     * Returns an int[] representation of the list.
     * 
     * @return the list as an int[].
     */
    public int[] toArray(){

    } 
    
}
