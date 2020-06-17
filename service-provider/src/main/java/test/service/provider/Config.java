package test.service.provider;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class Config {

    @Bean(name = "testMap")
    public Map<String, String> getMap() {
        Map<String, String> map = new HashMap<>();
        map.put("1", "a");
        return map;
    }

}
