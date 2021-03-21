package com.ivoronline.springboot_junit_beforeafter.controllers;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MyControllerTest {

  static int i;
  @Autowired MyController myController;

  @BeforeAll
  public static void callBeforeAllTests() {
    i = 100;
    System.out.println("callBeforeAllTests() " + i);
  }

  @BeforeEach
  public void callBeforeEachTest() {
    i = i + 20;
    System.out.println("callBeforeEachTest() " + i);
  }

  @Test
  void hello() {
    i = i + 3;
    System.out.println("Test Method: hello() " + i);
    String result = myController.hello();
    assertEquals("Hello from Controller", result);
  }

  @AfterEach
  public void callAfterEachTest() {
    i = i - 20;
    System.out.println("callAfterEachTest() " + i);
  }

  @AfterAll
  public static void callAfterAllTests() {
    i = i - 100;
    System.out.println("\ncallAfterAllTests() " + i);
  }

}
