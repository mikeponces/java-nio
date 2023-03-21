package com.pluralsight.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class WalkFileTreePattern {
	public void walk() throws IOException {
		Path path = Paths.get("files/media");
		try (Stream<Path> stream = Files.walk(path)) {
			long count = stream.count();
			long files = Files.walk(path).filter(Files::isRegularFile).count();
			long directories = Files.walk(path).filter(Files::isDirectory).count();
			System.out.println(count);
			System.out.println(files);
			System.out.println(directories);
		}
	}
}
