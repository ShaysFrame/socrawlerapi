package pub.shay.socrawlerapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

	@Bean
	public OpenAPI socrawlerApiOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("SoCrawler API")
						.description("Stack Overflow Data API - Spring Boot implementation")
						.version("1.0.0")
						.contact(new Contact()
								.name("API Support")
								.email("support@socrawler.com"))
						.license(new License()
								.name("MIT License")
								.url("https://opensource.org/licenses/MIT")));
	}
}
