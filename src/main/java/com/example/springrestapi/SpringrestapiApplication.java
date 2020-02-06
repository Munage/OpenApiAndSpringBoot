package com.example.springrestapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        tags = {
                @Tag(name="books", description="Book operations"),
                @Tag(name="authors", description="Operations related to authors")
        },
        info = @Info(
                title="Books API",
                version = "1.0.0",
                contact = @Contact(
                        name = "Example API Support",
                        url = "http://exampleurl.com/contact",
                        email = "techsupport@example.com"),
                license = @License(
                        name = "Apache 2.0",
                        url = "http://www.apache.org/licenses/LICENSE-2.0.html"))
)
@SpringBootApplication
public class SpringrestapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringrestapiApplication.class, args);
    }

}
