package com.vtxlab.app;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileExceptionTest {
  public static void main(String[] args) throws Exception {
    List<String> lines = new ArrayList<>();
    try {
      Path filePath = Paths.get(
          "/Users/vincentlau/github/venturenixlab/java-class-demo/Week6/src/main/java/com/vtxlab/app/someFile.txt");
      lines = Files.readAllLines(filePath);
      // boolean deleteCompleted = Files.deleteIfExists(filePath);
      String str = "Hello";
      byte[] strToBytes = str.getBytes();
      Files.write(filePath, strToBytes, StandardOpenOption.APPEND);

    } catch (IOException e) { // checked exception
      Path filePath = Paths.get(
          "/Users/vincentlau/github/venturenixlab/java-class-demo/Week6/src/main/java/com/vtxlab/app/backFile.txt");
      lines = Files.readAllLines(filePath);
    } finally {
      System.out.println(lines);
    }
    // test difference
  }
}
