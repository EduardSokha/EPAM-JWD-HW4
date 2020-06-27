package by.sokhaeduard.fourthhw.task4_1.service;

import by.sokhaeduard.fourthhw.task4_1.entity.Array;
import by.sokhaeduard.fourthhw.task4_1.exception.AppException;

public class ArraySearchService {

	public int findNumber(Array sortedArray, int number) throws AppException {
		if (sortedArray == null || sortedArray.getLength() < 1) {
			throw new AppException("array is wrong");
		}
		int firstIndex = 0;
		int lastIndex = sortedArray.getLength() - 1;
		while (firstIndex <= lastIndex) {
			int middleIndex = (firstIndex + lastIndex) / 2;
			if (sortedArray.getElement(middleIndex).getAsInt() == number) {
				return middleIndex;
			} else if (sortedArray.getElement(middleIndex).getAsInt() < number) {
				firstIndex = middleIndex + 1;
			} else if (sortedArray.getElement(middleIndex).getAsInt() > number) {
				lastIndex = middleIndex - 1;
			}
		}
		return -1;
	}

	public int getMinNumber(Array array) throws AppException {
		if (array == null || array.getLength() < 2) {
			throw new AppException("array is wrong");
		}
		int min = array.getElement(0).getAsInt();
		for (int i = 1; i < array.getLength(); i++) {
			if (min > array.getElement(i).getAsInt()) {
				min = array.getElement(i).getAsInt();
			}
		}
		return min;
	}

	public int getMaxNumber(Array array) throws AppException {
		if (array == null || array.getLength() < 2) {
			throw new AppException("array is wrong");
		}
		int max = array.getElement(0).getAsInt();
		for (int i = 1; i < array.getLength(); i++) {
			if (max < array.getElement(i).getAsInt()) {
				max = array.getElement(i).getAsInt();
			}
		}
		return max;
	}

	public Array getSimpleNumbers(Array array) throws AppException {
		if (array == null || array.getLength() < 1) {
			throw new AppException("array is wrong");
		}
		int count = 0;
		int[] result = new int[count];
		int index = 0;

		for (int i = 0; i < array.getLength(); i++) {
			if (isSimple(array.getElement(i).getAsInt())) {
				count++;
			}
		}

		for (int i = 0; i < array.getLength(); i++) {
			if (isSimple(array.getElement(i).getAsInt())) {
				result[index] = array.getElement(i).getAsInt();
				index++;
			}
		}
		return new Array(result);
	}

	public Array getFibonacciNumbers(Array array) throws AppException {
		if (array == null || array.getLength() < 1) {
			throw new AppException("array is wrong");
		}
		int count = 0;
		for (int i = 0; i < array.getLength(); i++) {
			if (isFibonacci(array.getElement(i).getAsInt())) {
				count++;
			}
		}
		int[] fibonacciNumbers = new int[count];
		int index = 0;
		for (int i = 0; i < array.getLength(); i++) {
			if (isFibonacci(array.getElement(i).getAsInt())) {
				fibonacciNumbers[index] = array.getElement(i).getAsInt();
				index++;
			}
		}
		return new Array(fibonacciNumbers);
	}

	public Array getAnother(Array array) throws AppException {
		if (array == null || array.getLength() < 1) {
			throw new AppException("array is wrong");
		}
		int count = 0;
		int[] result = new int[count];
		int index = 0;

		for (int i = 0; i < array.getLength(); i++) {
			String number = Integer.toString(array.getElement(i).getAsInt());
			if (number.length() == 3) {
				char[] chars = number.toCharArray();
				if (chars[0] != chars[1] && chars[0] != chars[2] && chars[1] != chars[2]) {
					count++;
				}
			}
		}

		for (int i = 0; i < array.getLength(); i++) {
			String number = Integer.toString(array.getElement(i).getAsInt());
			if (number.length() == 3) {
				char[] chars = number.toCharArray();
				if (chars[0] != chars[1] && chars[0] != chars[2] && chars[1] != chars[2]) {
					result[index] = array.getElement(i).getAsInt();
					index++;
				}
			}
		}
		return new Array(result);
	}

	private boolean isSimple(int number) {
		boolean result = true;
		for (int i = 2; i < number; i++) {
			if (number % i == 0) {
				result = false;
			}
		}
		return result;
	}

	private boolean isPerfectSquare(int number) {
		final double root = Math.sqrt(number);
		return Double.compare(root, Math.floor(root)) == 0;
	}

	private boolean isFibonacci(int number) {
		final int fiveTimesSquare = 5 * number * number;
		return isPerfectSquare(fiveTimesSquare + 4) || isPerfectSquare(fiveTimesSquare - 4);
	}
}
