package com.vtxlab.app;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;

public class BufferedWriterDemo {
  public static void main(String[] args) throws Exception {
    StringWriter sw = null;
    BufferedWriter bw = null;
    String letters = "ABCDEFGHIJK";

    try {
      // create string writer
      sw = new StringWriter();
      // create buffered writer
      bw = new BufferedWriter(sw);
      // for each character in the string
      for (char c : letters.toCharArray()) {
        // append character to the writer
        bw.append(c);
        // flush the characters to the intended stream
        bw.flush();
        // print string buffer from string writer
        System.out.println(sw.getBuffer());
      }
    } catch (IOException e) {
      // if I/O error occurs
      e.printStackTrace();
    } finally {
      // releases any system resources associated with the stream
      if (sw != null)
        sw.close();
      if (bw != null)
        bw.close();
    }
  }
}
