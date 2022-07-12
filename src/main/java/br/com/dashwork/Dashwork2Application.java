package br.com.dashwork;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Dashwork2Application {

	public static void main(String[] args) {
		SpringApplication.run(Dashwork2Application.class, args);
	}
}
