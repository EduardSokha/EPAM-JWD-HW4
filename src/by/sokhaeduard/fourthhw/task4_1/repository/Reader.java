package by.sokhaeduard.fourthhw.task4_1.repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import by.sokhaeduard.fourthhw.task4_1.exception.AppException;

public class Reader {

	public String readFile(String filePath) throws AppException {
		BufferedReader br = null;
		String numbers;
		StringBuilder stringBuilder = new StringBuilder();
		Path path = Paths.get(filePath);

		try {
			br = Files.newBufferedReader(path);
			while ((numbers = br.readLine()) != null) {
				stringBuilder.append(numbers).append(" ");
			}
		} catch (IOException e) {
			throw new AppException("file not found");
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return stringBuilder.toString();
	}

	public String readConsole() throws AppException {
		ReadLine readLine = new ReadLine();
		StringBuilder stringBuilder = new StringBuilder();

		String enterValue;
		int length = readLine.getInt("Enter length of array");
		for (int i = 0; i < length; i++) {
			enterValue = readLine.getString("Enter " + i + " element");
			stringBuilder.append(enterValue).append(" ");
		}
		return stringBuilder.toString();
	}
}
