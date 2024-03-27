package com.example.send;

import camundajar.impl.scala.Int;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.camunda.bpm.engine.ProcessEngines;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

  public static void main(String... args) {
    SpringApplication.run(Application.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    List<String> list = List.of("one", "two", "three", "four", "five");
    Map<String,Object> vars = new HashMap<>();
    vars.put("vars", list);
    ProcessEngines.getDefaultProcessEngine()
        .getRuntimeService()
        .startProcessInstanceByKey("multiinstance-process",vars );
  }
}