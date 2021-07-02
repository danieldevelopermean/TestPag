package testpag.com.br;

import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import testpag.com.br.popular_csv.PopularCSV;

@SpringBootApplication
public class TestPagApplication {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		SpringApplication.run(TestPagApplication.class, args);
		
		PopularCSV popularCSV = new PopularCSV();
		
	    popularCSV.popularCSVMetodo();
	}

}
