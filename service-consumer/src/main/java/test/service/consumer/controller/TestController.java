package test.service.consumer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.service.api.TestService;

import javax.annotation.Resource;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@Slf4j
public class TestController {

    private volatile int index = 0;

    private volatile AtomicInteger i = new AtomicInteger(0);

    @Resource
    private TestService service;

    @RequestMapping("check")
    public String check() {
        long c = System.currentTimeMillis();
        String s = null;
        try {
            s = "check now, " + service.hello("" + i.getAndIncrement());
            return s;
        } catch (Exception ex) {
            s = ex.getMessage();
            return s;
        } finally {
            log.info(s + " : d [{}]ms", System.currentTimeMillis() - c);
        }
    }

    // @Scheduled(fixedDelay = 3000)
    public void testDelay() {
        String hello = service.hello("");
        System.out.println(hello);
    }
}
