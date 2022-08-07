package bg.softuni.mobilelle.mobilelle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class MobilelleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobilelleApplication.class, args);
	}

}
