package atlassian;

import org.junit.*;

import java.util.*;

public class SubArray {
    public int isSubArray(List<Integer> list1, List<Integer> list2) {
        for(int i = 0; i <= list1.size() - list2.size(); i += 1) {
            boolean found = true;
            for(int j = 0; j < list2.size(); j += 1) {
                if (list1.get(i + j) != list2.get(j)) {
                    found = false;
                    break;
                }
            }

            if (found) {
                return i;
            }

            found = true;
        }

        return -1;
    }

    @Test
    public void test1() {
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(2);
        list2.add(3);

        System.out.println(isSubArray(list1, list2));
    }

    @Test
    public void test2() {
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(3);
        list2.add(2);

        System.out.println(isSubArray(list1, list2));
    }

}
