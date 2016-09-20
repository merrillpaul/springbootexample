package hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;


@RestController
public class HelloController {

    @RequestMapping("/hello/{name}")
    public String index(@PathVariable String name) {
        return "Greetings " + name + ", from Spring Boot!";
    }

}
