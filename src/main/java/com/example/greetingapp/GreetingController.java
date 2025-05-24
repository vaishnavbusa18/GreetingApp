package com.example.greetingapp;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	private static final String template ="Hello,%s";
	private final AtomicLong counter = new AtomicLong();
	
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value ="name", defaultValue="world") String name) {
		return new Greeting(counter.incrementAndGet(),String.format(template, name));
	}
	@PostMapping("/post")
	public Greeting greeting1(@RequestBody String name) {
		return new Greeting(counter.incrementAndGet(),String.format(template, name));
	}
	
	@PutMapping("/put/{name}")
	public Greeting greeting2(@PathVariable String name) {
		return new Greeting(counter.incrementAndGet(),String.format(template, name));
	}

	@DeleteMapping("/{id}")
	public String deleteGreeting(@PathVariable Long id) {
	    return "Greeting with ID " + id + " deleted.";
	}

	
}

