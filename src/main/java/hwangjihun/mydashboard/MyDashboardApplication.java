package hwangjihun.mydashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MyDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyDashboardApplication.class, args);
	}

}
