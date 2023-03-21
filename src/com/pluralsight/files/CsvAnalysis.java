package com.pluralsight.files;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Function;
import java.util.stream.Stream;

import com.pluralsight.files.vo.Person;

public class CsvAnalysis {

	public void reader() {
		Path path = Paths.get("files/data.csv");
		try (BufferedReader reader = Files.newBufferedReader(path);) {
			String line = reader.readLine();
			while (line != null) {
				if (!line.startsWith("#")) {
					String[] elements = line.split(";");
					String name = elements[0];
					int age = Integer.parseInt(elements[1]);
					String city = elements[2];

					Person p = new Person(name, age, city);
					System.out.println(p);
					// TODO
				}
				line = reader.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void function() {
		Path path = Paths.get("files/data.csv");

		Function<String, Person> lineToPerson = line -> {
			String[] elements = line.split(";");
			String name = elements[0];
			int age = Integer.parseInt(elements[1]);
			String city = elements[2];
			return new Person(name, age, city);
		};

		try (BufferedReader reader = Files.newBufferedReader(path);) {
			String line = reader.readLine();
			while (line != null) {
				if (!line.startsWith("#")) {
					Person p = lineToPerson.apply(line);
					System.out.println(p);
					// TODO
				}
				line = reader.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void bufferedReaderLines() {
		Path path = Paths.get("files/data.csv");

		Function<String, Person> lineToPerson = line -> {
			String[] elements = line.split(";");
			String name = elements[0];
			int age = Integer.parseInt(elements[1]);
			String city = elements[2];
			return new Person(name, age, city);
		};

		try (BufferedReader reader = Files.newBufferedReader(path);) {
			Stream<String> lines = reader.lines();
			lines.filter(line -> !line.startsWith("#")).map(lineToPerson).forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void filesLines() {
		Path path = Paths.get("files/data.csv");

		Function<String, Person> lineToPerson = line -> {
			String[] elements = line.split(";");
			String name = elements[0];
			int age = Integer.parseInt(elements[1]);
			String city = elements[2];
			return new Person(name, age, city);
		};

		try (Stream<String> lines = Files.lines(path);) {
			lines.filter(line -> !line.startsWith("#")).map(lineToPerson).forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void flatMap() {
		Path path = Paths.get("files/data.csv");

		try (Stream<String> lines = Files.lines(path);) {
			lines.filter(line -> !line.startsWith("#"))
			.flatMap(CsvAnalysis::lineToPerson)
			.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static Stream<Person> lineToPerson(String line) {
		try {
			String[] elements = line.split(";");

			String name = elements[0];
			int age = Integer.parseInt(elements[1]);
			String city = elements[2];

			Person p = new Person(name, age, city);

			return Stream.of(p);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Stream.empty();
	}
}
