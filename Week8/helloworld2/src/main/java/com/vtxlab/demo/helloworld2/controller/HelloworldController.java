package com.vtxlab.demo.helloworld2.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vtxlab.demo.helloworld2.service.HelloworldService;
import com.vtxlab.demo.helloworld2.service.WhatsappService;

//@Controller // class level annotation, 
//@ResponseBody
@RestController // = @Controller + @ResponseBody
@RequestMapping(value = "/api/v1")
public class HelloworldController {

  @Autowired
  public HelloworldService helloworldService;

  @Autowired
  public WhatsappService whatsappService;

  // RestFul API
  @GetMapping(value = { "/helloworld/{string}/age/{age}", "/helloworld/age",
      "/helloworld/age/{age}", "/helloworld/{string}/age" })
  // /api/v1/helloworld
  public String helloworld(
      @PathVariable(value = "string", required = false) String str, //
      @PathVariable(value = "age", required = false) Integer age)
      throws Exception {
    if (age == null) {
      return "age is null";
    }
    return "age is not null";
    // return String.valueOf(age); // age = null
  }

  @GetMapping(value = "/greeting")
  public String greeting(@RequestParam String gender,
      @RequestParam String age) {
    if ("M".equals(gender) && "2".equals(age)) {
      return "Gender:" + gender;
    }
    return "default";
  }

  // Use Optional<?> to receive a PathVariable
  // @GetMapping(value = "/greeting")
  @RequestMapping(value = { "/optional/string/{str}",
      "/optional/string" }, method = RequestMethod.GET)
  public String getAge(@PathVariable Optional<String> str) {
    String var = "123";
    str.ifPresent(e -> {
      e = e + var;
    });
    // return (String) str.get();
    if (str.isPresent() && "456".equals(str.get())) {
      return str.get();
    }
    return "default";
  }

  // Use Map to to recieve more than one PathVariable
  @GetMapping(value = "/abc/{name}/cbd/{age}")
  public String getName(
      @PathVariable Map<String, String> map) {
    // 1st Entry name, John
    // 2nd Entry age, 30
    return map.get("name") + map.get("age");
  }

  @GetMapping(value = "/helloworld/{name}")
  public String getHellworld(@PathVariable String name) {
    return helloworldService.sayHelloService(name);
  }

  @GetMapping(value = { "/helloworld/list/{name}/{name2}",
      "/helloworld/list/{name}" })
  public List<String> getHellworldbyList(
      @PathVariable Map<String, String> map) {
    /// String str = "";
    List<String> strings = new ArrayList<>();
    map.forEach((a, b) -> {
      strings.add(helloworldService.sayHelloService(b));
    });
    return strings;
  }

  @PostMapping(value = { "/giftlist/{name}" })
  public Boolean createString(@PathVariable String name) {
    return helloworldService.createString(name);
  }

  @GetMapping(value = { "/giftlist" })
  public List<String> getAllString() {
    return helloworldService.getAllString();
  }

  @DeleteMapping(value = { "/giftlist" })
  public List<String> deleteAll() {
    if (helloworldService.deleteAll()) {
      return getAllString();
    }
    return new ArrayList<>();
  }

  @DeleteMapping(value = { "/giftlist/deleteLast" })
  public String deleteLast() {
    return helloworldService.deleteLast();
  }

  // GetMapping
  // stream(), filter
  // No change in service layer
  // return type: List<String>
  // No input params
  // Requirement: get all string from strings starting from t or T
  @GetMapping(value = { "/giftlist/tStrings" })
  public List<String> getStringsStartFromT() {
    return this.getAllString().stream()
        .map(e -> e.substring(0, 2))
        .filter(e -> e.toUpperCase().startsWith("T"))
        .collect(Collectors.toList());
  }

  @PutMapping(value = { "/giftlist" })
  public List<String> updateStrings(@RequestBody List<String> strings) {
    return helloworldService.updateStrings(strings);
  }

  @GetMapping(value = "/sendWhatsappMessage")
  public String sendWhatsappMessage() {
    return whatsappService.sendMessage();
  }

  // Update the first element of the strings list 
  @PatchMapping(value = { "/giftlist/firstElement" })
  public String updateFirst(String element) {
    
  }


}
