import java.util.Arrays;
public class MyIntList extends TestIntList implements SortableIntList{

    private int[] intArray;
    private int totalNums = 0;

    public MyIntList(){
        intArray = new int[30];
    }
    /**
     * Adds a value to the end of the list.
     * 
     * @param value the value to add.
     */

     /*
      * TODO: throw new exceptions where necessary
      */
    public void add(int value){
    resize();
    intArray[totalNums] = value;
    totalNums++;
    }
    /**
     * Adds a value to the list at the specific list index.
     * 
     * @param index the index.
     * @param value the value to add.
     */
    public void add(int index, int value){
        resize();
            for (int i = totalNums; i >= index; i--){
                intArray[i + 1] = intArray[i];
            }
        intArray[index] = value;
        totalNums++;
    }
    /**
     * Takes the size of the current array, and doubles it (if it is not 0), then copies the values from the original array into the new one. This allows the array to grow as needed when adding to it.
     */
    private void resize(){
        if (totalNums >= intArray.length){
            int[] newIntArray = new int[intArray.length * 2];
            for (int i = 0; i < intArray.length; i++){
                newIntArray[i] = intArray[i];
            }
            intArray = newIntArray;
        }
    }
    /**
     * Returns the value at the specified index.
     * @param index the index.
     * @return the value at the index.
     */
    public int get(int index){
        return intArray[index];
    }
    /**
     * Removes a value at the specified index.
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
    /**
     * Returns a string representaion of the array
     * @return the list as a String
     */
    public String toString(){
        return Arrays.toString(toArray());
    }
    /**
     * Sorts the list using the specified sort algorithm.
     * 
     * @param type the sort algorithm to use.
     */
    //might need to swap Algorithm to SortableIntList.Algorithm
    public void sort(Algorithm type){
        switch (type) {
            case SELECTION:
            /*
             * call algorithm method here
             * selectionSort();
             */
                break;
            case INSERTION:
            /*
             * insertionSort();
             */
                break;
            case MERGE: 
            /*
             * mergeSort();
             */
                break;
            case QUICK:
            /*
             * quickSort();
             */
                break;
            case HEAP:
            /*
             * heapSort();
             */
                break;
        }
    }
    public void getAlgorithm(){
    }
}