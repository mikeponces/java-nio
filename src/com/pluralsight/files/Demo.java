package com.pluralsight.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@SuppressWarnings("unused")
public class Demo {

	public void java7() { // Uses Paths factory class
		Path path1 = Paths.get("c:/tmp/debug.log");
		Path path2 = Paths.get("c:", "tmp", "debug.log");

		URI uri = URI.create("file://c:/tmp/debug.log");
		Path path3 = Paths.get(uri);
	}

	public void java11() { // Uses Path.of
		Path path1 = Path.of("c:/tmp/debug.log");
		Path path2 = Path.of("c:", "tmp", "debug.log");
	}

	public void exists() throws IOException {
		Path path1 = Paths.get("c:/tmp/debug.log");
		Path path2 = Paths.get("c:", "tmp", "debug.log");
		boolean exists = Files.exists(path1);
		boolean sameFile = Files.isSameFile(path1, path2);
	}

	public void find() throws IOException {
		Path dir = Paths.get("e:/images");
		Path image = Paths.get("image.jpg");
		// 3 - depth of search
		// attributes - path attribute for every file to be searched
		Files.find(dir, 3, (path, attributes) -> path.endsWith(image));
	}

	private class TextFile {
		void read() throws IOException {
			Path path = Paths.get("c:/tmp/sonnet.txt");
			BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.ISO_8859_1);
			String line = reader.readLine();
		}

		void write() throws IOException {
			Path path = Paths.get("c:/tmp/sonnet.txt");
			BufferedWriter writer = Files.newBufferedWriter(path);
			writer.write("Hello World!");
		}
	}
}
