package test.service.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient("service-provider")
@RequestMapping(path = "test")
public interface TestService {

    @RequestMapping(path = "hello", method = RequestMethod.GET)
    String hello(@RequestParam(name = "id", required = false) String id);

}
