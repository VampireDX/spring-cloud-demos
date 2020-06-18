package test.service.consumer;


import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import test.service.api.TestService;

@Component
public class TestServiceFallback implements FallbackFactory<TestService> {

    private static volatile TestService singleton;

    @Override
    public TestService create(Throwable cause) {
        if (singleton != null) {
            return singleton;
        }

        synchronized (TestService.class) {
            if (singleton != null) {
                return singleton;
            }
            System.out.println("TestServiceFallback ===  create  ==========");
            singleton = new TestService() {
                @Override
                public String hello(String id) {
                    System.out.println("TestServiceFallback ======================================" + id);
                    return "fallback; reason was: " + cause.getMessage();
                }
            };
        }

        return singleton;
    }

}
