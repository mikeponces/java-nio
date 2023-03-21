package com.pluralsight.files;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WritingFiles {

	public void bufferedWriter() {
		Path path = Paths.get("files/debug.txt");

		try (Writer writer = Files.newBufferedWriter(path);) {
			writer.write("Hello World!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void printWriter() {
		Path path = Paths.get("files/debug.txt");

		try (Writer writer = Files.newBufferedWriter(path);
				BufferedWriter bufferedWriter = new BufferedWriter(writer);
				PrintWriter pw = new PrintWriter(bufferedWriter);) {

			writer.write("Hello World!");

			pw.printf("i = %d\n", 12);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
