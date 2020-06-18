package test.service.consumer.remote;


import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import test.service.api.TestService;

@Component
public class TestServiceFallbackFactory implements FallbackFactory<TestService> {

    @Override
    public TestService create(Throwable cause) {
        return new TestService() {
            @Override
            public String hello(String id) {
                return "hello fallback; reason was: " + cause.getMessage();
            }

            @Override
            public String bye(String id) {
                return "bye fallback; reason was: " + cause.getMessage();
            }
        };
    }

}
