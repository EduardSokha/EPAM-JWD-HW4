package by.sokhaeduard.fourthhw.task4_1.service;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.sokhaeduard.fourthhw.task4_1.entity.Array;
import by.sokhaeduard.fourthhw.task4_1.exception.AppException;

public class ArraySortServiceTest {
	ArraySortService arraySortService;
	Array actualArray;

	@BeforeMethod
	public void load() {
		arraySortService = new ArraySortService();
		int[] array = new int[] { 20, 72, 7, 5, 35 };
		try {
			actualArray = new Array(array);
		} catch (AppException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void insertionSortingTest() {
		int[] sorting = new int[] { 5, 7, 20, 35, 72 };
		try {
			Array expected = new Array(sorting);
			arraySortService.doInsertionSort(actualArray);
			assertEquals(actualArray, expected);
		} catch (AppException e) {
			fail();
		}
	}

	@Test(expectedExceptions = AppException.class)
	public void insertionSortingTestWithException() throws AppException {
		Array intArray = null;
		arraySortService.doInsertionSort(intArray);
	}

	@Test
	public void bubbleSortingTest() {
		int[] numbers = new int[] { 5, 7, 20, 35, 72 };
		try {
			Array expected = new Array(numbers);
			arraySortService.doBubbleSort(actualArray);
			assertEquals(actualArray, expected);
		} catch (AppException e) {
			fail();
		}
	}

	@Test(expectedExceptions = AppException.class)
	public void bubbleSortingTestWithException() throws AppException {
		int[] array = new int[] { 20 };
		Array newArray = new Array(array);
		arraySortService.doBubbleSort(newArray);
	}

	@Test
	public void selectionSortingTest() {
		int[] numbers = new int[] { 5, 7, 20, 35, 72 };
		try {
			Array expected = new Array(numbers);
			arraySortService.selectionSort(actualArray);
			assertEquals(actualArray, expected);
		} catch (AppException e) {
			fail();
		}
	}

	@Test(expectedExceptions = AppException.class)
	public void selectionSortingTestWithException() throws AppException {
		Array array = null;
		arraySortService.selectionSort(array);
	}
}