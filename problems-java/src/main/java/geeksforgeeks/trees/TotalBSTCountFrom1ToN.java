package geeksforgeeks.trees;

import org.junit.*;

public class TotalBSTCountFrom1ToN {
    public int count(int n) {
        if (n == 1 || n == 0) {
            return  1;
        }

        int sum = 0;

        for (int i = 1; i <= n; i += 1) {
            sum += count(i - 1) * count(n - i);
        }

        return sum;
    }

    @Test
    public void test1() {
        System.out.println(count(1));
        System.out.println(count(2));
        System.out.println(count(3));
        System.out.println(count(4));
    }
}
