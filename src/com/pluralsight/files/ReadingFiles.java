package com.pluralsight.files;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadingFiles {
	public static void main(String[] args) {
		Path path = Paths.get("files/sonnet-UTF8.txt");

		Files.exists(path);

		try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.ISO_8859_1);) {
			String line = reader.readLine();
			while (line != null) {
				System.out.println(line);
				line = reader.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
