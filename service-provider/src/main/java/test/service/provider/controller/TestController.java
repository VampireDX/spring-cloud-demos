package test.service.provider.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import test.service.api.TestService;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@Slf4j
public class TestController implements TestService {

    @Resource(name = "testMap")
    private Map<String, String> testMap;

    @Override
    public String hello(String id) {
        String s = "hello," + testMap.get(id);
        Integer i = Integer.parseInt(id);
        if (i % 4 == 0) {
            sleep();
        }
        log.info("return {}", s);
        return s;
    }


    private void sleep() {
        try {
            Thread.sleep(1000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    public String bye(String id) {
        sleep();
        String s = "bye," + testMap.get(id);
        log.info("return {}", s);
        return s;
    }
}
