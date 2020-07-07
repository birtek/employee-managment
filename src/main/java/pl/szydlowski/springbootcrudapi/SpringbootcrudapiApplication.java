package pl.szydlowski.springbootcrudapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;


@SpringBootApplication
@EnableSwagger2
public class SpringbootcrudapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootcrudapiApplication.class, args);
	}
}
