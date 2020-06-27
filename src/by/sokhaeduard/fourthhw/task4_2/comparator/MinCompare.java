package by.sokhaeduard.fourthhw.task4_2.comparator;

import java.util.Comparator;

public class MinCompare implements Comparator<int[]> {
    @Override
    public int compare(int[] array1, int[] array2) {
        if (getMin(array1) > getMin(array2)) {
            return 1;
        } else if (getMin(array1) < getMin(array2)) {
            return -1;
        }
        return 0;
    }

    private int getMin(int[] array) {
        int minValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (minValue > array[i]) {
                minValue = array[i];
            }
        }
        return minValue;
    }
}
