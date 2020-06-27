package by.sokhaeduard.fourthhw.task4_2.comparator;

import java.util.Comparator;

public class MaxCompare implements Comparator<int[]> {
	
    @Override
    public int compare(int[] array1, int[] array2) {
        if (getMax(array1) > getMax(array2)) {
            return 1;
        } else if (getMax(array1) < getMax(array2)) {
            return -1;
        }
        return 0;
    }

    private int getMax(int[] array) {
        int maxValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (maxValue < array[i]) {
                maxValue = array[i];
            }
        }
        return maxValue;
    }
}
