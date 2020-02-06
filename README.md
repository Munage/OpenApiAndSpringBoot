# Open-API with Spring Boot
This project provides examples of how to generate [Open-API](https://swagger.io/specification/) specifications from a spring boot project.

The examples used are a combination of the following guides: 
- [documenting-spring-boot-rest-api-springdoc-openapi-3](https://www.dariawan.com/tutorials/spring/documenting-spring-boot-rest-api-springdoc-openapi-3/)
- [openapi-swaggerui](https://quarkus.io/guides/openapi-swaggerui)

### Dependencies 
Add the Open-API dependency to your pom

    <dependency>
        <groupId>org.springdoc</groupId>
        <artifactId>springdoc-openapi-ui</artifactId>
        <version>1.2.30</version>
    </dependency>
    
        
In your Application.java, Add the API base definitions. Please note that title and version are mandatory, while the rest 
of the fields are optional.
        
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
    ...
    
Tag your RestController with a name and description:

    @Tag(name = "book", description = "the Book API")
    
For each endpoint in the controller, create a summary for the endpoint.
Typically the users who are reading the documentation dont have context over what the API does, so try to keep it as 
informative as possible. Remember to include the api response codes and what each one means.

    @Operation(summary = "Find Book by ID", description = "Returns a single book", tags = { "book" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(schema = @Schema(implementation = Book.class))),
            @ApiResponse(responseCode = "404", description = "Book not found") })
    @GetMapping("/{id}")
    public Optional<Book> findById(@PathVariable long id) {
        return repository.findById(id);
    }
    
Models only require that **each** field be documented with the @Schema annotation. 

    @Schema(description = "Unique identifier of the Book.",
            example = "1", required = true)
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private long id;
    
To get the JSON api doc, go to http://localhost:8080/v3/api-docs, or http://localhost:8080/v3/api-docs.yaml to download 
the .yaml version. 

To view the well formatted specification: http://localhost:8080/swagger-ui/index.html?url=/v3/api-docs

Once you have the json or yaml specifications, you can upload it to https://editor.swagger.io/ and have your client code
generated for you in your language of choice.
