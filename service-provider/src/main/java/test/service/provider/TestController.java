package test.service.provider;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestController implements TestService {

    @Override
    public String hello(String id) {
        String s = "hello," + id;
        try {
            Thread.sleep(2000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(s);
        return s;
    }
}
