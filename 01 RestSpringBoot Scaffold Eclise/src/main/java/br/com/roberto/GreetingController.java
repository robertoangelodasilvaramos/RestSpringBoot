package br.com.roberto;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	
	private static final String template = "hello, %s!";
	
	private final AtomicLong conter = new AtomicLong();
	
	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String nome ) {
		return new Greeting(conter.incrementAndGet(), String.format(template, nome));
	}
}
