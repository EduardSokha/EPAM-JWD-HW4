package by.sokhaeduard.fourthhw.task4_1.generator;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.sokhaeduard.fourthhw.task4_1.entity.Array;
import by.sokhaeduard.fourthhw.task4_1.exception.AppException;
import by.sokhaeduard.fourthhw.task4_1.service.generator.ArrayGenerator;

public class ArrayGeneratorTest {
	ArrayGenerator intArrayCreator;

	@BeforeMethod
	public void setUp() {
		intArrayCreator = new ArrayGenerator();
	}

	@Test
	public void randomGenerateTest() {
		int expected = 5;
		try {
			Array intArray = intArrayCreator.generateRandomArray(5);
			int actual = intArray.getLength();
			assertEquals(actual, expected);
		} catch (AppException e) {
			fail();
		}
	}

	@Test(expectedExceptions = AppException.class)
	public void randomGenerateTestWithException() throws AppException {
		intArrayCreator.generateRandomArray(0);
	}
}