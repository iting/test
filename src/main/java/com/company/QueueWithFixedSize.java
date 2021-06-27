package com.company;
import java.util.*;

public class QueueWithFixedSize {

    int fixedSize;
    List<Object> head;
    List<Object> tail;
    int tailPtr;
    int headPtr;
    int count;

    public QueueWithFixedSize(int fixedSize) {
        this.fixedSize = fixedSize;
        this.head = new ArrayList<>();
        this.tail = this.head;
        this.count = 0;

    }

    public int poll() {

        int topNumber = (int) this.head.get(headPtr);
        this.count -=1;
        this.headPtr +=1;

        // one place needs to store the next array
        if(this.headPtr == this.fixedSize -1) {
            List<Object> newList = (List<Object>)this.head.get(this.headPtr);
            this.headPtr = 0;
            this.head.clear();
            this.head = newList;
        }
        return topNumber;
    }


    public void offer(int num) {

        if(this.tailPtr == this.fixedSize -1) {
            List<Object> newList = new ArrayList<>();
            newList.add(num);
            this.tail.add(newList);
            this.tail = (List<Object>) this.tail.get(this.tailPtr);
            this.tailPtr = 0;
        } else {
            this.tail.add(num);
        }
        this.tailPtr +=1;
        this.count +=1;

    }

    public int size() {
        return this.count;
    }
}
