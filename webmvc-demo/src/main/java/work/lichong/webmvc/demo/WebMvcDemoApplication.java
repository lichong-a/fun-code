package work.lichong.webmvc.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class WebMvcDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebMvcDemoApplication.class, args);
    }

}
