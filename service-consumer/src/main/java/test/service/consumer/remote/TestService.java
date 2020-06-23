package test.service.consumer.remote;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "service-provider")
public interface TestService extends test.service.api.TestService {

}
