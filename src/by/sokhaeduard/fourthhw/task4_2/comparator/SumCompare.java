package by.sokhaeduard.fourthhw.task4_2.comparator;

import java.util.Comparator;

public class SumCompare implements Comparator<int[]> {
    @Override
    public int compare(int[] array1, int[] array2) {
        if (getSum(array1) > getSum(array2)) {
            return 1;
        } else if (getSum(array1) < getSum(array2)) {
            return -1;
        }
        return 0;
    }
    private int getSum(int[] array) {
        int sumValue = 0;
        for (int e : array) {
            sumValue += e;
        }
        return sumValue;
    }
}
