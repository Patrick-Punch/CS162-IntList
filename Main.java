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
    }
}
