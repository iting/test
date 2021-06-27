package com.company;
import java.util.*;

public class ListOfIterator implements Iterator<Integer>  {

    List<List<Integer>> data;
    int row;
    int col;
    public ListOfIterator(List<List<Integer>> vec) {
        this.data = vec;
        this.row = 0;
        this.col = 0;
    }

    @Override
    public boolean hasNext() {
        while(this.row < this.data.size()) {

            if(this.col < this.data.get(this.row).size()) {
                return true;
            }
            this.row +=1;
            this.col = 0;
        }
        return false;
    }

    @Override
    public Integer next() {
        int res = this.data.get(this.row).get(this.col);
        this.col +=1;
        return res;
    }


    // void remove() remove the last element returned by the iterator.
    // That is, remove the element that the previous next() returned.
    // This method can be called only once per call to next(), otherwise an exception will be thrown.
    @Override
    public void remove() {

        List<Integer> targetRowArray;
        int colToRemove = this.col;
        int rowToRemove = this.row;

        if(colToRemove == 0) {
            rowToRemove -=1;
            colToRemove = this.data.get(rowToRemove).size()-1;
            targetRowArray = this.data.get(rowToRemove);
        } else {
            colToRemove -=1;
            targetRowArray = this.data.get(rowToRemove);
        }
        targetRowArray.remove(colToRemove);

        if(targetRowArray.size() == 0) {
            this.data.remove(targetRowArray);
            this.row -=1;
        }

        if(this.col > 0) {
            this.col -=1;
        }

    }
}
