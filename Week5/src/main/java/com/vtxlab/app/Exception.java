package com.vtxlab.app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Exception {
  int age;
  String name;

  public static void main(String[] args) throws IOException {
    Path filePath = Paths
        .get("/Users/vincentlau/github/venturenixlab/java-class-demo/Week5/src/main/java/com/vtxlab/app/someFile2.txt");
    // File f = new File("/Users/pavankumar/Desktop/Testing/Java.txt");
    List<String> lines = Files.readAllLines(filePath);
    System.out.println(lines);

    Exception e = Exception.builder().age(12).name("MARY").build(); // constructor
    Exception e2 = new Exception(13, "Peter");

    
  }
}
