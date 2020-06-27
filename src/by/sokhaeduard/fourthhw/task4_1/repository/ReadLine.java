package by.sokhaeduard.fourthhw.task4_1.repository;

import java.util.Scanner;

public class ReadLine {
	Scanner sc = new Scanner(System.in);

	public int getInt(String message) {
		int number;
		System.out.println(message);

		while (sc.hasNextInt() == false) {
			sc.next();
			System.out.println("not int");
			System.out.println("enter int");
		}
		number = sc.nextInt();

		return number;
	}

	public String getString(String message) {
		System.out.println(message);

		String line = sc.next();
		sc.close();

		return line;
	}

	public void scClose() {
		sc.close();
	}
}
