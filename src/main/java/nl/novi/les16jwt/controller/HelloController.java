package nl.novi.les16jwt.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String sayHello() {

        // The simplest way to retrieve the currently authenticated principal is via a static call to the SecurityContextHolder:
        // https://www.baeldung.com/get-user-in-spring-security
        // The principal is the currently logged in user. However, you retrieve it through the security context which is bound to the current thread and as such, it's also bound to the current request and its session.
        // https://stackoverflow.com/questions/37499307/whats-the-principal-in-spring-security
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

            if (auth.getPrincipal() instanceof UserDetails) { // UserDetails interface
            // The API of the Authentication class is very open so that the framework remains as flexible as possible. Because of this, the Spring Security principal can only be retrieved as an Object and needs to be cast to the correct UserDetails instance:
            // https://www.baeldung.com/get-user-in-spring-security
            UserDetails ud = (UserDetails) auth.getPrincipal();
            return "Hello " + ud.getUsername();
        }
        else {
            return "Hello stranger!";
        }
    }

    @GetMapping("/secret")
    public String tellSecret() {
        return "This is very secret...";
    }
}

// In /hello moet een bearer token ingevoerd worden om /hello en /secret te kunnen zien.
// {{token}} variabele in Postman