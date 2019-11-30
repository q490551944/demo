package com.example.demo.controller;

import com.example.demo.entity.Greeting;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author huangpeijun
 */
@RestController
@RequestMapping("test")
public class HelloController {

    private static final String TEMPLATE = "Hello,%s";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public Greeting greeting(@RequestParam(value = "name",defaultValue = "World")String name) {
        return new Greeting(counter.incrementAndGet(),String.format(TEMPLATE,name));
    }

    @GetMapping
    public Greeting getGreeting(@RequestParam(value = "name",defaultValue = "World")String name) {
        return new Greeting(counter.incrementAndGet(),String.format(TEMPLATE,name));
    }

}
