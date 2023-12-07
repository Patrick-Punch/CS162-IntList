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
    public void sort(Algorithm type){
        switch (type) {
            case SELECTION:
            selectionSort();
                break;
            case INSERTION:
            insertionSort();
                break;
            case MERGE: 
            mergeSort();
                break;
            case QUICK:
            quickSort();
                break;
            case HEAP:
            heapSort();
                break;
        }
    }
    /**
     * A method that implements a Selection Sort Algortithm
     */
    private void selectionSort(){
        for (int i = 0; i < totalNums - 1; i++){
            int min = i; // index position is current min
            for (int j = i + 1; j < totalNums; j++){
                if (intArray[j] < intArray[min]){ //if compared value is less than current min, compared value becomes min
                    min = j;
                }
            }
            int temp = intArray[i]; 
            intArray[i] = intArray[min]; // swap minimum value with original value in list, continue for each index
            intArray[min] = temp;
        }
    }
    /**
     * A method that implements a Insertion Sort Algortithm
     */
    private void insertionSort(){
        for (int i = 1; i < totalNums; i++){ //start at 1 and compare to the value before it
            int temp = intArray[i]; // current value at the index
            while (i > 0 && temp < intArray[i - 1]){ // if the value at the index is less than than the index before it, swap the values
                intArray[i] = intArray[i - 1];
                i--; // move the index down, so the new order can be tested at the previous index
            }
            intArray[i] = temp; 
        }
    }
    /**
     * A method that implements a Merge Sort Algortithm
     */
    private void mergeSort(){
        int [] sortedArray = new int[totalNums];
        mergeSortHelper(intArray, 0, totalNums-1, sortedArray);
    }
    /**
     * A method that recursively splits the array to be sorted into subarrays, and then calls merge() to combine them
     * @param intArray - the array to sort
     * @param start index[0] of intArrray
     * @param end the array index at totalNums-1
     * @param sortedArray - a new array to place the sorted values into 
     */
    private void mergeSortHelper(int[] intArray, int start, int end, int[] sortedArray){
        if (start < end){
            int arrayCenter = (start + end) / 2; 
            int centerLeft = arrayCenter;
            int centerRight = arrayCenter + 1;
            mergeSortHelper(intArray, start, centerLeft, sortedArray); // Recursive call left side
            mergeSortHelper(intArray, centerRight, end, sortedArray); // Recursive call right side
            merge(intArray, start, arrayCenter, end, sortedArray); //sort + combine 
        }
    }
    /**
     * a method that merges two arrays, and sorts the elements within to a new, sorted array 
     * @param intArray - array to be sorted 
     * @param start at index 0
     * @param arrayCenter - the center of the array
     * @param end at the last index to be sorted
     * @param sortedArray - the sorted array
     */
    private void merge(int[] intArray, int start, int arrayCenter, int end, int[] sortedArray){
        int leftIndex = start;
        int rightIndex = arrayCenter + 1;
        int sortedIndex = start;

        while (leftIndex <= arrayCenter && rightIndex <= end){ //merge left and right side arrays
            if (intArray[leftIndex] < intArray[rightIndex]){
                sortedArray[sortedIndex] = intArray[leftIndex];
                leftIndex++;
            }else {
                sortedArray[sortedIndex] = intArray[rightIndex];
                rightIndex++;
            }
            sortedIndex++;
        }
        while (leftIndex <= arrayCenter){ //merge elements from the left 
            sortedArray[sortedIndex] = intArray[leftIndex];
            leftIndex++;
            sortedIndex++;
        }
        while (rightIndex <= end){ //merge elements from the right 
            sortedArray[sortedIndex] = intArray[rightIndex];
            rightIndex++;
            sortedIndex++;
        }
        for (sortedIndex = start; sortedIndex <= end; sortedIndex++){ //copy values to original array
            intArray[sortedIndex] = sortedArray[sortedIndex];
        }
    }
    /**
     * A method that implements a Quick Sort Algortithm by defining a pivot point. Then it sorts the pivot point value to its proper point in the array. Then, it takes all the elements less than it, and all the elements greater than it, treating them as subarrays, and sorts them recursively.
     */
    private void quickSort(){
        quickSortHelper(0, totalNums-1);
    }
    /**
     * A method that loops through an array and recursivley splits and sorts the array
     * @param start at index 0
     * @param end at the last index to be sorted
     */
    private void quickSortHelper(int start, int end){
        if (start < end){ //base case for recursion
            int partitionIndex = partition(start, end);
            quickSortHelper(start, partitionIndex - 1);
            quickSortHelper(partitionIndex + 1, end);
        }
    }
    /**
     * The partition method takes a pivot point to its sorted poition, and then sorting the two subarrays on the sides of the pivot
     * @param start at index 0
     * @param end at the last index to be sorted
     * @return the partition index
     */
    private int partition(int start, int end){
        int pivot = intArray[end]; //Initial pivot point at the end of the array
        int partitionIndex = (start - 1);

        for (int i = start; i < end; i++){//if the value to the right is smaller than the pivot, swap them
            if (intArray[i] <= pivot){
                partitionIndex++; 
                int swapTemp = intArray[partitionIndex];
                intArray[partitionIndex] = intArray[i];
                intArray[i] = swapTemp;
            }
        } //once the pivot is sorted, sort the element at the next index
        int swapTemp = intArray[partitionIndex + 1]; 
        intArray[partitionIndex + 1] = intArray[end];
        intArray[end] = swapTemp;
        return partitionIndex + 1;
    }
    /**
     * A method that implements a Heap Sort Algortithm by creating a binary tree (heap) representation of the array, setting the root value to its sorted index and then sorting the remaining heap until all elements are in the sorted array.
     */
    private void heapSort(){
 
        for (int i = ((totalNums / 2) - 1); i >= 0; i--){ 
            heapify(intArray, totalNums, i); //make a heap (tree)
        }
 
        for (int i = totalNums - 1; i > 0; i--){ //pull elements from heap
            int temp = intArray[0]; //move root to the end
            intArray[0] = intArray[i];
            intArray[i] = temp;
            heapify(intArray, i, 0); //heapify the smaller tree
        }
    }
    /**
     * A method that creates a binary tree representation (heap) of an array, and recursively calls its subtrees after placing the root into its sorted position
     * @param intArray - the array to be sorted
     * @param heapSize represents the size of the tree 
     * @param i - represents the root
     */
    private void heapify(int[] intArray, int heapSize, int i){
        int largest = i; // Initialize largest as root
        int leftChild = 2 * i + 1; //index of the left child of ith node = 2 * i + 1
        int rightChild = 2 * i + 2; //index of the right child of ith node  = 2 * i + 2
        int temp;

        if (leftChild < heapSize && intArray[leftChild] > intArray[largest]){ //check if larger than the root
            largest = leftChild;
        }
 
        if (rightChild < heapSize && intArray[rightChild] > intArray[largest]){ //check if larger than the root
            largest = rightChild;
        }
 
        if (largest != i){ //base case for recursive call                                      
            temp = intArray[i];
            intArray[i] = intArray[largest];
            intArray[largest] = temp;
            heapify(intArray, heapSize, largest); //recursive call for new subtrees
        }
    }
}