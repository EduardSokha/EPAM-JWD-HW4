package by.sokhaeduard.fourthhw.task4_1.service.generator;

import java.util.Random;

import by.sokhaeduard.fourthhw.task4_1.entity.Array;
import by.sokhaeduard.fourthhw.task4_1.exception.AppException;

public class ArrayGenerator {

    public Array generateRandomArray(int length) throws AppException {
        if (length < 1) {
            throw new AppException("wrong length");
        }
        Random random = new Random();
        int[] numbers = new int[length];
        for (int i = 0; i < length; i++) {
            numbers[i] = random.nextInt(1001);
        }
        return new Array(numbers);
    }
}
