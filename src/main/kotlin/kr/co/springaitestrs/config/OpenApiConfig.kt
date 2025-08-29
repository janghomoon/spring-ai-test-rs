package kr.co.springaitestrs.config

import org.springframework.context.annotation.Configuration
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean

@Configuration
class OpenApiConfig {
    @Bean
    fun springOpenAPI(): OpenAPI {
        return OpenAPI()
            .info(
                Info()
                    .title("Spring AI Test RS API")
                    .version("1.0")
                    .description("Spring AI를 활용한 챗봇 API")
            )

    }

}
