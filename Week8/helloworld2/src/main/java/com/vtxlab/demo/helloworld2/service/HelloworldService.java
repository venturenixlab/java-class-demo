package com.vtxlab.demo.helloworld2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service //
public class HelloworldService {

  // Our database
  private static final List<String> strings = new ArrayList<>();

  @Value("${string-length.max.helloworld}")
  private Integer maxLengthForHelloworld;

  @Value("${string-length.min.helloworld}")
  private Integer minLengthForHelloworld;

  public String sayHelloService(String string) {
    if (string.length() > maxLengthForHelloworld) {
      return "Exceed max length";
    }
    if (string.length() < minLengthForHelloworld) {
      return "Below min length";
    }
    return string + " hello world ";
  }

  public Boolean createString(String name) {
    return strings.add(name);
  }

  public List<String> getAllString() {
    return HelloworldService.strings;
  }

  public Boolean deleteAll() {
    return strings.size() == 0 ? true : strings.removeAll(strings);
  }

  public String deleteLast() {
    return strings.remove(strings.size() - 1); // delete by index
  }

  public List<String> updateStrings(List<String> stringList) { // empty List
    if (stringList == null) {
      this.deleteAll();
      return strings;
    }
    if (this.deleteAll()) {
      stringList.forEach(e -> {
        strings.add(e);
      });
      return strings;
    }
    return strings; // Error Response (Code, Msg)
  }

  public String updateFirst(String element) {
    // update first element if it exists
    if (strings.isEmpty()) {
      strings.add(element);
      return element;
    }
    // add first element if it does not exist
    strings.set(0, element);
    return element;
  }

  // 100 methods here...
}
