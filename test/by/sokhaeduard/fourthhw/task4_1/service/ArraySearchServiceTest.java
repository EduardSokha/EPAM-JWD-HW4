package by.sokhaeduard.fourthhw.task4_1.service;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.sokhaeduard.fourthhw.task4_1.entity.Array;
import by.sokhaeduard.fourthhw.task4_1.exception.AppException;

public class ArraySearchServiceTest {
	ArraySearchService arraySearchService;
	Array array;

	@BeforeMethod
	public void load() {
		arraySearchService = new ArraySearchService();
		int[] arrayNum = new int[] { 4, 5, 20, 6, 25, 26, 301, 433 };
		try {
			array = new Array(arrayNum);
		} catch (AppException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void findNumberTest() {
		int expected = 2;
		try {
			int actual = arraySearchService.findNumber(array, 20);
			assertEquals(actual, expected);
		} catch (AppException e) {
			fail();
		}
	}

	@Test(expectedExceptions = AppException.class)
	public void findNumberTestWithException() throws AppException {
		Array intArray = null;
		arraySearchService.findNumber(intArray, 99);
	}

	@Test
	public void minNumberTest() {
		int expected = 4;
		try {
			int actual = arraySearchService.getMinNumber(array);
			assertEquals(actual, expected);
		} catch (AppException e) {
			fail();
		}
	}

	@Test(expectedExceptions = AppException.class)
	public void minNumberTestWithException() throws AppException {
		Array intArray = null;
		arraySearchService.getMinNumber(intArray);
	}

	@Test
	public void maxNumberTest() {
		int expected = 433;
		try {
			int actual = arraySearchService.getMaxNumber(array);
			assertEquals(actual, expected);
		} catch (AppException e) {
			fail();
		}
	}

	@Test(expectedExceptions = AppException.class)
	public void maxNumberTestWithException() throws AppException {
		Array intArray = null;
		arraySearchService.getMaxNumber(intArray);
	}

	@Test
	public void simpleNumbTest() {
		int[] numbers = new int[] { 5, 7 };
		try {
			Array expected = new Array(numbers);
			Array actual = arraySearchService.getSimpleNumbers(array);
			assertEquals(actual, expected);
		} catch (AppException e) {
			fail();
		}
	}

	@Test(expectedExceptions = AppException.class)
	public void simpleNumbTestWithException() throws AppException {
		Array array = null;
		arraySearchService.getSimpleNumbers(array);
	}

	@Test
	public void fibonacciTest() {
		int[] numbers = new int[] { 5, 7 };
		try {
			Array expected = new Array(numbers);
			Array actual = arraySearchService.getFibonacciNumbers(array);
			assertEquals(actual, expected);
		} catch (AppException e) {
			fail();
		}
	}

	@Test(expectedExceptions = AppException.class)
	public void fibonacciTestWithException() throws AppException {
		Array array = null;
		arraySearchService.getFibonacciNumbers(array);
	}

	@Test
	public void anotherDigitsTest() {
		int[] differentDigitsNumbers = new int[] { 301 };
		try {
			Array expected = new Array(differentDigitsNumbers);
			Array actual = arraySearchService.getAnother(array);
			assertEquals(actual, expected);
		} catch (AppException e) {
			fail();
		}
	}

	@Test(expectedExceptions = AppException.class)
	public void anotherDigitsTestWithException() throws AppException {
		Array intArray = null;
		arraySearchService.getAnother(intArray);
	}
}