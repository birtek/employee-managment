package pl.szydlowski.springbootcrudapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.szydlowski.springbootcrudapi.generatedatatodb.GenerateSQL;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.IOException;
import java.time.LocalDate;


@SpringBootApplication
@EnableSwagger2
public class SpringbootcrudapiApplication {

	public static void main(String[] args) throws IOException {
		//SpringApplication.run(SpringbootcrudapiApplication.class, args);
		GenerateSQL sql = new GenerateSQL();
		sql.GenerateDataToDatabase();

	}
}
