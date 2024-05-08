package com.ucb.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.lang.Exception;
import io.sentry.Sentry;

@SpringBootApplication
public class LoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginApplication.class, args);
		try {
			throw new Exception("This is a test.");
		  } catch (Exception e) {
			Sentry.captureException(e);
		  }
	}

}
