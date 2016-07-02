package geeksforgeeks.dp;

import org.junit.*;

import java.util.*;

public class MinimumCoins {
    public int getMinimumCoins(int[] coins, int sum, Map<Integer, Integer> cache) {

        if (sum == 0) {
            return 0;
        }

        if (sum < 0) {
            return -1;
        }

        int coinsBest = -1;

        if (cache.containsKey(sum)) {
            return cache.get(sum);
        }

        for (int i = 0; i < coins.length; i += 1) {
            int coinsCurrent = getMinimumCoins(coins, sum - coins[i], cache);

            if (coinsCurrent == -1) {
                continue;
            }

            if(coinsBest == -1) {
                coinsBest = coinsCurrent + 1;
            } else if (coinsBest > coinsCurrent + 1) {
                coinsBest = coinsCurrent + 1;
            }
        }

        cache.put(sum, coinsBest);
        return coinsBest;
    }

    @Test
    public void test1() {
        System.out.println(getMinimumCoins(new int[] {9, 6, 5, 1}, 11, new HashMap<Integer, Integer>()));
    }
}
