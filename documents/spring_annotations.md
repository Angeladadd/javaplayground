Core Spring Annotations (Dependency Injection & Configuration)

These are the fundamental annotations for defining beans and wiring them together.

@Component: A generic stereotype annotation. It marks a Java class as a "bean" or a component managed by the Spring container.

@Service: A specialization of @Component. It indicates that the class holds business logic. It's functionally the same as @Component but used for semantic purposes.

@Repository: A specialization of @Component. It's used on classes that directly access the database. It also enables exception translation for persistence-related errors.

@Controller: A specialization of @Component used in the web layer (Spring MVC).

@Autowired: The most common annotation for dependency injection. It tells Spring to automatically inject an instance of a required bean. Can be used on constructors, fields, or setter methods.

@Configuration: Marks a class as a source of bean definitions. It's used with @Bean to declare beans programmatically.

@Bean: Used inside a @Configuration class on a method. It indicates that the method produces a bean to be managed by the Spring container.

@ComponentScan: Tells Spring where to scan for components (@Component, @Service, etc.). Spring Boot's @SpringBootApplication includes this automatically.

@Qualifier: Used alongside @Autowired when you have multiple beans of the same type and need to specify which one to inject.

@Value: Used to inject values from property files (e.g., application.properties) into fields in your beans.

@Scope: Defines the scope of a bean (e.g., singleton, prototype, request, session).

Spring Web (MVC/WebFlux) Annotations
For building REST APIs and web applications.

@RestController: A convenience annotation that combines @Controller and @ResponseBody. It marks a class as a REST controller where every method returns a domain object instead of a view.

@RequestMapping: The primary annotation for mapping web requests onto specific handler classes and/or handler methods. Can be used at the class or method level.

@GetMapping: A shortcut for @RequestMapping(method = RequestMethod.GET).

@PostMapping: A shortcut for @RequestMapping(method = RequestMethod.POST).

@PutMapping: A shortcut for @RequestMapping(method = RequestMethod.PUT).

@DeleteMapping: A shortcut for @RequestMapping(method = RequestMethod.DELETE).

@PathVariable: Binds a method parameter to a URI template variable (e.g., /users/{id}).

@RequestParam: Binds a method parameter to a web request parameter (e.g., /users?name=John).

@RequestBody: Binds the body of the HTTP request to a method parameter. Spring automatically deserializes the JSON/XML into a Java object.

@ResponseBody: Indicates that a method's return value should be bound to the web response body. It's automatically included in @RestController.

Spring Data Annotations
For database interactions, primarily with JPA and MongoDB.

@Entity: (JPA) Specifies that the class is an entity and is mapped to a database table.

@Table: (JPA) Specifies the name of the database table that this entity maps to.

@Id: Specifies the primary key of an entity.

@GeneratedValue: (JPA) Configures the way of incrementing the value of the primary key.

@Column: (JPA) Specifies the mapped column for a persistent property or field.

@Document: (MongoDB) Marks a class as a MongoDB document that can be stored in a collection.

Spring Boot Annotations
These annotations simplify the setup and configuration of a Spring application.

@SpringBootApplication: The main annotation. It's a convenience annotation that combines @Configuration, @EnableAutoConfiguration, and @ComponentScan.

@EnableAutoConfiguration: Enables Spring Boot's auto-configuration mechanism, which attempts to automatically configure your Spring application based on the jar dependencies you have added.

Transaction & Caching Annotations
@Transactional: Declares that a method or class should be wrapped in a database transaction. It provides all-or-nothing semantics.

@EnableCaching: Enables Spring's annotation-driven cache management capability.

@Cacheable: Indicates that the result of invoking a method (or all methods in a class) can be cached.

@CachePut: Updates the cache with the method's return value without interfering with the method execution.

@CacheEvict: Removes data from the cache.