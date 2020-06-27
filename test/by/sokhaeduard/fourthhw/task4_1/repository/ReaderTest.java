package by.sokhaeduard.fourthhw.task4_1.repository;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.sokhaeduard.fourthhw.task4_1.exception.AppException;

public class ReaderTest {
	Reader appReader;

	@BeforeMethod
	public void setUp() {
		appReader = new Reader();
	}

	@Test
	public void readFileTest() {
		String expected = "35 55 106 72";
		try {
			String actual = appReader.readFile("resources/array.txt");
			assertEquals(actual, expected);
		} catch (AppException e) {
			fail();
		}
	}

	@Test(expectedExceptions = AppException.class)
	public void readFileTestWithException() throws AppException {
		appReader.readFile("resourcesûûûû/array.txt");
	}
}