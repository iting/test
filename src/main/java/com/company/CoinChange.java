package com.company;
import java.util.*;

public class CoinChange {

    public CoinChange() {

    }
    public int getMinCoins(int[] coins, int amount) {

        Map<Integer, Integer> count = new HashMap<>();

        int res = this.helper(coins, amount, count);
        return res;
    }

    private int helper(int[] coins, int amount, Map<Integer, Integer> map) {
        if(amount < 0) {
            return -1;
        }

        if(amount == 0) {
            return 0;
        }

        if(map.containsKey(amount)) {
            return map.get(amount);
        }

        int size = coins.length;
        int res = amount +1;
        for(int i=size-1; i>=0; i--) {
            int cur_coin = coins[i];

            if((amount-cur_coin)>=0) {
                int numCoins = this.helper(coins, amount-cur_coin, map);
                if(numCoins < 0) {
                    continue;
                }
                res = Math.min(res, 1+numCoins);
            }

        }
        res = res == amount +1 ? -1: res;
        map.put(amount, res);
        return map.get(amount);

    }
}
