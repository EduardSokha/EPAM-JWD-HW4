package by.sokhaeduard.fourthhw.task4_2.service;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.sokhaeduard.fourthhw.task4_2.comparator.MaxCompare;
import by.sokhaeduard.fourthhw.task4_2.comparator.MinCompare;
import by.sokhaeduard.fourthhw.task4_2.exception.AppException;

public class ArrayServiceTest {

    ArrayService arrayService;
    int[][] actual;

    @BeforeMethod
    public void load() {
        arrayService = new ArrayService();
        actual = new int[][]{{13, 99, 48}, {11, 26, 10}, {200, 625, 66}};
    }

    @Test
    public void soringtArrayMinTest() {
        int[][] expected = new int[][]{{11, 26, 10}, {13, 99, 48}, {200, 625, 66}};
        try {
            arrayService.sortArray(actual, new MinCompare(), false);
            assertEquals(actual, expected);
        } catch (AppException e) {
            fail();
        }
    }

    @Test
    public void sortingArrayMaxTest() {
        int[][] expected = new int[][]{{13, 99, 48}, {11, 26, 10}, {200, 625, 66}};
        try {
            arrayService.sortArray(actual, new MaxCompare(), false);
            assertEquals(actual, expected);
        } catch (AppException e) {
            fail();
        }
    }

    @Test(expectedExceptions = AppException.class)
    public void sortArrayTestWithException() throws AppException {
        arrayService.sortArray(actual, null, true);
    }

    @Test
    public void reverseTest() {
        int[][] expected = new int[][]{{200, 625, 66}, {11, 26, 10}, {13, 99, 48}};
        try {
            arrayService.doReverse(actual);
        } catch (AppException e) {
            fail();
        }
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = AppException.class)
    public void reverseTestWithException() throws AppException {
        int[][] array = null;
        arrayService.doReverse(array);
    }
}