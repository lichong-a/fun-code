package work.lichong.funcode.webflux.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WebfluxDemoApplicationTests {

    @Autowired
    WebfluxDemoApplication webfluxDemoApplication;

    @Test
    void contextLoads() {
        Assertions.assertNotNull(webfluxDemoApplication);
    }

}
