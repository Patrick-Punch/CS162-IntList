import java.util.*;

public class TestIntList {

    public static void runTests(IntList list) {
        // Test 1
        addItems(list, 500);
        
        // Test 2
        for (int i=0; i<500; i++) {
            list.remove(0);
        }
        if (list.size() != 0) {
            throw new RuntimeException("Test 2: removing items from list failed!");
        }
        System.out.println("Successfully removed items from the list");

        // Test 3
        addItems(list, 50000);

        // Test 4
        list.clear();
        if (list.size() != 0) {
            throw new RuntimeException("Test 4: clear() test failed!");
        }   
        System.out.println("Successfully cleared list");

        // Test 5
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(1, 2);
        list.remove(3);
        if (!Arrays.equals(list.toArray(), new int [] {1, 2, 3})) {
            throw new RuntimeException("Test 5: add and remove test failed!");
        }
        System.out.println("Successfully added and removed list items");

        System.out.println("All tests completed successfully!");
    } 

    private static void addItems(IntList list, int size) {
        // Use an ArrayList to check our work
        ArrayList<Integer> qaList = new ArrayList<Integer>();
        for (int i=0; i<size; i++) {
            int num = (int)Math.random()*10000;
            list.add(num);
            qaList.add(num);
        }
        // Check to make sure that the lists match
        for (int i=0; i<size; i++) {
            if (list.get(i) != qaList.get(i).intValue()) {
                throw new RuntimeException("Exception adding items to the IntList. Failed qa check!");
            }
        }
        System.out.println("Successfully added %d items to the list".formatted(size));
    }

}