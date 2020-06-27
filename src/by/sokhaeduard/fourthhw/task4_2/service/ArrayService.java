package by.sokhaeduard.fourthhw.task4_2.service;

import java.util.Comparator;

import by.sokhaeduard.fourthhw.task4_2.exception.AppException;

public class ArrayService {

	public void sortArray(int[][] array, Comparator<int[]> comparator, boolean reverse) throws AppException {
		if (array == null || comparator == null) {
			throw new AppException("wrong parameters");
		}
		boolean sorting = false;
		while (!sorting) {
			sorting = true;
			for (int i = 0; i < array.length - 1; i++) {
				if (comparator.compare(array[i], array[i + 1]) > 0) {
					int[] tmp = array[i + 1];
					array[i + 1] = array[i];
					array[i] = tmp;
					sorting = false;
				}
			}
		}
		if (reverse) {
			doReverse(array);
		}
	}

	public void doReverse(int[][] array) throws AppException {
		int length = array.length;
		for (int i = 0; i < length / 2; i++) {
			int[] temp = array[length - 1 - i];
			array[length - 1 - i] = array[i];
			array[i] = temp;
		}
	}
}
