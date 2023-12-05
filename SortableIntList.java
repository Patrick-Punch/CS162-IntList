/**
 * A sortable version of IntList.
 */
public interface SortableIntList extends IntList {

    /**
     * Sorts the list using the specified sort algorithm.
     * 
     * @param type the sort algorithm to use.
     */
    void sort(Algorithm type);

    enum Algorithm {
        /**
         * Selection sort
         */
        SELECTION,
        
        /**
         * Insertion sort
         */
        INSERTION,
        
        /**
         * Merge sort
         */
        MERGE,

        /*
         * Quick sort
         */
        QUICK,

        /*
         * Heap sort
         */
        HEAP
    }

}