package by.sokhaeduard.fourthhw.task4_1.service;

import by.sokhaeduard.fourthhw.task4_1.entity.Array;
import by.sokhaeduard.fourthhw.task4_1.exception.AppException;

public class ArraySortService {

    public void doInsertionSort(Array array) throws AppException {
        if (array == null || array.getLength() < 2) {
            throw new AppException("array is wrong");
        }
        for (int i = 1; i < array.getLength(); i++) {
            int current = array.getElement(i).getAsInt();
            int j = i - 1;
            while (j >= 0 && current < array.getElement(j).getAsInt()) {
                array.setElement(array.getElement(j).getAsInt(), j + 1);
                j--;
            }
            array.setElement(current, j + 1);
        }
    }

    public void doBubbleSort(Array array) throws AppException {
        if (array == null || array.getLength() < 2) {
            throw new AppException("array is wrong");
        }
        boolean sorted = false;
        int temp;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < array.getLength() - 1; i++) {
                if (array.getElement(i).getAsInt() > array.getElement(i + 1).getAsInt()) {
                    temp = array.getElement(i + 1).getAsInt();
                    array.setElement(array.getElement(i).getAsInt(), i + 1);
                    array.setElement(temp, i);
                    sorted = false;
                }
            }
        }
    }

    public void selectionSort(Array array) throws AppException {
        if (array == null || array.getLength() < 2) {
            throw new AppException("array is wrong");
        }
        for (int i = 0; i < array.getLength(); i++) {
            int min = array.getElement(i).getAsInt();
            int idMin = i;
            for (int j = i + 1; j < array.getLength(); j++) {
                if (array.getElement(j).getAsInt() < min) {
                    min = array.getElement(j).getAsInt();
                    idMin = j;
                }
            }
            int temp = array.getElement(i).getAsInt();
            array.setElement(min, i);
            array.setElement(temp, idMin);
        }
    }
}
