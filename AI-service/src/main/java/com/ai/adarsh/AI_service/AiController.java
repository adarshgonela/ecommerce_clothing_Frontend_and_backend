package com.ai.adarsh.AI_service;

import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.Map;

@RestController
@RequestMapping("/ai")
@Async
public class AiController {
@Autowired
  private  OllamaChatModel ollamaChatModel;

    @GetMapping("/generate")
    public Map<String,String> generate(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {
        return Map.of("generation", this.ollamaChatModel.call(message));
    }

//    @GetMapping("/generate/{name}")
//    public Flux<String> generate1(@PathVariable String name){
////        Prompt p=new Prompt(name);
////        ollamaChatModel.stream(name);
//     return ollamaChatModel.stream(name);
//    }




}
