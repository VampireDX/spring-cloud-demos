package test.service.consumer;


import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableFeignClients(basePackages = "test.service.consumer.remote")
@EnableSwagger2
public class Config {

    @Bean
    public Docket customDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .select()
            .apis(RequestHandlerSelectors.basePackage("test.service.consumer.controller"))
            .paths(PathSelectors.any())
            .build();
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("Consumer Team", "mailto:vdanielliu@gmail.com", "vdanielliu@gmail.com");
        return new ApiInfoBuilder()
            .title("Service Consumer DOC")
            .description("Service Consumer DESCRIPTION")
            .contact(contact)   // 联系方式
            .version("1.0.0")  // 版本
            .build();
    }
}
