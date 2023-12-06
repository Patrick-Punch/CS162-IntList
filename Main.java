/**
 * The IntList project uses a int[] as a data set, and the myIntList class implements the intList interface, allowing it to perform data management operations run by the testIntList class.
 * @author Patrick Punch
 * @version 1.0
 * @since 12/3/2023
 */

public class Main extends TestIntList {

    public static void main(String[] args){
        MyIntList intArray = new MyIntList();
        runTests(intArray);
        runSortTests(intArray);
        intArray.clear();
        for (int i = 0; i < 10; i++){
            int num = (int)(Math.random()*1000);            
            intArray.add(num);
        }
        System.out.println("\nUnsorted Array: " + intArray.toString());
        intArray.sort(SortableIntList.Algorithm.INSERTION);
        System.out.println("Insertion Sort: "+ intArray.toString());
        intArray.clear();

        for (int i = 0; i < 10; i++){
            int num = (int)(Math.random()*1000);            
            intArray.add(num);
        }
        System.out.println("\nUnsorted Array: " + intArray.toString());
        intArray.sort(SortableIntList.Algorithm.SELECTION);
        System.out.println("Selection Sort: " + intArray.toString());
        intArray.clear();

        for (int i = 0; i < 10; i++){
            int num = (int)(Math.random()*1000);            
            intArray.add(num);
        }
        System.out.println("\nUnsorted Array: " + intArray.toString());
        intArray.sort(SortableIntList.Algorithm.MERGE);
        System.out.println("Merge Sort: " + intArray.toString());
    }
}
