package com.erich.grosner.slackmoviemaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"me.ramswaroop.jbot", "com.erich.grosner"})
public class SlackmoviemasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SlackmoviemasterApplication.class, args);
	}
}
