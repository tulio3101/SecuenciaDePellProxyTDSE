package tdse.parcial;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProxyApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ProxyApplication.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", getPort()));
		app.run(args);
	}

	static int getPort(){
		if (System.getenv("PORT") != null){
			return Integer.parseInt(System.getenv("PORT"));
		}
		return 6501;
	}

}
