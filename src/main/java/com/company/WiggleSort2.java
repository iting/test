package com.company;

public class WiggleSort2 {

    public WiggleSort2() {
    }

    public void sort(int[] nums) {
        int len = nums.length;
        int k = (len+1) /2 ;
        int pos = k-1;
        int medi = this.findK(nums, 0, len-1, pos);

        int largeLeft = 1;
        int rightSmall = len % 2 == 0? len-2 : len-1;
        int i=0;
        while(i<len) {
            int cur = nums[i];
            if(cur < medi && (i<rightSmall || (i>=rightSmall && i%2 != 0))) {
                this.swap(nums, rightSmall, i);
                rightSmall -=2;
            } else if(cur > medi && (i>largeLeft || (i<=largeLeft && i%2!=1))) {
                this.swap(nums, largeLeft, i);
                largeLeft +=2;
            } else {
                i+=1;
            }
        }

    }
    public int findK(int[] nums, int st, int end, int pos) {
        if(st>end) {
            return nums[st];
        }
        int random = nums[st];
        this.swap(nums, st, end);
        int run = st;
        for(int i=st; i<end; i++) {
            if(nums[i] < random) {
                this.swap(nums, i, run++);
            }
        }
        this.swap(nums, run, end);
        if(run == pos) {
            return nums[run];
        }
        if(run > pos) {
            return findK(nums, st, run-1, pos);
        }
        return findK(nums, run+1, end, pos);
    }

    public void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

}
