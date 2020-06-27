package by.sokhaeduard.fourthhw.task4_1.entity;

import java.util.OptionalInt;

import by.sokhaeduard.fourthhw.task4_1.exception.AppException;

public class Array {

    private int[] array;

    public Array(int[] array) throws AppException {
        if (array == null) {
            throw new AppException("array not exist");
        }
        this.array = array;
    }

    public Array(int length) throws AppException {
        if (length <= 0) {
            throw new AppException("wrong value of length");
        }
        array = new int[length];
    }

    public OptionalInt getElement(int index) {
        if (!validIndex(index)) {
            return OptionalInt.empty();
        }
        return OptionalInt.of(array[index]);
    }

    public boolean setElement(int value, int index) {
        if (!validIndex(index)) {
            return false;
        }
        array[index] = value;
        return true;
    }

    public int getLength() {
        return array.length;
    }

    private boolean validIndex(int index) {
        boolean result = false;
        if (index >= 0 && index < array.length) {
            result = true;
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Array intArray = (Array) o;
        if (intArray.array.length != array.length) {
            return false;
        }
        for (int i = 0; i < array.length; i++)
            if (array[i] != intArray.array[i]) {
                return false;
            }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;
        for (int element : array) {
            result = 31 * result + element;
        }
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("IntArray{");
        int count = 0;
        for (int i : array) {
            sb.append(" value[").append(count).append("] = ").append(i);
            count++;
        }
        sb.append(" }");
        return sb.toString();
    }
}
